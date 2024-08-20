public class Main {
    public static Employee createEmployee(String name, int department, int salary) {
        Employee employee = new Employee(name, department, salary);
        return employee;
    }

    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        employee[0] = createEmployee("Иванов Роман Сергеевич", 2, 68000);
        employee[1] = createEmployee("Волков Арсен Игоревич", 5, 72000);
        employee[2] = createEmployee("Боровик Егор Олегович", 2, 50000);
        employee[3] = createEmployee("Жмышенко Альберт Егорович", 1, 77700);
        employee[4] = createEmployee("Петрова Анастасия Ильинишна", 3, 55000);
        employee[5] = createEmployee("Воронина Анна Владимировна", 4, 68000);
        employee[6] = createEmployee("Зубенко Михаил Петрович", 1, 100000);
        employee[7] = createEmployee("Сергеев Иван Романович", 3, 75000);
        employee[8] = createEmployee("Хлебникова Ирина Михайловна", 5, 64700);
        employee[9] = createEmployee("Дуб Артем Сергеевич", 4, 80000);
        for (int count = 0; count < employee.length; count++) {
            System.out.println(employee[count]);
        }
        int commonSalary = calculateSalary(employee);
        double middleSalary = calculateMiddleSalary(employee);
        System.out.println("Общая сумма затрат на зарплату " + commonSalary);
        minSalary(employee);
        maxSalary(employee);
        System.out.println("Среднее значение зарплат " + middleSalary);
        printName(employee);

    }

    private static int calculateSalary(Employee[] employees) {
        int commonSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null) {
                commonSalary = commonSalary + employee.getSalary();
            }
        }
        return commonSalary;
    }

    private static void minSalary(Employee[] employees) {
        int employeeMinSalary = Integer.MAX_VALUE;
        int i = 0;
        for (int count = 0; count < employees.length; count++) {
            Employee employee = employees[count];
            if (employee != null) {
                if (employee.getSalary() < employeeMinSalary) {
                    employeeMinSalary = employee.getSalary();
                    i = count;
                }
            }
        }
        Employee employee = employees[i];
        System.out.println("Сотрудник с самой низкой ЗП - " + employee.getName());
    }

    private static void maxSalary(Employee[] employees) {
        int employeeMaxSalary = Integer.MIN_VALUE;
        int i = 0;
        for (int count = 0; count < employees.length; count++) {
            Employee employee = employees[count];
            if (employee != null) {
                if (employee.getSalary() > employeeMaxSalary) {
                    employeeMaxSalary = employee.getSalary();
                    i = count;
                }
            }
        }
        Employee employee = employees[i];
        System.out.println("Сотрудник с самой высокой ЗП - " + employee.getName());
    }

    private static double calculateMiddleSalary(Employee[] employees) {
        double middleSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null) {
                middleSalary = middleSalary + employee.getSalary();
            }
        }
        return middleSalary / employees.length;
    }

    private static void printName(Employee[] employees) {

        int count;
        for (count = 0; count < employees.length; count++) {
            Employee employee = employees[count];
            System.out.println("ФИО сотрудника - " + employee.getName());
        }
    }

}