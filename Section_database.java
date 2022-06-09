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


public class Section_database 
{
   
    private int Total_number_of_students;
    private int total_Sections;
    private int total_rooms;
    private String Teacher_name;
  public
     
     Section_database()
     {
       Total_number_of_students=0;
        total_Sections=0;
        total_rooms=0;
     }
    
    public boolean making(String course,String Teacher_name)
    {
        String temp;
        String temp1;
          try{
                   // Class.forName("com.mysql.jdbc.Driver");
                    var myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable_project","root","Zia3695@gmail");
                    Statement myStatement = myConn.createStatement();
                    ResultSet myRs = myStatement.executeQuery("Select * from section_allocation");
                    while(myRs.next())
                    {
                        temp = myRs.getString("Course_name");
                        Total_number_of_students=Integer.parseInt(myRs.getString("Total_number_of_Students"));
                        total_Sections=Integer.parseInt(myRs.getString("Total_number_of_sections"));
                        total_rooms=Integer.parseInt(myRs.getString("total_rooms_allocated"));
                        temp1=myRs.getString("teacher_name");
                        if((temp.equals(course)&& temp1.equals(Teacher_name))==true)
                        {
                          //  System.out.println("Connected successfully");
                            System.out.println("Found");
                            return true;
                        }
                    }
                    System.out.println("Connected successfully");
                    return false;
            }
                catch(Exception exc){
                    System.out.println("Error occured");
                    exc.printStackTrace();
                }
        return false;
    }
       
    
    public int Section_allocation(String course_name,int Student_numbers,String Teacher_name)
    {
        boolean check=making(course_name,Teacher_name);
        if(check==true)
        {
           try{
                   // Class.forName("com.mysql.jdbc.Driver");
                   final var T_N = course_name;
                   
                  Total_number_of_students=Total_number_of_students+Student_numbers;
                   final var n = Total_number_of_students;
                   int sections=(Total_number_of_students/40);
                   if(Total_number_of_students%40!=0)
                   {
                       sections++;
                   }
                   final var b = sections;
                   final var c= sections;
                      
                    Connection Conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable_project","root","Zia3695@gmail");
                    Statement myStatement = Conn.createStatement();
                   String sql = "update section_allocation  set Total_number_of_Students='"+n+"', Total_number_of_sections='"+b+"',total_rooms_allocated='"+c+"'"
                           +"where Course_name='"+T_N+"'  AND  teacher_name='"+Teacher_name+"'  ";
                   myStatement.executeUpdate(sql);
                   System.out.println("Connected successfully");
                  return (sections-total_rooms);
                  
                } 
                catch(Exception exc){
                    System.out.println("Error occured");
                    exc.printStackTrace();
                    return 0;
                }
        } 
        else
        {
                  try{
                   // Class.forName("com.mysql.jdbc.Driver");  
                   int sections=(Student_numbers/40);
                   if(Student_numbers%40!=0)
                   {
                       sections=sections+1;
                   }
                   
                    Connection Conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable_project","root","Zia3695@gmail");
                    Statement myStatement = Conn.createStatement();
                   String sql = "insert into section_allocation"
                           +"(Course_name,Total_number_of_Students,Total_number_of_sections,total_rooms_allocated,teacher_name)"
                           +"values('"+course_name+"','"+Student_numbers+"','"+sections+"','"+sections+"','"+Teacher_name+"'  )";
                   myStatement.executeUpdate(sql);
                    System.out.println("Connected successfully");
                  return sections;
                  
                } 
                catch(Exception exc){
                    System.out.println("Error occured");
                    exc.printStackTrace();
                    return 0;
                }    
        }
            
    }
    
}
