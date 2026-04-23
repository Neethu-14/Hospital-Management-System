package hospitalmanagement;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class CancelAppointment extends JFrame implements ActionListener {
	JTextField id;
    JButton delete;

    public CancelAppointment() {
        setTitle("Cancel Appointment");
        setSize(300, 200);
        setLayout(null);

        JLabel l = new JLabel("Enter ID:");
        l.setBounds(20, 20, 100, 20);
        add(l);

        id = new JTextField();
        id.setBounds(100, 20, 150, 20);
        add(id);

        delete = new JButton("Cancel");
        delete.setBounds(80, 80, 100, 30);
        add(delete);

        delete.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM appointments WHERE id=?"
            );
            ps.setInt(1, Integer.parseInt(id.getText()));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Appointment Cancelled!");
         // Clear text field
            id.setText("");

            //  Move cursor back to field
            id.requestFocus();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
