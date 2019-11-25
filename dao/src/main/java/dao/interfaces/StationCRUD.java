package dao.interfaces;

import entity.Station;

import java.util.List;

public interface StationCRUD {
    List<Station> getAllStations();
    boolean deleteStationByName(String name);
    boolean editStationIntineary(String stationName);
    String addNewStation();
}
