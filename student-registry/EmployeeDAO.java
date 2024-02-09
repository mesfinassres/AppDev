package Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Application.Employee;

import java.util.List;
import java.util.LinkedList;

public class EmployeeDAO {
    
	private PreparedStatement preparedStatement = null;
        DBconnect connect=new DBconnect();

        public int read() throws Exception {
            String QueryString="SELECT id from studentregistry.employees";
            Connection conn= connect.open();
            ResultSet Rset;
            int id=0, max=0;
            
            try {   
                    preparedStatement = conn.prepareStatement(QueryString);
                    Rset = preparedStatement.executeQuery();

            } catch (Exception e) {
                    throw e;
            } finally {
                    connect.close();
            }
            while (Rset.next()) {

                id = Integer.parseInt(Rset.getString("id"));
                if(max<id) max=id;
             }
            return max;
	}
        public void write(int ID, String Name, String FatherName, String GrandFather,
                        String Gender,String Birthdate, String EmpType, 
                        String EmpYear, String Username, String Password, 
                        String RegApproval) throws Exception {
            
           String QueryString = "INSERT INTO EMPLOYEES values ("+ID+",'"+Name+
                    "','"+FatherName+"','"+GrandFather+"','"+
                    Gender+"',"+Birthdate+",'"+EmpType+"',"+EmpYear+",'"+Username+
                    "','"+Password+"','"+RegApproval+"')";
            Connection conn= connect.open();
            try {   
                    preparedStatement = conn.prepareStatement(QueryString);
                    preparedStatement.executeUpdate();
            } catch (Exception e) {
                    throw e;
            } finally {
                    connect.close();
            }
	}
        public Employee Search(int id) throws Exception{
            String QueryString="SELECT * from studentregistry.employees where id="+Integer.toString(id);
            Connection conn= connect.open();
            ResultSet resultset;
            Employee employee=null;

            try {   
                    preparedStatement = conn.prepareStatement(QueryString);
                    resultset = preparedStatement.executeQuery();

            } catch (Exception e) {
                    throw e;
            } finally {
                    connect.close();
            }

            if (resultset.next()==true) {
                employee = new Employee(resultset.getString("firstname"),resultset.getString("FathersName"),
                              resultset.getString("grandfather"),resultset.getString("gender"),
                              resultset.getString("datebirth"),resultset.getString("emptype"),
                              resultset.getString("empdate"),resultset.getString("username"),
                              resultset.getString("password"),resultset.getString("regapproved"));   
            }
            return employee;
        }
        public boolean login(String username, String password)throws Exception{
            String QueryString="SELECT * from studentregistry.employees where username='"+username+"'";
            String uname=null, pwd=null;
            
            Connection conn= connect.open();
            ResultSet resultset;

            try {   
                    preparedStatement = conn.prepareStatement(QueryString);
                    resultset = preparedStatement.executeQuery();

            } catch (Exception e) {
                    throw e;
            } finally {
                    connect.close();
            }

            if (resultset.next()==true) {
                uname=resultset.getString("username");
                pwd = resultset.getString("password");
            }
            if(username.equals(uname)&&password.equals(pwd))
                return true;
            else return false;
        }
        public void UpdateLoginAccount(String uname, String pwd) {
            String QueryString="Update studentregistry.employees set password='"+
                                pwd+"'where username='"+uname+"'";
            
            Connection conn= connect.open();
            boolean updated=false;

            try {   
                    preparedStatement = conn.prepareStatement(QueryString);
                    updated = preparedStatement.execute();

            } catch (Exception e) {
                  
            } finally {
                    connect.close();
            }
            
        }
        public void SubmitGrade(int id, int code, String grade) {
            String QueryString="UPDATE studentregistry.registration SET grade='"+grade+
                               "' WHERE studid="+id+" AND courseid="+code;
            
            Connection conn= connect.open();
            boolean updated=false;

            try {   
                    preparedStatement = conn.prepareStatement(QueryString);
                    updated = preparedStatement.execute();

            } catch (Exception e) {
                  
            } finally {
                    connect.close();
            }
            
        }
        public List<Employee> getEmployeeList(){
            List< Employee > emplist = new LinkedList< Employee >();        
            String QueryString="SELECT * FROM studentregistry.employees";         
            Connection conn= connect.open();
            ResultSet resultset;

            try {   
                    preparedStatement = conn.prepareStatement(QueryString);
                    resultset = preparedStatement.executeQuery();
                    while(resultset.next()) { 
                        Employee emp = new Employee(resultset.getString("firstname"),resultset.getString("FathersName"),
                                                    resultset.getString("grandfather"),resultset.getString("gender"),
                                                    resultset.getString("datebirth"),resultset.getString("emptype"),
                                                    resultset.getString("empdate"),resultset.getString("username"),
                                                    resultset.getString("password"),resultset.getString("regapproved"));
                        emp.setID(resultset.getShort("ID"));                        
                        emplist.add(emp);
                        
                    }
            } 
            catch (Exception e) {} 
            finally {
                    connect.close();
            }    
             return emplist;
        }  
        public void Update(Employee emp) {
            String QueryString="UPDATE studentregistry.employees SET "+
                                "firstname='"+emp.getName()+"',FathersName='"+emp.getFatherName()+
                                "',grandfather='"+emp.getGrandFather()+"',gender='"+emp.getGender()+
                                "',datebirth='"+emp.getBirthdate()+"',emptype='"+emp.getEnrolType()+
                                "',empdate='"+emp.getEnrolYear()+"',username='"+emp.getUsername()+
                                "',password='"+emp.getPassword()+"',regapproved='"+emp.getRegApproval()+
                                "' WHERE id="+emp.getId(); 
            Connection conn= connect.open();
            try {                   
                    preparedStatement = conn.prepareStatement(QueryString);
                    preparedStatement.execute();                    

            } catch (Exception e) {
                  
            } finally {
                    connect.close();
            }
            
        }        
}