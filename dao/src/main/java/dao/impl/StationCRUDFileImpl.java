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
    public boolean editStationIntineary(String stationId) {
        FileUtils fu = new FileUtils();
        List<Station> list = fu.readStations();
        Station st = new Station();
        st=list.stream().filter(station -> station.getName().equalsIgnoreCase(stationId)).collect(Collectors.toList()).get(0);
        if(st == null){
            System.out.println("Wrong station ID");
            return false;
        }
        else{

        }
    }

    @Override
    public String addNewStation() {
        return null;
    }
}
