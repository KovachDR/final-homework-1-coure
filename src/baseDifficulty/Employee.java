package baseDifficulty;

public class Employee {
    private String name;
    private int department;
    private int salary;
    private int id;
    private static int counter = 1;

    public Employee(String name, int department, int salary) {
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

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
