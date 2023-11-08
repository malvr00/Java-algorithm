import java.util.*;

public class Main {
    /*
        10. 가장 짧은 문자거리
     */
    public static List<Integer> solution(String str1, String str2) {
        List<Integer> result = new ArrayList<>();

        List<Integer> index = new ArrayList<>();

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                index.add(i);
            }
        }

        int indexKey = 0;
        int targetIndex = index.get(indexKey);

        for (int i = 0; i < str1.length(); i++) {
            if (i <= targetIndex) {
                result.add(targetIndex - i);
            } else {
                if (index.size() > indexKey + 1) {
                    int preIndex = targetIndex;
                    int postIndex = index.get(indexKey + 1);

                    int val1 = i - preIndex;
                    int val2 = 0;

                    if (i <= postIndex) {
                        val2 = postIndex - i;
                    } else {
                        val2 = i - postIndex;
                    }
                    if (val1 < val2) {
                        targetIndex = preIndex;
                        result.add(val1);
                    } else {
                        targetIndex = postIndex;
                        result.add(val2);
                        indexKey++;
                    }
                } else {
                    result.add(i - targetIndex);
                }
            }

        }

        return result;
    }

    public static int[] solution2(String str, char t) {
        int[] result = new int[str.length()];
        int p = 1000;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == t) {
                p = 0;
            } else {
                p++;
            }
            result[i] = p;
        }

        p = 1000;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == t) {
                p = 0;
            } else {
                p++;
                result[i] = Math.min(result[i], p);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String strValue1 = kb.next();
        String strValue2 = kb.next();

        List<Integer> result = solution(strValue1, strValue2);

        String trim = " ";
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + trim);
        }
    }
}