package wiaci.proj.facade.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import wiaci.proj.facade.entity.Group;
import wiaci.proj.facade.entity.Subject;
import wiaci.proj.facade.feignClient.fallback.GroupClientFallback;

import java.util.List;

@FeignClient(value = "group-subjects", url = "http://localhost:8765/", fallback = GroupClientFallback.class)
public interface GroupSubjectClient {

    @GetMapping("/groups/")
    List<Group> getGroups(@RequestParam Integer pageNum,
                              @RequestParam Integer pageCount);

    @GetMapping("/groups/{id}")
    Group getGroup(@PathVariable Long id);

    @PostMapping("/groups/")
    void addGroup(@RequestParam String name);

    @DeleteMapping("/groups/delete/{id}")
    void deleteGroup(@PathVariable Long id);

    @GetMapping("/subjects/getAll")
    List<Subject> getAllSubject();

    @GetMapping("/subjects/{id}")
    Subject getSubject(@PathVariable Long id);

    @PostMapping("/subjects/")
    void addSubject(@RequestParam String name);

    @DeleteMapping("/subjects/delete/{id}")
    void deleteSubject(@PathVariable Long id);


}
