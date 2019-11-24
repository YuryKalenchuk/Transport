package dao.impl;

import dao.interfaces.AdminDAO;

import dao.utils.FileUtils;
import entity.Station;
import entity.Transport;
import entity.User;


import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminDAOImpl implements AdminDAO {

    public List<User> getAllUsers() {

        FileUtils fs = new FileUtils();
        List<User> list;
        list = fs.readUsers();
        return list;
    }

    public boolean deleteUserByLogin(String login) {
        FileUtils fs = new FileUtils();
        List<User> list;
        list = fs.readUsers();
        list = list.stream()
                .filter(user -> !user.getLogin().equals(login))
                .collect(Collectors.toList());
        fs.writeUsers(list);
        return false;
    }


    public boolean editProfile(User user) {
        Scanner sc = new Scanner(System.in);


        return false;
    }

    public String addNewUser() {

        return null;
    }

    public List<Station> getAllStations() {
        return null;
    }

    public boolean deleteStationByName(String name) {

        return false;
    }

    public boolean editStationIntineary(String stationName) {

        return false;
    }

    public String addNewStation() {

        return null;
    }

    public List<Transport> getAllTransports() {
        return null;
    }

    public boolean deleteTransportById(long id) {

        return false;
    }

    public boolean editTransport(long id) {

        return false;
    }

    public String addNewTransport() {

        return null;
    }
}
