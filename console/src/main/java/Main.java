import dao.utils.FileUtils;
import entity.Station;
import entity.Transport;
import menu.MainMenu;

import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //  MainMenu.go();
        Station start = new Station();
        start.setName("Start");
        start.setId(UUID.randomUUID().toString());
        Map<String, LocalTime> startIntineary = new HashMap<>();
        LocalTime t1 = LocalTime.of(7,20);
        LocalTime t2 = LocalTime.of(8,10);
        LocalTime t3 = LocalTime.of( 9,0);
        String m1 = new String("bus#2332AM");
        startIntineary.put(m1, t1);
        startIntineary.put("2", t2);
        startIntineary.put("3", t3);
        start.setIntineary(startIntineary);
        Station up = new Station();
        up.setId(UUID.randomUUID().toString());
        up.setName("up");
        Map<String, LocalTime> upIntineary = new HashMap<>();
        LocalTime t11 = LocalTime.of(8,20);
        LocalTime t12 = LocalTime.of(9,10);
        upIntineary.put("4", t11);
        upIntineary.put("5", t12);
        up.setIntineary(upIntineary);
        Station end = new Station();
        end.setId(UUID.randomUUID().toString());
        end.setName("END");
        Map<String, LocalTime> endIntineary = new HashMap<>();
        LocalTime t13 = LocalTime.of(8, 20);
        LocalTime t23 = LocalTime.of(9, 10);
        LocalTime t33 = LocalTime.of(9, 30);
        endIntineary.put(m1, t13);
        endIntineary.put("2", t23);
        endIntineary.put("3", t33);
        end.setIntineary(endIntineary);
        List<Station> memoryStations = new ArrayList<>();
        memoryStations.add(start);
        memoryStations.add(up);
        memoryStations.add(end);
        System.out.println(memoryStations);
        List<Station> readStations = new ArrayList<>();
        FileUtils fu = new FileUtils();
        fu.writeStations(memoryStations);
        readStations= fu.readStations();
        // System.out.println(readStations);
        Transport transport1 = new Transport();
        transport1.setName("1");
        transport1.setId(m1);
        Map<String,LocalTime> statins1Trans = new HashMap<>();
        statins1Trans.put(start.getName(),start.getIntineary().get(transport1.getId()));
        //statins1Trans.put(up.getName(),up.getIntineary().get(transport1.getId()));
        statins1Trans.put(end.getName(),end.getIntineary().get(transport1.getId()));
        transport1.setTransportIntineary(statins1Trans);
        List<Transport> memoryTransport = new ArrayList<>();
        memoryTransport.add(transport1);
        System.out.println(transport1);
    }
}
