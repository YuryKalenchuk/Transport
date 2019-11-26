package interfaces;

import entity.Feedback;

import java.util.Collection;
import java.util.Date;


public interface DriverService {
    Collection<Feedback> getFeedbacks(String transportRegNum, Date startWork);

    String replyFeedback(String feedbackId);
}
