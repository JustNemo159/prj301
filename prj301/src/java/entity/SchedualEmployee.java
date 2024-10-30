/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class SchedualEmployee {
    private int SchEmpID;
    private int SchID;
    private int EmployeeID;
    private BigDecimal Quantity;

    public SchedualEmployee() {
    }

    public SchedualEmployee(int SchID, int SchEmpID, int EmployeeID, BigDecimal Quantity) {
        this.SchEmpID = SchEmpID;
        this.SchID = SchID;
        this.EmployeeID = EmployeeID;
        this.Quantity = Quantity;
    }

    public int getSchEmpID() {
        return SchEmpID;
    }

    public void setSchEmpID(int schEmpID) {
        SchEmpID = schEmpID;
    }

    public int getSchID() {
        return SchID;
    }

    public void setSchID(int schID) {
        SchID = schID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public BigDecimal getQuantity() {
        return Quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "SchedualEmployee{" +
                "SchEmpID=" + SchEmpID +
                ", SchID=" + SchID +
                ", EmployeeID=" + EmployeeID +
                ", Quantity=" + Quantity +
                '}';
    }
}
