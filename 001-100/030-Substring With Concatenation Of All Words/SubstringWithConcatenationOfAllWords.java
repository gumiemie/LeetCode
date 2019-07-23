import org.junit.Test;

import java.util.*;

/**
 * @author guyang <guyang@ebnew.com>
 * @description 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * @date 2019-06-09 12:55
 */
public class SubstringWithConcatenationOfAllWords {

    /**
     * 解题思路是依次循环法
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        LinkedList<String> wordList = null;
        List<String> strings = Arrays.asList(words);
        if (words.length > 0) {
            int wordLength = words[0].length();
            int length = s.length();
            if (length < wordLength * words.length) {
                return result;
            } else {
                int sIndex = 0;
                one:
                while (sIndex <= length - wordLength) {
                    wordList = new LinkedList<String>();
                    wordList.addAll(strings);

                    int tempIndex = sIndex;
                    while (wordList.size() > 0 && tempIndex <= length - wordLength) {
                        String subString = s.substring(tempIndex, tempIndex + wordLength);
                        if (wordList.contains(subString)) {
                            wordList.remove(subString);
                            tempIndex += wordLength;
                        } else {
                            sIndex++;
                            continue one;
                        }
                    }

                    if (wordList.size() == 0) {
                        result.add(sIndex);
                    }

                    sIndex++;
                }
            }
        }
        return result;
    }

    @Test
    public void execute() {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        List<Integer> result = findSubstring2(s, words);
        System.out.println(result);
    }

    /**
     * 网上的解答，还没有看。
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> result = new ArrayList();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        Map<String, Integer> wordsCount = generateCount(words);
        int length = words[0].length();

        for (int i = 0; i < length; ++i) {
            Map<String, Integer> window = new HashMap();
            int left = i;
            int right = i;
            while (right <= s.length() - length && left <= s.length() - length * words.length) {
                String sub = s.substring(right, right + length);
                incr(window, sub);
                if (!wordsCount.containsKey(sub)) {
                    window.clear();
                    right += length;
                    left = right;
                    continue;
                }
                while (window.get(sub) > wordsCount.get(sub)) {
                    decr(window, s.substring(left, left + length));
                    left += length;
                }
                right += length;
                if (right - left == length * words.length) {
                    result.add(left);
                }
            }
        }
        return result;
    }

    private Map<String, Integer> generateCount(String[] words) {
        Map<String, Integer> wordsCount = new HashMap();
        for (String word : words) {
            incr(wordsCount, word);
        }
        return wordsCount;
    }

    private void incr(Map<String, Integer> map, String key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    private void decr(Map<String, Integer> map, String key) {
        if (map.containsKey(key)) {
            Integer value = map.get(key);
            if (value <= 1) {
                map.remove(key);
            } else {
                map.put(key, value - 1);
            }
        }
    }



    public List<Integer> findSubstring2(String s, String[] words) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        if (words.length == 0 || s.length() == 0) {
            return result;
        }

        int sLength = s.length();
        int arrayLength = words.length;
        int wordLength = words[0].length();

        if (sLength < wordLength * arrayLength) {
            return result;
        }

        HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();
        for (String s1 : words) {
            if (wordsMap.get(s1) != null) {
                wordsMap.put(s1, wordsMap.get(s1) + 1);
            } else {
                wordsMap.put(s1, 1);
            }
        }

        int sIndex = 0;
        Map<String, Integer> tempMap = null;
        one:
        while (sIndex <= sLength - wordLength) {
            tempMap = new HashMap();
            tempMap.putAll(wordsMap);
            int tempIndex = sIndex;
            while (!tempMap.isEmpty() && tempIndex <= sLength - wordLength) {
                String subString = s.substring(tempIndex, tempIndex + wordLength);
                if (tempMap.keySet().contains(subString)) {
                    Integer integer = tempMap.get(subString);
                    if (integer == 1) {
                        tempMap.remove(subString);
                    } else {
                        tempMap.put(subString, integer - 1);
                    }
                    tempIndex += wordLength;
                } else {
                    sIndex++;
                    continue one;
                }
            }

            if (tempMap.isEmpty()) {
                result.add(sIndex);
            }

            sIndex++;
        }
        return result;
    }


}
