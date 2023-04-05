package highDifficulty;

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
        System.out.println("Сумма затрат на ЗП в месяц составляет " + calculationTotalSalary());
        delimiter();
        System.out.println("Минимальную ЗП получает " + checkMinSalary());
        delimiter();
        System.out.println("Максимальную ЗП получает " + checkMaxSalary());
        delimiter();
        System.out.println("Среднее значение ЗП составляет " + calculationAverageSalary());
        delimiter();
        getNamesOfEmployees();
        delimiter();
        indexSalary(10);
        delimiter();
        System.out.println(findMinSalaryInDepartment(1) + " получает минимальную ЗП в отделе");
        delimiter();
        System.out.println(findMaxSalaryInDepartment(1) + " получает максимальную ЗП в отделе");
        delimiter();
        System.out.println(findTotalSalaryInDepartment(1) + " - общая сумма затрат на ЗП в отделе");
        delimiter();
        System.out.println(findAverageSalaryInDepartment(1) + " - средняя ЗП в отделе");
        delimiter();
        indexSalaryInDepartment(1,10);
        delimiter();
        printInfoEmployeesWithoutNumberDepartment(1);
        delimiter();
        searchLowerPaidEmployees(50000);
        delimiter();
        searchBetterPaidEmployees(70000);
    }
    public static void printInfo(){
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    public static double calculationTotalSalary() {
        double totalSalaryInMonth = 0;
        for (Employee employee : employees) {
            totalSalaryInMonth = totalSalaryInMonth + employee.getSalary();
        }
        return totalSalaryInMonth;
    }
    public static double calculationAverageSalary(){
        double averageSalary;
        averageSalary = calculationTotalSalary() / employees.length;
        return averageSalary;
    }
    public static Employee checkMinSalary () {
        Employee employeeWithMinSalary = null;
        double minSalary = employees[0].getSalary();
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
        double maxSalary = employees[0].getSalary();
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

    public static void indexSalary(double indexPercentage) {
        if (indexPercentage <= 0){
            throw new IllegalArgumentException("Введите в параметр значение больше нуля");
        }
        double newSalary;
        for (Employee employee : employees){
            newSalary = employee.getSalary()/100 * indexPercentage + employee.getSalary();
            employee.setSalary(newSalary);
            System.out.println("Индексация зарплаты на " + indexPercentage + " % проведена. Теперь " + employee);
        }
    }
    public static Employee findMinSalaryInDepartment(int numberDepartment) {
        if (numberDepartment < 1 || numberDepartment > 5) {
            throw new IllegalArgumentException("Некорректно введён входной параметр. Введите значение от 1 до 5");
        }
        Employee employeeWithMinSalaryInDepartment = null;
        double minSalaryInDepartment = 10000000;
        for (Employee employee : employees) {
            if (numberDepartment == employee.getDepartment() && minSalaryInDepartment > employee.getSalary()) {
                minSalaryInDepartment = employee.getSalary();}
            if (numberDepartment == employee.getDepartment() && minSalaryInDepartment == employee.getSalary()) {
                    employeeWithMinSalaryInDepartment = employee;
            }
        }
        return employeeWithMinSalaryInDepartment;
    }
    public static Employee findMaxSalaryInDepartment(int numberDepartment) {
        if (numberDepartment < 1 || numberDepartment > 5) {
            throw new IllegalArgumentException("Некорректно введён входной параметр. Введите значение от 1 до 5");
        }
        Employee employeeWithMaxSalaryInDepartment = null;
        double maxSalaryInDepartment = 0;
        for (Employee employee : employees) {
            if (numberDepartment == employee.getDepartment() && maxSalaryInDepartment < employee.getSalary()) {
                maxSalaryInDepartment = employee.getSalary();}
            if (numberDepartment == employee.getDepartment() && maxSalaryInDepartment == employee.getSalary()) {
                    employeeWithMaxSalaryInDepartment = employee;
            }
        }
        return employeeWithMaxSalaryInDepartment;
    }
    public static double findTotalSalaryInDepartment(int numberDepartment){
        if (numberDepartment < 1 || numberDepartment > 5){
            throw new IllegalArgumentException("Некорректно введён входной параметр. Введите значение от 1 до 5");
        }
        double totalSalaryInDepartment = 0;
        for (Employee employee : employees){
            if(numberDepartment == employee.getDepartment()){
                totalSalaryInDepartment = totalSalaryInDepartment + employee.getSalary();
            }
        }
        return totalSalaryInDepartment;
    }
    public static double findAverageSalaryInDepartment(int numberDepartment){
        if (numberDepartment < 1 || numberDepartment > 5){
            throw new IllegalArgumentException("Некорректно введён входной параметр. Введите значение от 1 до 5");
        }
        double totalSalaryInDepartment = 0;
        double averageSalaryInDepartment;
        int quantityEmployeesInDepartment = 0;
        for (Employee employee : employees){
            if(numberDepartment == employee.getDepartment()){
                totalSalaryInDepartment = totalSalaryInDepartment + employee.getSalary();
            }
            if (numberDepartment == employee.getDepartment()){
                quantityEmployeesInDepartment++;
            }
        }
       if (quantityEmployeesInDepartment == 0){
           return 0;
       }
            averageSalaryInDepartment = totalSalaryInDepartment / quantityEmployeesInDepartment;
        return averageSalaryInDepartment;
    }
    public static void indexSalaryInDepartment (int numberDepartment , double indexPercentage){
        if (numberDepartment < 1 || numberDepartment > 5){
            throw new IllegalArgumentException("Некорректно введён номер отдела. Введите значение от 1 до 5");
        }
        if (indexPercentage <= 0){
            throw new IllegalArgumentException("Введите в параметр процента индексации значение больше нуля");
        }
        double newSalary;
        for (Employee employee : employees){
            if (numberDepartment == employee.getDepartment()){
                newSalary = employee.getSalary()/100 * indexPercentage + employee.getSalary();
                employee.setSalary(newSalary);
                System.out.println("Индексация зарплаты на " + indexPercentage + " % в отделе № "
                        + numberDepartment + " проведена. Теперь " + employee);
            }
        }
    }
    public static void printInfoEmployeesWithoutNumberDepartment(int numberDepartment){
        if (numberDepartment < 1 || numberDepartment > 5){
            throw new IllegalArgumentException("Некорректно введён номер отдела. Введите значение от 1 до 5");
        }
        for (Employee employee : employees){
            if (numberDepartment == employee.getDepartment()) {
                System.out.println("Сотрудник - " + employee.getName() + " с зарплатой " + employee.getSalary()
                        + ". Табельный номер - " + employee.getId());
            }
        }
    }
    public static void searchLowerPaidEmployees (int number){
        if (number <= 0) {
            throw new IllegalArgumentException("Введите положительное значение в параметр");
        }
        for (Employee employee : employees){
            if (number > employee.getSalary()) {
                System.out.println("Табельный номер - " + employee.getId() + ". Сотрудник - "
                        + employee.getName() + ". Зарплата " + employee.getSalary());
            }
        }
    }
    public static void searchBetterPaidEmployees (int number){
        if (number <= 0){
            throw new IllegalArgumentException("Введите положительное значение в параметр");
        }
        for (Employee employee : employees){
            if (number <= employee.getSalary()){
                System.out.println("Табельный номер - " + employee.getId() + ". Сотрудник - "
                        + employee.getName() + ". Зарплата " + employee.getSalary());
            }
        }
    }
}

