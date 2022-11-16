package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * 0 ~ 99 정수
 * 주어진 수가 10보다 작다면 앞에 0을 붙여 두자리 수로 만들어 각 자리싀 숫자를 더함
 * 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다
 * ex : 26 -> 2 + 6 = 8 , 새로운 수는 68. 6 + 8 = 14. 새로운수는 84. 8 + 4 = 12. 새로운 수는 42. 4 + 2 = 6. 새로운 수는 26
 * 4번만에 원래 수로 돌아옴. 따라서 26의 사이클의 길이는 4
 *
 */
public class Backjun_1110 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        Backjun_1110 backjun_1110 = new Backjun_1110();
        backjun_1110.process1(num);
    }

    private int process1(int num){
        int count = 0;
        int result = num;
        while (true){
            result = result % 10 * 10 + (result / 10 + result % 10) % 10;
            count++;
            if(result == num) {
                System.out.println(count);
                break;
            }
        }
        return count;
    }



}
