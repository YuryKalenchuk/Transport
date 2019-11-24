package entity;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Transport extends BaseEntity {
    private String name;
    private Map<String,LocalTime> transportIntineary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String,LocalTime> getStationNames() {
        return transportIntineary;
    }

    public void setTransportIntineary(Map<String, LocalTime> transportIntineary) {
        this.transportIntineary = transportIntineary;
    }
}
