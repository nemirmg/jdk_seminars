public class Employee {
    private static int Id = 0;
    private int employeeId;
    private String phoneNumber;
    private String name;
    private int seniority;

    public Employee(String name, String phoneNumber, int seniority) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.seniority = seniority;
        this.employeeId = setEmployeeId();
    }

    private static int setEmployeeId() {
        return ++Id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSeniority() {
        return seniority;
    }

    @Override
    public String toString() {
        return "{ID: " + employeeId + 
               ", Имя: " + name + 
               ", Тел.: " + phoneNumber + 
               ", Стаж: " + seniority + "}";
    }
}