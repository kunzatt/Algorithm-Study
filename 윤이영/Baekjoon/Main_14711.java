import java.util.Scanner;

public class Main_14711 {
    static int N;
    static char[][] map;
    static int[][] check; 
    static int[] dr = { 0, 1, 0};
    static int[] dc= {  1, 0, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        check = new int[N][N];
        
        map[0] = sc.next().toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<N-1; i++) {
            // 몇번 뒤집히는지 세기
            for(int j=0; j<N; j++) {
                if(map[i][j]=='#') {
                    check[i][j]++;
                    // 뒤집오
                    for(int d=0; d<3; d++) {
                        int nr = i+dr[d];
                        int nc = j+dc[d];
                        if(!check(nr, nc)) continue;
                        //System.out.println(nr+" "+nc);
                        check[nr][nc]++;
                    }
                    //System.out.println(Arrays.toString(map[i]));
                }

            }
            

            for(int j=0; j<N; j++){
                // 만약 타일이 짝수번 뒤집힌 경우: 현재 타일과 동일한 값을 다음 행에 저장
                if(check[i][j] % 2 == 0){
                    map[i+1][j] = (map[i][j] == '#') ? '#' : '.' ;
                }
                else{
                    map[i+1][j] = (map[i][j] == '#') ? '.' : '#';
                }
            }

        }

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(map[r][c]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    } 

    private static boolean check(int r, int c) {
        // TODO Auto-generated method stub
        return r>=0 && r<N && c>=0 && c<N;
    }


}
