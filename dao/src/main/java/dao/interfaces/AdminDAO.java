package dao.interfaces;

import entity.Station;
import entity.Transport;
import entity.User;

import java.util.List;

public interface AdminDAO {
    //Users
    List<User> getAllUsers();
    boolean deleteUserByLogin(String login);
    boolean editProfile(User user);
    String addNewUser();
    //Stations
    List<Station> getAllStations();
    boolean deleteStationByName(String name);
    boolean editStationIntineary(String stationName);
    String addNewStation();
    //Transport
    List<Transport> getAllTransports();
    boolean deleteTransportById(long id);
    boolean editTransport(long id);
    String addNewTransport();


}
