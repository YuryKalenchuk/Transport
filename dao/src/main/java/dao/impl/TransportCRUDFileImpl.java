package dao.impl;

import dao.interfaces.TransportCRUD;
import dao.utils.FileUtils;
import entity.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TransportCRUDFileImpl implements TransportCRUD {

    @Override
    public List<Transport> getAllTransports() {
        FileUtils fu = new FileUtils();
        List<Transport> list = fu.readTransports();
        return list;
    }

    @Override
    public boolean deleteTransportById(String id) {
        FileUtils fu = new FileUtils();
        List<Transport> listDb = fu.readTransports();
        List<Transport> list = fu.readTransports();
        list.removeIf(transport -> transport.getId().equalsIgnoreCase(id));
        if (list.size() == listDb.size()) {
            return false;
        } else {
            fu.writeTransport(list);
            return true;
        }
    }

    @Override
    public boolean editTransport(Transport transportApp) {
        FileUtils fu = new FileUtils();
        List<Transport> listDb = fu.readTransports();
        Transport transportDb = listDb.stream().filter(transport -> transport.getId().equalsIgnoreCase(transportApp.getId())).collect(Collectors.toList()).get(0);
        if (transportDb == null) {
            return false;
        } else {
            listDb.removeIf(transport -> transport.getId().equalsIgnoreCase(transportApp.getId()));
            listDb.add(transportApp);
            fu.writeTransport(listDb);
            return true;
        }
    }

    @Override
    public String addNewTransport(Transport transport) {
        FileUtils fu = new FileUtils();
        List<Transport> listDb = fu.readTransports();
        if (listDb.stream().filter(transport1 -> transport1.getId().equalsIgnoreCase(transport.getId())).collect(Collectors.toList()).size() > 0) {
            return "Wrong ID";
        } else {
            listDb.add(transport);
            fu.writeTransport(listDb);
            return transport.getId();
        }
    }
}
