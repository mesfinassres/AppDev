package Persistence;
import java.sql.*;

public class DBconnect {
    private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
        String ConnDriver="com.mysql.jdbc.Driver";
        String ConnString="jdbc:mysql://localhost/studentregistry?user=root&password=Hadaslema1";

        //Connect to database
        public void DBconnect(){
            
        }
        public Connection open(){
            Connection con= null;
            try{
                Class.forName(ConnDriver);
                con= DriverManager.getConnection(ConnString);
            } 
            catch (Exception e){ 
                System.out.println(e); 
            }
            return con;
        }
        
        // Close the resultSet, statement, or connection
        public void close() {
            try {
                    if (resultSet != null) {
                            resultSet.close();
                    }

                    if (statement != null) {
                            statement.close();
                    }

                    if (connect != null) {
                            connect.close();
                    }
            } 
            catch (Exception e) {

            }
        }
}
