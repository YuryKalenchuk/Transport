package dao.impl;

import dao.interfaces.AdminDAO;
import dao.services.FileService;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminDAOImpl implements AdminDAO {

    public void getAllUsers() {
        FileService fs=new FileService();
        List<User> list;
        list = fs.readUsers();
        System.out.println(list);
    }

    public void deleteUserByLogin(String login) {
        FileService fs=new FileService();
        List<User> list;
        list = fs.readUsers();
        list=list.stream()
                .filter(user ->! user.getLogin().equals(login))
                .collect(Collectors.toList());
        fs.writeUsers(list);
    }

    @Override
    public void editProfile() {

    }

    public void editProfile(User user) {
       Scanner sc = new Scanner(System.in);


    }

    public void addNewUser() {

    }

    public String getAllStations() {
        return null;
    }

    public void deleteStationByName(String name) {

    }

    public void editStationIntineary(String stationName) {

    }

    public void addNewStation() {

    }

    public String getAllTransports() {
        return null;
    }

    public void deleteTransportById(long id) {

    }

    public void editTransport(long id) {

    }

    public void addNewTransport() {

    }
}
