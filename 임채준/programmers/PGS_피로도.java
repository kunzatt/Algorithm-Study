public class PGS_피로도 {

    static boolean[] visited;
    static int max = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        cal(k, dungeons, 0);
        return max;
    }

    private void cal(int total, int[][] dungeons, int count) {

        max = Math.max(max, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && total >= dungeons[i][0]) {
                visited[i] = true;
                cal(total - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }

}
