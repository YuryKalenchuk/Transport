package dbImpl;

import dao.interfaces.AdminDAO;
import dao.interfaces.UserCRUT;
import dao.utils.DBUtils;
import entity.Role;
import entity.Station;
import entity.Transport;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserCRUDDbImpl implements UserCRUT {
    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Connection conn = DBUtils.getConnection();
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("select * from mydbtest.users;");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setLogin(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                switch (rs.getString("role").trim().toLowerCase()) {
                    case "user":
                        user.setRole(Role.USER);
                        break;
                    case "admin":
                        user.setRole(Role.ADMIN);
                        break;
                    case "driver":
                        user.setRole(Role.DRIVER);
                        break;
                    default:
                        System.out.println("Sorry. Unknown role");
                        break;
                }
                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteUserByLogin(String login) {
        return false;
    }

    @Override
    public boolean editProfile(User user) {
        String updateSql = "UPDATE  mydbtest.users set name = ?, email = ?, password = ?, login = ? where id=?;";
        String selectSql = "select * from mydbtest.users where id like '" + user.getId() + "'";
        User dbUser = new User();
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(updateSql);
             Statement st = conn.createStatement()
        ) {
            ResultSet rs = st.executeQuery(selectSql);
            while (rs.next()) {
                dbUser.setName(rs.getString("name"));
                dbUser.setEmail(rs.getString("email"));
                dbUser.setPassword(rs.getString("password"));
                dbUser.setLogin(rs.getString("login"));
            }
            if (user.getName() != null) {
                ps.setString(1, user.getName());
            } else {
                ps.setString(1, dbUser.getName());
            }
            if (user.getEmail() != null) {
                ps.setString(2, user.getEmail());
            } else {
                ps.setString(2, dbUser.getEmail());
            }
            if (user.getPassword() != null) {
                ps.setString(3, user.getPassword());
            } else {
                ps.setString(3, dbUser.getPassword());
            }
            if (user.getLogin() != null) {
                ps.setString(4, user.getLogin());
            } else {
                ps.setString(4, dbUser.getLogin());
            }
            ps.setString(5, user.getId());
            int rowCount = ps.executeUpdate();
            if (rowCount == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public String addNewUser() {
        return null;
    }


}
