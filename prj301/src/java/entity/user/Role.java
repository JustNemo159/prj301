/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.user;

/**
 *
 * @author Admin
 */
public class Role {
    private int RoleID;
    private String RoleName;
    private String Description;

    public Role() {
    }

    public Role(int RoleID, String RoleName, String Description) {
        this.RoleID = RoleID;
        this.RoleName = RoleName;
        this.Description = Description;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int roleID) {
        RoleID = roleID;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
