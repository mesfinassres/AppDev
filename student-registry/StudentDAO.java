package Persistence;
import Application.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Application.Student;

import java.util.List;
import java.util.LinkedList;

import java.util.Calendar;

public class StudentDAO {
    
	private PreparedStatement preparedStatement = null;
        DBconnect connect=new DBconnect();
        Calendar dateTime = Calendar.getInstance();

        public int read() throws Exception {
            String QueryString="SELECT id from studentregistry.students";
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
                        String Gender,String Birthdate, String EnrolType, 
                        String EnrolYear, String Username, String Password, 
                        String RegApproval) throws Exception {
            
           String QueryString = "INSERT INTO STUDENTS values ("+ID+",'"+Name+
                    "','"+FatherName+"','"+GrandFather+"','"+
                    Gender+"',"+Birthdate+",'"+EnrolType+"',"+EnrolYear+",'"+Username+
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
        public Student Search(int id) throws Exception{
            String QueryString="SELECT * from studentregistry.students where id="+Integer.toString(id);
            Connection conn= connect.open();
            ResultSet resultset;
            Student student=null;

            try {   
                    preparedStatement = conn.prepareStatement(QueryString);
                    resultset = preparedStatement.executeQuery();

            } catch (Exception e) {
                    throw e;
            } finally {
                    connect.close();
            }

            if (resultset.next()) {
             
                student = new Student(resultset.getString("firstname"),resultset.getString("FathersName"),
                              resultset.getString("grandfather"),resultset.getString("gender"),
                              resultset.getString("datebirth"),resultset.getString("enroltype"),
                              resultset.getString("enroldate"),resultset.getString("username"),
                              resultset.getString("password"),resultset.getString("regapproved"));   
            }
            return student;
        }        
        public String login(String username, String password)throws Exception{
            String QueryString="SELECT * from studentregistry.students where username='"+username+"'";
            String uname=null, pwd=null;
            String id = "";
            
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
                id = resultset.getString("id");
                
            }
            if(username.equals(uname)&&password.equals(pwd))
                return id;
            else return null;
        }
        public void UpdateLoginAccount(String uname, String pwd) {
            String QueryString="Update studentregistry.students set password='"+
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
        public Student[] getStudentList(){
            
            String QueryString="SELECT * FROM studentregistry.students";         
            Connection conn= connect.open();
            ResultSet resultset;
            int i=0;
            Student[] student=null; 
            try {   
                    preparedStatement = conn.prepareStatement(QueryString);
                    resultset = preparedStatement.executeQuery();
                    resultset.last();
                    student = new Student[resultset.getRow()];
                    resultset.first();
                    do{ 
                        Student stud = new Student(resultset.getString("firstname"),
                        resultset.getString("fathersname"), resultset.getString("grandfather"), resultset.getString("gender"),
                        resultset.getString("datebirth"), resultset.getString("enroltype"),resultset.getString("enroldate"),
                        resultset.getString("username"), resultset.getString("password"), resultset.getString("regapproved"));
                        stud.setIDs(resultset.getShort("ID"));
                        
                        student[i]= stud;
                        i++;
                        
                    } while(resultset.next()==true);

            } 
            catch (Exception e) {} 
            finally {
                    connect.close();
            }
            return student;      
    }     
    public void Register(String studentid, String courseid) throws Exception {
        
       String date = dateTime.getTime().toString();
              date = date.subSequence(4,11).toString()+date.subSequence(24, 28).toString();
       String QueryString = "INSERT INTO registration values (default,"+studentid+","+courseid+
                            ",'"+date+"',default)";

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
    public void ApproveRegister(int id, String register) {
        String QueryString="Update studentregistry.students set regapproved='"+
                            register+"'where id='"+id+"'";

        Connection conn= connect.open();

        try {   
                preparedStatement = conn.prepareStatement(QueryString);
                preparedStatement.execute();

        } catch (Exception e) {

        } finally {
                connect.close();
        }
    } 
    public Course[] getCourseList(int id){   
            String QueryString = null;
            if(id==0) {
                     QueryString= "SELECT studentregistry.courses.* FROM studentregistry.courses "+
                                  "WHERE courses.courseid in (SELECT registration.courseid from studentregistry.registration)";
            }
            else{
                     QueryString= "SELECT studentregistry.courses.* "+ 
                                    "FROM studentregistry.courses LEFT JOIN studentregistry.registration "+
                                    "ON courses.courseid=registration.courseid "+
                                    "WHERE studentregistry.registration.studid="+Integer.toString(id);                
            }
            Connection conn= connect.open();
            ResultSet resultset;
            int i=0;
            Course[] course=null; 
            try {                   
                    preparedStatement = conn.prepareStatement(QueryString);
                    resultset = preparedStatement.executeQuery();
                    resultset.last();
                    course = new Course[resultset.getRow()];
                    resultset.first();
                    do{ 
                        Course crs = new Course(resultset.getString("title"),
                        resultset.getString("hostdept"), resultset.getString("levelcat"), resultset.getString("requizit"),
                        resultset.getString("credithour"), resultset.getString("year"),resultset.getString("semester"));
                        crs.setIDs(resultset.getShort("courseID"));
                        
                        course[i]= crs;
                        i++;

                        
                    } while(resultset.next()==true);
            } 
            catch (Exception e) {} 
            finally {
                    connect.close();
            }
            return course;      
    }
    public Student[] getStudentsRegisteredFor(int courseid){   
            String QueryString= "SELECT studentregistry.students.* "+ 
                                "FROM studentregistry.students LEFT JOIN studentregistry.registration ON students.id=registration.studid "+
                                "WHERE studentregistry.registration.courseid="+Integer.toString(courseid)+" AND registration.grade is null";
            Connection conn= connect.open();
            ResultSet resultset;
            int i=0;
            Student[] student=null; 
            try {   
                    preparedStatement = conn.prepareStatement(QueryString);
                    resultset = preparedStatement.executeQuery();
                    resultset.last();
                    student = new Student[resultset.getRow()];
                    resultset.first();
                    do{ 
                        Student stud = new Student(resultset.getString("firstname"),
                        resultset.getString("fathersname"), resultset.getString("grandfather"), resultset.getString("gender"),
                        resultset.getString("datebirth"), resultset.getString("enroltype"),resultset.getString("enroldate"),
                        resultset.getString("username"), resultset.getString("password"), resultset.getString("regapproved"));
                        stud.setIDs(resultset.getShort("ID"));
                        
                        student[i]= stud;
                        i++;
                        
                    } while(resultset.next()==true);

            } 
            catch (Exception e) {} 
            finally {
                    connect.close();
            }
            return student;  
    }  
    public List<Student> getStudentLinkedList(){
        List< Student > studlist = new LinkedList< Student >();        
        String QueryString="SELECT * FROM studentregistry.students";         
        Connection conn= connect.open();
        ResultSet resultset;
        try {   
                preparedStatement = conn.prepareStatement(QueryString);
                resultset = preparedStatement.executeQuery();
   
                while(resultset.next()) { 
                    Student stud = new Student(resultset.getString("firstname"),resultset.getString("fathersname"), 
                                               resultset.getString("grandfather"), resultset.getString("gender"),
                                               resultset.getString("datebirth"), resultset.getString("enroltype"),
                                               resultset.getString("enroldate"),resultset.getString("username"), 
                                               resultset.getString("password"), resultset.getString("regapproved"));
                    stud.setIDs(resultset.getShort("ID"));                        
                    studlist.add(stud);
                }
        } 
        catch (Exception e) {} 
        finally {
                connect.close();
        }    
         return studlist;
    }
    public void Update(Student stud) {        
        String QueryString="UPDATE studentregistry.students SET "+
                            "firstname='"+stud.getName()+"',FathersName='"+stud.getFatherName()+
                            "',grandfather='"+stud.getGrandFather()+"',gender='"+stud.getGender()+
                            "',datebirth='"+stud.getBirthdate()+"',enroltype='"+stud.getEnrolType()+
                            "',enroldate='"+stud.getEnrolYear()+"',username='"+stud.getUsername()+
                            "',password='"+stud.getPassword()+"',regapproved='"+stud.getRegApproval()+
                            "' WHERE id="+stud.getId(); 
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