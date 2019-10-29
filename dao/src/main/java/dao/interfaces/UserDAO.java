package dao.interfaces;

import entity.Feedback;
import entity.User;

import java.util.Collection;


public interface UserDAO {
    Collection<String> getItineary(String str);

    Collection<String> getRoute(String start, String finish);

    void editProfile(User user);

    void sendFeedback(Feedback feedback);
}
