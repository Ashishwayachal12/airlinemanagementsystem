
package airlinemanagementsystem;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
public class BookFlight extends JFrame implements ActionListener{
    
    JTextField tfaadhar;
    JButton bookflight,fechButton,flight;
    JLabel tfname,tfnationlity,tfaddress,labelgender,labelfname,labelfcode,lbldate;
    Choice sources,destination;
    JDateChooser dcdate;
    
    public BookFlight()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Book Flight");
        heading.setBounds(420,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.red);
        add(heading);
        
        JLabel lblaadhar=new JLabel("Aadhar:");
        lblaadhar.setBounds(60,80,150,25);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(220,80,150,25);
        add(tfaadhar);
        
        
        fechButton =new JButton("Fetch User");
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
        
        
        
        JLabel lblnationlity=new JLabel("Nationlity:");
        lblnationlity.setBounds(60,180,150,25);
        lblnationlity.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationlity);
        
        tfnationlity=new JLabel();
        tfnationlity.setBounds(220,180,150,25);
        add(tfnationlity);
    
        
        JLabel lbladdress=new JLabel("Address:");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress=new JLabel();
        tfaddress.setBounds(220,230,150,25);
        add(tfaddress);
        
        JLabel lblgender=new JLabel("Gender:");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        labelgender=new JLabel();
        labelgender.setBounds(220,280,150,25);
        add(labelgender);
       
        JLabel lblsources=new JLabel("Sources:");
        lblsources.setBounds(60,330,150,25);
        lblsources.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblsources);
        
        sources=new Choice();
        sources.setBounds(220,330,150,25);
      //sources.add("Ashish");
        add(sources);
        
        JLabel lbldestination=new JLabel("Destination:");
        lbldestination.setBounds(60,380,150,25);
        lbldestination.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldestination);
        
         destination=new Choice();
         destination.setBounds(220,380,150,25);
      // destination.add("Ashish");
         add(destination);
        
        try
        {
          Conn c=new Conn();
          String query="select * from flight";
          ResultSet rs=c.s.executeQuery(query);
          
          while(rs.next())
          {
              sources.add(rs.getString("source"));
              destination.add(rs.getString("destination"));
          }
            
        }catch(Exception e )
        {
            e.printStackTrace();
        }
        
        
        flight=new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.red);
        flight.setBounds(380,380,120,25);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname=new JLabel("Flight Name:");
        lblfname.setBounds(60,430,150,25);
        lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfname);
        
        labelfname=new JLabel();
        labelfname.setBounds(220,430,150,25);
        add(labelfname);
        
        JLabel lblfcode=new JLabel("Flight Code:");
        lblfcode.setBounds(60,480,150,25);
        lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfcode);
        
        labelfcode=new JLabel();
        labelfcode.setBounds(220,480,150,25);
        add(labelfcode);
        
        lbldate=new JLabel("Date of Travel:");
        lbldate.setBounds(60,530,150,25);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
        
        dcdate=new JDateChooser();
        dcdate.setBounds(220,530,150,25);
        add(dcdate);

        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 320,Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i2);
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(550,80,500,410);
        add(lblimage);
        
        bookflight=new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.red);
        bookflight.setBounds(220,580,150,25);
        bookflight.addActionListener(this);
        add(bookflight);
        
        setSize(1100,700);
        setLocation(200,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==fechButton){
        
        String aadhar=tfaadhar.getText();
        String gender=null;
        
        
        
        try
        {
            Conn conn=new Conn();
            String query="select * from passenger where aadhar='"+aadhar+"'";
         ResultSet rs=conn.s.executeQuery(query);
         if(rs.next())
         {
             tfname.setText(rs.getString("name"));
             tfnationlity.setText(rs.getString("nationality"));
             tfaddress.setText(rs.getString("address"));
             labelgender.setText(rs.getString("gender"));
         }else {
             JOptionPane.showMessageDialog(null,"Please enter correct aadhar card!");
           // setVisible(false);
         }
            
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       }
        
        else if(ae.getSource()==flight){
        
        String src=sources.getSelectedItem();
        String dest=destination.getSelectedItem();
    
        try
        {
            Conn conn=new Conn();
            String query="select * from flight where source='"+src+"' and destination='" +dest+"'";
         ResultSet rs=conn.s.executeQuery(query);
         if(rs.next())
         {
             labelfname.setText(rs.getString("f_name"));
             labelfcode.setText(rs.getString("f_code"));
           
         }else {
             JOptionPane.showMessageDialog(null,"No flights Found!");
           // setVisible(false);
         }
            
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       }
        else
        {
          Random random=new Random();
          
          String aadhar= tfaadhar.getText();
          String name=tfname.getText();
          String address=tfaddress.getText();
          String nationlity=tfnationlity.getText();
          String flightname=labelfname.getText();
          String flightcode=labelfcode.getText();
          String gender=labelgender.getText();
          String src=sources.getSelectedItem();
          String dest=destination.getSelectedItem();
          String ddate=((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
          
           try
        {
            Conn conn=new Conn();
            String query="insert into  reservation values('PNR-"+random.nextInt(1000000)+"','TIC-" +random.nextInt(10000)+"','"+aadhar+"','"+name+"','"+address+"','"+nationlity+"','"+flightname+"','"+flightcode+"','"+gender+"','"+src+"','"+dest+"','"+ddate+"')";
         conn.s.executeUpdate(query);
       
             JOptionPane.showMessageDialog(null,"Ticket Booked Succesfully!");
             setVisible(false);
         
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        }
        
     }
    
    public static void main(String[]args)
    {
        new BookFlight();
    }
    
}
