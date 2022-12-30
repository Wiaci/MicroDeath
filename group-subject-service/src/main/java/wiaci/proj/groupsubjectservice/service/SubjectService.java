package wiaci.proj.groupsubjectservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wiaci.proj.groupsubjectservice.dao.SubjectDao;
import wiaci.proj.groupsubjectservice.entity.Subject;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectDao subjectDao;

    @Transactional
    public void addSubject(String name) throws SQLException {
        Subject subject = new Subject(0L, name);
        subjectDao.save(subject);
    }

    public Subject getById(Long id) {
        return subjectDao.findById(id);
    }

    public List<Subject> getAll() {
        return subjectDao.findAll();
    }

    @Transactional
    public void delete(Long id) throws SQLException {
        subjectDao.delete(id);
    }

}
