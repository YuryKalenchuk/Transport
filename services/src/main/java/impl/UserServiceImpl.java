package impl;

import dao.impl.TransportCRUDFileImpl;
import dao.impl.UserCRUDFileImpl;
import dao.utils.FileUtils;
import entity.Station;
import entity.Transport;
import entity.User;
import interfaces.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    @Override
    public String getStationInteneary(String stationName) {
        FileUtils fu = new FileUtils();
        List<Station> list = new ArrayList<>();
        list = fu.readStations();
        list = list.stream().filter(station -> station.getName().equalsIgnoreCase(stationName)).collect(Collectors.toList());
        if (list.size() == 0) {
            return "Wrong Station name";
        } else {
            return list.get(0).getIntineary().toString().replace("}", "\n").replace(",", " ").replace("{", "- ").replace("=", " arrive at ");
        }
    }

    @Override
    public String getTransportToStation(String startStationName, String finishStationName) {
        String fStartStationName = startStationName.toUpperCase();
        String fFinishStationName = finishStationName.toUpperCase();
        List<Transport> list = new ArrayList<>();
        TransportCRUDFileImpl trudf = new TransportCRUDFileImpl();
        list = trudf.getAllTransports();
        list = list.stream().filter(transport -> transport.getTransportIntineary().containsKey(fStartStationName))
                .filter(transport -> transport.getTransportIntineary().containsKey(fFinishStationName))
                .collect(Collectors.toList());
        list.removeIf(transport -> transport.getTransportIntineary().get(fStartStationName)
                .isAfter(transport.getTransportIntineary().get(fFinishStationName)));
        if (list.size() != 0) {
            list.forEach(transport -> System.out.println("BUS #" + transport.getName() + " Arrive at " + transport.getTransportIntineary().get(fStartStationName).toString()));
            return "Have a good day!";
        }
        return "No available transports";
    }

    @Override
    public boolean editProfile(User user) {
        UserCRUDFileImpl ucfi = new UserCRUDFileImpl();
        return ucfi.editProfile(user);
    }

    @Override
    public boolean sendFeedback(String busRegNum) {
        return false;
    }
}
