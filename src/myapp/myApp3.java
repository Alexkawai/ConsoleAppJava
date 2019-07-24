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
public class myApp3 {
    public static void Get() {
      try{
         String DATABASE_URL= MyApp.DATABASE_URL;
         String JDBC_DRIVER= MyApp.JDBC_DRIVER;
         String USER= MyApp.USER;
         String PASSWORD=MyApp.PASSWORD;
            
             Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
      try (Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)){
                  
                Statement statement = conn.createStatement();
                 
                ResultSet resultSet = statement.executeQuery("SELECT DISTINCT * , DATEDIFF( CURDATE( ) , Birth ) /365 AS 'Col' FROM `humans`WHERE 1 ORDER BY FIO");
                while(resultSet.next()){
                     
                    //int id = resultSet.getInt(1);
                    String fio = resultSet.getString(2);
                    String birth = resultSet.getString(3);
                    String sex = resultSet.getString(4);
                    int age = resultSet.getInt(5);
                    System.out.printf("%s , %s, %s, %d \n", fio, birth, sex, age);
                }
             }
         }
         catch(Exception ex){
             System.out.println("Connection failed...");
              
             System.out.println(ex);
         }
    }
}
