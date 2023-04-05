package highDifficulty;

public class Employee {
    private final String name;
    private int department;
    private double salary;
    private int id;
    private static int counter = 1;

    public Employee(String name, int department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        id = counter++;
    }
    @Override
    public String toString() {
        return "Сотрудник по имени " + name + " из отдела № " + department +
                ", получает зарплату = " + salary +
                ", табельный номер - " + id;
    }
    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public int getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
    public int getId() {
        return id;
    }
}
