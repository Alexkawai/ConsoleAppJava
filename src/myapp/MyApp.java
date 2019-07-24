
package myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 *
 * @author lehai
 */
public class MyApp {
 public static final String DATABASE_URL = "jdbc:mysql://mysql101.1gb.ru:3306/gb_56132?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
   public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   public static final String USER = "gb_56132";
   public static final String PASSWORD = "e26ca36ba";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
       Connection connection = null;
        Statement statement = null;
        try {
            System.out.println("Registering JDBC driver...");
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating connection to database...");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            System.out.println("Creating table in selected database...");
            statement = connection.createStatement();

            String SQL = "CREATE TABLE IF NOT EXISTS `humans` " +
                    "(id INTEGER not NULL, " +
                    " FIO VARCHAR(30)not NULL, " +
                    " Birth DATE not NULL, " +
                    " Sex CHAR not NULL, " +
                    " PRIMARY KEY (id))";

            statement.executeUpdate(SQL);
            System.out.println("Table successfully created...");
        }finally {
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
     
        Scanner on = new Scanner(System.in);
        System.out.print("Do you want insert into DB?(Yes/No)\n");
        String ans = on.nextLine(); 
        if("Yes".equals(ans)){
         myApp2.Insert();}

         System.out.println("Do you want to see table?(Yes/No)\n ");
         String answ = on.nextLine();
       if("Yes".equals(answ)){
         myApp3.Get();}
       
       System.out.println("Do you want to see myApp5?(Yes/No)\n ");
         String answe = on.nextLine();
       if("Yes".equals(answe)){
         myApp5.GetMan();}
        on.close();
        
    }
   
   
    }
    

