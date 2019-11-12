package dbImpl;

import dao.interfaces.AdminDAO;
import dao.services.DBUtils;
import entity.Role;
import entity.Station;
import entity.Transport;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoDbImpl implements AdminDAO {
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
        String sql = "UPDATE  mydbtest.users set name = ?, email = ?, password = ?, login = ? where id=?;";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             Statement st = conn.createStatement();

             ) {
            st.executeQuery("select * from users where id = '1aa'" );
            if (user.getName() != null) {
                ps.setString(1, user.getName());
            }
            if (user.getEmail() != null) {
                ps.setString(2, user.getEmail());
            }
            if (user.getPassword() != null) {
                ps.setString(3, user.getPassword());
            }
            if (user.getLogin() != null) {
                ps.setString(4, user.getLogin());
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

    @Override
    public List<Station> getAllStations() {
        return null;
    }

    @Override
    public boolean deleteStationByName(String name) {
        return false;
    }

    @Override
    public boolean editStationIntineary(String stationName) {
        return false;
    }

    @Override
    public String addNewStation() {
        return null;
    }

    @Override
    public List<Transport> getAllTransports() {
        return null;
    }

    @Override
    public boolean deleteTransportById(long id) {
        return false;
    }

    @Override
    public boolean editTransport(long id) {
        return false;
    }

    @Override
    public String addNewTransport() {
        return null;
    }
}
