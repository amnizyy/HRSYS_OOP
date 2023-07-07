import java.util.ArrayList;

class Company {
    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        departments = new ArrayList<Department>();
    }

    public String getName() {
        return name;
    }

    public void addDepartment(String departmentName) {
        Department department = new Department(departmentName, this);
        departments.add(department);
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
