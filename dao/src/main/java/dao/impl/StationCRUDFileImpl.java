package dao.impl;

import dao.interfaces.StationCRUD;
import dao.utils.FileUtils;
import entity.Station;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StationCRUDFileImpl implements StationCRUD {

    @Override
    public List<Station> getAllStations() {
        List<Station> list = new ArrayList<>();
        FileUtils fu = new FileUtils();
        list = fu.readStations();
        return list;

    }

    @Override
    public boolean deleteStationByName(final String name) {
        List<Station> list;
        List<Station> list2;
        FileUtils fu = new FileUtils();
        list = fu.readStations();
        list2 = fu.readStations();
        list2.removeIf(station -> station.getName().equalsIgnoreCase(name));
        if (list.size() == list2.size()) {
            return false;
        } else {
            fu.writeStations(list2);
            return true;
        }

    }

    @Override
    public boolean editStation(Station stationApp) {
        FileUtils fu = new FileUtils();
        List<Station> list = fu.readStations();
        Station stDb;
        stDb = list.stream().filter(station -> station.getId().equals(stationApp.getId())).collect(Collectors.toList()).get(0);
        if (stDb == null) {
            System.out.println("Wrong station ID");
            return false;
        } else {
            list.removeIf(station -> station.getId().equals(stationApp));
            list.add(stationApp);
            fu.writeStations(list);
            return true;
        }
    }

    @Override
    public String addNewStation(Station st) {
        FileUtils fu = new FileUtils();
        List<Station> list = fu.readStations();
        if (st != null) {
            list.add(st);
            fu.writeStations(list);
            return st.getId();
        } else {
            return "Error!!!";
        }
    }
}
