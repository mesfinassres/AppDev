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
      <td width="2%" height="2">&nbsp;</td>
      <td colspan="2" height="2"><font size="4">Students' evaluation monitoring 
        (</font>use id or username<font size="4">)</font></td>
    </tr>
    <tr> 
      <td width="2%" height="2">&nbsp;</td>
      <td width="56%" height="2"><b>Username</b></td>
      <td width="42%" height="2"> 
        <input type="text" name="username" size="20">
      </td>
    </tr>
    <tr> 
      <td width="2%" height="26" rowspan="2"> 
        <p>&nbsp;</p>
      </td>
      <td height="12" width="56%"><b>or </b></td>
      <td width="42%" height="12">&nbsp; </td>
    </tr>
    <tr> 
      <td height="12" width="56%"><b>ID number</b></td>
      <td width="42%" height="12"> 
        <input type="text" name="id" size="20">
      </td>
    </tr>
    <tr> 
      <td width="2%" height="2">&nbsp;</td>
      <td height="2" width="56%">&nbsp; </td>
      <td width="42%" height="2"> 
        <input type=SUBMIT name="Show" value="Show">
      </td>
    </tr>
  </table>
</form>


<!-----------------------------List students------------------------------------------->

<%
      String username = request.getParameter("username");

      String id = request.getParameter("id");

      String Query = "SELECT ExamTitle, Score " +
                     "FROM Student INNER JOIN StudentScore " + 
                     "ON Student.Username = StudentScore.UserId " +
                     "WHERE UserId='" + username + "' OR Id='" + id + "'";
     
      rs = ConnectDataAccess(Query);
    
      if ((rs!=null)&& ((username!=null)||(id!=null)))  

       if (rs.next())  {
           
           rs.beforeFirst();
%>
<table width="36%" border="1" name="lessons">
  <tr bgcolor="#FFFF00"> 
             
    <td colspan="2"><font size="4">List of Tests</font></td>
           </tr>

           <tr bgcolor="#FFFF00"> 
           
    <td width="74%"><font size="4">Test title</font></td>
    <td width="26%"> 
      <div align="center"><font size="4">Score</font></div>
           </td>
           </tr>

<%       while(rs.next()) {
%>
           <tr>
               
    <td width="74%"> <%=rs.getString(1) %></td>
               
    <td width="26%"> <%=rs.getString(2) %></td>
           </tr>
<%       } 

        } else {out.println("No test has been taken by " + username+ " " + id + "!");  }  
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
