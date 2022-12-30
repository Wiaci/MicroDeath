package wiaci.proj.userservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import wiaci.proj.userservice.entity.Group;
import wiaci.proj.userservice.feignClient.fallback.GroupClientFallback;

@FeignClient(value = "groups", url = "http://localhost:8765/", fallback = GroupClientFallback.class)
public interface GroupClient {

    @GetMapping("/groups/{id}")
    Group findById(@PathVariable Long id);

}
