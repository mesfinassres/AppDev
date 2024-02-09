<html>


<%@page contentType="text/html"%>
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.lang.*" %>

<%!

   ResultSet rs=null;
//---------------------Connect to database-----------------------------------
ResultSet ConnectDataAccess(String Query) {

  ResultSet rs=null;
	Connection con;
	String url = "jdbc:mysql://localhost:3306/elearning?user=root&password=Hadaslema1";

  try{
      //Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");
		Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection (url);
      Statement stmt=con.createStatement(
         ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
      rs= stmt.executeQuery(Query);       
	
  }
  catch(Exception E) {
   System.out.println("Exception caught : "+E);
   E.printStackTrace(); 
  }    
 	return rs;
}// ConnectDataAccess    
   
%>


<form name="form1" method="post" action="">
  <table width="46%" border="1" bordercolor="#00FFFF" bgcolor="#33FFFF" height="101">
    <tr> 
      <td width="3%" height="2">&nbsp;</td>
      <td colspan="2" height="2"> 
        <p><font size="4">Student performance monitoring </font><font size="4">(</font>use 
          id or username<font size="4">)</font></p>
        </td>
    </tr>
    <tr> 
      <td width="3%" height="2">&nbsp;</td>
      <td width="49%" height="2"><b>Username</b></td>
      <td width="48%" height="2"> 
        <input type="text" name="username" size="20">
      </td>
    </tr>
    <tr> 
      <td width="3%" height="26" rowspan="2"> 
        <p>&nbsp;</p>
      </td>
      <td height="12" width="49%"><b>or</b></td>
      <td width="48%" height="12">&nbsp; </td>
    </tr>
    <tr> 
      <td height="12" width="49%"><b>ID number</b></td>
      <td width="48%" height="12">
        <input type="text" name="id" size="20">
      </td>
    </tr>
    <tr> 
      <td width="3%" height="2">&nbsp;</td>
      <td height="2" width="49%">&nbsp; </td>
      <td width="48%" height="2"> 
        <input type=SUBMIT name="Show" value="Show">
      </td>
    </tr>
  </table>
</form>


<!-----------------------------List students------------------------------------------->

<%
      String username = request.getParameter("username");

      String id = request.getParameter("id");

      String Query = "SELECT LessonInfo.Number, LessonInfo.Title " +
                     "FROM Student INNER JOIN (LessonInfo INNER JOIN " + 
                     "StudentPerformance ON LessonInfo.Number = StudentPerformance.LessonNo) " + 
                     "ON Student.Username = StudentPerformance.UserId " +
                     "WHERE UserId='" + username + "' OR Id='" + id + "'";
     
      rs = ConnectDataAccess(Query);
    
      if ((rs!=null)&& ((username!=null)||(id!=null)))  

       if (rs.next())  {
           
           rs.beforeFirst();
%>
           <p>&nbsp;</p>
           <table width="59%" border="1" name="lessons">
           <tr bgcolor="#FFFF00"> 
             <td colspan="2"><font size="4">List of Lessons</font></td>
           </tr>

           <tr bgcolor="#FFFF00"> 
           <td width="29%"><font size="4">Lesson number</font></td>
           <td width="71%"> 
           <div align="center"><font size="4">Title</font></div>
           </td>
           </tr>

<%       while(rs.next()) {
%>
           <tr>
               <td width="29%"> <%=rs.getString(1) %></td>
               <td width="71%"> <%=rs.getString(2) %></td>
           </tr>
<%       } 

        } else {out.println("No lesson has been covered by " + username+ " " + id + "!");  }  
%> 

  </table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp; </p>
  <p>&nbsp; </p>
  <p>&nbsp; </p>  
  <p>&nbsp; </p>

</body>
</html>
