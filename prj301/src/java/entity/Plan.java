/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author sonnt-local
 */
public class Plan {
    private int PlanID;
    private String PlanName;
    private String StartDate;
    private String EndDate;
    private int Quantity;
    private int DepartmentID;

    public Plan() {
    }

    public Plan(int PlanID, String PlanName, String StartDate, String EndDate, int Quantity, int DepartmentID) {
        this.PlanID = PlanID;
        this.PlanName = PlanName;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Quantity = Quantity;
        this.DepartmentID = DepartmentID;

    }

    public int getPlanID() {
        return PlanID;
    }

    public void setPlanID(int planID) {
        PlanID = planID;
    }

    public String getPlanName() {
        return PlanName;
    }

    public void setPlanName(String planName) {
        PlanName = planName;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int departmentID) {
        DepartmentID = departmentID;
    }
}