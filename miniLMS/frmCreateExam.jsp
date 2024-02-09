<%@page contentType="text/html"%>
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.lang.*" %>
<%@ page import = "java.math.*" %>

<HTML>

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

   // ConnectDataAccess        
   

   //---------------------Identify selected questions-----------------------------

   boolean IsChosen(int QuesionNo, int ReqQues) {
  
    boolean exists=false;

    for (int i=0; i<ReqQues; i++) 

       if (SelectedQues[i]==QuesionNo) exists=true;  
    
    return exists;
  }

  //------------------------Convert String to Integer-------------------------------

  int StrintToInteger(String Amount) { 

      int theNum=0,x=0;

      int strleng=Amount.length();

      char[] ch= new char[50];

      ch = Amount.toCharArray();
            
      char c;

      for (int i=0; i < strleng; i++) {

           c = ch[i];

           x = (int) c; 

           theNum = theNum + (int) (x-48)* (int) (Math.pow(10.0,(double) (strleng-i-1)));
      }

      return theNum;
  }


%>


<BODY>

<! ------------------------- the form ----------------------------------------------->


<form method="post" action="">


  <table width="67%" border="1" bordercolor="#00FFFF" bgcolor="#33FFFF" height="221">
    <tr> 
      <td height="66" width="2%"> 
        <p><font size="3"><b></b></font></p>
        <p><font size="3"><b></b></font></p>
        <p>&nbsp;</p>
      </td>

      <td colspan="8" height="66"><font size="3"><b><font size="4" face="Times New Roman, Times, serif" color="#000000">Create 
        Exam </font></b></font></td>
    </tr>


    <tr> 
      <td width="2%" height="27">&nbsp;</td>
      <td width="6%" height="27"><b>Title</b></td>
      <td height="27" colspan="2"> 
        <input type="text" name="title" value="" size="29">
      </td>


      <td width="15%" height="27"><b>Date </b></td>
      <td width="10%" height="27"><b> 
        <input type="text" name="Date" size="10">
        </b></td>

      <td width="14%" height="27"><b>Time </b></td>
      <td width="11%" height="27"><b> 
        <input type="text" name="Time" size="8" maxlength="8">
        </b></td>

      <td width="16%" height="27">&nbsp;</td>
    </tr>
    <tr> 
      <td width="2%" height="30"> 
        <p>&nbsp;</p>
      </td>


      <td height="30" colspan="3"><b>Number of Questions 
        <input type="text" name="NoQues" size="3" maxlength="3">
        </b><b> </b><b> </b></td>

      <td height="30" colspan="2"> <b>Duration</b> <b>in mnts</b> </td>
      <td height="30" colspan="2"> 
        <input type="text" name="Duration" size="3" maxlength="3">
      </td>


      <td height="30" width="16%">&nbsp; </td>
    </tr>
    <tr> 
      <td width="2%" height="57">&nbsp;</td>
      <td height="57" colspan="3"><b>From lesson 
        <input type="text" name="from" size="2" maxlength="2">
        to 
        <input type="text" name="to" size="2" maxlength="2">
        </b></td>


      <input type="hidden" name="correctInput" value="true">

      <td height="57" colspan="2"><b> 
        <input type=SUBMIT name="Submit" value="Submit">
        </b> </td>
      <td height="57" colspan="3"><b> 
        <input type="reset" name="Reset" value="Reset">
        </b> </td>
    </tr>
  </table>

  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp; </p>
  <p>&nbsp; </p>
  <p>&nbsp; </p>  
  <p>&nbsp; </p>
</form>

<%

 String title = request.getParameter("title");
 String date = request.getParameter("Date");
 String time = request.getParameter("Time");
 String amount = request.getParameter("NoQues");
 String duration = request.getParameter("Duration");
 String fromLesson = request.getParameter("from");
 String toLesson = request.getParameter("to");
 
 if((fromLesson!="")&&(amount!=null)) {
    //Insert exam information
    String Query0 = "INSERT INTO PastExams VALUES ('" + title + "','" + amount+ "','" + 
                    date + "','" + time + "','" + duration + "')";
    ConnectDataUpdate(Query0); 
    
    //generate the exam
    String Query1 = "SELECT * FROM QuestionBank WHERE LessonId>=" +
                    "'" + fromLesson + "' " + "And LessonId<=" + "'" + toLesson + "'";
    ResultSet  rs1 = ConnectDataAccess(Query1); 
    
    int ReqRows = 0;
    ReqRows = StrintToInteger(amount);
    int AvailRows = 0;   
    if (rs1!=null) 
      while (rs1.next()) AvailRows++;   
    if(AvailRows>ReqRows) {
       GiveRandomQues(AvailRows, ReqRows);
       rs1.beforeFirst();
       int i=0;
       while(rs1.next()) { 
            i++; 
            if( IsChosen(i, ReqRows)) {          
                 String Query2 = "INSERT INTO CurrentExam VALUES ('" + title + "','" +
                                  rs1.getString(1) + "')"; 
                 ConnectDataUpdate(Query2);
            }
        }

    }/* end if AvailRows */

 }//
   
%>


</BODY>
</HTML>
