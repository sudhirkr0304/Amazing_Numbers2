
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();

        String[] str = s.split("-");

        System.out.println(str[1] + "/" + str[2] + "/" + str[0]);
    }
}