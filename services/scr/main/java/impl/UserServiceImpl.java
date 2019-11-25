package impl;

import entity.Transport;
import interfaces.UserService;

import java.util.Collection;

public class UserServiceImpl implements UserService {
    @Override
    public Collection<Transport> getStationInteneary(String stationName) {
        return null;
    }

    @Override
    public Transport getTransportToStation(String startStationName, String finishStationName) {
        return null;
    }

    @Override
    public boolean editProfile() {
        return false;
    }

    @Override
    public boolean sendFeedback(String busRegNum) {
        return false;
    }
}
