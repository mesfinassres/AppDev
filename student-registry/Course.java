package Application;
import Persistence.CourseDAO;
import javax.swing.JOptionPane;

import java.util.List;

public class Course {
   private int    courseid;
   private String Title,HostDept,Level;
   private String requisite, credithour, year, semester;
   CourseDAO courseDAO = new CourseDAO();
 
   public Course(){
       
   }
   public Course(String Title, String HostDept, String Level,
                        String requisite,String credithour, String year, String semester)throws Exception{
             this.setCourseId();
             this.setTitle(Title);
             this.setHostDept(HostDept);
             this.setLevel(Level);
             this.setRequisite(requisite);
             this.setCredithour(credithour);
             this.setYear(year);
             this.setSemester(semester);
   }
   public void setIDs(int ID){
       this.courseid = ID;
   }

   private void setCourseId() throws Exception{
        int maxid=courseDAO.read();
        this.courseid=++maxid;
   } 
   private void setTitle(String Title){
       this.Title=Title;
   }
   private void setHostDept(String HostDept){
       this.HostDept=HostDept;
   }
   private void setLevel(String Level){
       this.Level=Level;
   }
   private void setRequisite(String requisite){
       this.requisite=requisite;
   }
   private void setCredithour(String credithour){
       this.credithour=credithour;
   }
   private void setYear(String year){
       this.year=year;
   }
   private void setSemester(String semester){
       this.semester=semester;
   }
   
   public int getCourseId(){
       return this.courseid;
   }
   public String getTitle(){
       return this.Title;
   }
   public String getHostDept(){
       return this.HostDept;
   }
   public String getLevel(){
       return this.Level;
   }
   public String getRequisite(){
       return this.requisite;
   }
   public String getCredithour(){
       return this.credithour;
   }
   public String getYear(){
       return this.year;
   }
   public String getSemester(){
       return this.semester;
   }

   public void Insert() throws Exception{
       courseDAO.write(this.courseid, this.Title,this.HostDept,this.Level,
                        this.requisite,this.credithour, this.year,this.semester);    
   }
   public Course Search(int id) throws Exception{
       Course course = courseDAO.Search(id);
       return course;
   }
           
   public Course[] getList(){
         CourseDAO coursedao = new CourseDAO();
         return coursedao.getList();      
    }
   public String getGrade(int id, int code){
         CourseDAO coursedao = new CourseDAO();        
         return coursedao.getGrade(id,code);      
   }   
   public List<Course> getCourseList(){
     CourseDAO coursedao = new CourseDAO(); 
     return coursedao.getCourseList(); 
   }   
   public void Update(Course course){
       CourseDAO coursedao = new CourseDAO();
       coursedao.Update(course);          
   }   
   public String PrintCourseId()throws Exception{
        
        String IDstring =this.HostDept.substring(0, 3);
        if((this.courseid<=0)||(this.courseid /  1000)>=1) 
            System.out.println("Incorrect student ID");
        else if(this.courseid/100>=1) 
            IDstring +=Integer.toString(this.courseid);
        else if (this.courseid/10>=1) 
            IDstring +="0"+Integer.toString(this.courseid);
        else if (this.courseid>=1) 
            IDstring +="00"+Integer.toString(this.courseid);            
        return IDstring;
   }    
}