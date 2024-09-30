package com.weather.infoapp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TestService {
    
    private final Environment env;

    public ArrayList<String> getTableList() {
        ArrayList<String> returnList = new ArrayList<>();
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(
                env.getProperty("spring.datasource.url"),
                env.getProperty("spring.datasource.username"), 
                env.getProperty("spring.datasource.password")
                );
            state = conn.createStatement();
            rs = state.executeQuery("show tables");
            while(rs.next()) {
                returnList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnList;
    }
}
