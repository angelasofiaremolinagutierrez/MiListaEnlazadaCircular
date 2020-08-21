import co.edu.upb.list.CircularList;

public class Main {

    public static void main(String[] args) {
        CircularList l = new CircularList();
        for (int i = 1; i <= 5; i++) {
            l.add(i);
        }

        System.out.println(l.toString());

        System.out.println(l.search(5).toString());
    }
}
