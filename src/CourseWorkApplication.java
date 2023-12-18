import java.util.Arrays;
import java.util.Scanner;

public class CourseWorkApplication {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иван", "Иванович", "Иванов", 1, 50_000.00);
        employees[1] = new Employee("Петр", "Петрович", "Петров", 2, 60_000.00);
        employees[2] = new Employee("Василий", "Васильевич", "Васильев", 3, 63_000.00);
        employees[3] = new Employee("Сергей", "Сергеевич", "Сергеев", 4, 51_000.00);
        employees[4] = new Employee("Георгий", "Георгиевич", "Георгиев", 5, 51_500.00);
        employees[5] = new Employee("Светлана", "Георгиевна", "Георгиева", 1, 51_500.00);
        employees[6] = new Employee("Татьяна", "Сергеевна", "Семеркина", 2, 54_500.00);
        employees[7] = new Employee("Зинаида", "Александровна", "Победова", 3, 51_800.00);
        employees[8] = new Employee("Анатолий", "Александрович", "Мячиков", 4, 56_700.00);
        employees[9] = new Employee("Олег", "Олегович", "Рыбкин", 5, 63_200.00);
        printAllEmployees(employees);
        System.out.println("paymentsMonthly(employees) = " + paymentsMonthly(employees));
        System.out.println("findMinSalaryEmployee(employees) = " + findMinSalaryEmployee(employees));
        System.out.println("findMaxSalaryEmployee(employees) = " + findMaxSalaryEmployee(employees));
        System.out.println("avgSalaryEmployees(employees) = " + avgSalaryEmployees(employees));
        getAllEmployeesFullName(employees);
        //Повышенная сложность
        System.out.println("Введите процент индексации");
        Scanner scanner = new Scanner(System.in);
        double indexingValue = scanner.nextDouble();
        indexingSalary(employees, indexingValue);
        printAllEmployees(employees);
        System.out.println("Введите номер отдела");
        int inputDepartment = scanner.nextInt();
        if (inputDepartment > 0 && inputDepartment <= 5) {
            System.out.println("Введите процент индексации");
            double indexingValueForDepartment = scanner.nextDouble();
            methodsAnDepartment(employees, inputDepartment, indexingValueForDepartment);
        } else {
            System.out.println("Такого отдела нет");
        }
        printAllEmployees(employees);
        System.out.println("Введите значение для сравнения зарплаты");
        int compareSalaryValue = scanner.nextInt();
        compareLowerSalary(employees, compareSalaryValue);
        compareGreaterSalary(employees, compareSalaryValue);
    }

    static void printAllEmployees(Employee[] employees) {
        /*for (Employee employee : employees) {
            System.out.println(employee);
        } */
        System.out.println(Arrays.toString(employees).replace("[", "").replace("]", "").replace(", ", "\n"));
    }

    static double paymentsMonthly(Employee[] employees) {
        double payments = 0;
        for (Employee employee : employees) {
            payments += employee.getSalary();
        }
        return payments;
    }

    static Employee findMinSalaryEmployee(Employee[] employees) {
        Employee minSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalaryEmployee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    static Employee findMaxSalaryEmployee(Employee[] employees) {
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    static double avgSalaryEmployees(Employee[] employees) {
        double avgSalary = paymentsMonthly(employees) / employees.length;
        return avgSalary;
    }

    static void getAllEmployeesFullName(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getFirstName() + " " + employee.getSurName() + " " + employee.getLastName());
        }
    }

    //Повышенная сложность
    static void indexingSalary(Employee[] employees, double indexValue) {
        double convertIndexValue;
        if (indexValue > 0) {
            convertIndexValue = 1 + (indexValue / 100);
            for (Employee employee : employees) {
                employee.setSalary(Math.round(employee.getSalary() * convertIndexValue));
            }
        } else {
            System.out.println("Индексация на введенную величину невозможна");
        }
    }

    static void methodsAnDepartment(Employee[] employees, int dept, double indexingValue) {
        System.out.println("findMinSalaryEmployee(employees, dept) = " + findMinSalaryEmployee(employees, dept));
        System.out.println("findMaxSalaryEmployee(employees, dept) = " + findMaxSalaryEmployee(employees, dept));
        System.out.println("paymentsMonthly(employees, dept) = " + paymentsMonthly(employees, dept));
        System.out.println("avgSalaryEmployees(employees, dept) = " + avgSalaryEmployees(employees, dept));
        indexingSalary(employees, indexingValue, dept);
        getAllEmployeesFullName(employees, dept);
    }

    static Employee findMinSalaryEmployee(Employee[] employees, int dept) {
        Employee minSalaryEmployee = employees[0];
        boolean flagMathDepartment = true;
        for (Employee employee : employees) {
            if (employee.getDepartment() == dept && flagMathDepartment) {
                minSalaryEmployee = employee;
                flagMathDepartment = false;
            }
            if (employee.getSalary() < minSalaryEmployee.getSalary() && employee.getDepartment() == dept) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    static Employee findMaxSalaryEmployee(Employee[] employees, int dept) {
        Employee maxSalaryEmployee = employees[0];
        boolean flagMathDepartment = true;
        for (Employee employee : employees) {
            if (employee.getDepartment() == dept && flagMathDepartment) {
                maxSalaryEmployee = employee;
                flagMathDepartment = false;
            }
            if (employee.getSalary() > maxSalaryEmployee.getSalary() && employee.getDepartment() == dept) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    static double paymentsMonthly(Employee[] employees, int dept) {
        double payments = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == dept) {
                payments += employee.getSalary();
            }
        }
        return payments;
    }

    static double avgSalaryEmployees(Employee[] employees, int dept) {
        int countEmployeeOfDepartment = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == dept) {
                countEmployeeOfDepartment++;
            }
        }
        double avgSalary = paymentsMonthly(employees, dept) / countEmployeeOfDepartment;
        return avgSalary;
    }

    static void indexingSalary(Employee[] employees, double indexValue, int dept) {
        double convertIndexValue;
        if (indexValue > 0) {
            convertIndexValue = 1 + (indexValue / 100);
            for (Employee employee : employees) {
                if (employee.getDepartment() == dept) {
                    employee.setSalary(Math.round(employee.getSalary() * convertIndexValue));
                }
            }
        } else {
            System.out.println("Индексация на введенную величину невозможна");
        }
    }

    static void getAllEmployeesFullName(Employee[] employees, int dept) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == dept) {
                System.out.println("id=" + employee.getId() + " " + employee.getFirstName() + " " + employee.getSurName() + " " + employee.getLastName() + " salary=" + employee.getSalary());
            }
        }
    }

    static void compareLowerSalary(Employee[] employees, int compareSalaryValue) {
        for (Employee employee : employees) {
            if (employee.getSalary() < compareSalaryValue) {
                System.out.println("id=" + employee.getId() + " " + employee.getFirstName() + " " + employee.getSurName() + " " + employee.getLastName() + " salary=" + employee.getSalary());
            }
        }
    }

    static void compareGreaterSalary(Employee[] employees, int compareSalaryValue) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= compareSalaryValue) {
                System.out.println("id=" + employee.getId() + " " + employee.getFirstName() + " " + employee.getSurName() + " " + employee.getLastName() + " salary=" + employee.getSalary());
            }
        }
    }
}
