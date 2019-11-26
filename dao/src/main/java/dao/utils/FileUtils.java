package dao.utils;

import com.google.gson.Gson;
import entity.Station;
import entity.Transport;
import entity.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileUtils {
    public void writeUsers(List<User> users) {
        Gson gson = new Gson();
        FileWriter fw = null;
        try {
            fw = new FileWriter("usersDb.txt");
            User[] userInfo = new User[users.size()];
            users.toArray(userInfo);
            String line = gson.toJson(userInfo, User[].class);
            fw.write(line);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> readUsers() {
        String userInfoJson = null;
        List<User> list = new ArrayList<>();
        User[] userInfo;
        Gson gson = new Gson();
        try {
            userInfoJson = new String(Files.readAllBytes(Paths.get("usersDb.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        userInfo = gson.fromJson(userInfoJson, User[].class);
        list.addAll(Arrays.asList(userInfo));
        return list;
    }

    public void writeStations(List<Station> stations) {
        Gson gson = new Gson();
        FileWriter fw = null;
        try {
            fw = new FileWriter("stationDb.txt");
            Station[] stationArr = new Station[stations.size()];
            stations.toArray(stationArr);
            String line = gson.toJson(stationArr, Station[].class);
            fw.write(line);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Station> readStations() {
        String stationInfoJson = null;
        List<Station> list = new ArrayList<>();
        Station[] stations;
        Gson gson = new Gson();
        try {
            stationInfoJson = new String(Files.readAllBytes(Paths.get("stationDb.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stations = gson.fromJson(stationInfoJson, Station[].class);
        list.addAll(Arrays.asList(stations));
        return list;
    }

    public void writeTransport(List<Transport> transports) {
        Gson gson = new Gson();
        FileWriter fw = null;
        try {
            fw = new FileWriter("transportDB.txt");
            Transport[] transportArr = new Transport[transports.size()];
            transports.toArray(transportArr);
            String line = gson.toJson(transportArr, Transport[].class);
            fw.write(line);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Transport> readTransports() {
        String transportInfoJson = null;
        List<Transport> list = new ArrayList<>();
        Transport[] transports;
        Gson gson = new Gson();
        try {
            transportInfoJson = new String(Files.readAllBytes(Paths.get("transportDb.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        transports = gson.fromJson(transportInfoJson, Transport[].class);
        list.addAll(Arrays.asList(transports));
        return list;
    }
}




