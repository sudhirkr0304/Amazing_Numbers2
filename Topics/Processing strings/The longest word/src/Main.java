import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner scanner = new Scanner(System.in);

        String string  = scanner.nextLine();

        String[] str = string.split(" ");

        Optional<String> result = Arrays.stream(str).max(Comparator.comparingInt(s -> s.length()));

        System.out.println(result.get());
    }
}