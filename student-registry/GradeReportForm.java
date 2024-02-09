/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GradeReportForm.java
 *
 * Created on Jan 22, 2012, 11:43:14 AM
 */
package Presentation;
import Application.Student;
import Application.Course;

import java.util.Formatter;
import java.util.Scanner;

import java.net.URI;
import java.awt.Desktop;

import javax.swing.JOptionPane;
/**
 *
 * @author lapowner
 */
public class GradeReportForm extends javax.swing.JFrame {
    //Student stud = new Student();
    Student[] student;
    int count=0, courselen = 0; static int length=0;
    private Formatter output;
    boolean isstudent=false;
    String username;
    /** Creates new form GradeReportForm */
    public GradeReportForm(boolean studlogin, String uname) {
        isstudent = studlogin;
        username = uname;
        initComponents();
        getStudentList();
        showGradeReport();              
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        StudentPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        FullnameTextField = new javax.swing.JTextField();
        IDTextField = new javax.swing.JTextField();
        ProgramTextField = new javax.swing.JTextField();
        YearTextField = new javax.swing.JTextField();
        SemesterTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CourseTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        CurrentPointsTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        GPATextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TotalPointsTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CgpaTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        StatusTextField = new javax.swing.JTextField();
        StatusPanel = new javax.swing.JPanel();
        FirstButton = new javax.swing.JButton();
        PreviousButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        LastButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        PrintButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grade Report Form");
        setResizable(false);

        StudentPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setText("Full name:");

        jLabel2.setText("ID Number:");

        jLabel3.setText("Academic program:");

        jLabel4.setText("Year:");

        jLabel5.setText("Sem:");

        FullnameTextField.setEditable(false);

        ProgramTextField.setEditable(false);
        ProgramTextField.setToolTipText("");

        YearTextField.setEditable(false);

        SemesterTextField.setEditable(false);

        CourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Code", "Title", "CrHr", "Grade", "Points"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(CourseTable);

        jLabel6.setText("Points:");

        CurrentPointsTextField.setEditable(false);

        jLabel8.setText("GPA:");

        GPATextField.setEditable(false);

        jLabel9.setText("Total Points:");

        TotalPointsTextField.setEditable(false);
        TotalPointsTextField.setToolTipText("");

        jLabel7.setText("CGPA:");

        CgpaTextField.setEditable(false);

        jLabel10.setText("Status:");

        StatusTextField.setEditable(false);

        javax.swing.GroupLayout StudentPanelLayout = new javax.swing.GroupLayout(StudentPanel);
        StudentPanel.setLayout(StudentPanelLayout);
        StudentPanelLayout.setHorizontalGroup(
            StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, StudentPanelLayout.createSequentialGroup()
                        .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(StudentPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FullnameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                            .addGroup(StudentPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ProgramTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(StudentPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                            .addGroup(StudentPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(YearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SemesterTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, StudentPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CurrentPointsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GPATextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalPointsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CgpaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StatusTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
                .addContainerGap())
        );
        StudentPanelLayout.setVerticalGroup(
            StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(FullnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(ProgramTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(YearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SemesterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CurrentPointsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(GPATextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(TotalPointsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(CgpaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(StatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        StatusPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        FirstButton.setText("First");
        FirstButton.setToolTipText("");
        FirstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstButtonActionPerformed(evt);
            }
        });

        PreviousButton.setText("<< Previous");
        PreviousButton.setToolTipText("");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        NextButton.setText("Next >>");
        NextButton.setToolTipText("");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        LastButton.setText("Last");
        LastButton.setToolTipText("");
        LastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StatusPanelLayout = new javax.swing.GroupLayout(StatusPanel);
        StatusPanel.setLayout(StatusPanelLayout);
        StatusPanelLayout.setHorizontalGroup(
            StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FirstButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(NextButton)
                .addGap(79, 79, 79)
                .addComponent(LastButton)
                .addContainerGap())
        );
        StatusPanelLayout.setVerticalGroup(
            StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(LastButton)
                .addComponent(FirstButton)
                .addComponent(PreviousButton)
                .addComponent(NextButton))
        );

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        PrintButton.setText("Print");
        PrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintButtonActionPerformed(evt);
            }
        });

        SaveButton.setText("Save");
        SaveButton.setToolTipText("");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(PrintButton))
                    .addComponent(CloseButton)
                    .addComponent(SaveButton))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PrintButton)
                .addGap(47, 47, 47)
                .addComponent(SaveButton)
                .addGap(42, 42, 42)
                .addComponent(CloseButton)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Aksum University");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Office of the Registrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StatusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StudentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(StudentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void LastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastButtonActionPerformed
        count=length-1;
        showGradeReport();
    }//GEN-LAST:event_LastButtonActionPerformed

    private void FirstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstButtonActionPerformed
        count = 0;
        showGradeReport();
    }//GEN-LAST:event_FirstButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        if(count<length-1){
            count++; 
            showGradeReport();
        }
    }//GEN-LAST:event_NextButtonActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        if(count>0){
            count--;
            showGradeReport();
        }
    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void PrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintButtonActionPerformed
        try{
            openFile();
            saveRecords();
            closeFile();
        }
        catch(Exception e){}        
        URI uri = URI.create("gradereport.doc");
        Desktop ds = Desktop.getDesktop();
        try{
            ds.browse(uri); 
        }
        catch (Exception e){}
        
    }//GEN-LAST:event_PrintButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        try{
            openFile();
            saveRecords();
            closeFile();
        }
        catch(Exception e){}
        
    }//GEN-LAST:event_SaveButtonActionPerformed
    private void getStudentList(){
         Student stud = new Student();
         student = stud.getStudentList();     
    }
    private void showGradeReport(){
        length = student.length;
        if(isstudent){
            NextButton.hide();
            PreviousButton.hide();
            FirstButton.hide();
            LastButton.hide();
            for(int i=0;i<length; i++){
                String uname = student[i].getUsername();
                if(uname != null)
                    if(uname.equals(username)){
                        count = i;
                        break;
                    }
            }            
        }
        FullnameTextField.setText(student[count].getName()+" "+student[count].getFatherName()+
                                  " "+student[count].getGrandFather());
        IDTextField.setText(student[count].PrintID().substring(0, 13));
        ProgramTextField.setText(student[count].getEnrolType());
        YearTextField.setText("I"); SemesterTextField.setText("I");

        //courses registered by a student
        int id = student[count].getId();
        int points = 0, sumpoints = 0, sumcrhr = 0;
        Course[] course = student[count].getCourseList(id);  
        
        for(int i=0; i<courselen;i++)
            for(int j = 0; j<5; j++) CourseTable.setValueAt(null, i, j); 
        
        if (course!=null){            
            courselen = course.length;
            for(int i = 0; i < courselen; i ++){
               try{CourseTable.setValueAt(course[i].PrintCourseId(), i, 0);}catch (Exception e){}                
               CourseTable.setValueAt(course[i].getTitle(), i, 1);
               
               String grade = course[i].getGrade(id, course[i].getCourseId());
               String crhr = course[i].getCredithour();
               
               CourseTable.setValueAt(crhr, i, 2);
               CourseTable.setValueAt(grade, i, 3);
               
               if(grade!=null) {
                   points = calcGradePoints(crhr, grade);
                   CourseTable.setValueAt(points, i, 4); 
                   sumpoints += points;
                   sumcrhr += Integer.parseInt(crhr);                   
               }
            }
            CurrentPointsTextField.setText(Integer.toString(sumpoints));
            double gpa = 0.0;
            if(sumcrhr>0) gpa = (double)sumpoints/sumcrhr;           
            GPATextField.setText(String.valueOf(gpa).substring(0, 3));
            //to be worked out
            TotalPointsTextField.setText(Integer.toString(sumpoints));
            CgpaTextField.setText(String.valueOf(gpa).substring(0, 3));
            if(gpa>=2) StatusTextField.setText("Pass");
            else if(gpa>0) StatusTextField.setText("Fail");
            else  StatusTextField.setText("Unknown");
        }
    }
    private int calcGradePoints(String crhr, String grade){
        int points=0;
        try{
            if(grade.equals("A"))
                points = Integer.parseInt(crhr)*4;
            else if(grade.equals("B"))
                points = Integer.parseInt(crhr)*3;    
            else if(grade.equals("C"))
                points = Integer.parseInt(crhr)*2;
            else if(grade.equals("D"))
                points = Integer.parseInt(crhr); 
            else if(grade.equals("F"))
                points = 0;
            else points = -1;
        }
        catch (Exception e){}
        return points;
    }
    public void openFile() {
        try {
            output = new Formatter( "gradereport.doc" ); // open the file
        }
        catch ( Exception e) {}
    } // end method openFile
    public void saveRecords() throws Exception{
        length = student.length;
        output.format("%s%n", "Aksum University");
        output.format("%s%n", "Office of the Registrar");
        output.format("%n");
        output.format("Full name:%s %s %s   ID number:%s%n",student[count].getName(),
                      student[count].getFatherName(),student[count].getGrandFather(), 
                      student[count].PrintID().substring(0, 13));
        output.format("%n");
        output.format("Enrollment type:%s  Year:%s   Semester:%s%n",student[count].getEnrolType(), "I","I");
        output.format("%n");
        output.format("%s     %s                                %s %s %s%n",
                      "Code","Title","CrHr","Grade","Points");
        output.format("------------------------------------------------------------------%n");
        //courses registered by a student
        int id = student[count].getId();
        int points = 0, sumpoints = 0, sumcrhr = 0;
        Course[] course = student[count].getCourseList(id);  
        
        if (course!=null){            
            courselen = course.length;
            for(int i = 0; i < courselen; i ++){
               String grade = course[i].getGrade(id, course[i].getCourseId());
               String crhr = course[i].getCredithour();

               if(grade!=null) {
                   points = calcGradePoints(crhr, grade);
                   sumpoints += points;
                   sumcrhr += Integer.parseInt(crhr);                   
               }
               int strlen = course[i].getTitle().length();
               String strformat = "%s   %s    %s      %s      %s%n";
               if(strlen<30) strformat = "%s   %s                 %s      %s      %s%n";
               output.format(strformat,
                             course[i].PrintCourseId(),course[i].getTitle(),crhr, grade,points);               
            }
            output.format("%n");
            output.format("%n");   
           
            double gpa = 0.0;
            String status = "";
            if(sumcrhr>0) gpa = (double)sumpoints/sumcrhr;           
            //to be worked out
            if(gpa>=2) status= "Pass";
            else if(gpa>0) status = "Fail";
            else  status = "Unknown";
            output.format("Curr Points:%s GPA:%s Total Points:%s CGPA:%s Status:%s%n", 
                          Integer.toString(sumpoints), String.valueOf(gpa).substring(0, 3),
                          Integer.toString(sumpoints),String.valueOf(gpa).substring(0, 3),
                    status);            
        }
    }
    public void closeFile()
    {
        if ( output != null )
            output.close();
    }    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GradeReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GradeReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GradeReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GradeReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new GradeReportForm().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CgpaTextField;
    private javax.swing.JButton CloseButton;
    private javax.swing.JTable CourseTable;
    private javax.swing.JTextField CurrentPointsTextField;
    private javax.swing.JButton FirstButton;
    private javax.swing.JTextField FullnameTextField;
    private javax.swing.JTextField GPATextField;
    private javax.swing.JTextField IDTextField;
    private javax.swing.JButton LastButton;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JButton PrintButton;
    private javax.swing.JTextField ProgramTextField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SemesterTextField;
    private javax.swing.JPanel StatusPanel;
    private javax.swing.JTextField StatusTextField;
    private javax.swing.JPanel StudentPanel;
    private javax.swing.JTextField TotalPointsTextField;
    private javax.swing.JTextField YearTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
