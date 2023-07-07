import java.util.Scanner;

abstract class Employee {
    private String name;
    private String icNo;
    private Department department;

    public Employee() {
    }

    public Employee(String name, String icNo) {
        this.name = name;
        this.icNo = icNo;
    }

    public void keyinInfo(Scanner keyin) {
        System.out.print("Enter employee name: ");
        name = keyin.nextLine();
        System.out.print("Enter employee IC number: ");
        icNo = keyin.nextLine();
    }

    public String getName() {
        return name;
    }

    public String getICNo() {
        return icNo;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public abstract String getPost();
}

