import dao.utils.FileUtils;
import entity.Station;
import entity.Transport;
import menu.MainMenu;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        MainMenu.go();
//        Station start = new Station();
//        start.setName("START");
//        start.setId(UUID.randomUUID().toString());
//        Map<String, LocalTime> startIntineary = new HashMap<>();
//        LocalTime t1 = LocalTime.of(7, 20);
//        LocalTime t2 = LocalTime.of(8, 10);
//        LocalTime t3 = LocalTime.of(9, 0);
//        String m1 = new String("bus#2332-AM");
//        String m2 = "bus#0155-XX";
//        String m3 = "LightBus#5614-BK";
//        startIntineary.put(m1, t1);
//        startIntineary.put(m2, t2);
//        startIntineary.put(m3, t3);
//        start.setIntineary(startIntineary);
//        Station up = new Station();
//        up.setId(UUID.randomUUID().toString());
//        up.setName("UP");
//        Map<String, LocalTime> upIntineary = new HashMap<>();
//        LocalTime t11 = LocalTime.of(8, 20);
//        LocalTime t12 = LocalTime.of(9, 15);
//        upIntineary.put(m2, t11);
//        upIntineary.put(m3, t12);
//        up.setIntineary(upIntineary);
//        Station end = new Station();
//        end.setId(UUID.randomUUID().toString());
//        end.setName("END");
//        Map<String, LocalTime> endIntineary = new HashMap<>();
//        LocalTime t13 = LocalTime.of(8, 20);
//        LocalTime t23 = LocalTime.of(8, 30);
//        LocalTime t33 = LocalTime.of(9, 30);
//        endIntineary.put(m1, t13);
//        endIntineary.put(m2, t23);
//        endIntineary.put(m3, t33);
//        end.setIntineary(endIntineary);
//        List<Station> memoryStations = new ArrayList<>();
//        memoryStations.add(start);
//        memoryStations.add(up);
//        memoryStations.add(end);
//
//
//        List<Station> readStations = new ArrayList<>();
//        FileUtils fu = new FileUtils();
//        fu.writeStations(memoryStations);
//        readStations = fu.readStations();
//        Transport transport1 = new Transport();
//        transport1.setName("1");
//        transport1.setId(m1);
//        Map<String, LocalTime> statins1Trans = new HashMap<>();
//        statins1Trans.put(start.getName(), start.getIntineary().get(transport1.getId()));
//
//        statins1Trans.put(end.getName(), end.getIntineary().get(transport1.getId()));
//        transport1.setTransportIntineary(statins1Trans);
//        List<Transport> memoryTransport = new ArrayList<>();
//        memoryTransport.add(transport1);
//        Transport transport2 = new Transport();
//        Transport transport3 = new Transport();
//        transport2.setName("2");
//        transport2.setId(m2);
//        Map<String, LocalTime> stationsT2 = new HashMap<>();
//        stationsT2.put(start.getName(), start.getIntineary().get(transport2.getId()));
//        stationsT2.put(up.getName(), up.getIntineary().get(transport2.getId()));
//        stationsT2.put(end.getName(), end.getIntineary().get(transport2.getId()));
//        transport2.setTransportIntineary(stationsT2);
//        transport3.setId(m3);
//        transport3.setName("3");
//        Map<String, LocalTime> stationsT3 = new HashMap<>();
//        stationsT3.put(start.getName(), start.getIntineary().get(transport3.getId()));
//        stationsT3.put(up.getName(), up.getIntineary().get(transport3.getId()));
//        stationsT3.put(end.getName(), end.getIntineary().get(transport3.getId()));
//        transport3.setTransportIntineary(stationsT3);
//        memoryTransport.add(transport2);
//        memoryTransport.add(transport3);
//        fu.writeTransport(memoryTransport);
//        System.out.println(memoryStations.toString().replace("}", "\n").replace(",", " ").replace("{", "- "));
    }
}
