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


<body>

<form name="form1" method="post" action="">
  <table width="52%" border="1" bordercolor="#00FFFF" bgcolor="#33FFFF" height="101">
    <tr> 
      <td width="1%" height="2">&nbsp;</td>
      <td colspan="2" height="2"><font size="4">Monitor Lessons (</font>use lesson 
        number <font size="4">)</font></td>
    </tr>

    <tr> 
      <td width="1%" height="2">&nbsp;</td>
      <td width="67%" height="2"><b>Lesson number</b></td>
      <td width="32%" height="2"> 
        <input type="text" name="lesson" size="20">
      </td>
    </tr>
    <tr> 
      <td width="1%" height="26">&nbsp;</td>
      <td height="26" width="67%">&nbsp;</td>
      <td width="32%" height="26"> 
        <input type=SUBMIT name="Show" value="Show">
      </td>
    </tr>
  </table>

</form>


<!-----------------------------List students------------------------------------------->


<%


      String lesson = request.getParameter("lesson");

      String Query = "SELECT Username, Id, FullName FROM Student INNER JOIN " +
                     "StudentPerformance ON Student.Username = StudentPerformance.UserId " +
                     "WHERE LessonNo=" + lesson; 
     
      rs = ConnectDataAccess(Query);
    
      if ((rs!=null)&& (lesson!=null))  

       if (rs.next())  {
           
           rs.beforeFirst();
%>
          <p>&nbsp;</p>

          <table width="59%" border="1">

          <tr bgcolor="#FFFF00"> 
           <td colspan="3"><font size="4">List of Students</font></td>
             </tr>

             <tr bgcolor="#FFFF00"> 
               <td width="26%"><font size="4">Username</font></td>
                <td width="26%"> 
               <div align="left"><font size="4">Id</font></div>
              </td>
             <td width="48%"><font size="4">Full name</font></td>
         </tr>

<%       while(rs.next()) {
%>           
           <tr> 
               <td> <%=rs.getString(1) %> </td>
               <td> <%=rs.getString(2) %> </td>
               <td> <%=rs.getString(3) %> </td>
           </tr>
<%       } 

        } else {out.println("No student has covered lesson " + lesson + "!");  }  
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
