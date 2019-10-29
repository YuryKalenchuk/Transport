package entity;

import java.util.Calendar;
import java.util.List;

public class Transport extends BaseEntity {
    private String name;
    private List<String> route;
    private List<Integer> routePing;
    private Calendar startTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoute() {
        return route;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }

    public List<Integer> getRoutePing() {
        return routePing;
    }

    public void setRoutePing(List<Integer> routePing) {
        this.routePing = routePing;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }
}
