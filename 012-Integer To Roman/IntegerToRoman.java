import org.junit.Test;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description
 * @date 2018/12/4 15:24$
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String[] romans = new String[]{"I", "V", "X", "L", "C", "D", "M"};
        int x = new StringBuilder().append(num).length() - 1;
        StringBuilder result = new StringBuilder();
        while (x >= 0) {
            int i = 2 * x;
            int pow = (int) Math.pow(10, x);
            int temp = num / pow;
            if (temp == 9) {
                result.append(romans[i]);
                result.append(romans[i + 2]);
            } else if (temp >= 5) {
                result.append(romans[i + 1]);
                for (int y = 0; y < temp - 5; y++) {
                    result.append(romans[i]);
                }
            } else if (temp == 4) {
                result.append(romans[i]);
                result.append(romans[i + 1]);
            } else {
                for (int y = 0; y < temp; y++) {
                    result.append(romans[i]);
                }
            }
            num = num % pow;
            x--;
        }
        return result.toString();
    }

    private StringBuilder processIndex(int number, int x) {
        StringBuilder sb = new StringBuilder();
        switch (x) {
            case 3:
                for (int i = 0; i < number; i++) {
                    sb.append("M");
                }
                break;
            case 2:
                if (number == 9) {
                    sb.append("CM");
                    break;
                }
                if (number >= 5) {
                    sb.append("D");
                    for (int i = 0; i < number - 5; i++) {
                        sb.append("C");
                    }
                    break;
                }
                if (number == 4) {
                    sb.append("CD");
                    break;
                } else {
                    for (int i = 0; i < number; i++) {
                        sb.append("C");
                    }
                    break;
                }
            case 1:
                if (number == 9) {
                    sb.append("XC");
                    break;
                }
                if (number >= 5) {
                    sb.append("L");
                    for (int i = 0; i < number - 5; i++) {
                        sb.append("X");
                    }
                    break;
                }
                if (number == 4) {
                    sb.append("XL");
                    break;
                } else {
                    for (int i = 0; i < number; i++) {
                        sb.append("X");
                    }
                    break;
                }
            case 0:
                if (number == 9) {
                    sb.append("IX");
                    break;
                }
                if (number >= 5) {
                    sb.append("V");
                    for (int i = 0; i < number - 5; i++) {
                        sb.append("I");
                    }
                    break;
                }
                if (number == 4) {
                    sb.append("IV");
                    break;
                } else {
                    for (int i = 0; i < number; i++) {
                        sb.append("I");
                    }
                    break;
                }
        }

        return sb;
    }

    @Test
    public void execute() {
        System.out.println(intToRoman(4));
    }
}
