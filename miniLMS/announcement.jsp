<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<title>Announcement</title>

<meta name="Author" content="Olga Gredeskoul">

<meta name="Generator" content="Microsoft FrontPage 5.0">

</head>



<%@page contentType="text/html"%>
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.lang.*" %>


<%!
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

<%
      String Query = "SELECT * FROM Announcement";      
      ResultSet  rs = ConnectDataAccess(Query);
%>

<body>
<table width="78%" border="1" bordercolor="#FFFFFF" bgcolor="#FFFFFF">
  <tr bgcolor="#FFFFFF" bordercolor="#FFFFFF"> 
    <td width="22%"><font size="4">Title</font></td>
    <td width="19%"><font size="4">Date</font></td>
    <td width="59%"><font size="4">Message</font></td>
  </tr>
<%
      while(rs.next()) {
%>      
  <p>      
  <tr bgcolor="#FFFFFF" bordercolor="#FFFFFF"> 
    <td width="22%"><%=rs.getString(1) %></td>      
    <td width="19%"><%=rs.getString(2) %></td>
    <td width="59%"><%=rs.getString(3) %></td>
  </tr>
<%   }
%>

</table>
</body>
</html>
