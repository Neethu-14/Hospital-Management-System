package hospitalmanagement;
import javax.swing.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class ViewAppointments extends JFrame {
	JTable table;
    DefaultTableModel model;

    public ViewAppointments() {
        setTitle("View Appointments");
        setSize(700, 400);

        // Column Names
        String[] columns = {
            "ID", "Patient Name", "Doctor Name",
            "Department", "Date", "Time"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);
        add(sp);

        loadData();

        setVisible(true);
    }

    //  Load data from database
    private void loadData() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM appointments");

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("patient_name"),
                    rs.getString("doctor_name"),
                    rs.getString("department"),
                    rs.getDate("appointment_date"),
                    rs.getTime("appointment_time")
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	}
