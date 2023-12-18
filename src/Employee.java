public class Employee {

    private static int counter = 0;
    private String firstName = "";
    private String lastName = "";
    private String surName = "";
    private int department;
    private double salary;
    private int id;

    public Employee(String firstName, String surName, String lastName, int department, double salary) {
        counter++;
        id = counter;
        if (firstName.equals(null) || firstName.equals("")) {
            throw new IllegalArgumentException("Не заполнено имя сотрудника");
        } else {
            this.firstName = firstName;
        }
        if (surName.equals(null) || surName.equals("")) {
            throw new IllegalArgumentException("Не заполнено отчество сотрудника");
        } else {
            this.surName = surName;
        }
        if (lastName.equals(null) || lastName.equals("")) {
            throw new IllegalArgumentException("Не заполнена фамилия сотрудника");
        } else {
            this.lastName = lastName;
        }
        if (department == 0) {
            throw new IllegalArgumentException("Не заполнен отдел сотрудника");
        } else {
            this.department = department;
        }
        if (salary == 0) {
            throw new IllegalArgumentException("Не заполнена зарплата сотрудника");
        } else {
            this.salary = salary;
        }
    }

    public int getId() {
        return id;
    }

    public int getCounter() {
        return counter;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int dept) {
        this.department = dept;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id=" + id + " " + firstName + " " + surName + " " + lastName + " department-" + department + " salary=" + salary;
    }
}
