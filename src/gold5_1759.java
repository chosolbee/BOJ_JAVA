import java.io.*;
import java.util.*;

public class gold5_1759 {
    public static int L, C;
    public static char[] code;
    public static char[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list = new char[C];
        code = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int x = 0; x < C; x++) {
            list[x] = st.nextToken().charAt(0);
        }

        // 정렬
        Arrays.sort(list);

        combination(0, 0);

    }

    public static void combination(int start, int cnt) {
        System.out.println(start+" "+cnt);
        if (cnt == L) { //최소 한개의 모음, 2개의 자음이 있는지 확인
            if (check()) {
                System.out.println(code);
            }
            return;
        }
        //아직 길이 L의 코드를 만들지 않았고 글자도 아직 남은 경우
        for (int i = start; i < C; i++) {
            code[cnt] = list[i];
            combination(i + 1, cnt + 1);
        }
    }

    public static boolean check() {
        int vowel = 0; //모음
        int consonant = 0; //자음
        for (char x : code) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }
        if (vowel >= 1 && consonant >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
