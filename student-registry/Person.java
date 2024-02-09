/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 *
 * @author lapowner
 */
public abstract class Person {
   protected String Name;
   protected String FatherName;
   protected String GrandFather;
   protected String Gender;
   protected String Birthdate;  
   protected String Username;
   protected String Password;
   
   public Person(){
       
   }   
   
   protected void setName(String Name){
       this.Name=Name;
   }
   protected void setFatherName(String FatherName){
       this.FatherName=FatherName;
   }
   protected void setGrandFather(String GrandFather){
       this.GrandFather=GrandFather;
   }
   protected void setGender(String Gender){
       this.Gender=Gender;
   }
   protected void setBirthdate(String Birthdate){
       this.Birthdate=Birthdate;
   }
   protected void setUsername(String Username){
       this.Username=Username;
   }
   protected void setPassword(String Password){
       this.Password=Password;
   }   
   public String getName(){
       return this.Name;
   }
   public String getFatherName(){
       return this.FatherName;
   }
   public String getGrandFather(){
       return this.GrandFather;
   }
   public String getGender(){
       return this.Gender;
   }
   public String getBirthdate(){
       return this.Birthdate;
   }   
   public String getUsername(){
       return this.Username;
   }
   public String getPassword(){
       return this.Password;
   }   
}
