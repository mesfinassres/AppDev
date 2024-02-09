package Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TranscriptOrderDAO {
	private PreparedStatement preparedStatement = null;
        DBconnect connect=new DBconnect();

        public void read() throws Exception {

	}
        public void write(int ID, String RecipientAddress, String Courier, String Express) 
                            throws Exception {
            
           String QueryString = "INSERT INTO TranscriptRequest values (default,"+ID+",'"+RecipientAddress+
                    "','"+Courier+"','"+Express+"')";
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
}