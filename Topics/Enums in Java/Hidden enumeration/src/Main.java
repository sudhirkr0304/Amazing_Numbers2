public class Main {

    public static void main(String[] args) {
    // write your program here

        int count = 0;

        for(Secret sec : Secret.values()) {
            if(sec.toString().startsWith("STAR")) {
                count++;
            }
        }

        System.out.println(count);
    }
}


//   enum Secret {
//    STAR, CRASH, START,
//}
