/*
 * MainMenu.java
 *
 * Created on Dec 30, 2011, 4:44:56 PM
 */
package Presentation;
import Application.Employee;
import Application.Student;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.logging.*;
import javax.swing.border.*;

/**
 *
 * Student Record Management System 1.0.0
 * 
 */
public class MainMenu extends JFrame {   
    /** Creates new form MainMenu */
    boolean AccountVerified=false;
    String GroupName="";
    String id = null;
    
    
    // Variables declaration
    private JMenuItem AboutMenuItem;
    private JMenu AccountMenuItem;
    private JButton CancelButton;
    private JMenuItem ContentMenuItem;
    private JMenuItem EditMenuItem;
    private JMenuItem ExitMenu;
    private JMenuItem GradeReportMenuItem;
    private JLabel GroupLabel;
    private JLabel GroupLabel1;
    private JMenuItem InsertCourseMenuItem;
    private JMenuItem InsertEmployeeMenuItem;
    private JMenuItem InsertGradeMenuItem;
    private JMenuItem InsertStudentMenuItem;
    private JButton LoginButton;
    private JComboBox LoginGroupComboBox;
    private JMenuItem LoginMenuItem;
    private JLabel LoginMessageLabel;
    private JTextField LoginNameText;
    private JPanel LoginPanel;
    private JPasswordField LoginPasswordText;
    private JMenuItem LogoutMenuItem;
    private JLabel NewPasswordLabel;
    private JLabel NewStudentLabel;
    private JLabel PasswordLabel;
    private JLabel PasswordLabel1;
    private JMenuItem RegApprovMenuItem;
    private JMenuItem RegRequestMenuItem;
    private JMenuItem TranscriptRequestMenu;
    private JMenuItem UpdateAccountMenuItem;
    private JPanel UpdateAccountPanel;
    private JButton UpdateCancelButton;
    private JButton UpdateLoginButton;
    private JComboBox UpdateLoginGroupComboBox;
    private JTextField UpdateLoginNameText;
    private JPasswordField UpdateLoginPasswordText;
    private JPasswordField UpdateNewPasswordText;
    private JLabel UserNameLabel;
    private JLabel UserNameLabel1;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenu jMenu4;
    private JMenu jMenu5;
    private JMenuBar jMenuBar1;
    private JMenuBar jMenuBar2;
    private JPopupMenu.Separator jSeparator1;
    private JPopupMenu.Separator jSeparator2;
    private JPopupMenu.Separator jSeparator3;
    private JPopupMenu.Separator jSeparator4;
    private JPopupMenu.Separator jSeparator5;
    private JPopupMenu.Separator jSeparator6;
    private JPopupMenu.Separator jSeparator7;
    private JPopupMenu.Separator jSeparator8;
    // End of variables declaration
    
    
    public MainMenu() {
        initComponents();
        this.setExtendedState(MainMenu.MAXIMIZED_BOTH);
        LoginNameText.setText("");
        LoginPasswordText.setText("");        
    }
    public String getId(){
        return this.id;
    }
    /** 
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jMenuBar2 = new JMenuBar();
        jMenu3 = new JMenu();
        jMenu4 = new JMenu();
        LoginPanel = new JPanel();
        LoginGroupComboBox = new JComboBox();
        PasswordLabel = new JLabel();
        LoginButton = new JButton();
        GroupLabel = new JLabel();
        CancelButton = new JButton();
        UserNameLabel = new JLabel();
        LoginNameText = new JTextField();
        LoginPasswordText = new JPasswordField();
        NewStudentLabel = new JLabel();
        UpdateAccountPanel = new JPanel();
        UpdateLoginGroupComboBox = new JComboBox();
        PasswordLabel1 = new JLabel();
        UpdateLoginButton = new JButton();
        GroupLabel1 = new JLabel();
        UpdateCancelButton = new JButton();
        UserNameLabel1 = new JLabel();
        UpdateLoginNameText = new JTextField();
        UpdateLoginPasswordText = new JPasswordField();
        NewPasswordLabel = new JLabel();
        UpdateNewPasswordText = new JPasswordField();
        LoginMessageLabel = new JLabel();
        jMenuBar1 = new JMenuBar();
        AccountMenuItem = new JMenu();
        jSeparator5 = new JPopupMenu.Separator();
        LoginMenuItem = new JMenuItem();
        LogoutMenuItem = new JMenuItem();
        jSeparator2 = new JPopupMenu.Separator();
        UpdateAccountMenuItem = new JMenuItem();
        jSeparator4 = new JPopupMenu.Separator();
        ExitMenu = new JMenuItem();
        jMenu5 = new JMenu();
        jSeparator1 = new JPopupMenu.Separator();
        InsertStudentMenuItem = new JMenuItem();
        InsertCourseMenuItem = new JMenuItem();
        jSeparator7 = new JPopupMenu.Separator();
        InsertEmployeeMenuItem = new JMenuItem();
        InsertGradeMenuItem = new JMenuItem();
        EditMenuItem = new JMenuItem();
        jSeparator3 = new JPopupMenu.Separator();
        jMenu1 = new JMenu();
        RegRequestMenuItem = new JMenuItem();
        RegApprovMenuItem = new JMenuItem();
        jSeparator8 = new JPopupMenu.Separator();
        TranscriptRequestMenu = new JMenuItem();
        GradeReportMenuItem = new JMenuItem();
        jSeparator6 = new JPopupMenu.Separator();
        jMenu2 = new JMenu();
        ContentMenuItem = new JMenuItem();
        AboutMenuItem = new JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);
        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Registry System");
        setLocationByPlatform(true);
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        LoginPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(0, 0, 0), 1, true)));
        LoginGroupComboBox.setModel(new DefaultComboBoxModel(new String[] { "Admin", "Advisor", "Student", "Other" }));
        PasswordLabel.setText("Password:");

        LoginButton.setText("Login");
        LoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        GroupLabel.setText("Group:");
        CancelButton.setText("Cancel");
        
        CancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        UserNameLabel.setText("Username:");
        LoginPasswordText.setText("jPasswordField1");

        NewStudentLabel.setForeground(new Color(102, 102, 255));
        NewStudentLabel.setText("New student ?");
        NewStudentLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        NewStudentLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                NewStudentLabelMouseClicked(evt);
            }
        });

        GroupLayout LoginPanelLayout = new GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(LoginPanelLayout.createSequentialGroup()
                            .addGroup(LoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(UserNameLabel)
                                .addGroup(LoginPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(GroupLabel)
                                    .addComponent(PasswordLabel)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(LoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(LoginGroupComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LoginPasswordText)
                                .addGroup(LoginPanelLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(LoginNameText, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(LoginPanelLayout.createSequentialGroup()
                            .addComponent(LoginButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CancelButton)))
                    .addComponent(NewStudentLabel))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(UserNameLabel)
                    .addComponent(LoginNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLabel)
                    .addComponent(LoginPasswordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(GroupLabel)
                    .addComponent(LoginGroupComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LoginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginButton)
                    .addComponent(CancelButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NewStudentLabel))
        );

        UpdateAccountPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(0, 0, 0), 1, true)));
        UpdateAccountPanel.setOpaque(false);

        UpdateLoginGroupComboBox.setModel(new DefaultComboBoxModel(new String[] { "Admin", "Advisor", "Student", "Other" }));

        PasswordLabel1.setText("Password:");

        UpdateLoginButton.setText("Update");
        UpdateLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UpdateLoginButtonActionPerformed(evt);
            }
        });

        GroupLabel1.setText("Group:");

        UpdateCancelButton.setText("Cancel");
        UpdateCancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UpdateCancelButtonActionPerformed(evt);
            }
        });

        UserNameLabel1.setText("Username:");

        UpdateLoginPasswordText.setText("jPasswordField1");

        NewPasswordLabel.setText("New Password:");

        UpdateNewPasswordText.setText("jPasswordField1");

        GroupLayout UpdateAccountPanelLayout = new GroupLayout(UpdateAccountPanel);
        UpdateAccountPanel.setLayout(UpdateAccountPanelLayout);
        UpdateAccountPanelLayout.setHorizontalGroup(
            UpdateAccountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(UpdateAccountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UpdateAccountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(UpdateAccountPanelLayout.createSequentialGroup()
                        .addGroup(UpdateAccountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(UserNameLabel1)
                            .addComponent(GroupLabel1)
                            .addComponent(PasswordLabel1)
                            .addComponent(UpdateLoginButton))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdateAccountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(UpdateCancelButton, GroupLayout.Alignment.TRAILING)
                            .addGroup(UpdateAccountPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(UpdateLoginGroupComboBox, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.LEADING, UpdateAccountPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(UpdateNewPasswordText, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(GroupLayout.Alignment.LEADING, UpdateAccountPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(UpdateLoginPasswordText, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(UpdateLoginNameText, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(NewPasswordLabel))
                .addGap(22, 22, 22))
        );
        UpdateAccountPanelLayout.setVerticalGroup(
            UpdateAccountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(UpdateAccountPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(UpdateAccountPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(UserNameLabel1)
                    .addComponent(UpdateLoginNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UpdateAccountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateLoginPasswordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordLabel1))
                .addGap(13, 13, 13)
                .addGroup(UpdateAccountPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(NewPasswordLabel)
                    .addComponent(UpdateNewPasswordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UpdateAccountPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(GroupLabel1)
                    .addComponent(UpdateLoginGroupComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UpdateAccountPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateCancelButton)
                    .addComponent(UpdateLoginButton)))
        );

        LoginMessageLabel.setFont(new Font("Tahoma", 0, 14));
        LoginMessageLabel.setForeground(new Color(255, 102, 0));
        LoginMessageLabel.setToolTipText("");

        AccountMenuItem.setText("Account");
        AccountMenuItem.add(jSeparator5);

        LoginMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
        LoginMenuItem.setText("Login");
        LoginMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LoginMenuItemActionPerformed(evt);
            }
        });
        AccountMenuItem.add(LoginMenuItem);

        LogoutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_MASK));
        LogoutMenuItem.setText("Logout");
        LogoutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LogoutMenuItemActionPerformed(evt);
            }
        });
        AccountMenuItem.add(LogoutMenuItem);
        AccountMenuItem.add(jSeparator2);

        UpdateAccountMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_MASK));
        UpdateAccountMenuItem.setText("Update account");
        UpdateAccountMenuItem.setToolTipText("");
        UpdateAccountMenuItem.setActionCommand("Create");
        UpdateAccountMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UpdateAccountMenuItemActionPerformed(evt);
            }
        });
        AccountMenuItem.add(UpdateAccountMenuItem);
        AccountMenuItem.add(jSeparator4);

        ExitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        ExitMenu.setText("Exit");
        ExitMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        AccountMenuItem.add(ExitMenu);

        jMenuBar1.add(AccountMenuItem);

        jMenu5.setText("Data entry");
        jMenu5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });
        jMenu5.add(jSeparator1);

        InsertStudentMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_MASK));
        InsertStudentMenuItem.setText("Insert Student Record");
        InsertStudentMenuItem.setToolTipText("");
        InsertStudentMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                InsertStudentMenuItemActionPerformed(evt);
            }
        });
        jMenu5.add(InsertStudentMenuItem);

        InsertCourseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        InsertCourseMenuItem.setText("Insert Course Record");
        InsertCourseMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                InsertCourseMenuItemActionPerformed(evt);
            }
        });
        jMenu5.add(InsertCourseMenuItem);
        jMenu5.add(jSeparator7);

        InsertEmployeeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
        InsertEmployeeMenuItem.setText("Insert Employee Record");
        InsertEmployeeMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                InsertEmployeeMenuItemActionPerformed(evt);
            }
        });
        jMenu5.add(InsertEmployeeMenuItem);

        InsertGradeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.ALT_MASK));
        InsertGradeMenuItem.setText("Insert Student Grade");
        InsertGradeMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                InsertGradeMenuItemActionPerformed(evt);
            }
        });
        jMenu5.add(InsertGradeMenuItem);

        EditMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
        EditMenuItem.setText("Edit All Data");
        EditMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                EditMenuItemActionPerformed(evt);
            }
        });
        jMenu5.add(EditMenuItem);
        jMenu5.add(jSeparator3);
        jMenuBar1.add(jMenu5);
        jMenu1.setText("Commands");

        RegRequestMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        RegRequestMenuItem.setText("Register for Courses");
        RegRequestMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RegRequestMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(RegRequestMenuItem);

        RegApprovMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        RegApprovMenuItem.setText("Approve Registration");
        RegApprovMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RegApprovMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(RegApprovMenuItem);
        jMenu1.add(jSeparator8);
        TranscriptRequestMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
        TranscriptRequestMenu.setText("Request for Transcript");
        TranscriptRequestMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TranscriptRequestMenuActionPerformed(evt);
            }
        });
        jMenu1.add(TranscriptRequestMenu);

        GradeReportMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
        GradeReportMenuItem.setText("Get Grade Report");
        GradeReportMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                GradeReportMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(GradeReportMenuItem);
        jMenu1.add(jSeparator6);
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenu2.setToolTipText("");
        ContentMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        ContentMenuItem.setText("Content");
        ContentMenuItem.setToolTipText("");
        ContentMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ContentMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(ContentMenuItem);
        AboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        AboutMenuItem.setText("About");
        AboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AboutMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(AboutMenuItem);
        jMenuBar1.add(jMenu2);
        setJMenuBar(jMenuBar1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(LoginMessageLabel)
                    .addComponent(LoginPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(316, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(UpdateAccountPanel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(317, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LoginPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(LoginMessageLabel)
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(UpdateAccountPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(145, Short.MAX_VALUE)))
        );
        pack();
    }
    private void jMenu5ActionPerformed(ActionEvent evt) {}
    private void ExitMenuActionPerformed(ActionEvent evt) { System.exit(0);    
    }
    private void TranscriptRequestMenuActionPerformed(ActionEvent evt) {
      if((AccountVerified)&& (GroupName.equals("Student")))
        new TranscriptRequestForm().setVisible(true);     
    }
    private void InsertStudentMenuItemActionPerformed(ActionEvent evt) {
        if((AccountVerified)&& (GroupName.equals("Admin")))
            new StudentDataEntryForm().setVisible(true);
    }
    private void InsertEmployeeMenuItemActionPerformed(ActionEvent evt) {
        if((AccountVerified)&& (GroupName.equals("Admin")))
            new EmployeeDataEntryForm().setVisible(true);
    }
    private void LoginMenuItemActionPerformed(ActionEvent evt) {
        LoginNameText.setText("");
        LoginPasswordText.setText("");        
        LoginPanel.setVisible(true);
    }
    private void LoginButtonActionPerformed(ActionEvent evt) {   
        UpdateAccountPanel.setVisible(false);
        LoginMessageLabel.setText("");
        String uname = LoginNameText.getText();
        String pwd = LoginPasswordText.getText();   
        GroupName=LoginGroupComboBox.getSelectedItem().toString(); 
        try{
            if(GroupName.equals("Admin")||GroupName.equals("Advisor")) {
                Employee emp = new Employee();
                AccountVerified = emp.login(uname, pwd);   
            }
            else if (GroupName.equals("Student")){
                Student stud = new Student();                
                id = stud.login(uname, pwd);              
                if(id!=null) AccountVerified =true;
            }
            else JOptionPane.showMessageDialog(null, "Unknown user group");
        } 
        catch (Exception e){
            System.out.println(e.toString());
        }
        if(AccountVerified) LoginPanel.setVisible(false);
        else LoginMessageLabel.setText("Incorrect username or password");      
    }
    private void CancelButtonActionPerformed(ActionEvent evt) {
        LoginPanel.setVisible(false);
        LoginMessageLabel.setText("");
        UpdateAccountPanel.setVisible(false);     
    }
    private void LogoutMenuItemActionPerformed(ActionEvent evt) {      
        AccountVerified=false;
        GroupName=null;
        LoginNameText.setText("");
        LoginPasswordText.setText("");        
        LoginPanel.setVisible(true);      
    }
    private void UpdateLoginButtonActionPerformed(ActionEvent evt) {
        
        LoginPanel.setVisible(false);
        LoginMessageLabel.setText("");
        String uname = UpdateLoginNameText.getText();
        String pwd = UpdateLoginPasswordText.getText();
        String pwdnew = UpdateNewPasswordText.getText();
        GroupName=UpdateLoginGroupComboBox.getSelectedItem().toString();       
        try{

            if(GroupName.equals("Admin")||GroupName.equals("Advisor")) {
                Employee emp = new Employee();
                AccountVerified = emp.login(uname, pwd);   
            }

            else if (GroupName.equals("Student")){
                Student stud = new Student();
                id = stud.login(uname, pwd);
                if(id!=null) AccountVerified =true;
            }

            else JOptionPane.showMessageDialog(null, "Unknown user group");
        } 
        catch (Exception e){
            System.out.println(e.toString());
        }
        //update
        if(AccountVerified){    
            UpdateAccountPanel.setVisible(false);          
            if(GroupName.equals("Admin")||GroupName.equals("Advisor")){ 
                Employee emp = new Employee();
                emp.UpdateLoginAccount(uname, pwdnew); 
            }
            else if(GroupName.equals("Student")){
                Student stud = new Student();
                stud.UpdateLoginAccount(uname, pwdnew);              
            }
        }
        else {
              LoginMessageLabel.setText("Incorrect username or password");
        }       
    }
    private void UpdateCancelButtonActionPerformed(ActionEvent evt) {     
        UpdateAccountPanel.setVisible(false);
        LoginMessageLabel.setText("");       
    }
    private void UpdateAccountMenuItemActionPerformed(ActionEvent evt) {
        UpdateAccountPanel.setVisible(true);    
    }
    private void RegApprovMenuItemActionPerformed(ActionEvent evt) {       
        try{
            if((AccountVerified)&& (GroupName.equals("Advisor")))
                new RegistrationApprovalForm().setVisible(true);
        }
        catch (Exception e) {}      
    }
    private void InsertCourseMenuItemActionPerformed(ActionEvent evt) {      
        if((AccountVerified)&& (GroupName.equals("Admin")))
            new CourseDataEntryForm().setVisible(true);         
    }
    private void AboutMenuItemActionPerformed(ActionEvent evt) {   
        new AboutDialogForm().setVisible(true); 
    }
    private void RegRequestMenuItemActionPerformed(ActionEvent evt) { 
	    try{
	        if((AccountVerified)&& (GroupName.equals("Student")))
	        new RegRequestForm(id).setVisible(true);         
	    }
	    catch (Exception e){} 
    }
    private void ContentMenuItemActionPerformed(ActionEvent evt) {
        String currentdir = System.getProperty("user.dir");
        currentdir = currentdir.replace('\\', '/');
        URI uri = URI.create(currentdir+"/dist/javadoc/index.html");        
        Desktop ds = Desktop.getDesktop();      
        try{
            ds.browse(uri); 
        }
        catch (Exception e){}    
    }
    private void InsertGradeMenuItemActionPerformed(ActionEvent evt) {
        if((AccountVerified)&& (GroupName.equals("Admin")))
            new GradeEntryForm().setVisible(true);      
    }
    private void GradeReportMenuItemActionPerformed(ActionEvent evt) {
        boolean isstudent = false;
        if(AccountVerified){            
            if (GroupName.equals("Student")) isstudent = true;
            new GradeReportForm(isstudent, LoginNameText.getText()).setVisible(true);  
        }     
    }
    private void EditMenuItemActionPerformed(ActionEvent evt) {    
        if((AccountVerified)&& (GroupName.equals("Admin")))
            new EditorForm(null, true).setVisible(true);  
    }
    private void NewStudentLabelMouseClicked(MouseEvent evt) {      
        new StudentDataEntryForm().setVisible(true);      
    }
    public static void main(String args[]) {
        /* 
         * Set the Nimbus look and feel. If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {

            public void run() {
               MainMenu mm = new MainMenu();
               mm.setVisible(true);
            }
        });
    }

}
