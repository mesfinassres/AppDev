package Application;
import Persistence.StudentDAO;

import java.util.List;

public class Student extends Application.Person{
   private int    ID;
   private String EnrolType,EnrolYear,RegApproval;
   StudentDAO studentDAO = new StudentDAO();
   //constructor method for student class
   public Student(){
       
   }
   public Student(String Name, String FatherName, String GrandFather,
                        String Gender,String Birthdate, String EnrolType, 
                        String EnrolYear, String Username, String Password,
                        String RegApproval)throws Exception{
             this.setId();
             this.setName(Name);
             this.setFatherName(FatherName);
             this.setGrandFather(GrandFather);
             this.setGender(Gender);
             this.setBirthdate(Birthdate);
             this.setEnrolType(EnrolType);
             this.setEnrolYear(EnrolYear);
             this.setUsername(Username);
             this.setPassword(Password);
             this.setRegApproval(RegApproval);
   }
   // Setter methods for student class
   private void setId() throws Exception{
        int maxid=studentDAO.read();
        this.ID=++maxid;
   } 
   public void setIDs(int IDs){
       this.ID = IDs;
   }     
   private void setEnrolType(String EnrolType){
       this.EnrolType=EnrolType;
   }
   private void setEnrolYear(String EnrolYear){
       this.EnrolYear=EnrolYear;
   }
   public void setRegApproval(String RegApproval){
       this.RegApproval=RegApproval;
   }
   
   //Getter methods for student class
   public int getId(){
       return this.ID;
   }
   public String getEnrolType(){
       return this.EnrolType;
   }
   public String getEnrolYear(){
       return this.EnrolYear;
   }
   public String getRegApproval(){
       return this.RegApproval;
   }
   //Add a student record into the database
   public void Insert() throws Exception{
       studentDAO.write(this.ID, this.Name,this.FatherName,this.GrandFather,this.
                        Gender,this.Birthdate,this.EnrolType,this.EnrolYear,
                        this.Username, this.Password, this.RegApproval);    
   }
   public Student Search(int id) throws Exception{
       
       Student student = studentDAO.Search(id);

       return student;
   }
   public String login(String username, String password) throws Exception{
       StudentDAO stud = new StudentDAO();
       return stud.login(username, password);
   }
   public void UpdateLoginAccount(String uname, String pwd){
       StudentDAO stud = new StudentDAO();
       stud.UpdateLoginAccount(uname, pwd);
   }   
           
   public Student[] getStudentList(){
         StudentDAO studdao = new StudentDAO();

         return studdao.getStudentList();      
    }      
   public Course[] getCourseList(int id){
         StudentDAO student = new StudentDAO();
         return student.getCourseList(id);         
   }
   public void Register(String studentid, String courseid) throws Exception{
         StudentDAO studdao = new StudentDAO();

         studdao.Register(studentid,courseid);        
   }
   public void ApproveRegister(int id, String register){
       StudentDAO stud = new StudentDAO();
       stud.ApproveRegister(id, register);
   }     
   public Student[] getStudentsRegisteredFor(int courseid){
         StudentDAO studentdao = new StudentDAO();
         return studentdao.getStudentsRegisteredFor(courseid);
   }   
   public List<Student> getStudentLinkedList(){
     StudentDAO studentdao = new StudentDAO(); 
     return studentdao.getStudentLinkedList(); 
   }   
   public void Update(Student stud){
       StudentDAO studentdao = new StudentDAO();        
       studentdao.Update(stud);  
   }   
   public String PrintID(){
        
        String IDstring =this.EnrolType+"/";
        if((this.ID<=0)||(this.ID /  10000)>=1) 
            System.out.println("Incorrect student ID");
        else if(this.ID/1000>=1) 
            IDstring +=Integer.toString(this.ID);
        else if (this.ID/100>=1) 
            IDstring +="0"+Integer.toString(this.ID);
        else if (this.ID/10>=1) 
            IDstring +="00"+Integer.toString(this.ID);
        else if (this.ID/1>=1) 
            IDstring +="000"+Integer.toString(this.ID);            
        return IDstring+"/"+this.EnrolYear;
   } 
}
