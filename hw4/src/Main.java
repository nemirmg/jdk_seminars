public class Main {
    public static void main(String[] args) {
        EmployeeList employees = new EmployeeList();
        employees.addEmployee(new Employee("Василий", "123456", 4));
        employees.addEmployee(new Employee("Анна", "852741", 12));
        employees.addEmployee(new Employee("Петр", "789654", 13));
        employees.addEmployee(new Employee("Кирилл", "951357", 7));
        employees.addEmployee(new Employee("Екатерина", "100200", 5));
        employees.addEmployee(new Employee("Петр", "999999", 9));

        System.out.println(employees);

        System.out.println(employees.getEmployeeById(2));
        
        employees.delEmployee(2);
        
        System.out.println(employees.getEmployeeBySeniority(7, 20));

        employees.getPhoneByName("ПЕТР");
    }
}
