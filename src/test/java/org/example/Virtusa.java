package org.example;


/*
    Employee
        id int
        name String

    HashMap
        K -> Employee
        V -> String

Iterate
 */


/*
Employee Table
 id
 name
 salary

 Todo:// Name of the employee who has second highest salary

 */

// select name,max(salary) from Employee where salary<max(salary);

// get , load


import java.util.*;

class Employee {

    private static Employee employee;

    static Employee getEmployee(int id, String employeeName) {
        if (employee == null) {
            return new Employee(id, employeeName);
        }
        employee.setEmployeeId(id);
        employee.setEmployeeName(employeeName);
        return employee;
    }


    int employeeId;
    String employeeName;

    Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;

    }

    private void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }


    public String getEmployeeName() {
        return employeeName;
    }

    private void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}


public class Virtusa {


    public static void main(String[] args) {
/*
        Map<Employee, String> employeeMap = new HashMap<>();
        employeeMap.put(new Employee(1, "Rajesh"), "Rajesh");
        employeeMap.put(new Employee(2, "Kumar"), "Kumar");


        for (Map.Entry m : employeeMap.entrySet()) {
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }*/

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Rajesh"));
        employeeList.add(new Employee(2, "Kumar"));
        employeeList.add(new Employee(3, "Raja"));


        employeeList.sort((o1, o2) -> Integer.compare(o2.employeeId, o1.employeeId));

        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }

    }
}
