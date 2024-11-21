import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeList implements Iterable<Employee> {
    private List<Employee> employees;
    private int length = 0;
    private EmployeeList query;
    
    public EmployeeList() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        length++;
    }

    public void delEmployee(int employeeId) {
        employees.remove(getEmployeeById(employeeId));
        length--;
    }

    public Employee getEmployeeById(int employeeId) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId() == employeeId) {
                return employees.get(i);
            }
        }
        return null;
    }

    public EmployeeList getEmployeeBySeniority(int from, int to) {
        query = new EmployeeList();
        for (Employee e : employees) {
            if (e.getSeniority() >= from && e.getSeniority() < to) {
                query.addEmployee(e);
            }
        }
        return query;
    }

    private EmployeeList getEmployeeByName(String name) {
        query = new EmployeeList();
        for (Employee e : employees) {
            if (e.getName().equalsIgnoreCase(name)) {
                query.addEmployee(e);
            }
        }
        return query;
    }

    public String[] getPhoneByName(String name) {
        query = getEmployeeByName(name);
        String[] phones = new String[query.length];
        int i = 0;
        for (Employee e : query) {
            phones[i] = e.getPhoneNumber();
            i++;
        }
        System.out.println(Arrays.toString(phones));
        return phones;
    }

    @Override
    public String toString() {
        return "Сотрудники=" + employees;
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<>() {
            private int index = -1;

            @Override
            public boolean hasNext() {
                return index + 1 < employees.size();
            }

            @Override
            public Employee next() {
                index++;
                if (index >= 0 && index < employees.size()) {
                    return employees.get(index);
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
