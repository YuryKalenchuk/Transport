package impl;

import entity.Feedback;
import interfaces.DriverService;

import java.util.Collection;
import java.util.Date;

public class DriverServiceImpl implements DriverService {


    @Override
    public Collection<Feedback> getFeedbacks(String transportRegNum, Date startWork) {
        return null;
    }

    @Override
    public String replyFeedback(String feedbackId) {
        return null;
    }
}
