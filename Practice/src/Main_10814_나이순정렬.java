import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10814_나이순정렬 {

    static class User implements Comparable<User>{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            return Integer.compare(this.age, o.age);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        User[] users = new User[N];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            users[n] = new User(age, name);
        }

        Arrays.sort(users);

        for (int n = 0; n < N; n++) {
            System.out.println(users[n].age + " " + users[n].name);
        }

    }
}
