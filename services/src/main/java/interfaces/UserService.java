package interfaces;
import entity.User;



public interface UserService {
    String getStationInteneary(String stationName);

    String getTransportToStation(String startStationName, String finishStationName);

    boolean editProfile(User user);

    boolean sendFeedback(String busRegNum);
}
