package login;

import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Myframe6 extends JFrame{
    
 Container h;
 JLabel label1;
 JTextField deleteuser;
 JButton Delete;
    
 Myframe6(){
     setTitle("DeletePage");
     setSize(500,300);
     setLocation(180,60);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setResizable(false);
     
     h=getContentPane();
     h.setLayout(null);
     h.setBackground(new Color(255, 153, 153));
     label1=new JLabel("Enter Username:");
     label1.setFont(new Font("Sylfaen",1,25));
     label1.setBounds(20,70,250,40);
     h.add (label1);
     deleteuser = new JTextField();
     deleteuser.setBounds(220,70,250,40);
     deleteuser.setFont(new Font("Calibri",1,20));
     h.add(deleteuser);
     Delete = new JButton("Delete");
     Delete.setBounds(170,160,120,30);
     h.add(Delete);
     Delete.setFont(new Font("Sylfaen",1,20));
     Delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e4) {

                String delete = deleteuser.getText();
                 try{
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform","root","1234");
                 PreparedStatement c = (PreparedStatement) connection
                        .prepareStatement("Select Username from login where Username = ?");
                 c.setString(1,delete);
                 ResultSet rs= c.executeQuery();
                 if(rs.next()){
                
                 PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("delete from login where Username=?");

                    st.setString(1, delete);
                    
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(Delete, "Account has been successfully Deleted");
                        dispose();
                        AdminPage frame4 = new AdminPage();
                        frame4.show();
                    
                    connection.close();
                 
                }else{JOptionPane.showMessageDialog(Delete,"Username does not Exist. Try again!");}

            } 
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } 
            }
        });
     setVisible(true);
 }
}
class Delete{
    public static void main(String args[]){
     
    Myframe6 frame6 = new Myframe6(); 
    
        
    }
    public void show() {
        Myframe6 frame6 = new Myframe6();
    }
}