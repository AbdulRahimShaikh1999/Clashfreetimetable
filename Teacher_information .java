/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timetable.data;
import Timetable.data.mysql.*;



public class Teacher_information 
{
    private String Teacher_name;
    private String Course_name;
    private  int No_of_students;
    
    public
    
        Teacher_information()
        {
            
        }
        
        public void set_teacher_name(String T_N)
        {
            Teacher_name=T_N;
        }
    
        public void set_Course_name(String T_C)
        {
            Course_name=T_C;
        }
        
        public void set_no_of_students(int T_N_S)
        {
            No_of_students=T_N_S;
        }
            
        public String get_Teacher_name()
        {
            return Teacher_name;
        }
    
        
        public String get_Course_name()
        {
            return Course_name;
        }
        
        public int get_no_of_students()
        {
            return No_of_students;
        }
 
        
        public boolean insert()
        {
            System.out.println(this.get_Teacher_name());
            System.out.println(this.get_Course_name());
            System.out.println(this.get_no_of_students());
                
            insert_teacher_database obj=new insert_teacher_database();
            if(obj.insertteacher(this.get_Teacher_name(),this.get_Course_name(),this.get_no_of_students())==false)
                    return false;
            else
                return true;
            
        }
        
}
