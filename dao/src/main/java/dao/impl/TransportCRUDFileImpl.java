package dao.impl;

import dao.interfaces.TransportCRUD;
import dao.utils.FileUtils;
import entity.Transport;

import java.util.ArrayList;
import java.util.List;

public class TransportCRUDFileImpl implements TransportCRUD {

    @Override
    public List<Transport> getAllTransports() {
        FileUtils fu = new FileUtils();
        List<Transport> list= new ArrayList<>();
        list= fu.readTransports();
        return list;
    }

    @Override
    public boolean deleteTransportById(long id) {
        return false;
    }

    @Override
    public boolean editTransport(long id) {
        return false;
    }

    @Override
    public String addNewTransport() {
        return null;
    }
}
