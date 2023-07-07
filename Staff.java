import java.util.Scanner;

class Staff extends Employee {
    private String post;

    public Staff() {
    }

    public Staff(String name, String icNo, String post) {
        super(name, icNo);
        this.post = post;
    }

    public void keyinInfo(Scanner keyin) {
        super.keyinInfo(keyin);
        System.out.print("Enter staff post: ");
        post = keyin.nextLine();
    }

    public String getPost() {
        return post;
    }
}
