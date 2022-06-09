/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timetable.data.mysql;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
import Timetable.*;
import Timetable.data.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class insert_teacher_database {
    
    public
           insert_teacher_database()
           {
               
           }
           
           
           
    public boolean insertteacher(String teacher_name, String Course_name,int total_no_of_students)
       {
            
               try{
                   // Class.forName("com.mysql.jdbc.Driver");
                   final var T_N = teacher_name;
                   final var n = Course_name;
                   final var b = total_no_of_students;
                  
                    
                    Connection Conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable_project","root","Zia3695@gmail");
                    Statement myStatement = Conn.createStatement();
                   String sql = "insert into Teacher_information"
                           +"(Teacher_name,Course_name,Total_no_of_student)"
                           +"values('"+T_N+"','"+n+"','"+b+"')";
                   myStatement.executeUpdate(sql);
                    System.out.println("Connected successfully");
                  return true;
                  
                } 
                catch(Exception exc){
                    System.out.println("Error occured");
                    exc.printStackTrace();
                    return false;
                }

    }

    
}
