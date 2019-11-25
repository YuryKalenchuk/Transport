package dao.interfaces;

import entity.Transport;

import java.util.List;

public interface TransportCRUD {
    List<Transport> getAllTransports();
    boolean deleteTransportById(long id);
    boolean editTransport(long id);
    String addNewTransport();
}
