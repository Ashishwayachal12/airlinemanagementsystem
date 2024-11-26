
package airlinemanagementsystem;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JButton fechButton;
    JLabel tfname,tfnationlity,tfsrc,tfdest,labelfname,labelfcode,lbldate,labeldate;
    
   
    
    public BoardingPass()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel subheading=new JLabel("AIR INDIA");
        subheading.setBounds(380,10,450,35);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,32));
        subheading.setForeground(Color.red);
        add(subheading);
        
        JLabel heading=new JLabel("Bording Pass");
        heading.setBounds(360,50,300,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblpnr=new JLabel("PNR DETAILS:");
        lblpnr.setBounds(60,100,150,25);
        lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpnr);
        
        tfpnr=new JTextField();
        tfpnr.setBounds(220,100,150,25);
        add(tfpnr);
        
        
        fechButton =new JButton("Enter");
        fechButton.setBackground(Color.BLACK);
        fechButton.setForeground(Color.red);
        fechButton.setBounds(380,100,120,25);
        fechButton.addActionListener(this);
        add(fechButton);
        
        
        JLabel lblname=new JLabel("Name:");
        lblname.setBounds(60,140,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
        tfname=new JLabel();
        tfname.setBounds(220,140,150,25);
        add(tfname);
        
        
        
        JLabel lblnationlity=new JLabel("NATIONLITY:");
        lblnationlity.setBounds(60,180,150,25);
        lblnationlity.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationlity);
        
        tfnationlity=new JLabel();
        tfnationlity.setBounds(220,180,150,25);
        add(tfnationlity);
    
        
        JLabel lblsrc=new JLabel("SRC:");
        lblsrc.setBounds(60,220,150,25);
        lblsrc.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblsrc);
        
        tfsrc=new JLabel();
        tfsrc.setBounds(220,220,150,25);
        add(tfsrc);
        
        JLabel lbldest=new JLabel("DEST:");
        lbldest.setBounds(380,220,150,25);
        lbldest.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldest);
        
        tfdest=new JLabel();
        tfdest.setBounds(500,220,150,25);
        add(tfdest);
       
     
        
        JLabel lblfname=new JLabel("Flight Name:");
        lblfname.setBounds(60,260,150,25);
        lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfname);
        
        labelfname=new JLabel();
        labelfname.setBounds(220,260,150,25);
        add(labelfname);
        
        JLabel lblfcode=new JLabel("Flight Code:");
        lblfcode.setBounds(380,260,150,25);
        lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfcode);
        
        labelfcode=new JLabel();
        labelfcode.setBounds(500,260,150,25);
        add(labelfcode);
        
        lbldate=new JLabel("Date:");
        lbldate.setBounds(60,300,150,25);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
        
        labeldate=new JLabel();
        labeldate.setBounds(220,300,150,25);
        add(labeldate);

        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2=i1.getImage().getScaledInstance(300, 230,Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(650,0,300,300);
        add(lblimage);
        
        
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
       
        String pnr=tfpnr.getText();
     
        
        
        
        try
        {
            Conn conn=new Conn();
            String query="select * from reservation where PNR='"+pnr+"'";
         ResultSet rs=conn.s.executeQuery(query);
          if(rs.next())
         {
             tfname.setText(rs.getString("name"));
             tfnationlity.setText(rs.getString("nationality"));
             tfsrc.setText(rs.getString("source"));
              tfdest.setText(rs.getString("destination"));
             labelfcode.setText(rs.getString("flight_code"));
              labelfname.setText(rs.getString("flight_name"));
              labelfcode.setText(rs.getString("flight_code"));         
              labeldate.setText(rs.getString("departure_date"));
              
            
         }else {
             JOptionPane.showMessageDialog(null,"Please enter correct aadhar card!");
           // setVisible(false);
         }
            
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       }
        
       
        
     
    
    public static void main(String[]args)
    {
        new BoardingPass();
    }
    
}
