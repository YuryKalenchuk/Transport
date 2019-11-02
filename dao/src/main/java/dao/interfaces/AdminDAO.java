package dao.interfaces;

import entity.Station;
import entity.User;

public interface AdminDAO {
    //Users
    String getAllUsers();
    void deleteUserByLogin(String login);
    void editProfile(User user);
    void addNewUser();
    //Stations
    String getAllStations();
    void deleteStationByName(String name);
    void editStationIntineary(String stationName);
    void addNewStation();
    //Transport
    String getAllTransports();
    void deleteTransportById(long id);
    void editTransport(long id);
    void addNewTransport();


}
