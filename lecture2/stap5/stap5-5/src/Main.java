import java.util.*;

class Info implements Comparable<Info>{
    public int idx;
    public Character team;
    public int power;
    Info(int idx, Character team, int power){
        this.idx = idx;
        this.team = team;
        this.power = power;
    }
    @Override
    public int compareTo(Info ob){
        return this.power - ob.power;
    }
}
public class Main {
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];

        List<int []> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < students.length; i++) {
            String[] s = students[i].split(" ");

            list.add(new int[]{i, s[0].charAt(0), Integer.parseInt(s[1])});
        }
        list.sort(Comparator.comparingInt(a -> a[2]));

        int j = 0;
        int maxVal = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] post = list.get(i);
            while (j < i) {
                int[] pre = list.get(j);
                if(post[2] == pre[2]) break;
                maxVal += pre[2];
                map.put((char) pre[1], map.getOrDefault((char) pre[1], 0) + pre[2]);
                j++;
            }
            Integer matchVal = map.get((char) post[1]);
            answer[post[0]] = matchVal == null ? maxVal : maxVal - matchVal;
        }

        return answer;
    }

    public int[] solution(String[] students, int version){
        int n = students.length;
        int[] answer = new int[n];
        ArrayList<Info> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Character a = students[i].split(" ")[0].charAt(0);
            int b = Integer.parseInt(students[i].split(" ")[1]);
            list.add(new Info(i, a, b));
        }
        Collections.sort(list);
        HashMap<Character, Integer> Tp = new HashMap<>();
        int j = 0, total = 0;
        for(int i = 1; i < n; i++){
            for( ; j < n; j++){
                if(list.get(j).power < list.get(i).power){
                    total += list.get(j).power;
                    char x = list.get(j).team;
                    Tp.put(x, Tp.getOrDefault(x, 0) + list.get(j).power);
                }
                else break;
            }
            answer[list.get(i).idx] = total - Tp.getOrDefault(list.get(i).team, 0);
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}