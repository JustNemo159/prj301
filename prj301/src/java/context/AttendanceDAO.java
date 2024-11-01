package context;

import entity.Attendence;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class AttendanceDAO extends DBContext implements IDAO<Attendence> {

    @Override
    public List<Attendence> getAll() {
        List<Attendence> attendances = new ArrayList<>();
        String sql = "SELECT * FROM Attendence";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Attendence a = new Attendence(
                    rs.getInt("AttendentID"),
                    rs.getInt("SchEmpID"),
                    rs.getBigDecimal("Quantity"),
                    rs.getFloat("Alpha")
                );
                attendances.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return attendances;
    }

    @Override
    public void add(Attendence attendance) {
        String sql = "INSERT INTO Attendence (AttendentID, SchEmpID, Quantity, Alpha) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, attendance.getAttendentID());
            st.setInt(2, attendance.getSchEmpID());
            st.setBigDecimal(3, attendance.getQuantity());
            st.setFloat(4, attendance.getAlpha());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Attendence attendance) {
        String sql = "UPDATE Attendence SET SchEmpID = ?, Quantity = ?, Alpha = ? WHERE AttendentID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, attendance.getSchEmpID());
            st.setBigDecimal(2, attendance.getQuantity());
            st.setFloat(3, attendance.getAlpha());
            st.setInt(4, attendance.getAttendentID());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Attendence WHERE AttendentID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public Attendence getById(int id) {
        String sql = "SELECT * FROM Attendence WHERE AttendentID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Attendence(
                    rs.getInt("AttendentID"),
                    rs.getInt("SchEmpID"),
                    rs.getBigDecimal("Quantity"),
                    rs.getFloat("Alpha")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Attendence> getBySchEmpID(int schEmpID) {
        List<Attendence> attendances = new ArrayList<>();
        String sql = "SELECT * FROM Attendence WHERE SchEmpID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, schEmpID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Attendence a = new Attendence(
                    rs.getInt("AttendentID"),
                    rs.getInt("SchEmpID"),
                    rs.getBigDecimal("Quantity"),
                    rs.getFloat("Alpha")
                );
                attendances.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return attendances;
    }
}