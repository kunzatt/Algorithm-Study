package class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_10814_나이순정렬 {
	
	static int N;
	static List<person> people;
	static class person{
		int age;
		String name;
		int order;
		public person(int age, String name, int order) {
			super();
			this.age = age;
			this.name = name;
			this.order = order;
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		List<person> people = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			people.add(new person(age, name, i));
		}
		
		Collections.sort(people, (p1, p2) -> {
			if(p1.age == p2.age) {
				return p1.order - p2.order;
			}
			return p1.age - p2.age;
		});
		
		StringBuilder sb = new StringBuilder();
		for(person p: people) {
			sb.append(p.age).append(" ").append(p.name).append("\n");
		}
		System.out.println(sb);
	}

}
