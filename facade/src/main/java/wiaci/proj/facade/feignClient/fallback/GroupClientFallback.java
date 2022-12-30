package wiaci.proj.facade.feignClient.fallback;

import org.springframework.stereotype.Component;
import wiaci.proj.facade.entity.Group;
import wiaci.proj.facade.entity.Subject;
import wiaci.proj.facade.feignClient.GroupSubjectClient;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupClientFallback implements GroupSubjectClient {

    @Override
    public List<Group> getGroups(Integer pageNum, Integer pageCount) {
        return new ArrayList<>();
    }

    @Override
    public Group getGroup(Long id) {
        return null;
    }

    @Override
    public void addGroup(String name) {}

    @Override
    public void deleteGroup(Long id) {}

    @Override
    public List<Subject> getAllSubject() {
        return new ArrayList<>();
    }

    @Override
    public Subject getSubject(Long id) {
        return null;
    }

    @Override
    public void addSubject(String name) {}

    @Override
    public void deleteSubject(Long id) {}
}
