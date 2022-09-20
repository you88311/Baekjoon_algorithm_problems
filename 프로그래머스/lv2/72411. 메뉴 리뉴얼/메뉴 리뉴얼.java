import java.util.*;

public class Solution {
    List<String> answer = new ArrayList<>();
    Map<String, Integer> hashMap = new HashMap<>();
    int max = 0;

    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }


        for (int courseLen : course) {
            max = 0;
            for (String order : orders) {
                if (order.length() < courseLen) continue;

                combination("", order, 0, courseLen);
            }
            Iterator<String> keys = hashMap.keySet().iterator();

            while (keys.hasNext() && max >= 2) {
                String key = keys.next();
                if (hashMap.get(key) == max) {
                    answer.add(key);
                }
            }
            hashMap.clear();
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private void combination(String comb, String remainOrder, int cur, int end) {
        if (cur == end) {
            int len;
            hashMap.put(comb, hashMap.getOrDefault(comb, 0) + 1);
            if (max <= hashMap.get(comb)) {
                max = hashMap.get(comb);
//                System.out.println(max);
            }
        }

        for (int i = 0; i < remainOrder.length(); i++) {
            combination(comb + remainOrder.charAt(i),
                    remainOrder.substring(i + 1), cur + 1, end);
        }
    }
}
