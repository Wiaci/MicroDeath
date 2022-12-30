package wiaci.proj.userservice.feignClient.fallback;

import wiaci.proj.userservice.entity.Subject;
import wiaci.proj.userservice.feignClient.SubjectClient;

import java.util.ArrayList;
import java.util.List;

public class SubjectClientFallback implements SubjectClient {
    @Override
    public List<Subject> findAllById(List<Long> ids) {
        return new ArrayList<>();
    }
}
