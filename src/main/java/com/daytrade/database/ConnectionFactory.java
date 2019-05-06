package com.daytrade.database;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class ConnectionFactory {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    public Connection getConnection(){
        Connection dbConnection = null;
        try{
            dbConnection  = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
        }catch (SQLException ex){
            System.out.printf(ex.getMessage());
        }
        return dbConnection;
    }
    @PostConstruct
    private void init(){
        try{
            Statement st = getConnection().createStatement();
            st.execute("CREATE TABLE ORGAIZATION(id int primary key)");

        }catch (Exception ex){}
    }
}
