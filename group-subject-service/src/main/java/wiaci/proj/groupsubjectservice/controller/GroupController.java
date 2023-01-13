package wiaci.proj.groupsubjectservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wiaci.proj.groupsubjectservice.entity.Group;
import wiaci.proj.groupsubjectservice.entity.Subject;
import wiaci.proj.groupsubjectservice.service.GroupService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api1/groups")
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/")
    public List<Group> getAll(@RequestParam Integer pageNum,
                              @RequestParam Integer pageCount) {
        return groupService.getGroupsPage(pageNum, pageCount);
    }

    @GetMapping("/{id}")
    public Group findById(@PathVariable Long id) {
        return groupService.getById(id);
    }

    @PostMapping
    public void addGroup(@RequestParam String name) throws SQLException {
        groupService.addGroup(name);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGroup(@PathVariable Long id) throws SQLException {
        groupService.deleteGroup(id);
    }

}
