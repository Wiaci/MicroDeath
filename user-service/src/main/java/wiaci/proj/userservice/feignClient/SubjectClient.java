package wiaci.proj.userservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wiaci.proj.userservice.entity.Subject;
import wiaci.proj.userservice.feignClient.fallback.SubjectClientFallback;

import java.util.List;

@FeignClient(value = "subjects", url = "http://localhost:8765/", fallback = SubjectClientFallback.class)
public interface SubjectClient {

    @GetMapping("/subjects/getAll")
    List<Subject> findAllById(@RequestParam List<Long> ids);
}
