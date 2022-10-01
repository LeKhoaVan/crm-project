package cybersoft.java18.crm.repository;


import cybersoft.java18.crm.jdbc.JdbcExecute;
import cybersoft.java18.crm.model.RoleModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository extends AbstractRepository<RoleModel> {
    public List<RoleModel> getAllRole() {
        List<RoleModel> listRole = new ArrayList<>();
        JdbcExecute<List<RoleModel>> jdbcExecute = (conn) -> {
            String query = "select id, name , description from roles ";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                listRole.add(new RoleModel(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("description")
                ));
            }
            return listRole;
        };
        return executeQuery(jdbcExecute);
    }

    public Integer executeDeleteById(String id) {
        String query = "delete from roles where id = ?";
        JdbcExecute jdbcExecute = (connection -> {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            return statement.executeUpdate();
        });
        return executeDeleteAndUpdate(jdbcExecute);
    }

    public Integer executeUpdate(RoleModel roleModel) {
        String query = "update roles set name =?, description=? where id =?";
        JdbcExecute jdbcExecute = (connection -> {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, roleModel.getName());
            statement.setString(2, roleModel.getDescription());
            statement.setInt(3, roleModel.getId());
            return statement.executeUpdate();
        });
        return executeDeleteAndUpdate(jdbcExecute);
    }

    public int executeCreateRole(String roleName, String description) {
        JdbcExecute jdbcExecute = (connection) -> {
            String query = "insert into roles(name,description) values(?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, roleName);
            statement.setString(2, description);
            return statement.executeUpdate();
        };
        return executeDeleteAndUpdate(jdbcExecute);
    }
}
