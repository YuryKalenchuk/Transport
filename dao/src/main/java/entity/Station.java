package entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Station extends BaseEntity {
    private String name;
    private Map<String, LocalTime> intineary;

    public Station(String name, Map map) {
        this.name = name;
        this.intineary = map;
    }

    public Station() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, LocalTime> getIntineary() {
        return intineary;
    }

    public void setIntineary(Map<String, LocalTime> intineary) {
        this.intineary = intineary;
    }
}
