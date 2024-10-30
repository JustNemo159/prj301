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
public class Attendence {
    private int AttendentID;
    private int SchEmpID;
    private BigDecimal Quantity;
    private float Alpha;

    public Attendence() {
    }

    public Attendence(int AttendentID, int SchEmpID, BigDecimal Quantity, float Alpha) {
        this.AttendentID = AttendentID;
        this.SchEmpID = SchEmpID;
        this.Quantity = Quantity;
        this.Alpha = Alpha;

    }

    @Override
    public String toString() {
        return "Attendence{" +
                "AttendentID=" + AttendentID +
                ", SchEmpID=" + SchEmpID +
                ", Quantity=" + Quantity +
                ", Alpha=" + Alpha +
                '}';
    }

    public int getAttendentID() {
        return AttendentID;
    }

    public void setAttendentID(int attendentID) {
        AttendentID = attendentID;
    }

    public int getSchEmpID() {
        return SchEmpID;
    }

    public void setSchEmpID(int schEmpID) {
        SchEmpID = schEmpID;
    }

    public BigDecimal getQuantity() {
        return Quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        Quantity = quantity;
    }

    public float getAlpha() {
        return Alpha;
    }

    public void setAlpha(float alpha) {
        Alpha = alpha;
    }
}
