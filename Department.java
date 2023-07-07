import java.util.*;

public class Department {
    private String name;
    private Company company;
    private ArrayList<Employee> staffs;

    Department(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {return name;}

    public Company getCompany() {return company;}
}