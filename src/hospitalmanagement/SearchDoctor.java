package hospitalmanagement;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class SearchDoctor extends JFrame implements ActionListener {
	 JTextField doctor;
	    JTextArea result;
	    JButton search;

	    public SearchDoctor() {
	        setTitle("Search Doctor");
	        setSize(400, 400);
	        setLayout(null);

	        doctor = new JTextField();
	        doctor.setBounds(20, 20, 200, 25);
	        add(doctor);

	        search = new JButton("Search");
	        search.setBounds(240, 20, 100, 25);
	        add(search);

	        result = new JTextArea();
	        result.setBounds(20, 60, 350, 250);
	        add(result);

	        search.addActionListener(this);
	        setVisible(true);
	    }

	    public void actionPerformed(ActionEvent e) {
	        try {
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(
	                "SELECT * FROM appointments WHERE doctor_name=?"
	            );
	            ps.setString(1, doctor.getText());

	            ResultSet rs = ps.executeQuery();

	            result.setText("");
	            while (rs.next()) {
	                result.append(rs.getString(2) + " | " + rs.getString(3) + "\n");
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
}
