package entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Station extends BaseEntity {
    private String name;
    private Map<String, ArrayList<Calendar>> intineary;

    Station(String name, Map map) {
        this.name = name;
        this.intineary = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, ArrayList<Calendar>> getIntineary() {
        return intineary;
    }

    public void setIntineary(Map<String, ArrayList<Calendar>> intineary) {
        this.intineary = intineary;
    }
}
