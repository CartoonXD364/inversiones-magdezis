package main.java.com.inversiones.magdezis.vespertina.login.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataBaseConnection {
    
    private static Connection conn;
    
    
    private DataBaseConnection(){
        
    }

    
    public static Connection getDBConnection()throws SQLException{  
        
        if(conn == null || conn.isClosed()){
            
            conn = DriverManager.getConnection(Credentials.URL_DATA_BASE, Credentials.USER_DATA_BASE, Credentials.PASS_DATA_BASE);
            
        }
      
        return conn;
    }
    
}
