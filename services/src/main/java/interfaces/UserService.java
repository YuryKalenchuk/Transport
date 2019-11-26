package interfaces;

import entity.Station;
import entity.Transport;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Map;

public interface UserService {
    String getStationInteneary(String stationName);

    String getTransportToStation(String startStationName, String finishStationName);

    boolean editProfile();

    boolean sendFeedback(String busRegNum);
}
