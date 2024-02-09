package Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Application.Course;

import java.util.List;
import java.util.LinkedList;

public class CourseDAO {
    
	private PreparedStatement preparedStatement = null;
        DBconnect connect=new DBconnect();

        public int read() throws Exception {
            String QueryString="SELECT courseid from studentregistry.courses";
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

                id = Integer.parseInt(Rset.getString("courseid"));
                if(max<id) max=id;
             }
            return max;
	}
        public void write(int courseID, String Title, String HostDept, String Level,
                        String requisite,String credithour, String year, String semester) throws Exception {
            
           String QueryString = "INSERT INTO COURSES values ("+courseID+",'"+Title+"','"+HostDept+
                    "','"+Level+"',"+requisite+","+credithour+","+year+","+semester+")";

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
        public Course Search(int id) throws Exception{
            String QueryString="SELECT * from studentregistry.courses where courseid="+Integer.toString(id);
            Connection conn= connect.open();
            ResultSet resultset;
            Course course=null;

            try {   
                    preparedStatement = conn.prepareStatement(QueryString);
                    resultset = preparedStatement.executeQuery();

            } catch (Exception e) {
                    throw e;
            } finally {
                    connect.close();
            }

            if (resultset.next()==true) {
                course = new Course(resultset.getString("Title"),resultset.getString("HostDept"),
                              resultset.getString("levelcat"),resultset.getString("requisite"),
                              resultset.getString("credithour"),resultset.getString("year"),
                              resultset.getString("semester"));   
            }
            return course;
        }
  
        public Course[] getList(){
            
            String QueryString="SELECT * FROM studentregistry.courses";         
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
                        Course  acourse = new Course(resultset.getString("Title"),resultset.getString("HostDept"),
                              resultset.getString("levelcat"),resultset.getString("requizit"),
                              resultset.getString("credithour"),resultset.getString("year"),
                              resultset.getString("semester"));
                        acourse.setIDs(resultset.getShort("courseID"));
                        
                        course[i]= acourse;
                        i++;
                        
                    } while(resultset.next()==true);

            } 
            catch (Exception e) {} 
            finally {
                    connect.close();
            }
            return course;      
    }   
    public String getGrade(int id, int code){
            String QueryString="SELECT * FROM studentregistry.registration "+
                               "WHERE studid="+id+" AND courseid="+code;         
            Connection conn= connect.open();
            ResultSet resultset;
            String grade=null; 
            try {   
                    preparedStatement = conn.prepareStatement(QueryString);
                    resultset = preparedStatement.executeQuery();
                    if(resultset.next())
                        grade = resultset.getString("grade");
            } 
            catch (Exception e) {} 
            finally {
                    connect.close();
            }
            return grade;              
    }
    public List<Course> getCourseList(){
        List< Course > courselist = new LinkedList< Course >();        
        String QueryString="SELECT * FROM studentregistry.courses";         
        Connection conn= connect.open();
        ResultSet resultset;

        try {   
                preparedStatement = conn.prepareStatement(QueryString);
                resultset = preparedStatement.executeQuery();
                while(resultset.next()) { 
                        Course  course = new Course(resultset.getString("Title"),resultset.getString("HostDept"),
                              resultset.getString("levelcat"),resultset.getString("requizit"),
                              resultset.getString("credithour"),resultset.getString("year"),
                              resultset.getString("semester"));
                    course.setIDs(resultset.getShort("courseID"));                        
                    courselist.add(course);

                }
        } 
        catch (Exception e) {} 
        finally {
                connect.close();
        }    
         return courselist;
    }  
    public void Update(Course course) {
        String QueryString="UPDATE studentregistry.courses SET "+
                            "title='"+course.getTitle()+"',hostdept='"+course.getHostDept()+
                            "',levelcat='"+course.getLevel()+"',requizit='"+course.getRequisite()+
                            "',credithour='"+course.getCredithour()+"',year='"+course.getYear()+
                            "',semester='"+course.getSemester()+
                            "' WHERE courseid="+course.getCourseId(); 
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