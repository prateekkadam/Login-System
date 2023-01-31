package login;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
// import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.MatteBorder;


class Myframe5 extends JFrame{
    Container g;
    JLabel labelhead2,nameLabel,dobLabel,emailLabel,mobileLabel,genderLabel,userLabel,PasswordLabel;
    JTextField nameText,dobText,emailText,mobileText,userText;
    JPasswordField PasswordText;
    JRadioButton maleRadio, femaleRadio;
    JButton registerButton,ResetButton,BackButton;

    Myframe5(){
        setTitle("UpdatePage");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocation(180,60);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        g=getContentPane();
        g.setLayout(null);
        g.setBackground(new Color(255, 153, 153));


        JLabel labelhead2 = new JLabel("UPDATE");
        labelhead2.setBounds(420, 20, 300, 40);
        labelhead2.setFont(new Font("Sylfaen",1,27));

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(220, 50, 150, 80);
        nameLabel.setFont(new Font("Sylfaen",1,25));

        JTextField nameText = new JTextField(20);
        nameText.setBounds(360, 60, 300, 40);
        nameText.setFont(new Font("Calibri",1,20));
        nameText.setBorder(new MatteBorder(0,0,3,0,Color.BLACK));

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(220, 100, 150, 80);
        emailLabel.setFont(new Font("Sylfaen",1,25));

        JTextField emailText = new JTextField(20);
        emailText.setBounds(360, 110, 300, 40);
        emailText.setFont(new Font("Calibri",1,20));
        emailText.setBorder(new MatteBorder(0,0,3,0,Color.BLACK));

        JLabel mobileLabel = new JLabel("Mobile:");
        mobileLabel.setBounds(220, 150, 150, 80);
        
        mobileLabel.setFont(new Font("Sylfaen",1,25));

        JTextField mobileText = new JTextField(20);
        mobileText.setBounds(360, 160, 300, 40);
        mobileText.setFont(new Font("Calibri",1,20));
        mobileText.setBorder(new MatteBorder(0,0,3,0,Color.BLACK));

        JLabel userLabel = new JLabel("UserName:");
        userLabel.setBounds(220, 200, 150, 80);
        
        userLabel.setFont(new Font("Sylfaen",1,25));

        JTextField userText = new JTextField(20);
        userText.setBounds(360, 210, 300, 40);
        userText.setFont(new Font("Calibri",1,20));
        userText.setBorder(new MatteBorder(0,0,3,0,Color.BLACK));
        
        JLabel PasswordLabel = new JLabel("Password:");
        PasswordLabel.setBounds(220, 250, 150, 80);
       
        PasswordLabel.setFont(new Font("Sylfaen",1,25));
        
        JPasswordField PasswordText = new JPasswordField(20);
        PasswordText.setBounds(360, 260, 300, 40);
       
        PasswordText.setBorder(new MatteBorder(0,0,3,0,Color.BLACK));
        
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(220, 300, 150, 80);
        
        genderLabel.setFont(new Font("Sylfaen",1,25));
        
        JRadioButton maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(360, 310, 100, 60);   
       
        maleRadio.setBackground(new Color(255, 153, 153));
        maleRadio.setFont(new Font("Sylfaen",1,20));
        
        JRadioButton femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(500, 310, 100, 60);
        
        femaleRadio.setBackground(new Color(255, 153, 153));
        femaleRadio.setFont(new Font("Sylfaen",1,20));
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(maleRadio);
        bg.add(femaleRadio);

        JLabel dobLabel = new JLabel("DOB:");
        dobLabel.setBounds(220, 360, 150, 80);
        
        dobLabel.setFont(new Font("Sylfaen",1,25));

        JTextField dobText = new JTextField(20);
        dobText.setBounds(360, 370, 300, 40);
        dobText.setFont(new Font("Calibri",1,20));
        dobText.setBorder(new MatteBorder(0,0,3,0,Color.BLACK));
        
        JButton registerButton = new JButton("Submit");
        registerButton.setBounds(370, 450, 140, 40);
        
        registerButton.setFont(new Font("Sylfaen",1,25));
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 String fullname = nameText.getText();
                 String email = emailText.getText();
                 String mobile = mobileText.getText();
                 String dob = dobText.getText();
                 String username = userText.getText();
                 String password = new String(PasswordText.getPassword());
                 String gen="";
                if(maleRadio.isSelected()){
                    gen = maleRadio.getText();
                }
                else if(femaleRadio.isSelected()){
                    gen = femaleRadio.getText();
                }
                String gender = gen;
                String msg = "" + fullname;
                msg += " \n";
                if (userText.getText().equals("")){
                    JOptionPane.showMessageDialog(registerButton, "Enter a Username");
                }
                else if (PasswordText.getPassword().equals("")){
                    JOptionPane.showMessageDialog(registerButton, "Enter a password");
                }
                else if (mobileText.getText().equals("")) {
                    JOptionPane.showMessageDialog(registerButton,"Enter a valid Mobile Number");
                }
                else {
                try{
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform","root","1234");
                 PreparedStatement c = (PreparedStatement) connection
                        .prepareStatement("Select Username from login where Username = ?");
                 c.setString(1,username);
                 ResultSet rs= c.executeQuery();
                 if(rs.next()){
                 
                PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement( "UPDATE login SET Fullname=?,Email=?,Mobile=?,password=?,Gender=?,DOB=? WHERE Username=?");
                
                
                    st.setString(1, fullname);
                    st.setString(2, email);
                    st.setString(3,mobile);
                    st.setString(4,password);
                    st.setString(5,gender);
                    st.setString(6,dob);
                    st.setString(7,username);
                    st.executeUpdate();
                 
                    
                        JOptionPane.showMessageDialog(registerButton,  " Sucessfully Account Updated");
                        dispose();
                        Login bo = new Login();
                        bo.show();
                        
                   c.close();
                   st.close();
                 
                }else{JOptionPane.showMessageDialog(registerButton,"Username does not Exist. Try again!");}

            } 
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } 
             
            } }
        });
        
//        BackButton = new JButton("GoBack");
//        BackButton.setBounds(370, 450, 140, 40);
//        BackButton.setFont(new Font("Sylfaen",1,25));
//        BackButton.addActionListener(new ActionListener(){
//         public void actionPerformed(ActionEvent e){
//             Login lf= new Login();
//             lf.show();
//             dispose();
//         }
//     } );
           
//        ResetButton = new JButton("Reset");
//        ResetButton.setBounds(520, 450, 150, 40);
//        ResetButton.setFont(new Font("Sylfaen",1,25));
//        ResetButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // code to handle clear button action
//                nameText.setText("");
//                dobText.setText("");
//                emailText.setText("");
//                mobileText.setText("");
//                userText.setText("");
//                PasswordText.setText("");
//                bg.clearSelection();
//            }
//        });

   g.add(labelhead2);
   g.add(nameLabel);
   g.add(dobLabel);
   g.add(emailLabel);
   g.add(mobileLabel);
   g.add(genderLabel);
   g.add(userLabel);
   g.add(PasswordLabel);
   g.add(nameText);
   g.add(dobText);
   g.add(emailText);
   g.add(mobileText);
   g.add(userText);
   g.add(PasswordText);
   g.add(maleRadio);
   g.add(femaleRadio);
   g.add(registerButton);
//   g.add(ResetButton);
//   g.add(BackButton);
   
   setVisible(true);
}
}

class Update{
    public static void main(String args[]){
     
    Myframe5 frame5 = new Myframe5(); 

    }

    public void show() {
        Myframe5 frame5 = new Myframe5();
    }
}
