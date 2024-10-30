/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

/**
 *
 * @author Admin
 */
import entity.PlanCampain;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanCampainDAO extends DBContext implements IDAO<PlanCampain>{

    @Override
    public List<PlanCampain> getAll() {
        String sql = "select * from [PlanCampain]";
        List<PlanCampain> planCampains = new ArrayList<>();
        try{
            PreparedStatement st= connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                PlanCampain planCampain = new PlanCampain(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)
                );
                planCampains.add(planCampain);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return planCampains;
    }

    @Override
    public void add(PlanCampain planCampain) {

    }

    @Override
    public void update(PlanCampain planCampain) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public PlanCampain getById(int id) {
        return null;
    }
}
