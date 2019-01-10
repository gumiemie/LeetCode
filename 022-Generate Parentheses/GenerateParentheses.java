import org.junit.Test;

import java.util.*;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * @date 2019/1/9 10:10$
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        ArrayList<StringBuilder> result = new ArrayList<StringBuilder>();
        StringBuilder newSb = new StringBuilder("(");
        result.add(newSb);
        HashMap<StringBuilder, String> map = new HashMap<StringBuilder, String>();
        map.put(newSb, "1-1");
        for (int i = 1; i < 2 * n; i++) {
            ArrayList<StringBuilder> result2 = new ArrayList<StringBuilder>();
            for (StringBuilder sb : result) {
                String[] split = map.get(sb).split("-");
                //多几个左括号
                Integer residue = Integer.valueOf(split[0]);
                //一共有几个左括号
                Integer sum = Integer.valueOf(split[1]);
                if (residue == 0) {
                    sb.append("(");
                    residue++;
                    sum++;
                } else {
                    if (sum < n) {
                        StringBuilder tempS1 = new StringBuilder(sb).append("(");
                        result2.add(tempS1);
                        map.put(tempS1, (residue + 1) + "-" + (sum + 1));
                    }
                    sb.append(")");
                    residue--;
                }
                map.put(sb, residue + "-" + sum);
            }
            if (result2.size() != 0) {
                result.addAll(result2);
            }
        }
        ArrayList<String> strings = new ArrayList<String>();
        for (StringBuilder sb : result) {
            strings.add(sb.toString());
        }
        return strings;
    }

    @Test
    public void execute() {
        ArrayList<String> strings = new ArrayList<String>();
        impl2(strings, "", 0, 0, 3);
        System.out.println(strings);
    }

    /**
     * 回溯递归
     * @param result
     * @param string
     * @param left
     * @param right
     * @param sum
     */
    private void impl2(List<String> result, String string, int left, int right, int sum) {
        if (sum == left && sum == right) {
            result.add(string);
            return;
        }
        if (right < left) {
            impl2(result, string + ")", left, right + 1, sum);
        }
        if (left < sum) {
            impl2(result, string + "(", left + 1, right, sum);
        }
    }
}
