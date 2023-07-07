import java.util.Scanner;

class ContractStaff extends Staff {
    private int contractMonth;

    public ContractStaff() {
    }

    public ContractStaff(String name, String icNo, String post, int contractMonth) {
        super(name, icNo, post);
        this.contractMonth = contractMonth;
    }

    public void keyinInfo(Scanner keyin) {
        super.keyinInfo(keyin);
        System.out.print("Enter contract duration (in months): ");
        contractMonth = Integer.parseInt(keyin.nextLine());
    }

    public int getContractMonth() {
        return contractMonth;
    }
}