/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.user;

import java.awt.Taskbar.Feature;
import java.util.ArrayList;

/**
 *
 * @author sonnt-local
 */
public class UserRole {
    private String UserName;
    private int RoleID;

    public UserRole() {
    }

    public UserRole(String UserName, int RoleID) {
        this.UserName = UserName;
        this.RoleID = RoleID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int roleID) {
        RoleID = roleID;
    }
}