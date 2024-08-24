public class Main {
    private final static Employee[] employees = new Employee[10];

    private static void createEmployee() {
        employees[0] = new Employee("Иванов Роман Сергеевич", 2, 68000);
        employees[1] = new Employee("Волков Арсен Игоревич", 5, 72000);
        employees[2] = new Employee("Боровик Егор Олегович", 2, 50000);
        employees[3] = new Employee("Жмышенко Альберт Егорович", 1, 77700);
        employees[4] = new Employee("Петрова Анастасия Ильинишна", 3, 55000);
        employees[5] = new Employee("Воронина Анна Владимировна", 4, 68000);
        employees[6] = new Employee("Зубенко Михаил Петрович", 1, 100000);
        employees[7] = new Employee("Сергеев Иван Романович", 3, 75000);
        employees[8] = new Employee("Хлебникова Ирина Михайловна", 5, 64700);
        employees[9] = new Employee("Дуб Артем Сергеевич", 4, 80000);
    }

    public static void main(String[] args) {
        createEmployee();
        for (int count = 0; count < employees.length; count++) {
            System.out.println(employees[count]);
        }
        int commonSalary = calculateSalary(employees);
        double middleSalary = calculateMiddleSalary(employees);
        System.out.println("Общая сумма затрат на зарплату " + commonSalary);
        minSalary(employees);
        maxSalary(employees);
        System.out.println("Среднее значение зарплат " + middleSalary);
        printName(employees);
        indexSalary(employees);
        for (int count = 0; count < employees.length; count++) {
            System.out.println(employees[count]);
        }
        for (int departmentNumber = 1; departmentNumber <= 5; departmentNumber++) {

            System.out.println("Сотрудник с минимальной зп по " + departmentNumber + " отделу " +
                    findEmployeeWithMinSalaryOnDepartment(departmentNumber));
        }
        for (int departmentNumber = 1; departmentNumber <= 5; departmentNumber++) {
            System.out.println("Сотрудник с максимальной зп по " + departmentNumber + " отделу " +
                    findEmployeeWithMaxSalaryOnDepartment(departmentNumber));
        }
        for (int departmentNumber = 1; departmentNumber <= 5; departmentNumber++) {
            System.out.println("Сумма затрат на отдел " + departmentNumber +
                    calculateSalaryOnDepartment(departmentNumber));
        }

        for (int departmentNumber = 1; departmentNumber <= 5; departmentNumber++) {
            System.out.println("Средняя зп на отдел " + departmentNumber + " - " +
                    calculateMiddleSalaryOnDepartment(departmentNumber));
        }

    }

    private static int calculateSalary(Employee[] employee) {
        int commonSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee employees = employee[i];
            if (employee != null) {
                commonSalary = commonSalary + employees.getSalary();
            }
        }
        return commonSalary;
    }

    private static void minSalary(Employee[] employee) {
        int employeeMinSalary = Integer.MAX_VALUE;
        int i = 0;
        for (int count = 0; count < employees.length; count++) {
            Employee employees = employee[count];
            if (employee != null) {
                if (employees.getSalary() < employeeMinSalary) {
                    employeeMinSalary = employees.getSalary();
                    i = count;
                }
            }
        }
        Employee employees = employee[i];
        System.out.println("Сотрудник с самой низкой ЗП - " + employees.getName());
    }

    private static void maxSalary(Employee[] employee) {
        int employeeMaxSalary = Integer.MIN_VALUE;
        int i = 0;
        for (int count = 0; count < employee.length; count++) {
            Employee employees = employee[count];
            if (employee != null) {
                if (employees.getSalary() > employeeMaxSalary) {
                    employeeMaxSalary = employees.getSalary();
                    i = count;
                }
            }
        }
        Employee employees = employee[i];
        System.out.println("Сотрудник с самой высокой ЗП - " + employees.getName());
    }

    private static double calculateMiddleSalary(Employee[] employee) {
        double middleSalary = 0;
        for (int i = 0; i < employee.length; i++) {
            Employee employees = employee[i];
            if (employees != null) {
                middleSalary = middleSalary + employees.getSalary();
            }
        }
        return middleSalary / employees.length;
    }

    private static void printName(Employee[] employee) {

        int count;
        for (count = 0; count < employee.length; count++) {
            Employee employees = employee[count];
            System.out.println("ФИО сотрудника - " + employees.getName());
        }
    }

    private static void indexSalary(Employee[] employee) {
        int count;
        int increasedSalary;
        for (count = 0; count < employee.length; count++) {
            Employee employees = employee[count];
            increasedSalary = employees.getSalary() * 14 / 100 + employees.getSalary();   //14/100 - это индекскация на 14%
            employees.setSalary(increasedSalary);
        }
    }

    private static Employee findEmployeeWithMinSalaryOnDepartment(int departmentNumber) {
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == departmentNumber && (employeeWithMinSalary == null ||
                    employee.getSalary() < employeeWithMinSalary.getSalary())) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalaryOnDepartment(int departmentNumber) {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == departmentNumber && (employeeWithMaxSalary == null ||
                    employee.getSalary() > employeeWithMaxSalary.getSalary())) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    private static int calculateSalaryOnDepartment(int department) {
        int commonSalary = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                commonSalary = commonSalary + employee.getSalary();
            }
        }
        return commonSalary;
    }

    private static double calculateMiddleSalaryOnDepartment(int department) {
        double middleSalary = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                middleSalary = middleSalary + employee.getSalary();
                count++;
            }
        }
        return middleSalary/count;
    }

}