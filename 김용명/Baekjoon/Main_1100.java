import java.io.*;

public class Main_1100 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[8][8];
		
		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i%2 == 0) {
					if (j%2 == 0 && map[i][j] == 'F') count++;
				}
				else if (i%2 == 1) {
					if (j%2 == 1 && map[i][j] == 'F') count++;
				}
			}
		}
		
		System.out.println(count);
		
	}

}
