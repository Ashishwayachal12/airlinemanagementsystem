
package airlinemanagementsystem;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Cancel extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JButton fechButton,flight;
    JLabel tfname,tfcancellation,tfflightcode,labladateoftravel;
    
    
    public Cancel()
    {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random  random=new Random();
        JLabel heading=new JLabel("CANCELLATION");
        heading.setBounds(180,20,250,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.red);
        add(heading);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(470,120,250,250);
        add(image);
        
        JLabel lblpnr=new JLabel("PNR Number:");
        lblpnr.setBounds(60,80,150,25);
        lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpnr);
        
        tfpnr=new JTextField();
        tfpnr.setBounds(220,80,150,25);
        add(tfpnr);
        
        
        fechButton =new JButton("Show Details");
        fechButton.setBackground(Color.BLACK);
        fechButton.setForeground(Color.red);
        fechButton.setBounds(380,80,120,25);
        fechButton.addActionListener(this);
        add(fechButton);
        
        
        JLabel lblname=new JLabel("Name:");
        lblname.setBounds(60,130,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
        tfname=new JLabel();
        tfname.setBounds(220,130,150,25);
        add(tfname);
        
        
        
        JLabel lblcancellation=new JLabel("Cancellation NO:");
        lblcancellation.setBounds(60,180,150,25);
        lblcancellation.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblcancellation);
        
        tfcancellation=new JLabel(""+random.nextInt(1000000));
        tfcancellation.setBounds(220,180,150,25);
        add(tfcancellation);
    
        
        JLabel lblflightcode=new JLabel("Flight Code:");
        lblflightcode.setBounds(60,230,150,25);
        lblflightcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblflightcode);
        
        tfflightcode=new JLabel();
        tfflightcode.setBounds(220,230,150,25);
        add(tfflightcode);
        
        JLabel lbldate=new JLabel("Date:");
        lbldate.setBounds(60,280,150,25);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
        
        labladateoftravel=new JLabel();
        labladateoftravel.setBounds(220,280,150,25);
        add(labladateoftravel);
       
      
        
        flight=new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.red);
        flight.setBounds(220,330,120,25);
        flight.addActionListener(this);
        add(flight);
        
        
        
        setSize(800,450);
        setLocation(350,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==fechButton){
        
        String  pnr=tfpnr.getText();       
        
        try
        {
            Conn conn=new Conn();
            String query="select * from reservation where PNR='"+pnr+"'";
         ResultSet rs=conn.s.executeQuery(query);
         if(rs.next())
         {
             tfname.setText(rs.getString("flight_name"));
             tfflightcode.setText(rs.getString("flight_code"));
             labladateoftravel.setText(rs.getString("departure_date"));
            
         }else {
             JOptionPane.showMessageDialog(null,"Please enter correct PNR!");
           // setVisible(false);
         }
            
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       }
        
        else if(ae.getSource()==flight){
        
        String name=tfname.getText();
        String pnr=tfpnr.getText();
        String cancelno=tfcancellation.getText();
        String fcode=tfflightcode.getText();
        String date=labladateoftravel.getText();
    
        try
        {
            Conn conn=new Conn();
            String query="insert into cancel values('"+pnr+"','"+name+"','"+cancelno+"','"+fcode+"','"+date+"')";
            conn.s.executeUpdate(query);
            conn.s.executeUpdate("delete from reservation where PNR='"+pnr+"'");
        
       
             JOptionPane.showMessageDialog(null,"Ticket Cancelled!");
              setVisible(false);
         
            
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       }
        
        
     }
    
    public static void main(String[]args)
    {
        new Cancel();
    }
    
}
