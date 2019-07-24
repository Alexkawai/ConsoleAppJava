/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;
import java.sql.*;
/**
 *
 * @author lehai
 */
public class myApp5 {
     public static void GetMan() {
           long start = System.currentTimeMillis();
      try{
         String DATABASE_URL= MyApp.DATABASE_URL;
         String JDBC_DRIVER= MyApp.JDBC_DRIVER;
         String USER= MyApp.USER;
         String PASSWORD=MyApp.PASSWORD;
            
             Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
      try (Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)){
                  
                Statement statement = conn.createStatement();
                 
                ResultSet resultSet = statement.executeQuery("SELECT distinct Sex,FIO FROM `humans` WHERE FIO LIKE 'F%' AND `Sex` = 'M'");
                while(resultSet.next()){
                     
                    //int id = resultSet.getInt(1);
                    String fio = resultSet.getString(2);
                 
                    String sex = resultSet.getString(1);
                    
                    System.out.printf("%s , %s\n", sex,  fio);
                }
             }
         }
         catch(Exception ex){
             System.out.println("Connection failed...");
              
             System.out.println(ex);
         }  
  
    long finish = System.currentTimeMillis();
    long timeConsumedMillis = finish - start;
    System.out.println(timeConsumedMillis);
    }
}
