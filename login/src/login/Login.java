package login;
import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Myframe extends JFrame{
    
 Container c;
 JLabel label1,label2,labelhead;
 JTextField user;
 JPasswordField pass;
 JButton signin,signup,Adminsignin;
    
 Myframe(){
     setTitle("LoginForm");
     setSize(1000,600);
     setLocation(180,60);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setResizable(false);
     
     c=getContentPane();
     c.setLayout(null);
     labelhead=new JLabel("LOGIN");
     label1=new JLabel("Username");
     label2=new JLabel("Password");
     
     labelhead.setFont(new Font("Sylfaen",1,32));
     label1.setFont(new Font("Sylfaen",1,25));
     label2.setFont(new Font("Sylfaen",1,25));
     
     labelhead.setBounds(450, 30, 300, 50);
     label1.setBounds(200,150,250,40);
     label2.setBounds(200,250,250,40);
     
     c.add (labelhead);
     c.add (label1);
     c.add (label2);
     
     user = new JTextField();
     user.setBounds(400,150,250,40);
     user.setFont(new Font("Calibri",1,20));
     c.add(user);
     
     pass = new JPasswordField();
     pass.setBounds(400,250,250,40);
     c.add(pass);
     
     signin = new JButton("Sign in as User");
     signin.setBounds(230,350,150,50);
     c.add(signin);
     
     signin.setFont(new Font("Sylfaen",1,15));
     signin.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            String username = user.getText();
            String password = new String(pass.getPassword());
            try{
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform","root","1234");
                PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select Username, password from login where Username=? and password=?");
                
                
                st.setString(1, username);
                    st.setString(2, password);
                    
                    ResultSet rs = st.executeQuery();
                    if(rs.next()){
                        JOptionPane.showMessageDialog(signin, "You have successfully logged in ");
                        HomePage frame3=new HomePage();
                    frame3.show();
                    dispose();
                        
                    } else {
                        JOptionPane.showMessageDialog(signin, "Wrong Usertype or Username or Password");
                    }
                    

            } 
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            /*if (e.getSource() == signin) {
            String username = user.getText();
            String password = new String(pass.getPassword());
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a username and password.");
                return;
            }
              JOptionPane.showMessageDialog(null, "Signed in Succesfully"); 
         }*/
         }
     } );
     
     
     Adminsignin = new JButton("Sign in as Admin");
     Adminsignin.setBounds(390,350,150,50);
     c.add(Adminsignin);
     Adminsignin.setFont(new Font("Sylfaen",1,15));
     Adminsignin.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            String UserName = user.getText();
            String Password = new String(pass.getPassword());
            try{
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform","root","1234");
                PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select UserName, Password from Admin where Username=? and password=?");
                
                
                st.setString(1, UserName);
                    st.setString(2, Password);
                    
                    ResultSet rs = st.executeQuery();
                    if(rs.next()){
                        JOptionPane.showMessageDialog(signin, "You have successfully logged in ");
                        AdminPage frame4=new AdminPage();
                    frame4.show();
                    dispose();
                        
                    } else {
                        JOptionPane.showMessageDialog(signin, "Wrong Usertype or Username or Password");
                    }
                    

            } 
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } 
         }
     } );
     
     signup = new JButton("Sign up");
     signup.setBounds(550,350,150,50);
     c.add(signup);
     
     
     signup.setFont(new Font("Sylfaen",1,15));
     signup.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             registration frame2=new registration();
             frame2.show();
             dispose();
         }
     } );
    
     setVisible(true);
     
     getContentPane().setBackground(new Color(255, 153, 153));
 }   
    
}


class Login{
    public static void main(String args[]){
     
    Myframe frame = new Myframe(); 
    
        
    }
    public void show() {
        Myframe frame = new Myframe();
    }
}