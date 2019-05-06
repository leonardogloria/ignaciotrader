package com.daytrade.database;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class InitDatabase {
    @PostConstruct
    public void init(){
    }
}
