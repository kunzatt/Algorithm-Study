import java.util.*;

public class Main_25325 {

    private static class Student {
        String name;
        int popularity;

        public Student(String name, int popularity) {
            this.name = name;
            this.popularity = popularity;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] studentNames = scanner.nextLine().split(" ");

        Map<String, List<String>> likesMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] likedStudents = scanner.nextLine().split(" ");
            for (String likedStudent : likedStudents) {
                if (!likesMap.containsKey(likedStudent)) {
                    likesMap.put(likedStudent, new ArrayList<>());
                }
                likesMap.get(likedStudent).add(studentNames[i]);
            }
        }

        List<Student> result = new ArrayList<>();

        for (String student : studentNames) {
            int popularity = likesMap.containsKey(student) ? likesMap.get(student).size() : 0;
            result.add(new Student(student, popularity));
        }

        Collections.sort(result, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.popularity != s2.popularity) {
                    return s2.popularity - s1.popularity;
                }
                return s1.name.compareTo(s2.name);
            }
        });

        for (Student student : result) {
            System.out.println(student.name + " " + student.popularity);
        }
    }


}