<HTML>
<BODY>


<SCRIPT LANGUAGE = "JavaScript">

 function myAlert() {

    alert("Please enter the data again!");

 }

</SCRIPT>


<form name="student" method="post" action="">
  <table width="65%" border="1" bordercolor="#00FFFF" bgcolor="#33FFFF" height="221">
    <tr> 
      <td height="66" width="6%"> 
        <p><font size="3"><b></b></font></p>
        <p><font size="3"><b></b></font></p>
        <p>&nbsp;</p>
      </td>
      <td colspan="5" height="66"><font size="3"><b><font size="4" face="Times New Roman, Times, serif" color="#000000">Enter 
        student data</font></b></font></td>
    </tr>
    <tr> 
      <td width="6%" height="27">&nbsp;</td>
      <td width="11%" height="27"><b>Name</b></td>
      <td width="25%" height="27"> 
        <input type="text" name="name" size="20">
      </td>
      <td width="11%" height="27">&nbsp;</td>
      <td width="19%" height="27"><b>User name</b></td>
      <td width="28%" height="27"> 
        <input type="text" name="username" size="10">
      </td>
    </tr>
    <tr> 
      <td width="6%" height="26"> 
        <p>&nbsp;</p>
      </td>
      <td height="26" width="11%"><b>Id</b></td>
      <td width="25%" height="26"> 
        <input type="text" name="id" size="20">
      </td>
      <td width="11%" height="26">&nbsp;</td>
      <td width="19%" height="26"><b>Password</b></td>
      <td width="28%" height="26"> 
        <input type="password" name="password" size="10">
      </td>
    </tr>
    <tr> 
      <td width="6%" height="22">&nbsp;</td>
      <td height="22" width="11%"><b>Section</b></td>
      <td width="25%" height="22"> 
        <input type="text" name="section" size="5">
      </td>
      <td height="22" colspan="2"><b>Confirm password</b> </td>
      <td width="28%" height="22"> 
        <input type="password" name="confirmpassword" size="10">
      </td>
    </tr>
    <tr> 
      <td colspan="3">&nbsp; </td>
      <td colspan="2"> 
        <p> 
          <input type="submit" name="Submit" value="Submit">
        </p>
        <p>&nbsp;</p>
      </td>
      <td width="28%"> 
        <p> 
          <input type="reset" name="Reset" value="Reset">
        </p>
        <p>&nbsp; </p>
      </td>
    </tr>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp; </p>
  <p>&nbsp; </p>
  <p>&nbsp; </p>  
  <p>&nbsp; </p>
</form>



<%@page contentType="text/html"%>
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.lang.*" %>


<%!

//---------------------Connect to database-----------------------------------
void ConnectDataUpdate(String Query) {
	PreparedStatement ps = null;
	Connection con;
	String url = "jdbc:mysql://localhost:3306/elearning?user=root&password=Hadaslema1";
	
	try{
		  Class.forName("com.mysql.jdbc.Driver");
	  con = DriverManager.getConnection (url);
	  ps = con.prepareStatement(Query);
	  ps.executeUpdate();
	}
	catch(Exception E) {
	System.out.println("Exception caught : "+E);
	E.printStackTrace(); 
	}    
}

//ConnectDataAccess        
   
%>

<%
  

      String name = request.getParameter("name");

      String id = request.getParameter("id");

      String section = request.getParameter("section");

      String username = request.getParameter("username");

      String password = request.getParameter("password");

      String confirmpassword = request.getParameter("confirmpassword");

       
      //Enter new student information

      String Query = "INSERT INTO Student VALUES ('" + username + "','" + password +
                      "','" + name + "','" + id + "','" + section + "')"; 

      if ((username!=null)&&(password!=null))

        if (password.equals(confirmpassword)) { 

	     ConnectDataUpdate(Query); 

        } else {
%>
	     <SCRIPT LANGUAGE = "JavaScript">

                myAlert();
 
             </SCRIPT>        
<%        }
%>


</BODY>
</HTML>
