/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

import java.sql.*;
import java.util.Random;

/**
 *
 * @author lehai
 */
public class myApp4 {
    public static void main(String[] args) {
      try{
         String DATABASE_URL= MyApp.DATABASE_URL;
         String JDBC_DRIVER= MyApp.JDBC_DRIVER;
         String USER= MyApp.USER;
         String PASSWORD=MyApp.PASSWORD;
            
             Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
      try (Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)){
          int id;      
          String sex;
          String fio,m,n,o;
          String birth;
          int a,b,c,f,k;
            for(int i=1000;i<1100;i++){
            id=i;
            sex="M";
            Random random = new Random();
           a = random.nextInt(90);
            a= 2019-a;
            b=random.nextInt(12+1);
            if(b==0){b=5;};
            c=random.nextInt(23+1);
            if(c>28 && b==2||c==0){c=28;}
            birth= Integer.toString(a)+"-"+Integer.toString(b)+"-"+Integer.toString(c);
            System.out.println(birth);
           
             
           k= random.nextInt(10+1);
        /* switch(k){
             case 1:m="Fyth";break;
         case 2:m="Felix";break;
         case 3:m="Myth";break;
         case 4:m="lyth";break;
         case 5:m="Gyth";break;
         case 6:m="Agnes";break;
         case 7:m="Ounes";break;
         case 8:m="Uoles";break;
         case 9:m="Yunes";break;
         default:m="Elves";break;
         }*/
         k= random.nextInt(10+1);
         switch(k){
             case 1:m="Fyth";break;
         case 2:m="Felix";break;
         case 3:m="Flafy";break;
         case 4:m="Flox";break;
         case 5:m="Fevral";break;
         case 6:m="Funny";break;
         case 7:m="Flu";break;
         case 8:m="Fly";break;
         case 9:m="Five";break;
         default:m="Four";break;
         }
          
         k= random.nextInt(10+1);
         switch(k){
             case 1:n="Fyth";break;
         case 2:n="Dyth";break;
         case 3:n="Myth";break;
         case 4:n="lyth";break;
         case 5:n="Gyth";break;
         case 6:n="Agnes";break;
         case 7:n="Ounes";break;
         case 8:n="Uoles";break;
         case 9:n="Yunes";break;
         default:n="Elves";break;
         }
         k= random.nextInt(10+1);
         switch(k){
             case 1:o="Fyth";break;
         case 2:o="Dyth";break;
         case 3:o="Myth";break;
         case 4:o="lyth";break;
         case 5:o="Gyth";break;
         case 6:o="Agnes";break;
         case 7:o="Ounes";break;
         case 8:o="Uoles";break;
         case 9:o="Yunes";break;
         default:o="Elves";break;}
         
         
         fio=m+" "+n+" "+o;
             
                String sql = "INSERT INTO `humans`(`id`, `FIO`, `Birth`, `Sex`) VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, fio);
                preparedStatement.setString(3, birth);
                preparedStatement.setString(4, sex);
                 
                int rows = preparedStatement.executeUpdate();
            
               // System.out.printf("%d rows added", rows);
            }
             }
         }
         catch(Exception ex){
             System.out.println("Connection failed...");
              
             System.out.println(ex);
         }
    }
}
