package hospitalmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HospitalGUI extends JFrame implements ActionListener  {

    JButton bookBtn, viewBtn, searchBtn, cancelBtn;

    public HospitalGUI() {
        setTitle("Hospital Management System");
        setSize(400, 400);
        setLayout(new GridLayout(5, 1));
        JLabel title = new JLabel("City Care Hospital", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        add(title);
        bookBtn = new JButton("Book Appointment");
        viewBtn = new JButton("View Appointments");
        searchBtn = new JButton("Search by Doctor");
        cancelBtn = new JButton("Cancel Appointment");

        add(bookBtn);
        add(viewBtn);
        add(searchBtn);
        add(cancelBtn);

        bookBtn.addActionListener(this);
        viewBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookBtn) {
            new BookAppointment();
        } else if (e.getSource() == viewBtn) {
            new ViewAppointments();
        } else if (e.getSource() == searchBtn) {
            new SearchDoctor();
        } else if (e.getSource() == cancelBtn) {
            new CancelAppointment();
        }
    }
    
    
	
	
	public static void main(String[] args) {
		new HospitalGUI();
	}

}




