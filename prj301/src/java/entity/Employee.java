/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Employee {
    private int EmployeeID;
    private String EmployeeName;
    private boolean gender;
    private String EmployeeAddress;
    private String dob;
    private int RoleID;
    private int DepartmentID;
    private long salary;

    public Employee() {
    }

    public Employee(int EmployeeID, String EmployeeName, boolean gender, String EmployeeAddress,
                    String dob, int RoleID, int DepartmentID, long salary) {
        this.EmployeeName = EmployeeName;
        this.EmployeeAddress = EmployeeAddress;
        this.dob = dob;
        this.RoleID = RoleID;
        this.DepartmentID = DepartmentID;
        this.salary = salary;
        this.gender = gender;
        this.EmployeeID = EmployeeID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID=" + EmployeeID +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", gender=" + gender +
                ", EmployeeAddress='" + EmployeeAddress + '\'' +
                ", dob='" + dob + '\'' +
                ", RoleID=" + RoleID +
                ", DepartmentID=" + DepartmentID +
                ", salary=" + salary +
                '}';
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmployeeAddress() {
        return EmployeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        EmployeeAddress = employeeAddress;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int roleID) {
        RoleID = roleID;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int departmentID) {
        DepartmentID = departmentID;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
