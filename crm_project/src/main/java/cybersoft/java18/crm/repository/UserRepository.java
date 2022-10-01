package cybersoft.java18.crm.repository;

import cybersoft.java18.crm.jdbc.JdbcExecute;
import cybersoft.java18.crm.model.UserModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends AbstractRepository<UserModel> {
    public List<UserModel> getUser() {
        List<UserModel> listUser = new ArrayList<>();
        JdbcExecute<List<UserModel>> jdbcExecute = (con) -> {
            String query = "select id, fullname, role_id from users";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                listUser.add(new UserModel(
                        result.getInt("id"),
                        result.getString("fullname"),
                        result.getInt("role_id")));
            }
            return listUser;
        };
        return executeQuery(jdbcExecute);
    }
}
