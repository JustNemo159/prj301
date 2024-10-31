/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import entity.SchedualCampaign;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SchedualCampaignDAO extends DBContext implements IDAO<SchedualCampaign>{
    @Override
    public List<SchedualCampaign> getAll() {
        return List.of();
    }

    @Override
    public void add(SchedualCampaign schedualCampaign) {

    }

    @Override
    public void update(SchedualCampaign schedualCampaign) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public SchedualCampaign getById(int id) {
        return null;
    }
    public int countQuantity(){
        int count=0;
        String sql="SELECT SUM(Quantity) AS totalQuantity FROM [SchedualCampaign];\n";
        try{
            PreparedStatement pr=connection.prepareStatement(sql);
            ResultSet rs=pr.executeQuery();
            while(rs.next()){
                count=rs.getInt("totalQuantity");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
