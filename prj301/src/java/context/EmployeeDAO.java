/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

/**
 *
 * @author Admin
 */
import entity.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends DBContext implements IDAO<Employee> {

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from [Employee]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Employee u = new Employee(rs.getInt(1),
                        rs.getString(2),
                        rs.getBoolean(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getLong(8));
                employees.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public int countEmployee(){
        String sql = "SELECT COUNT(*) AS totalEmployees FROM [employee];\n";

        int count=0;
        try{
            PreparedStatement ps= connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                count=rs.getInt("totalEmployees");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    @Override
    public void add(Employee employee) {
        String sql = "insert into [Employee] values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, employee.getEmployeeID());
            st.setString(2, employee.getEmployeeName());
            st.setBoolean(3, employee.isGender());
            st.setString(4, employee.getEmployeeAddress());
            st.setString(5, employee.getDob());
            st.setInt(6, employee.getRoleID());
            st.setInt(7, employee.getDepartmentID());
            st.setLong(8, employee.getSalary());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE [Employee]\n"
                + "   SET EmployeeName = ? \n"
                + "      ,gender = ? \n"
                + "      ,address = ? \n"
                + "      ,dob = ? \n"
                + "      ,RoleID = ? \n"
                + "      ,DepartmentID = ? \n"
                + "      ,salary = ? \n"
                + " WHERE EmployeeID = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, employee.getEmployeeName());
            st.setBoolean(2, employee.isGender());
            st.setString(3, employee.getEmployeeAddress());
            st.setString(4, employee.getDob());
            st.setInt(5, employee.getRoleID());
            st.setInt(6, employee.getDepartmentID());
            st.setLong(7, employee.getSalary());
            st.setInt(8, employee.getEmployeeID());
            int rs=st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        // Bước 1: Xóa các bản ghi liên quan trong SchedualEmployee
        String deleteScheduleSQL = "DELETE FROM [SchedualEmployee] WHERE EmployeeID = ?";
        try (PreparedStatement stSchedule = connection.prepareStatement(deleteScheduleSQL)) {
            stSchedule.setInt(1, id);
            stSchedule.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting from SchedualEmployee: " + e.getMessage(), e);
        }

        // Bước 2: Xóa bản ghi trong Employee
        String deleteEmployeeSQL = "DELETE FROM [Employee] WHERE EmployeeID = ?";
        try (PreparedStatement stEmployee = connection.prepareStatement(deleteEmployeeSQL)) {
            stEmployee.setInt(1, id);
            stEmployee.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting from Employee: " + e.getMessage(), e);
        }
    }


    @Override
    public Employee getById(int id) {
        String sql = "SELECT * FROM [Employee] WHERE EmployeeID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            // loop until select the last object
            while (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeID(rs.getInt(1));
                e.setEmployeeName(rs.getString(2));
                e.setGender(rs.getBoolean(3));
                e.setEmployeeAddress(rs.getString(4));
                e.setDob(rs.getString(5));
                e.setRoleID(rs.getInt(6));
                e.setDepartmentID(rs.getInt(7));
                e.setSalary(rs.getLong(8));
                return e;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public List<Employee> searchEmployeesByName(String name) {
        List<Employee> result = new ArrayList<>();
        String query = "SELECT * FROM [Employee] WHERE EmployeeName LIKE ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, "%" + name + "%"); // Tìm kiếm theo tên
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeID(rs.getInt("EmployeeID"));
                employee.setEmployeeName(rs.getString("EmployeeName"));
                employee.setGender(rs.getBoolean("gender"));
                employee.setEmployeeAddress(rs.getString("address"));
                employee.setDob(rs.getString("dob"));
                employee.setRoleID(rs.getInt("RoleID"));
                employee.setDepartmentID(rs.getInt("DepartmentID"));
                employee.setSalary(rs.getLong("salary"));
                result.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}

