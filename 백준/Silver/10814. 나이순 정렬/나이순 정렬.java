import java.util.*;
import java.io.*;

public class Main {
    static class Person {
        int id;
        String name;
        int age;

        Person(int id, int age, String name) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return age + " " + name;
        }

        public int getAge() {
            return age;
        }

        public int getId() {
            return id;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Person(i, age, name));
        }

        list.sort(Comparator.comparing(Person::getAge)
                .thenComparing(Person::getId));

        for(int i = 0; i < N; i++) {
            System.out.println(list.get(i).toString());
        }
    }
}