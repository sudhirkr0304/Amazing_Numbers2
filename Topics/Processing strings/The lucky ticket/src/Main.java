import java.util.Scanner;


class Main {


    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        String str1 = str.substring(0,3);
        String str2 = str.substring(str.length() - 3,str.length());
//        System.out.println(str1 + " " + str2);
        if(findsum(str1) == findsum(str2)) {
            System.out.println("Lucky");
        }
        else {
            System.out.println("Regular");
        }


    }

    public static int findsum(String str) {

        int val = Integer.valueOf(str);

        int sum = 0;

        while (val > 0) {
            sum += val % 10;
            val /= 10;
        }

        return sum;
    }
}