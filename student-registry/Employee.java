package Application;
import Persistence.EmployeeDAO;

import java.util.List;

public class Employee extends Application.Person{
   private int    ID;    
   private String EmpType,EmpYear, RegApproval;
   EmployeeDAO employeeDAO = new EmployeeDAO();
   //constructor method for employee class
   public Employee(){
       
   }
   public Employee(String Name, String FatherName, String GrandFather,
                        String Gender,String Birthdate, String EmpType, 
                        String EmpYear, String Username, String Password,
                        String RegApproval)throws Exception{
             this.setId();
             this.setName(Name);
             this.setFatherName(FatherName);
             this.setGrandFather(GrandFather);
             this.setGender(Gender);
             this.setBirthdate(Birthdate);
             this.setEnrolType(EmpType);
             this.setEnrolYear(EmpYear);
             this.setUsername(Username);
             this.setPassword(Password);
             this.setRegApproval(RegApproval);
   }
   // Setter methods for employee class

   private void setId() throws Exception{
        int maxid = employeeDAO.read();
        this.ID = ++maxid;
   }
   public void setID(int id) throws Exception{
        this.ID = id;
   } 
   private void setEnrolType(String EnrolType){
       this.EmpType=EnrolType;
   }
   private void setEnrolYear(String EnrolYear){
       this.EmpYear=EnrolYear;
   }
   private void setRegApproval(String RegApproval){
       this.RegApproval=RegApproval;
   }
   
   //Getter methods for employee class
   public int getId(){
       return this.ID;
   }
   public String getEnrolType(){
       return this.EmpType;
   }
   public String getEnrolYear(){
       return this.EmpYear;
   }
   public String getRegApproval(){
       return this.RegApproval;
   }
   //Add a record into the database
   public void Insert() throws Exception{
       employeeDAO.write(this.ID, this.Name,this.FatherName,this.GrandFather,
                        this.Gender,this.Birthdate,this.EmpType,this.EmpYear,
                        this.Username, this.Password, this.RegApproval);    
   }
   public Employee Search(int id) throws Exception{
       Employee employee = employeeDAO.Search(id);
       return employee;
   }
   public boolean login(String username, String password) throws Exception{
       EmployeeDAO emp = new EmployeeDAO();
       return emp.login(username, password);
   }
   public void UpdateLoginAccount(String uname, String pwd){
       EmployeeDAO emp = new EmployeeDAO();
       emp.UpdateLoginAccount(uname, pwd);
   }
   public void SubmitGrade(int id, int code, String grade){
       EmployeeDAO emp = new EmployeeDAO();
       emp.SubmitGrade(id, code,grade);       
   }
   public List<Employee> getEmployeeList(){
     EmployeeDAO employeedao = new EmployeeDAO(); 
     return employeedao.getEmployeeList(); 
   }
   public void Update(Employee emp){
       EmployeeDAO employeedao = new EmployeeDAO();
       employeedao.Update(emp);          
   }
   public String PrintID(){
        
        String IDstring =this.EmpType+"/";
        if((this.ID<=0)||(this.ID /  10000)>=1) 
            System.out.println("Incorrect employee ID");
        else if(this.ID/1000>=1) 
            IDstring +=Integer.toString(this.ID);
        else if (this.ID/100>=1) 
            IDstring +="0"+Integer.toString(this.ID);
        else if (this.ID/10>=1) 
            IDstring +="00"+Integer.toString(this.ID);
        else if (this.ID/1>=1) 
            IDstring +="000"+Integer.toString(this.ID);            
        return IDstring+"/"+this.EmpYear;
   } 
}