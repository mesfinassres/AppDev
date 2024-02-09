
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Examination</title>
<meta name="Author" content="Olga Gredeskoul">
<meta name="Generator" content="Microsoft FrontPage 5.0">


<SCRIPT LANGUAGE = "JavaScript" src = "Scripts/Correct.js">
</SCRIPT>

<link rel="StyleSheet" type="text/css" href="top_dir_files/styles.css">

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
}

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


<body onload = "uncheck();">


<table width="1000" align="center"><tr><td width="600">

</p>
<p CLASS="title"><left>Examination</p>
</td></tr></table>


<FORM name="quiz" ACTION="" METHOD="get">

<table width="1000" align="center" border="0" cellspacing="1" cellpadding="1">


<! ---------------------Questions run here --------------------------------------->

<% 

 String Query = "SELECT * FROM QuestionBank WHERE QuesId in " +
                 "(SELECT QuesNo FROM CurrentExam)"; 

 ResultSet  rs = ConnectDataAccess(Query); 

 int ReqRows=0;

 int i=1,QuesNo = 1;

 String answerset="";

 if ((rs!=null)&&(rs.next())) { // If examination is set, display the exam.

    rs.beforeFirst();

    while(rs.next()) { 

         answerset= answerset + rs.getString(4); 
         
%>            
         <tr>              
         <td width="36"><b>Q<%=QuesNo %>.</b></td>
         <td colspan="3"> <span><%= rs.getString(3) %> </span></td>
         </tr>
 
         <tr>
         <td width="36"><img name="<%= "q" + QuesNo + "r1" %>" src="top_dir_files/blank.gif" 	     width="22" height="20"></td>
         <td width="14"><b>A&nbsp;</b></td>
         <td width="35"> 
         <input type="radio" name="<%="q" + QuesNo %>" value="1">&nbsp;</td>
         <td width="487"><%= rs.getString(5) %> </td>
         </tr>

         <tr>
         <td width="36"><img name="<%="q" + QuesNo + "r2" %>" src="top_dir_files/blank.gif" width="22"              height="20"></td>   
         <td width="14"><b>B&nbsp;</b></td>       
         <td width="35"> 
         <input type="radio" name="<%="q" + QuesNo %>" value="2">&nbsp;</td>     
         <td width="487"><%= rs.getString(6) %></td>
         </tr>

         <tr>       
         <td width="36"><img name="<%="q" + QuesNo + "r3" %>" src="top_dir_files/blank.gif" width="22"              height="20"></td>        
         <td width="14"><b>C&nbsp;</b></td>       
         <td width="35"> 
         <input type="radio" name="<%="q" + QuesNo %>" value="3">&nbsp;</td>     
         <td width="487"><%= rs.getString(7) %></td>
         </tr>

         <tr>         
         <td width="36"><img name="<%="q" + QuesNo + "r4" %>" src="top_dir_files/blank.gif" width="22"              height="20"></td>
         <td width="14"><b>D&nbsp;</b></td>          
         <td width="35"> 
         <input type="radio" name="<%="q" + QuesNo %>" value="4">&nbsp;</td> 
         <td width="487"><%= rs.getString(8) %></td>
         </tr>
         <tr><td colspan="4">&nbsp;</td></tr>   
          
<%       QuesNo ++;    
   } 

   ReqRows = QuesNo - 1;
%>

   </table>


   <!-------------- Nunmber of questions asked--------------------------------------------->
   <input type="hidden" name="qnum" value="<%=ReqRows %>">

   <!------------------------------- Answers----------------------------------------------->
   <input type="hidden" name="anum" value="<%=answerset %>">

   <INPUT TYPE=hidden NAME=remark VALUE="" SIZE=20>

   <INPUT TYPE=hidden NAME=score VALUE="" SIZE=20>

   <!------------------------------Submit button ------------------------------------------>
   <center>
   <p><font color="#990000"><b>To check your answers click the button:</b> </font>
   &nbsp;&nbsp;&nbsp;

    <input type=SUBMIT name=button value="Submit" onClick="return results();">

   <center>
   <P STYLE="font-size:7pt; margin-left:40px"> 

   <!---------------------------- Update user records on completion---------------------->

   <%
   
   if(rs!=null) {
      String user= (String) session.getAttribute( "currentUser" );
      String title="";
      String Score = request.getParameter("score");
      String Remark = request.getParameter("remark");

      //find title of the exam from currentExam
      String Query1 = "SELECT * FROM CurrentExam"; 
      ResultSet  rs1 = ConnectDataAccess(Query1); 
      rs1.next();
      title = rs1.getString(1);

      //update score of the current student
      String Query2="INSERT INTO StudentScore VALUES ('" + user + "','" + title + "','" +
                     Score + "','" + Remark + "')"; 
      ConnectDataUpdate(Query2);

  }// inner if 
}//outer if
else { 
%>       
       <p> <B> No exam has been set.</B> 
<%
  }     
%> 

</FORM>
<hr width="90%">
</center>

<!----Modification information ---------------------------------------------->
<p STYLE="font-size:8pt; margin-left:40px">Last modified August 2004</p>

</body>
</html>
