import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class silv3_1431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //기타의 개수
        String[] arr = new String[N]; //시리얼 번호 담을 배열
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next(); //배열에 시리얼 번호 저장
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() == b.length()) { //서로 길이가 같다면
                    int asum = 0; //자리수 합을 구하기 위한 변수
                    int bsum = 0;
                    for (int i = 0; i < a.length(); i++) {
                        if (a.charAt(i) <= '9' && a.charAt(i) >= '0') {
                            //a가 숫자일 때 asum 변수에 더해줌
                            asum += Integer.parseInt(String.valueOf(a.charAt(i)));
                        }
                    }
                    for (int i = 0; i < b.length(); i++) {
                        if (b.charAt(i) <= '9' && b.charAt(i) >= '0') {
                            //b가 숫자일 때 bsum 변수에 더해줌
                            bsum += Integer.parseInt(String.valueOf(b.charAt(i)));
                        }
                    }
                    if (asum == bsum) { //3번 조건 (사전순으로 비교)
                        return a.compareTo(b);
                    } else {
                        return asum - bsum; //2번 조건 (작은 합이 먼저)
                    }
                } else { //1번 조건 (짧은 것이 먼저)
                    return a.length() - b.length();
                }
            }
        });
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]); //정렬한 시리얼 번호 출력
        }
    }
}
