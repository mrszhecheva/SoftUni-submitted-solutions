package CompanyRoster;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new HashMap<>();

        while (n-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            String name = line[0];
            double salary = Double.parseDouble(line[1]);
            String position = line[2];
            String department = line[3];

            Employee employee = null;

            if (line.length == 4) {
                employee = new Employee(name, salary, position,department);
            } else if (line.length == 6) {
                String email = line[4];
                int age = Integer.parseInt(line[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (line.length == 5) {
                try {
                    int age = Integer.parseInt(line[4]);
                    employee = new Employee (name, salary, position, department, age);
                } catch (NumberFormatException e) {
                    String email = line[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }

            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);
        }

        Department maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println(String.format("Highest Average Salary: %s", maxAverageSalaryDepartment.getName()));
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
    }
}
