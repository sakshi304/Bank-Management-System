// Step1: Register the Driver
// step2: Create connection
// step3: Create Statement
// step4: Execute Query
// Step5: Close Connection
package Bank_Management_System;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
         //   Class.forName(com.mysql.cj.jdbc.Driver);   you dont neeed to register the driver as the compiler will get the class from the library of mysqlconnector 
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","1234");
            s=c.createStatement();
        
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
