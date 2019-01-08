import org.junit.Test;

import java.util.HashMap;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 罗马数字转整数
 * @date 2018/12/5 14:47$
 */
public class RomanToInteger {


    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int i = 0;

        while (i < s.length()) {
            Integer integer1 = map.get(s.charAt(i));
            if (i + 1 < s.length()) {
                Integer integer2 = map.get(s.charAt(i + 1));
                if (integer2 == integer1 * 5 || integer2 == integer1 * 10) {
                    result -= integer1;
                    i++;
                    continue;
                }
            }
            result += integer1;
            i++;
        }
        return result;
    }

    @Test
    public void execute(){
        System.out.println(romanToInt("MCMXCIV"));
    }


}
