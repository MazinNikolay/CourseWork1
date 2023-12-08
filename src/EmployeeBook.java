import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];
    private int notNullItem = 0;

    public void printAllEmployees() {
        System.out.println(Arrays.toString(employees).replace("[", "").replace("]", "").replace(", ", "\n"));
    }

    public double paymentsMonthly() {
        double payments = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                payments += employees[i].getSalary();
            }
        }
        return payments;
    }

    public Employee findMinSalaryEmployee() {
        Employee minSalaryEmployee = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employees[i];
                }
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMaxSalaryEmployee() {
        Employee maxSalaryEmployee = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employees[i];
                }
            }
        }
        return maxSalaryEmployee;
    }

    public double avgSalaryEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                notNullItem++;
            }
        }
        double avgSalary = paymentsMonthly() / notNullItem;
        return avgSalary;
    }

    public void getAllEmployeesFullName() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFirstName() + " " + employees[i].getSurName() + " " + employees[i].getLastName());
            }
        }
    }


    //Повышенная сложность
    public void indexingSalary(double indexValue) {
        double convertIndexValue;
        if (indexValue > 0) {
            convertIndexValue = 1 + (indexValue / 100);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    employees[i].setSalary(Math.round(employees[i].getSalary() * convertIndexValue));
                }
            }
        } else {
            System.out.println("Индексация на введенную величину невозможна");
        }
    }

    public void methodsAnDepartment(int dept, double indexingValue) {
        System.out.println("Сотрудник с минимальной заработной платой в отделе " + dept + ":");
        System.out.println(findMinSalaryEmployee(dept));
        System.out.println("Сотрудник с максимальной заработной платой в отделе " + dept + ":");
        System.out.println(findMaxSalaryEmployee(dept));
        System.out.println("Заработная плата всех сотрудников в отделе " + dept + ":");
        System.out.println(paymentsMonthly(dept));
        System.out.println("Средняя заработная плата всех сотрудников в отделе " + dept + ":");
        System.out.printf("%.2f", avgSalaryEmployees(dept));
        System.out.println();
        System.out.println("Перечнь всех сотрудников в отделе " + dept + " с проиндексированной заработной платой:");
        indexingSalary(indexingValue, dept);
        getAllEmployees(dept);
    }

    public Employee findMinSalaryEmployee(int dept) {
        Employee minSalaryEmployee = employees[0];
        boolean flagMathDepartment = true;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == dept && flagMathDepartment) {
                    minSalaryEmployee = employees[i];
                    flagMathDepartment = false;
                }
                if (employees[i].getSalary() < minSalaryEmployee.getSalary() && employees[i].getDepartment() == dept) {
                    minSalaryEmployee = employees[i];
                }
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMaxSalaryEmployee(int dept) {
        Employee maxSalaryEmployee = employees[0];
        boolean flagMathDepartment = true;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == dept && flagMathDepartment) {
                    maxSalaryEmployee = employees[i];
                    flagMathDepartment = false;
                }
                if (employees[i].getSalary() > maxSalaryEmployee.getSalary() && employees[i].getDepartment() == dept) {
                    maxSalaryEmployee = employees[i];
                }
            }
        }
        return maxSalaryEmployee;
    }

    public double paymentsMonthly(int dept) {
        double payments = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == dept) {
                    payments += employees[i].getSalary();
                }
            }
        }
        return payments;
    }

    public double avgSalaryEmployees(int dept) {
        int countEmployeeOfDepartment = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == dept) {
                    countEmployeeOfDepartment++;
                }
            }
        }
        double avgSalary = paymentsMonthly(dept) / countEmployeeOfDepartment;
        return avgSalary;
    }

    public void indexingSalary(double indexValue, int dept) {
        double convertIndexValue;
        if (indexValue > 0) {
            convertIndexValue = 1 + (indexValue / 100);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (employees[i].getDepartment() == dept) {
                        employees[i].setSalary(Math.round(employees[i].getSalary() * convertIndexValue));
                    }
                }
            }
        } else {
            System.out.println("Индексация на введенную величину невозможна");
        }
    }

    public void getAllEmployees(int dept) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == dept) {
                    System.out.println("id=" + employees[i].getId() + " " + employees[i].getFirstName() + " " + employees[i].getSurName() + " " + employees[i].getLastName() + " salary=" + employees[i].getSalary());
                }
            }
        }
    }

    public void compareLowerSalary(int compareSalaryValue) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < compareSalaryValue) {
                    System.out.println("id=" + employees[i].getId() + " " + employees[i].getFirstName() + " " + employees[i].getSurName() + " " + employees[i].getLastName() + " salary=" + employees[i].getSalary());
                }
            }
        }
    }

    public void compareGreaterSalary(int compareSalaryValue) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() >= compareSalaryValue) {
                    System.out.println("id=" + employees[i].getId() + " " + employees[i].getFirstName() + " " + employees[i].getSurName() + " " + employees[i].getLastName() + " salary=" + employees[i].getSalary());
                }
            }
        }
    }

    //Очень сложно
    public void addEmployee(String firstName, String surName, String lastName, int department, double salary) {
        Employee emp = new Employee(firstName, surName, lastName, department, salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = emp;
                break;
            }
        }
    }

    public void deleteEmployee(String searchDataString, int searchDataInt) {
        String[] convertedDataString = convertEmployeeFio(searchDataString);
        String firstName = convertedDataString[0];
        String surName = convertedDataString[1];
        String lastName = convertedDataString[2];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getId() == searchDataInt && employees[i].getFirstName().equals(firstName) && employees[i].getSurName().equals(surName) && employees[i].getLastName().equals(lastName)) {
                    employees[i] = null;
                }
            }
        }
    }

    public void deleteEmployee(String searchDataString) {
        String[] convertedDataString = convertEmployeeFio(searchDataString);
        String firstName = convertedDataString[0];
        String surName = convertedDataString[1];
        String lastName = convertedDataString[2];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getFirstName().equals(firstName) && employees[i].getSurName().equals(surName) && employees[i].getLastName().equals(lastName)) {
                    employees[i] = null;
                }
            }
        }
    }

    public void deleteEmployee(int searchDataInt) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getId() == searchDataInt) {
                    employees[i] = null;
                }
            }
        }
    }

    public void changeEmployee(String searchDataString) {
        String[] convertedDataString = convertEmployeeFio(searchDataString);
        String firstName = convertedDataString[0];
        String surName = convertedDataString[1];
        String lastName = convertedDataString[2];
        System.out.println(firstName + surName + lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getFirstName().equals(firstName) && employees[i].getSurName().equals(surName) && employees[i].getLastName().equals(lastName)) {
                    employees[i].setSalary(20_000);
                    employees[i].setDepartment(1);
                }
            }
        }
    }

    public void printEmployeesByDepartment(int maxDeptValue) {
        for (int dept = 1; dept <= maxDeptValue; dept++) {
            System.out.println("Отдел -" + dept);
            getAllEmployeesFullName(dept);
        }
    }

    public String[] convertEmployeeFio(String searchDataString) {
        String[] fio = searchDataString.split(" ");
        for (int i = 0; i < fio.length; i++) {
            if (employees[i] != null) {
                fio[i] = Character.toUpperCase(fio[i].charAt(0)) + fio[i].substring(1, fio[i].length()).toLowerCase();
            }
        }
        return fio;
    }

    public void getAllEmployeesFullName(int dept) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == dept)
                    System.out.println(employees[i].getFirstName() + " " + employees[i].getSurName() + " " + employees[i].getLastName());
            }
        }
    }
}
