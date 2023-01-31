package login;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Myframe3 extends JFrame{
    Container e;
    JLabel label1;
    JButton Update,Logout;
    
 Myframe3(){
     
     setTitle("HomePage");
     setSize(1000,600);
     setLocation(180,60);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setResizable(false);
     
     e=getContentPane();
     e.setLayout(null);
     e.setBackground(new Color(255, 153, 153));
     
     JLabel label1 = new JLabel("WELCOME!!!");
     label1.setBounds(390, 60, 300, 60);
     label1.setFont(new Font("Sylfaen",1,35));
     e.add(label1);
             
     Update = new JButton("Update");
     Update.setBounds(220,300,200,100);
     Update.setFont(new Font("Calibri",1,30));
     e.add(Update);
         Update.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             Update frame5=new Update();
             frame5.show();
             dispose();
         }
     } );
     
     Logout = new JButton("Logout");
     Logout.setBounds(550,300,200,100);
     Logout.setFont(new Font("Calibri",1,30));
     e.add(Logout);
     Logout.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             Myframe frame = new Myframe(); 
             frame.show();
             dispose();
         }
     } );
     setVisible(true);
 }
}
 
class HomePage{
    public static void main(String args[]){
     
    Myframe3 frame3 = new Myframe3(); 
          
    }
    public void show() {
        Myframe3 frame3 = new Myframe3();
    }
}
