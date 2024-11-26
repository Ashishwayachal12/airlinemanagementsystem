package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    public Home() {
        // Set the layout of the JFrame to null for absolute positioning
       setLayout(null);

        // Load the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800);
        add(image);

        // Add heading text
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(550, 80, 1000, 80);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
        image.add(heading);

        // Create menu bar
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        // Add "Details" menu and its items
        JMenu details = new JMenu("Details");
        menubar.add(details);

        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);

        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);

        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);

        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);

        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);

        // Add "Ticket" menu and its items
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);

        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);

        // Set frame properties
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Make the window fullscreen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application on exit
        setVisible(true); // Make the frame visible
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();

        // Handle menu item clicks
        if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInfo();
        } else if (text.equals("Book Flight")) {
            new BookFlight();
        } else if (text.equals("Journey Details")) {
            new JourneyDetails();
        }else if(text.equals("Cancel Ticket"))
        {
            new Cancel();
        }else if(text.equals("Boarding Pass"))
        {
            new BoardingPass();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
