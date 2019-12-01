package dao.interfaces;

import entity.Transport;

import java.util.List;

public interface TransportCRUD {
    List<Transport> getAllTransports();
    boolean deleteTransportById(String id);
    boolean editTransport(Transport transport);
    String addNewTransport(Transport transport);
}
