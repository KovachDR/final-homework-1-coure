package baseDifficulty;

public class Main {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Иванов Иван Иванович", 1, 50000);
        employees[1] = new Employee("Сергеев Сергей Сергеевич", 2, 55000);
        employees[2] = new Employee("Петров Пётр Петрович", 3, 60000);
        employees[3] = new Employee("Владимиров Владимир Владимирович", 4, 45000);
        employees[4] = new Employee("Николаев Николай Николаевич", 5, 65000);
        employees[5] = new Employee("Александров Александр Александрович", 1, 85000);
        employees[6] = new Employee("Семёнов Семён Семёнович", 2, 45000);
        employees[7] = new Employee("Алексеев Алексей Алексеевич", 3, 35000);
        employees[8] = new Employee("Максимов Максим Максимович", 4, 55000);
        employees[9] = new Employee("Антонов Антон Антонович", 5, 65000);

        printInfo();
        delimiter();
        calculationTotalSalaryAndAverageSalary();
        delimiter();
        checkMinSalary();
        delimiter();
        checkMaxSalary();
        delimiter();
        getNamesOfEmployees();
    }
    public static void printInfo(){
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    public static void calculationTotalSalaryAndAverageSalary() {
        int totalSalaryInMonth = 0;
        for (Employee employee : employees) {
            totalSalaryInMonth = totalSalaryInMonth + employee.getSalary();
        }
        System.out.println("Сумма затрат на зарплаты в месяц составляет - " + totalSalaryInMonth);
        double averageSalary = (double) totalSalaryInMonth / employees.length;
        System.out.println("Средняя зарплата составляет - " + averageSalary);
    }
    public static void checkMinSalary () {
        int minSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (minSalary == employees[i].getSalary()) {
                System.out.println("Минимальную зарплату получает " + employees[i]);
            }
        }
    }
    public static void checkMaxSalary() {
        int maxSalary = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (maxSalary == employees[i].getSalary()) {
                System.out.println("Максимальную зарплату получает " + employees[i]);
            }
        }
    }
    public static void getNamesOfEmployees() {
        for (Employee employee : employees){
            System.out.println(employee.getName());
        }
    }
    public static void delimiter() {
        System.out.println("////////////////////////////////////////////////////");
    }
}

