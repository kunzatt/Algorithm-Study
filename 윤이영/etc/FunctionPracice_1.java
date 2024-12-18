// 연속 부분수열

import java.util.Scanner;

public class FunctionPracice_1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        
        int A[] = inputArr(n1); // 수열 A 입력
        int B[] = inputArr(n2); // 수열 B 입력;

        // 연속 부분수열인지 판단 후 출력
        if(isContinous(A,B)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }

    // 수열을 입력 받는 함수
    public static int[] inputArr(int n){
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    // 연속 부분 수열인지 확인하는 메서드
    public static Boolean isContinous(int a[], int b[]){
        for(int i=0; i<=a.length - b.length; i++){
            if(a[i] == b[0]){
                for(int j=0; j<b.length; j++){
                    if(a[i+j] != b[j]) {
                        break;
                    }
                }
                if(a[i+b.length-1] == b[b.length-1])
                    return true;
            }
        }
        return false;
    }
}
