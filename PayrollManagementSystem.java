/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package payroll.system;

/**
 *
 * @author TEJAL VINOD APRAJ
 */

import java.util.Scanner;

class Employee {
    String name;
    double salary;
    double taxRate;

    public Employee(String name, double salary, double taxRate) {
        this.name = name;
        this.salary = salary;
        this.taxRate = taxRate;
    }

    public double calculateNetSalary() {
        double taxAmount = salary * taxRate;
        double netSalary = salary - taxAmount;
        return netSalary;
    }

    public String generatePayStub() {
        double netSalary = calculateNetSalary();
        return "Name: " + name + "\nSalary: $" + salary + "\nTax: $" + (salary * taxRate) + "\nNet Salary: $" + netSalary;
    }
}

public class PayrollManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter tax rate (in decimal): ");
        double taxRate = scanner.nextDouble();

        Employee employee1 = new Employee(name, salary, taxRate);

        String payStub = employee1.generatePayStub();

        System.out.println(payStub);

        scanner.close();
    }
}

