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



public class Room_Allocation_database {
    
    private String Day_information;
    private String time_slot;
    private String Course_information;
    private int count;
    private String Teacher_name;
    
    
    public
            
    Room_Allocation_database()
    {
        count=0;
    }
            
    public void Room_Allocation_once()
    {
                 try{
                   // Class.forName("com.mysql.jdbc.Driver");  
                    Connection Conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable_project","root","Zia3695@gmail");
                    Statement myStatement = Conn.createStatement();
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
                    
                    
                    
                    
                    
                    for(int i=0;i<8;i++)
                    {
                        for(int j=1;j<18;j++)
                        {
                     String sql = "insert into Room_Allocation"
                           +"(Day,Timeslot,Course,Teacher_name,RoomID,Status)"
                           +"values('"+Day1+"','"+Timeslot.get(i)+"','"+null+"','"+null+"','"+("CS"+j)+"','"+0+"')";
                            myStatement.executeUpdate(sql);
                        }
                    }
                    
                    for(int i=0;i<8;i++)
                    {
                        for(int j=1;j<18;j++)
                        {
                     String sql = "insert into Room_Allocation"
                           +"(Day,Timeslot,Course,Teacher_name,RoomID,Status)"
                           +"values('"+Day2+"','"+Timeslot.get(i)+"','"+null+"','"+null+"','"+("CS"+j)+"','"+0+"')";
                            myStatement.executeUpdate(sql);
                        }
                    }
                   
                    for(int i=0;i<8;i++)
                    {
                        for(int j=1;j<18;j++)
                        {
                     String sql = "insert into Room_Allocation"
                           +"(Day,Timeslot,Course,Teacher_name,RoomID,Status)"
                           +"values('"+Day3+"','"+Timeslot.get(i)+"','"+null+"','"+null+"','"+("CS"+j)+"','"+0+"')";
                            myStatement.executeUpdate(sql);
                        }
                    }
                   
                 
                    for(int i=0;i<8;i++)
                    {
                        for(int j=1;j<18;j++)
                        {
                     String sql = "insert into Room_Allocation"
                           +"(Day,Timeslot,Course,Teacher_name,RoomID,Status)"
                           +"values('"+Day4+"','"+Timeslot.get(i)+"','"+null+"','"+null+"','"+("CS"+j)+"','"+0+"')";
                            myStatement.executeUpdate(sql);
                        }
                    }
                   
                   
                    for(int i=0;i<8;i++)
                    {
                        for(int j=1;j<18;j++)
                        {
                     String sql = "insert into Room_Allocation"
                           +"(Day,Timeslot,Course,Teacher_name,RoomID,Status)"
                           +"values('"+Day5+"','"+Timeslot.get(i)+"','"+null+"','"+null+"','"+("CS"+j)+"','"+0+"')";
                            myStatement.executeUpdate(sql);
                        }
                    }
                   
                   System.out.println("Connected successfully");
                  
                } 
                catch(Exception exc){
                    System.out.println("Error occured");
                    exc.printStackTrace();
                }      
             
        }
            
        public boolean ROOM_Allocation(String course_name,String teacher)
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
                
                    for(int i=0;i<5;i++)
                    {   
                        int c=0;
                       for(int j=0;j<8;j++)
                       {
                         int check=0;
                         for(int k=0;k<17;k++)
                         {
                           myRs.next();
                             Day_information = myRs.getString("Day");
                            time_slot=myRs.getString("Timeslot");
                            Course_information=myRs.getString("Course");
                            Teacher_name=myRs.getString("Teacher_name");
                
                            if(course_name.equals(Course_information) || teacher.equals(Teacher_name))
                            {
                                check=0;
                                break;        
                            }
                            check=1;
                            
                         }
                         if(check==1)
                         {
                             c=1;
                             break;
                         }
                       }
                       if(c==1)
                          break;
                    
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
