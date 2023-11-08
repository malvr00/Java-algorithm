import java.util.*;


class Coordinate {
    Integer x;
    Integer y;
}

class Point implements Comparable<Point> {
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) {
            return this.y - o.y;
        }
        else{
            return this.x - o.x;
        }
    }
}

public class Main {
    /*
        7. 좌표 정렬
     */

    public static List<Coordinate> solution(int n, List<Coordinate> arr) {
//        arr.sort(Comparator.comparing(s -> s.x ));
        arr.sort((s1, s2) -> {
            // 중간에 y 값 틀어져서 실패.
            int i;

            if (s1.x == s2.x) {
                i = s1.y - s2.y;
            } else {
                i = s1.x - s2.x;
            }

            return i;
        });

        return arr;
    }

    public static List<Point> solution2(int size, List<Point> arr) {
        Collections.sort(arr);

        return arr;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
//        List<Coordinate> arr = new ArrayList<>();
        List<Point> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            Point cd = new Point(x, y);

            arr.add(cd);
        }

        List<Point> answer = solution2(n, arr);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i).x + " " + answer.get(i).y);
        }
//        System.out.println();
    }
}