package com.mycompany.unipar.central.utils.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:postgresql://3.142.131.90:5435/uniparcentral",
                "aluno",
                "aluno"
        );
    }
}
