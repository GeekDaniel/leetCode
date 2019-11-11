package com.dannystone;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2019/11/11 12:24 AM
 */
public class DiffTegether {

    public String reorganizeString(String S) {
        //看起来是个动态规划问题，即如果这个字符串不能重构，那么它的所有子串都不能重构
        //了解了一下评论里的贪婪算法，发布其实不是动态规划问题 而是贪婪算法。
        //共同点为：都具有最优子结构性质，当一个问题的最优解包含其子问题的最优解时，称此问题具有最优子结构性质。
        //区别为：贪心算法的每一次操作都对结果产生直接影响，而动态规划则不是。贪心算法对每个子问题的解决方案都做出选择，不能回退；动态规划则会根据以前的选择结果对当前进行选择，有回退功能。动态规划主要运用于二维或三维问题，而贪心一般是一维问题
        char[] chars = S.toCharArray();
        List<String> charStringList = new ArrayList<>();
        for (char aChar : chars) {
            charStringList.add(aChar + "");
        }

        Map<String, Long> countMap = charStringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int maxSameElementCount = (chars.length + 1) / 2;

        //Optional 会报"can't find symbol"
        for (Long aLong : countMap.values()) {
            if(aLong>maxSameElementCount){
                return "";
            }
        }

        //贪心找到当前最多但和当前元素不同的元素排进来
        StringBuilder sb = new StringBuilder();
        long sum = countMap.values().stream().mapToLong(i -> i).sum();

        String prev = "";
        while (sum != 0) {
            String finalPrev = prev;
            //不支持optional
            List<Map.Entry<String, Long>> collect = countMap.entrySet().stream()
                    .filter(e -> !e.getKey().equals(finalPrev))
                    .sorted((e1, e2) -> e1.getValue() - e2.getValue() > 0 ? -1 : 1)
                    .collect(Collectors.toList());

            Map.Entry<String, Long> first = collect.get(0);

                sb.append(first.getKey());
                Long value = first.getValue();
                countMap.put(first.getKey(), --value);
                prev = first.getKey();

            sum = countMap.values().stream().mapToLong(i -> i).sum();
        }

        return sb.toString();

    }
    public static void main(String[] args){
        DiffTegether diffTegether = new DiffTegether();
        System.out.println(diffTegether.reorganizeString("vvvlo"));

    }


}
