/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timetable.data;
import Timetable.data.mysql.*;


public class Room_decision_and_Allocation_with_timeslot 
{
    private String Day;
    private String Time_slot;
    private String course;
    private String Teacher_name;
    private String RoomID;
    
   public  
    
    Room_decision_and_Allocation_with_timeslot()
    {
        
    }
    
    
    public void insert_DATA_INTO_TABLE()
    {
            Room_Allocation_database obj=new Room_Allocation_database();
            obj.Room_Allocation_once();
    }
    
    public boolean Course_room_allocation(String Course_name,String Teacher_name)
    {
            Room_Allocation_database obj=new Room_Allocation_database();
            if(obj.ROOM_Allocation(Course_name, Teacher_name)==true)
                    return true;
            else
                  return false;
    }
    
}
