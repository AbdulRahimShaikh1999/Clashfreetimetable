/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timetable.data;

import Timetable.data.mysql.*;

public class Section {
   private String Course_name;
    private  int No_of_students;
    private String Teacher_name;
    public
    
        Section()
        {
            
        }
        
        public void set_Course_name(String T_C)
        {
            Course_name=T_C;
        }
        
        public void set_Teacher_name(String T_C)
        {
            Teacher_name=T_C;
        }
        
        public void set_no_of_students(int T_N_S)
        {
            No_of_students=T_N_S;
        }
            
        
        public String get_Course_name()
        {
            return Course_name;
        }
        
        public String get_Teacher_name()
        {
            return Teacher_name;
        }
        
        
        public int get_no_of_students()
        {
            return No_of_students;
        }
 
        
        public int insert()
        {
            System.out.println(this.get_Course_name());
            System.out.println(this.get_no_of_students());
            System.out.println(this.get_Teacher_name());
            
            
            Section_database obj=new Section_database();
            int count=obj.Section_allocation(this.get_Course_name(),this.get_no_of_students(),get_Teacher_name());
                    System.out.println(count);
                    return count;
        }
     
}
