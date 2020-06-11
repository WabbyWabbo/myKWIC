package StringTokenizer;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String str = "google,taobao,facebook,zhihu";

        StringTokenizer st = new StringTokenizer(str, ",");

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        System.out.println("=================");

        StringTokenizer st2 = new StringTokenizer("JAVA : Code : String", " :", true);
        while (st2.hasMoreTokens()) {
            System.out.println(st2.nextToken() + "[end]");
        }

    }
}
