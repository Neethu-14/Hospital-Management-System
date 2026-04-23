package hospitalmanagement;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class BookAppointment extends JFrame implements ActionListener {
	JTextField pName, dName, dept, date, time;
    JButton submit;

    public BookAppointment() {
        setTitle("Book Appointment");
        setLayout(null);
        setSize(350, 400);

        JLabel l1 = new JLabel("Patient Name:");
        l1.setBounds(20, 20, 120, 20);
        add(l1);

        pName = new JTextField();
        pName.setBounds(150, 20, 150, 20);
        add(pName);

        JLabel l2 = new JLabel("Doctor Name:");
        l2.setBounds(20, 60, 120, 20);
        add(l2);

        dName = new JTextField();
        dName.setBounds(150, 60, 150, 20);
        add(dName);

        JLabel l3 = new JLabel("Department:");
        l3.setBounds(20, 100, 120, 20);
        add(l3);

        dept = new JTextField();
        dept.setBounds(150, 100, 150, 20);
        add(dept);

        JLabel l4 = new JLabel("Date (yyyy-mm-dd):");
        l4.setBounds(20, 140, 150, 20);
        add(l4);

        date = new JTextField();
        date.setBounds(150, 140, 150, 20);
        add(date);

        JLabel l5 = new JLabel("Time (HH:mm:ss):");
        l5.setBounds(20, 180, 150, 20);
        add(l5);

        time = new JTextField();
        time.setBounds(150, 180, 150, 20);
        add(time);

        submit = new JButton("Submit");
        submit.setBounds(120, 230, 100, 30);
        add(submit);

        submit.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO appointments (patient_name, doctor_name, department, appointment_date, appointment_time) VALUES (?, ?, ?, ?, ?)"
            );

            ps.setString(1, pName.getText());
            ps.setString(2, dName.getText());
            ps.setString(3, dept.getText());
            ps.setDate(4, Date.valueOf(date.getText()));
            ps.setTime(5, Time.valueOf(time.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Appointment Booked!");
         //  Clear all fields
            pName.setText("");
            dName.setText("");
            dept.setText("");
            date.setText("");
            time.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
