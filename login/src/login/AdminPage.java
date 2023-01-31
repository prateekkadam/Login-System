package login;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Myframe4 extends JFrame{
Myframe4(){
    super("AdminPage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new BorderLayout());
        setBackground(new Color(255, 153, 153));
      
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Mobile");
        model.addColumn("Username");
        model.addColumn("password");
        model.addColumn("Gender");
        model.addColumn("Date of Birth");
        

       
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform","root","1234");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM login");
            while (rs.next()) {
                Object[] row = {rs.getString("Fullname"), rs.getString("Email"), rs.getInt("Mobile"), rs.getString("Username"), rs.getString("password"), rs.getString("Gender"), rs.getString("DOB")};
                model.addRow(row);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

     
        JTable table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton insertButton = new JButton("Insert");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton Logout = new JButton("Logout");
        buttonPanel.add(insertButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(Logout);
        add(buttonPanel, BorderLayout.SOUTH);

        Logout.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             Myframe frame = new Myframe(); 
             frame.show();
             dispose();
         }
     } );
         deleteButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){ 
             Myframe6 frame6 = new Myframe6();
             frame6.show();
             dispose();
         }
     } );
         updateButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             Myframe7 frame7=new Myframe7();
             frame7.show();
             dispose();
         }
     } );
         insertButton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             Myframe8 frame8=new Myframe8();
             frame8.show();
             dispose();
         }
     } );
        
        setVisible(true);
}
}
 
class AdminPage{
    public static void main(String args[]){
     
    Myframe4 frame4 = new Myframe4(); 
          
    }
    public void show() {
        Myframe4 frame4 = new Myframe4();
    }
}












