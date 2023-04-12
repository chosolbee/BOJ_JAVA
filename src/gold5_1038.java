import java.io.*;
import java.util.*;

public class gold5_1038 {
    public static int N;
    public static List<Long> list;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //N번째 감소하는 수

        if (N > 1022) { //최대 감소하는 수 : 9876543210 (1022번째)
            System.out.println(-1);
            System.exit(0);
        }

        list = new ArrayList<Long>();
        for (int i = 0; i < 10; ++i) {
            calc(i, 1);
        }
        Collections.sort(list);
        System.out.println(list.get(N));
    }

    public static void calc(long num, int len) {
        if (len > 10) { //9876543210가 마지막이므로 10자리
            return;
        }

        list.add(num);

         /*
        num==0 -> pass
        num==1 -> 10 (i가 0일 때만)
        num==2 -> 21, 20, 210 (i가 0, 1일 때만)
        num==3 -> 32, 31, 30, 321, 320
        ...
        num==9 -> 90, 91, ...
         */

        for (int i = 0; i < 10; ++i) {
            if (num % 10 > i) {
                calc((num * 10) + i, len + 1);
            }
        }
    }
}