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




public class SLOT_and_room_with_choice {
    
    private String Day_information;
    private String time_slot;
    private String Course_information;
    private int count;
    private String Teacher_name;
    
    
    public
            
    SLOT_and_room_with_choice()
    {
        count=0;
    }
            
            
        public boolean ROOM_Allocation(String course_name,String teacher,String timeslot,String day)
        {
                    String Day1="Monday";
                    String Day2="Tuesday";
                    String Day3="Wednesday";
                    String Day4="Thursday";
                    String Day5="Friday";
                    
                    
                    ArrayList <String> Timeslot=new ArrayList();
                    Timeslot.add("8:00am-9:30am");
                    Timeslot.add("9:30am-11:00am");
                    Timeslot.add("11:00am-12:30pm");
                    Timeslot.add("12:30pm-2:00pm");
                    Timeslot.add("2:00pm-3:30pm");
                    Timeslot.add("3:30pm-5:00pm");
                    Timeslot.add("5:00pm-6:30pm");
                    Timeslot.add("6:30pm-8:00pm");
                
            try{
                   // Class.forName("com.mysql.jdbc.Driver");
                    var myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable_project","root","Zia3695@gmail");
                    Statement myStatement = myConn.createStatement();
                    ResultSet myRs = myStatement.executeQuery("Select * from Room_Allocation");
                
                    while(myRs.next())
                    {
                            Day_information = myRs.getString("Day");
                            time_slot=myRs.getString("Timeslot");
                           if(time_slot.equals(timeslot) && Day_information.equals(day))
                           {
                               break;
                           }
                    }
                    
                         for(int k=0;k<17;k++)
                         {
                            Day_information = myRs.getString("Day");
                            time_slot=myRs.getString("Timeslot");
                            Course_information=myRs.getString("Course");
                            Teacher_name=myRs.getString("Teacher_name");
                
                            if(teacher.equals(Teacher_name) || time_slot.equals(timeslot) && Day_information.equals(day))
                            {
                                return false;
                            }
                             myRs.next();
                         }
                         
                
                    int Status1;
                    ResultSet Testing = myStatement.executeQuery("Select * from Room_Allocation where Day='"+Day_information+"' AND  Timeslot='"+time_slot+"'");
                    while(Testing.next())
                    {
                        Status1=Integer.parseInt(Testing.getString("Status"));
                         if(Status1==0)
                         {
                               String sql = "update Room_Allocation   set Course='"+course_name+"', Teacher_name='"+teacher+"',Status='"+1+"'"
                           +"where Day='"+Testing.getString("Day")+"'  AND  Timeslot='"+Testing.getString("Timeslot")+"' AND  RoomID='"+Testing.getString("RoomID")+"'"  ;
                              myStatement.executeUpdate(sql);
                              break;          
                         }
                    }
                    System.out.println("Entering3");
                
                    return true;
            }
                catch(Exception exc){
                    System.out.println("Error occured");
                    exc.printStackTrace();
                }
            return false;
        }
        
}
