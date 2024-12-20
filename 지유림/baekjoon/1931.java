import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static class Time implements Comparable<Time> {
        int start;
        int end;

        @Override
        public int compareTo(Time o) {
            if(this.end < o.end) return -1;  // 종료시간 기준으로 정렬
            else if(this.end > o.end) return 1;
            else {  // 종료시간이 같으면 시작시간 기준으로 정렬
                if(this.start < o.start) return -1;
                else if(this.start > o.start) return 1;
                else return 0;
            }
        }

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<Time> time = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            time.add(new Time(start, end));
        }

        Collections.sort(time);
        
        int count = 1;  // 첫 번째 회의는 무조건 선택
        int endTime = time.get(0).end;  // 현재 선택된 회의의 종료 시간
        
        for(int i = 1; i < N; i++) {
            if(time.get(i).start >= endTime) {  // 현재 회의의 시작시간이 이전 회의 종료시간보다 크거나 같으면
                count++;  // 회의 선택
                endTime = time.get(i).end;  // 종료시간 갱신
            }
        }

        System.out.println(count);
    }
}
