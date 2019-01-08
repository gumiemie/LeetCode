import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）
 * @date 2018/12/12 14:03$
 */
public class LetterCombinationsOfAPhoneNumber {


    public List<String> letterCombinations(String digits) {
        HashMap<Character, String[]> maps = new HashMap<Character, String[]>();
        maps.put('2', new String[]{"a", "b", "c"});
        maps.put('3', new String[]{"d", "e", "f"});
        maps.put('4', new String[]{"g", "h", "i"});
        maps.put('5', new String[]{"j", "k", "l"});
        maps.put('6', new String[]{"m", "n", "o"});
        maps.put('7', new String[]{"p", "q", "r", "s"});
        maps.put('8', new String[]{"t", "u", "v"});
        maps.put('9', new String[]{"w", "x", "y", "z"});

        List<String> resultList = new LinkedList<String>();
        int i = 0;
        while (i < digits.length()) {
            ArrayList<String> tempList = new ArrayList<String>();
            if (resultList.size() != 0) {
                for (String s : resultList) {
                    for (String ts : maps.get(digits.charAt(i))) {
                        tempList.add(s + ts);
                    }
                }
            } else {
                for (String ts : maps.get(digits.charAt(i))) {
                    tempList.add(ts);
                }
            }
            resultList = tempList;
            i++;
        }

        return resultList;
    }


    @Test
    public void execute() {
        System.out.println(letterCombinations("2369"));
    }
}
