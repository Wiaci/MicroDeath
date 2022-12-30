package wiaci.proj.groupsubjectservice.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import wiaci.proj.groupsubjectservice.entity.Subject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SubjectDao {

    private final JdbcConfig jdbc;

    public void save(Subject subject) throws SQLException {
        Connection connection = jdbc.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("insert into subject(name) values (" + subject.getName() + ");");
        statement.close();
        connection.close();
    }

    public Subject findById(Long id) {
        try {
            Connection connection = jdbc.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from subject where id=" + id + ";");
            Subject subject = new Subject();
            if (rs.next()) {
                subject.setId(rs.getLong("id"));
                subject.setName(rs.getString("name"));
            }
            statement.close();
            connection.close();
            return subject;
        } catch (SQLException e) {
            return new Subject();
        }
    }

    public List<Subject> findAll() {
        try {
            Connection connection = jdbc.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from subject;");
            List<Subject> subjects = new ArrayList<>();
            while (rs.next()) {
                subjects.add(new Subject(rs.getLong("id"),
                        rs.getString("name")));
            }
            statement.close();
            connection.close();
            return subjects;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

    public void delete(Long id) throws SQLException {
        Connection connection = jdbc.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("delete from subject where id=" + id + ";");
        statement.close();
        connection.close();
    }



}
