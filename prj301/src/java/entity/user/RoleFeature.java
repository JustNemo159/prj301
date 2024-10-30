/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.user;

/**
 *
 * @author Admin
 */
public class RoleFeature {
     private int FeatureID;
    private int RoleID;

    public RoleFeature() {
    }

    public RoleFeature(int FeatureID, int RoleID) {
        this.FeatureID = FeatureID;
        this.RoleID = RoleID;
    }

    public int getFeatureID() {
        return FeatureID;
    }

    public void setFeatureID(int featureID) {
        FeatureID = featureID;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int roleID) {
        RoleID = roleID;
    }
}
