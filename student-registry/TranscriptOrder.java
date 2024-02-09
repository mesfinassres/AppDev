/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;
import Persistence.TranscriptOrderDAO;

/**
 *
 * @author lapowner
 */
public class TranscriptOrder {
    private int ID;
    private String recipientAddress;
    private String courier;
    private String express;
    
    public TranscriptOrder(){
        
    }
    public TranscriptOrder(int ID,String recipientAddress,String courier,String express){
        this.setID(ID);
        this.setRecipientAddress(recipientAddress);
        this.setCourier(courier);
        this.setExpress(express);
    }
    private void setID(int ID){
        this.ID=ID;
    }
    private void setRecipientAddress(String recipientAddress){
        this.recipientAddress=recipientAddress;
    }
    private void setCourier(String courier){
        this.courier=courier;
    }
    private void setExpress(String express){
        this.express=express;
    }
    public int getID(){
        return this.ID;
    }
    public String getRecipientAddress(){
        return this.recipientAddress;
    }
    public String getCourier(){
        return this.courier;
    }
    public String getExpress(){
        return this.express;
    }
    
    public void Insert() throws Exception{
       TranscriptOrderDAO transcriptOrderDAO= new TranscriptOrderDAO();
       transcriptOrderDAO.write(this.ID, this.recipientAddress,this.courier,this.express);
   }
}
