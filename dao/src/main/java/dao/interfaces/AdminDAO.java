package dao.interfaces;

import entity.Station;
import entity.User;

public interface AdminDAO {
    //Users
    void getAllUsers();
    void deleteUserByLogin(String login);
    void editProfile();
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
