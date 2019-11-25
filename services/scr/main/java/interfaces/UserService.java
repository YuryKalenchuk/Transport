package interfaces;

import entity.Transport;

import java.util.Collection;

public interface UserService {
    Collection<Transport> getStationInteneary(String stationName);

    Transport getTransportToStation(String startStationName, String finishStationName);

    boolean editProfile();

    boolean sendFeedback(String busRegNum);
}
