package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_11651_좌표정렬하기2 {

	static int N;
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Point> points = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new Point(x,y));
		}
		
		Collections.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if(p1.y == p2.y) {
					return p1.x - p2.x;
				}
				return p1.y - p2.y;
			}
			
		});
		
		for(Point p : points) {
			sb.append(p.x).append(" ").append(p.y).append("\n");
		}
		
		System.out.println(sb);

	}

}
