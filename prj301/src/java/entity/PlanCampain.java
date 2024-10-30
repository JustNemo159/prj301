/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import entity.Plan;
import entity.Product;
/**
 *
 * @author Admin
 */
public class PlanCampain {
    private int PlanCampainID;
    private int PlanID;
    private int ProductID;
    private int Quantity;
    private int Estimate;

    public PlanCampain() {
    }

    public PlanCampain(int PlanCampainID, int PlanID, int ProductID, int Quantity, int Estimate) {
        this.PlanCampainID = PlanCampainID;
        this.PlanID = PlanID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        this.Estimate = Estimate;

    }

    public int getPlanCampainID() {
        return PlanCampainID;
    }

    public void setPlanCampainID(int planCampainID) {
        PlanCampainID = planCampainID;
    }

    public int getPlanID() {
        return PlanID;
    }

    public void setPlanID(int planID) {
        PlanID = planID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getEstimate() {
        return Estimate;
    }

    public void setEstimate(int estimate) {
        Estimate = estimate;
    }
}