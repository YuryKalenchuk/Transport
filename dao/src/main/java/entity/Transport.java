package entity;

import java.time.LocalTime;
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

    public Map<String,LocalTime> getTransportIntineary() {
        return transportIntineary;
    }

    public void setTransportIntineary(Map<String, LocalTime> transportIntineary) {
        this.transportIntineary = transportIntineary;
    }

    @Override
    public String toString() {
        return  "# "+ name + '\''
                 + transportIntineary ;
    }
}
