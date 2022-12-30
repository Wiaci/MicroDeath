package wiaci.proj.groupsubjectservice.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import wiaci.proj.groupsubjectservice.entity.Group;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GroupDao {

    private final JdbcConfig jdbc;

    public List<Group> getGroupList(Integer pageNum, Integer pageCount) throws SQLException {
        Connection connection = jdbc.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from grp order by name limit "
                + pageCount + " offset " + (pageNum * pageCount) + ";";
        ResultSet rs = statement.executeQuery(sql);
        List<Group> groups = new ArrayList<>();
        while (rs.next()) {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            groups.add(new Group(id, name));
        }
        statement.close();
        connection.close();
        return groups;
    }

    public void save(Group group) throws SQLException {
        Connection connection = jdbc.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("insert into grp(name) values (" + group.getName() + ");");
        statement.close();
        connection.close();
    }

    public void delete(Long id) throws SQLException {
        Connection connection = jdbc.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("delete from grp where id=" + id + ";");
        statement.close();
        connection.close();
    }

    public Group findById(Long id) {
        try {
            Connection connection = jdbc.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from grp where id=" + id + ";");
            Group group = new Group();
            if (rs.next()) {
                group.setId(rs.getLong("id"));
                group.setName(rs.getString("name"));
            }
            statement.close();
            connection.close();
            return group;
        } catch (SQLException e) {
            return new Group();
        }

    }



}
