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
        calculationTotalSalaryAndAverageSalary();
        delimiter();
        checkMinSalary();
        delimiter();
        checkMaxSalary();
        delimiter();
        getNamesOfEmployees();
        delimiter();
        indexSalary(10);
        delimiter();
        findMinSalaryInDepartment(1);
        delimiter();
        findMaxSalaryInDepartment(1);
        delimiter();
        findTotalSalaryInDepartment(1);
        delimiter();
        findAverageSalaryInDepartment(1);
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
    public static void calculationTotalSalaryAndAverageSalary() {
        double totalSalaryInMonth = 0;
        for (Employee employee : employees) {
            totalSalaryInMonth = totalSalaryInMonth + employee.getSalary();
        }
        System.out.println("Сумма затрат на зарплаты в месяц составляет - " + totalSalaryInMonth);
        double averageSalary = totalSalaryInMonth / employees.length;
        System.out.println("Средняя зарплата составляет - " + averageSalary);
    }
    public static void checkMinSalary () {
        double minSalary = employees[0].getSalary();
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
        double maxSalary = employees[0].getSalary();
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
    public static void findMinSalaryInDepartment(int numberDepartment){
        if (numberDepartment < 1 || numberDepartment > 5){
            throw new IllegalArgumentException("Некорректно введён входной параметр. Введите значение от 1 до 5");
        }
        double minSalaryInDepartment = 10000000;
        for (Employee employee : employees){
        if (numberDepartment == employee.getDepartment() && minSalaryInDepartment > employee.getSalary()){
            minSalaryInDepartment = employee.getSalary();
                }
            }
        for (Employee employee : employees) {
            if(numberDepartment == employee.getDepartment() && minSalaryInDepartment == employee.getSalary()){
                System.out.println("Минимальная зарплата в отделе у сотрудника по имени - " + employee.getName()
                        + ". Он получает " + employee.getSalary());
            }
        }
    }
    public static void findMaxSalaryInDepartment(int numberDepartment){
        if (numberDepartment < 1 || numberDepartment > 5){
            throw new IllegalArgumentException("Некорректно введён входной параметр. Введите значение от 1 до 5");
        }
        double maxSalaryInDepartment = 0;
        for (Employee employee : employees){
            if (numberDepartment == employee.getDepartment() && maxSalaryInDepartment < employee.getSalary()){
                maxSalaryInDepartment = employee.getSalary();
            }
        }
        for (Employee employee : employees) {
            if(numberDepartment == employee.getDepartment() && maxSalaryInDepartment == employee.getSalary()){
                System.out.println("Максимальная зарплата в отделе у сотрудника по имени - " + employee.getName()
                        + ". Он получает " + employee.getSalary());
            }
        }
    }
    public static void findTotalSalaryInDepartment(int numberDepartment){
        if (numberDepartment < 1 || numberDepartment > 5){
            throw new IllegalArgumentException("Некорректно введён входной параметр. Введите значение от 1 до 5");
        }
        double totalSalaryInDepartment = 0;
        for (Employee employee : employees){
            if(numberDepartment == employee.getDepartment()){
                totalSalaryInDepartment = totalSalaryInDepartment + employee.getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплату в отделе № " + numberDepartment
                + " составляет " + totalSalaryInDepartment);
    }
    public static void findAverageSalaryInDepartment(int numberDepartment){
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
        }
        for (Employee employee : employees){
            if (numberDepartment == employee.getDepartment()){
                quantityEmployeesInDepartment++;
            }
        }
        averageSalaryInDepartment = totalSalaryInDepartment / quantityEmployeesInDepartment;
        System.out.println("Средняя зарплата в отделе № " + numberDepartment
                + " составляет " + averageSalaryInDepartment);
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
            if (numberDepartment == employee.getDepartment())
                System.out.println("Сотрудник - " + employee.getName() + " с зарплатой " + employee.getSalary()
                    + ". Табельный номер - " + employee.getId());
        }
    }
    public static void searchLowerPaidEmployees (int number){
        if (number <= 0)
            throw new IllegalArgumentException("Введите положительное значение в параметр");
        for (Employee employee : employees){
            if (number > employee.getSalary())
                System.out.println("Табельный номер - " + employee.getId() + ". Сотрудник - "
                        + employee.getName() + ". Зарплата " + employee.getSalary());
        }
    }
    public static void searchBetterPaidEmployees (int number){
        if (number <= 0)
            throw new IllegalArgumentException("Введите положительное значение в параметр");
        for (Employee employee : employees){
            if (number <= employee.getSalary())
                System.out.println("Табельный номер - " + employee.getId() + ". Сотрудник - "
                        + employee.getName() + ". Зарплата " + employee.getSalary());
        }
    }
}


