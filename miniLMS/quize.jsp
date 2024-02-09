
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Lesson 10: Self-Examination Questions</title>
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

   String   answerset = "";
   int 	            i = 0;
   int 	      ReqRows = 0;
   int[] SelectedQues = new int[50];  


   //-------- Generate a random number to select a question randomly.----------

   int GiveNum(int PopSize){ 

	int Num = 0;

	Num = (int) Math.round (Math.random() * PopSize); 
        if (Num==0) return GiveNum (PopSize);
        else return Num;
   }

   
   //-----------Give set of random questions ----------------------------------
   
   void GiveRandomQues(int AvailQues, int ReqQues) {
        
        int i, j, Num=0;
        boolean NumExists;

        //initialize array

        for (i=0; i<ReqQues; i++) SelectedQues[i]=0; 
        
        //Select questions randomly 
         
        for (i=0; i<ReqQues; i++) {
             
           NumExists = true;

           while (NumExists) {
  
                 Num = GiveNum(AvailQues);
                 
                 NumExists = false;
 
                 for (j=0; j<i; j++) if (Num == SelectedQues[j]) NumExists = true; 
           }
           
           SelectedQues[i] = Num;
           
        }

   }

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
   

   //---------------------Identify selected questions-----------------------------

   boolean IsChosen(int QuesionNo, int ReqQues) {
  
    boolean exists=false;

    for (int i=0; i<ReqQues; i++) 

       if (SelectedQues[i]==QuesionNo) exists=true;  
    
    return exists;
  }
%>


<body onload = "uncheck();">


<table width="600" align="center"><tr><td width="600">


<p><span CLASS="diff"><i>Introduction to MS-DOS</i></span><br>
<img src = "top_dir_files/bar20-narrow.jpg" border="0" width="600"height="5">
</p>
<p CLASS="title"><left>Lesson 10: Self-Examination Questions</p>
</td></tr></table>


<FORM name="quiz" ACTION="Quiz10.jsp" METHOD="get">

<table width="600" align="center" border="0" cellspacing="4" cellpadding="1">


<! ---------------------Questions run here --------------------------------------->

<% 

    String Query1 = "select * from QuestionBank where LessonId='10'"; 

    ResultSet  rs = ConnectDataAccess(Query1); 

    int AvailRows = 0;   

    while (rs.next()) AvailRows++;
     
    ReqRows = (int) Math.round(.75*AvailRows);

    GiveRandomQues(AvailRows, ReqRows);

    rs.beforeFirst();

    int i=1,QuesNo = 1;

    answerset="";
  
    while(rs.next()) { 

      if( IsChosen(i, ReqRows) ) {
	
         answerset= answerset + rs.getString(4); 
         
%>            
         <tr>              
         <td width="36"><b>Q<%=QuesNo %>.</b></td>
         <td colspan="3"><span> <%= rs.getString(3) %> </span></td>
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
          
<%   
         QuesNo++;    
     
      }//if

      i++; 
   } 
%>


</table>



<!-------------- Nunmber of questions asked--------------------------------------------->
<input type="hidden" name="qnum" value="<%=ReqRows %>">

<!------------------------------- Answers----------------------------------------------->
<input type="hidden" name="anum" value="<%=answerset %>">




<INPUT TYPE=hidden NAME=completed VALUE="false" SIZE=20>



<!------------------------------Submit button ------------------------------------------>
<center>
<p><font color="#990000"><b>To check your answers click the button:</b> </font>
&nbsp;&nbsp;&nbsp;

<input type="button" name=submit value="Self-Test" onClick="return results()">

<center>
<P STYLE="font-size:7pt; margin-left:40px"> 

Click  the Complete Lesson button to complete this lesson. A lesson is complete only if all questions are answered correctly.

<P><INPUT TYPE=submit NAME="Complete" VALUE="Complete Lesson" onClick="return MyAlert()" >


<!---------------------------- Update user records on completetion---------------------->

<%

   String GetValue = request.getParameter("completed");

   String MyValue  = "true";

   String user= (String) session.getAttribute( "currentUser" );



   //If all questions are answered correctly, update student record 

   if(MyValue.equals(GetValue)) { 
  
    String Query2="INSERT INTO StudentPerformance VALUES (" + "'" + user + "'" + "," + "10)"; 

    ResultSet rs2=ConnectDataAccess(Query2);

   }

%>


</FORM>
<hr width="90%">
</center>


<!----Modification information ---------------------------------------------->
<p STYLE="font-size:8pt; margin-left:40px">Last modified August 2004</p>

</body>
</html>
