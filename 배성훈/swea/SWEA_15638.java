package swea;

import java.util.*;

public class SWEA_15638 {
    class Monarch {
        int y;
        int x;
        int sol;

        Monarch(int y, int x, int sol) {
            this.y = y;
            this.x = x;
            this.sol = sol;
        }
    }

    private final int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    private final int[] dx = {0, 0, -1, 1, 1, -1, -1, 1};
    static final int SIZE = 625;
    int n;
    int[] parent = new int[10000]; // 최대 8000회 attack + 625
    List<Integer>[] unions = new ArrayList[SIZE];
    List<Integer>[] enemies = new ArrayList[SIZE];

    public int find(int x) {
        if (x != parent[x]) {
            return parent[x] = find(parent[x]);
        }
        return x;
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
            unions[a].addAll(unions[b]);
            enemies[a].addAll(enemies[b]);
            unions[b].clear();
            enemies[b].clear();
        }
    }

    public boolean isAlly(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }

    public boolean isEnemy(int a, int b) {
        a = find(a);
        b = find(b);
        for (int enemy : enemies[a]) {
            if (find(enemy) == b) {
                return true;
            }
        }
        return false;
    }

    public void makeEnemy(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        if (isEnemy(a, b)) {
            return;
        }
        enemies[a].add(b);
        enemies[b].add(a);
    }

    Map<String, Integer> monMap = new HashMap<>();
    Monarch[] mons = new Monarch[8625];
    int[][] monIdx = new int[26][26];
    int monCnt;

    public void init(int N, int[][] mSoldier, char[][][] mMonarch) {
        n = N;
        monCnt = n * n;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String monarch = new String(mMonarch[i][j]).trim();
                monMap.put(monarch, idx);
                monIdx[i][j] = idx;
                mons[idx] = new Monarch(i, j, mSoldier[i][j]);
                parent[idx] = idx;
                unions[idx] = new ArrayList<>();
                enemies[idx] = new ArrayList<>();
                unions[idx].add(idx);
                idx++;
            }
        }
    }

    public void destroy() {
        parent = new int[10000];
        unions = new ArrayList[SIZE];
        enemies = new ArrayList[SIZE];
        monMap.clear();
        mons = new Monarch[8625];
        monIdx = new int[26][26];
    }

    public int ally(char[] mMonarchA, char[] mMonarchB) {
        int a = monMap.get(new String(mMonarchA).trim());
        int b = monMap.get(new String(mMonarchB).trim());
        if (isAlly(a, b)) {
            return -1;
        }
        if (isEnemy(a, b)) {
            return -2;
        }
        union(a, b);
        return 1;
    }

    public int attack(char[] mMonarchA, char[] mMonarchB, char[] mGeneral) {
        int a = monMap.get(new String(mMonarchA).trim());
        int b = monMap.get(new String(mMonarchB).trim());
        String general = new String(mGeneral).trim();
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) {
            return -1;
        }
        boolean found = false;
        for (int i = 0; i < 8; i++) {
            int y = mons[b].y + dy[i];
            int x = mons[b].x + dx[i];
            if (y >= 0 && x >= 0 && y < n && x < n && aRoot == find(monIdx[y][x])) {
                found = true;
                break;
            }
        }
        if (!found) return -2;
        makeEnemy(aRoot, bRoot);
        int offense = 0;
        int defense = mons[b].sol;
        for (int i = 0; i < 8; i++) {
            int y = mons[b].y + dy[i];
            int x = mons[b].x + dx[i];
            if (y >= 0 && x >= 0 && y < n && x < n) {
                int monarch = monIdx[y][x];
                int root = find(monarch);
                if (root == aRoot) {
                    int support = mons[monarch].sol / 2;
                    mons[monarch].sol -= support;
                    offense += support;
                } else if (root == bRoot) {
                    int support = mons[monarch].sol / 2;
                    mons[monarch].sol -= support;
                    defense += support;
                }
            }
        }
        int result = offense - defense;
        if (result <= 0) {
            mons[b].sol = -result;
            return 0;
        }
        unions[bRoot].remove(Integer.valueOf(b));

        mons[b].sol = result;
        mons[monCnt] = mons[b];

        monIdx[mons[monCnt].y][mons[monCnt].x] = monCnt;
        monMap.put(general, monCnt);

        parent[monCnt] = aRoot;
        unions[aRoot].add(monCnt);

        monCnt++;
        return 1;
    }

    public int recruit(char[] mMonarch, int mNum, int mOption) {
        int monarch = monMap.get(new String(mMonarch).trim());
        int total = 0;

        if (mOption == 0) {
            mons[monarch].sol += mNum;
            total = mons[monarch].sol;
        } else if (mOption == 1) {
            int root = find(monarch);
            for (int u : unions[root]) {
                mons[u].sol += mNum;
                total += mons[u].sol;
            }
        }

        return total;
    }
}
