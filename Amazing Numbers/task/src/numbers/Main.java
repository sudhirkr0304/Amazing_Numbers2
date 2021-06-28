package numbers;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        write your code here

        Scanner scanner = new Scanner(System.in);

        //welcome
        System.out.println("Welcome to Amazing Numbers!\n");

        welcomeMessage();



        long input = -1;

        while (input != 0 ) {

            System.out.print("Enter a request: ");
            String in = scanner.nextLine();
            System.out.println();
            String[] inp = in.split(" ");

            if(inp.length == 0) {
                welcomeMessage();
                continue;
            }
            if(inp.length == 1) {

                if(!checkIsNumberic(inp[0])) {
                    System.out.println("The first parameter should be a natural number or zero.\n");
                    continue;
                }
                input = Long.valueOf(inp[0]);

                System.out.println();

                if(input == 0) {
                    continue;
                }
                else if (checkNaturalNumber(input)) {
                    checkAllProperties(input);
                }
                else {
                    System.out.println("The first parameter should be a natural number or zero.\n");
                }

            }
            else if (inp.length == 2) {

                checkNumberic(inp[0] , inp[1]);

                long num1 = Long.valueOf(inp[0]);
                long num2 = Long.valueOf(inp[1]);

                for(long index = num1 ; index < num1 + num2 ; index++) {

                    checkAllPropertiesOneByOne(index);

                }
                System.out.println();
            }
            else if(inp.length == 3) {

                checkNumberic(inp[0] , inp[1]);

                long num1 = Long.valueOf(inp[0]);
                long num2 = Long.valueOf(inp[1]);
                String string = inp[2];

                if(checkAvailableProperties(string)) {

                   long[] arr = findTheNumbers(num1,num2,string);

                   for(long index : arr) {
                      checkAllPropertiesOneByOne(index);
                   }

                   System.out.println();

                }
            }
            else {
                checkNumberic(inp[0] , inp[1]);

                long num1 = Long.valueOf(inp[0]);
                long num2 = Long.valueOf(inp[1]);

                String string1 = inp[2];
                String string2 = inp[3];

                String[] properties = new String[inp.length - 2];
                for(int i = 0 ;i < properties.length ;i++) {
                 properties[i] = inp[i+2];
                }
//                System.out.println(Arrays.toString(properties));
                  Arrays.sort(properties);

                  Collections.reverse(Arrays.asList(properties));
//                 System.out.println(Arrays.toString(properties));


                if(checkAvailableProperties(properties)) {

                    if(checkMutualyexclusive(properties)) {

                    }
                    else {

                        int count = 500;
                        string1 = properties[0].toUpperCase();
//                        System.out.println(string1 + Arrays.toString(properties));
                        if(string1.equals("EVEN") || string1.equals("ODD")  ) {
                            count = 10000000;
                        }
                        if(string1.equals("SPY")) {
                            if(num1 <= 10) {
                                count = 525;
                            }
                            else {
                                count = 400;
                            }
                        }
                        if(string1.equals("DUCK") ) {
                            count = 50000;
                        }
                        if(string1.equals("-DUCK")) {
                            count = 30000000;
                        }
                        if(string1.equals("PALINDROMIC")) {
                            count = 1500;
                        }
                        if(string1.equals("BUZZ")) {
                            count = 100000;
                        }
                        if(string1.equals("GAPFUL")) {
                            count = 100000;
                        }

                        List<Long>  list1 = Arrays.stream(findTheNumbers(num1,count,string1)).boxed().collect(Collectors.toList());

                        for(Long num : list1) {
                            int flag = 0;
                            for(int i = 0 ; i < properties.length ;i++) {
                                String str = properties[i];
                                if(!checkPropertyByString(num,str)) {
                                    flag = 1;
                                    break;
                                }
                            }
                            if(flag == 0 ) {
                                checkAllPropertiesOneByOne(num);
                                num2--;
                            }

                            if(num2 <= 0) {
                                break;
                            }

                        }

                        System.out.println();

                    }

                }
            }



        }

        System.out.println("Goodbye!");


    }

    public  static boolean checkNaturalNumber(long n) {

        if (n > 0 ) {
            return true;
        }
        return false;
    }

    public static boolean checkEven(long n) {

        if ( n % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean buzzNumber(long n) {

        String explanation = "";
        if(n % 10 == 7 && n % 7 == 0) {
//            System.out.println("It is a Buzz number.");
//            System.out.println("Explanation:");
//            System.out.println(n + " is divisible by 7 and ends with 7.");
            return true;
        }
        else if ( n % 10 == 7) {
//            System.out.println("It is a Buzz number.");
//            System.out.println("Explanation:");
//            System.out.println(n + " ends with 7.");
            return true;
        }
        else if ( n % 7 == 0) {
//            System.out.println("It is a Buzz number.");
//            System.out.println("Explanation:");
//            System.out.println(n + " is divisible by 7.");
              return true;
        }
        else {
//            System.out.println("It is not a Buzz number.");
//            System.out.println("Explanation:");
//            System.out.println(n + " is neither divisible by 7 nor does it end with 7.");
              return false;
        }

    }

    public static boolean isDuckNumber(long n) {

        while( n > 0) {
            if( n % 10 == 0) {
                return true;
            }
            n /= 10;
        }

        return false;
    }

    public static boolean checkPalindraome(long n) {

        String str = Long.toString(n);
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer = stringBuffer.reverse();

        return str.equals(stringBuffer.toString());

    }

    public static boolean isGapful(long n) {
        if( n < 100) {
            return false;
        }

        long num = n;

        long num2 =  n % 10;

        while( num >= 10) {
            num = num / 10;
        }

        num2 = num * 10 + num2;

        if( n % num2 == 0) {
            return true;
        }

        return false;


    }

    public static boolean happyNumber(long n) {
        if(n == 1 || n == 7) {
            return true;
        }
        if(n < 10) {
            return false;
        }

        for(int i = 0; i < 1000 ;i++) {

            long num = 0;
            long num2 = n;
            while (num2 > 0) {
                num += (num2%10) *(num2%10);
                num2 = num2 / 10;
            }

            if(num == 1) {
                return true;
            }
            if( num == n) {
                return false;
            }
            n = num;
        }

        return false;
    }

    public static void welcomeMessage() {

        //supported request
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameters show how many consecutive numbers are to be printed;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.\n");

    }

    public static boolean checkIsNumberic(String s) {

        for(int i = 0 ; i < s.length() ;i++) {
            if(!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSpy(long n) {

        long sum = 0;
        long product = 1;

        while (n > 0) {
            sum += n % 10;
            product *= n % 10;
            n = n / 10;
        }

        return sum == product;
    }

    public static boolean checkJumping(long n) {

        long num = n % 10;
        n = n / 10;

        while ( n > 0) {
            if(Math.abs(num - (n % 10) ) != 1) {
                return false;
            }
            num = n % 10;
            n = n / 10;
        }
        return true;
    }

    public static boolean checkAvailableProperties ( String...  strings) {

        String[] properties = {"EVEN" , "ODD" , "BUZZ" , "DUCK" , "PALINDROMIC" , "GAPFUL" , "SPY" ,
                "SQUARE" , "SUNNY" , "JUMPING" , "HAPPY" , "SAD" ,"-EVEN" , "-ODD" , "-BUZZ" , "-DUCK" , "-PALINDROMIC" , "-GAPFUL" , "-SPY" ,
                "-SQUARE" , "-SUNNY" , "-JUMPING" , "-HAPPY" , "-SAD" ,};


        for(int i = 0 ; i < strings.length ;i++) {
            strings[i] = strings[i].toUpperCase();
        }

        ArrayList<String> arr = new ArrayList<>();


        for(int i = 0 ; i < strings.length ;i++) {
            int flag = 0;
            for(int j = 0 ; j < properties.length ;j++) {
                if(strings[i].equals(properties[j]))
                {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                arr.add(strings[i]);
            }
        }

        if(arr.size() == 0) {
            return true;
        }

        if(arr.size() == 1) {
            System.out.println("The property " + arr + " is wrong.");
        }
        else {
            System.out.println("The properties " + arr + " are wrong.");
        }

        System.out.print("Available properties: ");
        System.out.println(Arrays.toString(properties));
        System.out.println();

        return false;

    }

    public static long[] findTheNumbers(long n , long m , String str) {

        str = str.toUpperCase();
//        System.out.println(str);
        long[] arr = new long[(int)m];
        long count = 0 ;
        if(str.equals("BUZZ") ) {

            while ( count < m) {
                if(buzzNumber(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("-BUZZ") ) {

            while ( count < m) {
                if(!buzzNumber(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }

        if(str.equals("DUCK") ) {

            while ( count < m) {
                if(isDuckNumber(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("-DUCK") ) {

            while ( count < m) {
                if(!isDuckNumber(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("PALINDROMIC") ) {

            while ( count < m) {
                if(checkPalindraome(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("-PALINDROMIC") ) {

            while ( count < m) {
                if(!checkPalindraome(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("GAPFUL") ) {

            while ( count < m) {
                if(isGapful(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("-GAPFUL") ) {

            while ( count < m) {
                if(!isGapful(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("SPY") ) {

            while ( count < m) {
                if(checkSpy(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("-SPY") ) {

            while ( count < m) {
                if(!checkSpy(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("EVEN") ) {

            while ( count < m) {
                if(checkEven(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("-EVEN") ) {

            while ( count < m) {
                if(!checkEven(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("ODD") ) {

            while ( count < m) {
                if(!checkEven(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("-ODD") ) {

            while ( count < m) {
                if(checkEven(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("SQUARE") ) {

            while ( count < m) {
                if(checkSquare(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("-SQUARE") ) {

            while ( count < m) {
                if(!checkSquare(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("SUNNY") ) {

            while ( count < m) {
                if(checksunny(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("-SUNNY") ) {

            while ( count < m) {
                if(!checksunny(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("JUMPING")) {
            while ( count < m) {
                if(checkJumping(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("-JUMPING")) {
            while ( count < m) {
                if(!checkJumping(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("HAPPY")) {
            while ( count < m) {
                if(happyNumber(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("-HAPPY")) {
            while ( count < m) {
                if(!happyNumber(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("SAD")) {
            while ( count < m) {
                if(!happyNumber(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }
        if(str.equals("-SAD")) {
            while ( count < m) {
                if(happyNumber(n)) {
                    arr[(int)count] = n;
                    count++;
                }
                n++;
            }
        }



        return arr;

    }

    public static void checkAllProperties (long input) {
        System.out.println("Properties of " + input);
        System.out.println("        buzz: " + buzzNumber(input));
        System.out.println("        duck: "+ isDuckNumber(input));
        System.out.println(" palindromic: " + checkPalindraome(input));
        System.out.println("      gapful: " + isGapful(input));
        System.out.println("         spy: " + checkSpy(input));
        System.out.println("      square: " + checkSquare(input));
        System.out.println("       sunny: " + checksunny(input));
        System.out.println("     jumping: " + checkJumping(input));
        System.out.println("       happy: " + happyNumber(input));
        System.out.println("         sad: " + !happyNumber(input));
        System.out.println("        even: " + checkEven(input));
        System.out.println("         odd: " + !checkEven(input));
        System.out.println();
    }

    public static void checkNumberic(String input1 , String input2) {

        if(!checkIsNumberic(input1)) {
            System.out.println("The first parameter should be a natural number or zero.\n");
        }
        else if(!checkIsNumberic(input2)) {
            System.out.println("the second parameter should be a natural number.\n");
        }

    }

    public static void checkAllPropertiesOneByOne(long index) {
        System.out.print(index + " is ");
        if(buzzNumber(index)) {
            System.out.print("buzz, ");
        }
        if(isDuckNumber(index)) {
            System.out.print("duck, ");
        }
        if(checkPalindraome(index)) {
            System.out.print("palindromic, ");
        }
        if(isGapful(index)) {
            System.out.print("gapful, ");
        }
        if(checkSpy(index)) {
            System.out.print("spy, ");
        }
        if(checkSquare(index)) {
            System.out.print("square, ");
        }
        if(checksunny(index)) {
            System.out.print("sunny, ");
        }
        if(checkJumping(index)) {
            System.out.print("jumping, ");
        }
        if(happyNumber(index)) {
            System.out.print("happy, ");
        }
        if(!happyNumber(index)) {
            System.out.print("sad, ");
        }
        if(checkEven(index)) {
            System.out.println("even");
        }
        else {
            System.out.println("odd");
        }
    }

    public static boolean checkMutualyexclusive(String[] strings ) {

        HashSet<String> hash = new HashSet<>();
        hash.addAll(Arrays.asList(strings));
//        System.out.println(Arrays.toString(strings));


        if(hash.contains("EVEN") && hash.contains("ODD")  || hash.contains("ODD") && hash.contains("-ODD")  ||
                hash.contains("EVEN") && hash.contains("-EVEN")  || hash.contains("-EVEN") && hash.contains("-ODD") ) {
            System.out.println("The request contains mutually exclusive properties:[EVEN , ODD]");
            System.out.println("There are no numbers with these properties.\n");
            return true;
        }
        if(hash.contains("DUCK") && hash.contains("SPY")  || hash.contains("SPY") && hash.contains("-SPY")  ||
                hash.contains("DUCK") && hash.contains("-DUCK")  || hash.contains("-DUCK") && hash.contains("-SPY") ) {
            System.out.println("The request contains mutually exclusive properties:[EVEN , ODD]");
            System.out.println("There are no numbers with these properties.\n");
            return true;
        }
        if(hash.contains("SUNNY") && hash.contains("SQUARE")  || hash.contains("SQUARE") && hash.contains("-SQUARE")  ||
                hash.contains("SUNNY") && hash.contains("-SUNNY")  || hash.contains("-SUNNY") && hash.contains("-SQUARE") ) {
            System.out.println("The request contains mutually exclusive properties:[EVEN , ODD]");
            System.out.println("There are no numbers with these properties.\n");
            return true;
        }


        return false;

    }

    public static boolean checkSquare(long n) {

        long num = (long)Math.sqrt(n);

        if(n == num*num) {
            return true;
        }
        return false;

    }

    public static boolean checksunny(long n) {

        return checkSquare(n+1);
    }

    public static boolean checkPropertyByString(Long num , String str) {

        str = str.toUpperCase();

        if(str.equals("EVEN")) {
            return checkEven(num);
        }
        else if(str.equals("-EVEN")) {
            return !checkEven(num);
        }
        else if(str.equals("ODD")) {
            return !checkEven(num);
        }
        else if(str.equals("-ODD")) {
            return checkEven(num);
        }
        else if(str.equals("SQUARE")) {
            return checkSquare(num);
        }
        else if(str.equals("-SQUARE")) {
            return !checkSquare(num);
        }
        else if(str.equals("SUNNY")) {
            return checksunny(num);
        }
        else if(str.equals("-SUNNY")) {
            return !checksunny(num);
        }
        else if(str.equals("PALINDROMIC")) {
            return checkPalindraome(num);
        }
        else if(str.equals("-PALINDROMIC")) {
            return !checkPalindraome(num);
        }
        else if(str.equals("BUZZ")) {
            return buzzNumber(num);
        }
        else if(str.equals("-BUZZ")) {
            return !buzzNumber(num);
        }
        else if(str.equals("DUCK")) {
            return isDuckNumber(num);
        }
        else if(str.equals("-DUCK")) {
            return !isDuckNumber(num);
        }
        else if(str.equals("SPY")){
            return checkSpy(num);
        }
        else if(str.equals("-SPY")){
            return !checkSpy(num);
        }
        else if(str.equals("JUMPING")) {
            return checkJumping(num);
        }
        else if(str.equals("-JUMPING")) {
            return !checkJumping(num);
        }
        else if(str.equals("HAPPY")) {
            return happyNumber(num);
        }
        else if(str.equals("-HAPPY")) {
            return !happyNumber(num);
        }
        else if(str.equals("SAD")) {
            return !happyNumber(num);
        }
        else if(str.equals("-SAD")) {
            return !happyNumber(num);
        }
        else if(str.equals("GAPFUL")) {
            return isGapful(num);
        }
        else {
            return !isGapful(num);
        }
    }

}
// 1 15 odd spy -duck spy buzz