/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author lehai
 */
public class myApp2 {
    
    public static void Insert() {
      try{
         String DATABASE_URL= MyApp.DATABASE_URL;
         String JDBC_DRIVER= MyApp.JDBC_DRIVER;
         String USER= MyApp.USER;
         String PASSWORD=MyApp.PASSWORD;
            
             Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
               Scanner in = new Scanner(System.in);
        System.out.print("Input a FIO: ");
        String fio = in.nextLine();
        System.out.print("Input a Birthday(example Y-M-D[0000-00-00]): ");
        String birth = in.nextLine();
        System.out.print("Input a Sex(example M or W): ");
        String sex = in.nextLine();
        System.out.printf("You wrote:%s , %s ,%s \n", fio,birth,sex);
        in.close();
             try (Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)){
                  
                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("INSERT INTO `humans`(`id`, `FIO`, `Birth`, `Sex`) VALUES (1,'"+fio+"','"+birth+"','"+sex+"')");
                System.out.printf("Added %d rows", rows);
             }
         }
         catch(Exception ex){
             System.out.println("Connection failed...");
              
             System.out.println(ex);
         }
    }

  
}
