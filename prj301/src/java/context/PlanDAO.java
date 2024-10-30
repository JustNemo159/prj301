/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

/**
 *
 * @author Admin
 */
import entity.Plan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanDAO extends DBContext implements IDAO<Plan>{

    @Override
    public List<Plan> getAll() {
        String sql = "select * from [plan]";
        List<Plan> plans = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Plan plan = new Plan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
                plans.add(plan);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return plans;
    }

    public List<Plan> getAllsevenday() {
        String sql = "SELECT * \n" +
                "FROM [Plan]\n" +
                "WHERE EndDate >= DATEADD(day, -7, GETDATE());\n";
        List<Plan> plans = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Plan plan = new Plan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
                plans.add(plan);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return plans;
    }
    @Override
    public void add(Plan plan) {
        String sql = "INSERT INTO [plan] VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, plan.getPlanID());
            st.setString(2, plan.getPlanName());

            // Chuyển đổi StartDate và EndDate từ String sang java.sql.Date
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = new Date(format.parse(plan.getStartDate()).getTime());
            Date endDate = new Date(format.parse(plan.getEndDate()).getTime());

            st.setDate(3, (java.sql.Date) startDate);
            st.setDate(4, (java.sql.Date) endDate);
            st.setInt(5, plan.getQuantity());
            st.setInt(6, plan.getDepartmentID());

            st.executeUpdate();
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Plan plan) {
        String sql = "UPDATE [plan] SET PlanName = ?, StartDate = ?, EndDate = ?, Quantity = ?, DepartmentID = ? WHERE PlanID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, plan.getPlanName());

            // Chuyển đổi StartDate và EndDate từ String sang java.sql.Date
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = new Date(format.parse(plan.getStartDate()).getTime());
            Date endDate = new Date(format.parse(plan.getEndDate()).getTime());

            st.setDate(2, (java.sql.Date) startDate);
            st.setDate(3, (java.sql.Date) endDate);
            st.setInt(4, plan.getQuantity());
            st.setInt(5, plan.getDepartmentID());
            st.setInt(6, plan.getPlanID());

            st.executeUpdate();
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int planID) {
        String sql = "DELETE FROM [plan] WHERE PlanID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, planID);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Plan getById(int planID) {
        String query = "SELECT * FROM [Plan] WHERE PlanID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, planID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Plan plan = new Plan();
                plan.setPlanID(rs.getInt("PlanID"));
                plan.setPlanName(rs.getString("PlanName"));
                plan.setStartDate(rs.getDate("StartDate").toString()); // Chuyển sang String nếu StartDate là kiểu DATE trong SQL
                plan.setEndDate(rs.getDate("EndDate").toString());     // Chuyển sang String nếu EndDate là kiểu DATE trong SQL
                plan.setQuantity(rs.getInt("Quantity"));
                plan.setDepartmentID(rs.getInt("DepartmentID"));
                return plan;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Trả về null nếu không tìm thấy bản ghi
    }

    public int countQuantity(){
        int count=0;
        String sql="SELECT COUNT(*) AS totalQantity FROM [Plan];\n";
        try{
            PreparedStatement pr=connection.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            while(rs.next()){
                count=rs.getInt("totalQantity");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    public List<Plan> searchPlansByName(String name) {
        List<Plan> result = new ArrayList<>();
        String query = "SELECT * FROM [Plan] WHERE PlanName LIKE ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, "%" + name + "%"); // Tìm kiếm theo tên kế hoạch
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Plan plan = new Plan();
                plan.setPlanID(rs.getInt("PlanID"));
                plan.setPlanName(rs.getString("PlanName"));
                plan.setStartDate(rs.getDate("StartDate").toString()); // Chuyển sang String nếu StartDate là kiểu DATE trong SQL
                plan.setEndDate(rs.getDate("EndDate").toString());     // Chuyển sang String nếu EndDate là kiểu DATE trong SQL
                plan.setQuantity(rs.getInt("Quantity"));
                plan.setDepartmentID(rs.getInt("DepartmentID"));
                result.add(plan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
