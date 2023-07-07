// // HRSYS.java
// // Team members:
// // 1. TEENESH A/L SUBRAMANIAM
// // 2. MUHAMMAD IZAT AIMAN BIN MOHAMAD


import java.util.*;

public class HRSYS {
    public static ArrayList<Company> companies = new ArrayList<Company>();
    public static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        boolean exit = false;
        int operation = 0;

        while (!exit) {
            System.out.println();
            System.out.println("1. Add Company");
            System.out.println("2. Add Department");
            System.out.println("3. Add Staff");
            System.out.println("4. List Staff");
            System.out.println("5. Exit");

            while (operation < 1 || operation > 5) {
                System.out.print("Choose operation (1-5): ");
                operation = Integer.parseInt(keyin.nextLine());
            }

            if (operation == 1)
                addCompany(keyin);
            else if (operation == 2)
                addDepartment(keyin);
            else if (operation == 3)
                addStaff(keyin);
            else if (operation == 4)
                listStaff(keyin);
            else if (operation == 5)
                exit = true;

            operation = 0;
        }
    }

    public static void addCompany(Scanner keyin) {
        System.out.println("ADD NEW COMPANY");
        System.out.print("Company Name: ");
        String companyName = keyin.nextLine();
        Company company = new Company(companyName);
        companies.add(company);
        pressEnter(keyin);
    }

    public static void addDepartment(Scanner keyin) {
        System.out.println("ADD NEW DEPARTMENT");
        System.out.print("Department Name: ");
        String departmentName = keyin.nextLine();

        int companyIndex = selectCompany(keyin);
        if (companyIndex != -1) {
            Company company = companies.get(companyIndex);
            company.addDepartment(departmentName);
        }

        pressEnter(keyin);
    }

    public static void addStaff(Scanner keyin) {
        System.out.println("ADD NEW STAFF");
        System.out.print("Contract staff? (y/n): ");
        String isContractStaff = keyin.nextLine().trim().toLowerCase();

        boolean isContract = isContractStaff.equals("y");
        System.out.print("Name: ");
        String name = keyin.nextLine();
        System.out.print("IC No.: ");
        String icNo = keyin.nextLine();
        System.out.print("Post: ");
        String post = keyin.nextLine();

        int companyIndex = selectCompany(keyin);
        if (companyIndex != -1) {
            Company company = companies.get(companyIndex);
            int departmentIndex = selectDepartment(keyin, company);
            if (departmentIndex != -1) {
                Department department = company.getDepartments().get(departmentIndex);

                if (isContract) {
                    System.out.print("Month(s) of Contract: ");
                    int contractMonths = Integer.parseInt(keyin.nextLine());
                    ContractStaff staff = new ContractStaff(name, icNo, post, contractMonths);
                    staff.setDepartment(department);
                    employees.add(staff);
                } else {
                    Staff staff = new Staff(name, icNo, post);
                    staff.setDepartment(department);
                    employees.add(staff);
                }
            }
        }

        pressEnter(keyin);
    }

    public static void listStaff(Scanner keyin) {
    System.out.println("STAFF LIST RECORD");
    System.out.println("No. Name IC No. Post Company-Department");
    System.out.println("-----------------------------------------");

    int count = 1;
    for (Employee employee : employees) {
        String departmentName = employee.getDepartment().getName();
        String companyName = employee.getDepartment().getCompany().getName();
        String contractInfo = "";
        if (employee instanceof ContractStaff) {
            int contractMonths = ((ContractStaff) employee).getContractMonth();
            contractInfo = " (" + contractMonths + " months contract)";
        }
        System.out.printf("%d %s %s %s %s-%s%s\n", count, employee.getName(), employee.getICNo(), employee.getPost(),
                companyName, departmentName, contractInfo);
        count++;
    }

    pressEnter(keyin);
}


    public static void pressEnter(Scanner keyin) {
        System.out.print("\nPress enter to continue... ");
        keyin.nextLine();
    }

    public static int selectCompany(Scanner keyin) {
        
        int count = 1;
        for (Company company : companies) {
            System.out.printf("%d - %s\n", count, company.getName());
            count++;
        }
        System.out.println("Choose company:");

        int choice = Integer.parseInt(keyin.nextLine());
        if (choice >= 1 && choice <= companies.size()) {
            return choice - 1;
        } else {
            System.out.println("Invalid company choice.");
            return -1;
        }
    }

    public static int selectDepartment(Scanner keyin, Company company) {
        
        int count = 1;
        for (Department department : company.getDepartments()) {
            System.out.printf("%d - %s\n", count, department.getName());
            count++;
        }
        System.out.println("Choose department:");

        int choice = Integer.parseInt(keyin.nextLine());
        if (choice >= 1 && choice <= company.getDepartments().size()) {
            return choice - 1;
        } else {
            System.out.println("Invalid department choice.");
            return -1;
        }
    }
}
