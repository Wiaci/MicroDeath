package wiaci.proj.groupsubjectservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wiaci.proj.groupsubjectservice.dao.GroupDao;
import wiaci.proj.groupsubjectservice.entity.Group;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupDao groupDao;

    public List<Group> getGroupsPage(Integer pageNum, Integer pageCount) {
        try {
            return groupDao.getGroupList(pageNum, pageCount);
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

    public void addGroup(String name) throws SQLException {
        Group group = new Group(0L, name);
        groupDao.save(group);
    }

    public void deleteGroup(Long id) throws SQLException {
        Group group = groupDao.findById(id);
        if (group == null) return;
        groupDao.delete(id);
    }

    public Group getById(Long id) {
        return groupDao.findById(id);
    }

}
