/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timetable.data;
import Timetable.data.mysql.*;


public class Room_and_slot_with_choice {
    private String Day;
    private String Time_slot;
    private String course;
    private String Teacher_name;
    private String RoomID;
    
   public  
    
    Room_and_slot_with_choice()
    {
        
    }
    
    
    
    public int Course_room_allocation(String Course_name,String Teacher_name,String timeslot,String day)
    {
            SLOT_and_room_with_choice obj=new SLOT_and_room_with_choice();
            if(obj.ROOM_Allocation(Course_name, Teacher_name,timeslot,day)==true)
                    return 1;
            else
            {
                Room_Allocation_database obj2=new  Room_Allocation_database();
                if(obj2.ROOM_Allocation(Course_name, Teacher_name)==true)
                {
                    return 2;
                }
                else 
                    return 3;
                
            }
    }
    
}
