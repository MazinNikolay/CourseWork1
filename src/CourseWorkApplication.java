import java.util.Arrays;
import java.util.Scanner;

public class CourseWorkApplication {
    public static void main(String[] args) {
        EmployeeBook employees = new EmployeeBook();
        employees.addEmployee("Иван", "Иванович", "Иванов", 1, 50_000.00);
        employees.addEmployee("Петр", "Петрович", "Петров", 2, 60_000.00);
        employees.addEmployee("Василий", "Васильевич", "Васильев", 3, 63_000.00);
        employees.addEmployee("Сергей", "Сергеевич", "Сергеев", 4, 51_000.00);
        employees.addEmployee("Георгий", "Георгиевич", "Георгиев", 5, 51_500.00);
        employees.addEmployee("Светлана", "Георгиевна", "Георгиева", 1, 51_500.00);
        employees.addEmployee("Татьяна", "Сергеевна", "Семеркина", 2, 54_500.00);
        employees.addEmployee("Зинаида", "Александровна", "Победова", 3, 51_800.00);
        employees.addEmployee("Анатолий", "Александрович", "Мячиков", 4, 56_700.00);
        employees.addEmployee("Олег", "Олегович", "Рыбкин", 5, 63_200.00);
        System.out.println("Вывод в консоль всех сотрудников из массива");
        employees.printAllEmployees();
        System.out.println("Общая заработная плата:");
        System.out.println(employees.paymentsMonthly());
        System.out.println("Сотрудник с минимальной заработной платой:");
        System.out.println(employees.findMinSalaryEmployee());
        System.out.println("Сотрудник с максимальной заработной платой:");
        System.out.println(employees.findMaxSalaryEmployee());
        System.out.println("Средняя заработная плата всех сотрудников:");
        System.out.printf("%.2f", employees.avgSalaryEmployees());
        System.out.println();
        System.out.println("Перечнь всех сотрудников:");
        employees.getAllEmployeesFullName();
        //Повышенная сложность
        System.out.println("Введите процент индексации");
        Scanner scanner = new Scanner(System.in);
        double indexingValue = scanner.nextDouble();
        employees.indexingSalary(indexingValue);
        System.out.println("Вывод в консоль всех сотрудников из массива с проиндексированной заработной платой");
        employees.printAllEmployees();
        System.out.println("Введите номер отдела");
        int inputDepartment = inputEmployeeDepartment();
        System.out.println("Введите процент индексации");
        double indexingValueForDepartment = scanner.nextDouble();
        employees.methodsAnDepartment(inputDepartment, indexingValueForDepartment);
        System.out.println("Вывод в консоль всех сотрудников из массива с проиндексированной заработной платой:");
        employees.printAllEmployees();
        System.out.println("Введите значение для сравнения заработной платы");
        int compareSalaryValue = scanner.nextInt();
        System.out.println("Перечнь всех сотрудников с заработной платой меньше чем " + compareSalaryValue + ":");
        employees.compareLowerSalary(compareSalaryValue);
        System.out.println("Перечнь всех сотрудников с заработной платой больше или равной " + compareSalaryValue + ":");
        employees.compareGreaterSalary(compareSalaryValue);
        System.out.println("Введите ФИО сотрудника через пробел для удаления");
        String searchDataString = inputEmployeeData();
        System.out.println("Введите id сотрудника для удаления");
        int searchDataInt = inputEmployeeId();
        if (searchDataString.isBlank() && searchDataInt == 0) {
            System.out.println("Не введены значения для поиска сотрудника");
        } else if (searchDataString.isBlank() && searchDataInt != 0) {
            employees.deleteEmployee(searchDataInt);
        } else if (!searchDataString.isBlank() && searchDataInt == 0) {
            employees.deleteEmployee(searchDataString);
        } else if (!searchDataString.isBlank() && searchDataInt != 0) {
            employees.deleteEmployee(searchDataString, searchDataInt);
        }
        System.out.println("Перечнь всех сотрудников:");
        employees.printAllEmployees();
        System.out.println("Введите ФИО сотрудника через пробел для изменения");
        searchDataString = inputEmployeeData();
        employees.changeEmployee(searchDataString);
        System.out.println("Перечнь всех сотрудников:");
        employees.printAllEmployees();
        System.out.println("Перечнь всех сотрудников по отделам:");
        employees.printEmployeesByDepartment(5);
    }

    static String inputEmployeeData() {
        String searchDataString = "";
        String[] searchDataStringArray = searchDataString.split(" ");
        Scanner scanner = new Scanner(System.in);
        while (searchDataString.isBlank() || searchDataStringArray.length != 3) {
            searchDataString = scanner.nextLine();
            searchDataStringArray = searchDataString.split(" ");
            if (searchDataString.isBlank() || searchDataStringArray.length != 3) {
                System.out.println("Данные для поиска сотрудника не введены или введены некорректно, введите данные заново");
            }
        }
        return searchDataString;
    }

    static int inputEmployeeDepartment() {
        Scanner scanner = new Scanner(System.in);
        int dept = 0;
        while (dept < 1 || dept > 5) {
            dept = scanner.nextInt();
            if (dept < 1 || dept > 5) {
                System.out.println("Введенный отдел не существует, введите заново");
            }
        }
        return dept;
    }

    static int inputEmployeeId() {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        while (id < 1 || id > 10) {
            id = scanner.nextInt();
            if (id < 1 || id > 10) {
                System.out.println("Сотрудник с введенным id не существует, введите заново");
            }
        }
        return id;
    }
}
