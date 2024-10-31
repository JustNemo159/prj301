/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class SchedualCampaign {
      private int ScID;
    private int PlanCampnID;
    private String Date;
    private int Shift;
    private int Quantity;

    public SchedualCampaign() {
    }

    public SchedualCampaign(int ScID, int PlanCampnID, String Date, int Shift, int Quantity) {
        this.ScID = ScID;
        this.PlanCampnID = PlanCampnID;
        this.Date = Date;
        this.Shift = Shift;
        this.Quantity = Quantity;

    }

    public int getScID() {
        return ScID;
    }

    public void setScID(int scID) {
        ScID = scID;
    }

    public int getPlanCampnID() {
        return PlanCampnID;
    }

    public void setPlanCampnID(int planCampnID) {
        PlanCampnID = planCampnID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getShift() {
        return Shift;
    }

    public void setShift(int shift) {
        Shift = shift;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }


}
