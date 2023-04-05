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
        System.out.println("Сумма затрат на зарплаты в месяц составляет " + calculationTotalSalary());
        delimiter();
        System.out.println("Минимальную зарплату получает " + checkMinSalary());
        delimiter();
        System.out.println("Максимальную зарплату получает " + checkMaxSalary());
        delimiter();
        System.out.println("Среднее значение зарплат составляет " + calculationAverageSalary());
        delimiter();
        getNamesOfEmployees();
    }
    public static void printInfo(){
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    public static int calculationTotalSalary() {
        int totalSalaryInMonth = 0;
        for (Employee employee : employees) {
            totalSalaryInMonth = totalSalaryInMonth + employee.getSalary();
        }
        return totalSalaryInMonth;
    }
    public static double calculationAverageSalary(){
        double averageSalary;
        averageSalary = (double) calculationTotalSalary() / employees.length;
        return averageSalary;
    }
    public static Employee checkMinSalary () {
        Employee employeeWithMinSalary = null;
        int minSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if(minSalary > employee.getSalary()){
                minSalary = employee.getSalary();
            }
            if (minSalary == employee.getSalary()){
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }
    public static Employee checkMaxSalary () {
        Employee employeeWithMaxSalary = null;
        int maxSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if(maxSalary < employee.getSalary()){
                maxSalary = employee.getSalary();
            }
            if (maxSalary == employee.getSalary()){
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
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

