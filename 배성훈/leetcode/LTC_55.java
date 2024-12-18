package leetcode;

// 55. Jump Game / Medium / 5:14 ~ 5:34
// 끝에 도달할 수 있는지 없는지를 확인하는 문제
// arr[i] 의 값은 최대로 그 값만큼 이동할 수 있다는 뜻
// 배열을 순회하면서 최대로 도달할 수 있는 곳을 기록하고, 만약 현재 인덱스가 최대로 도달할 수 있는 곳보다 크다면 이는 끝에 도달할 수 없다는 것을 의미하므로 false 를 return 한다.
public class LTC_55 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(i + nums[i], reachable);
            if (reachable >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
