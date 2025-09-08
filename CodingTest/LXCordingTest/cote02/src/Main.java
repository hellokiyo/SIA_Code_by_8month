import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 6개 입력해주세요(※숫자 간격 쉼표 구분");
        int max = Arrays.stream(sc.nextLine().trim().split(", ")).mapToInt(Integer::parseInt).max().getAsInt();
        System.out.println("가장 큰 수는 : "+ max);
    }
}