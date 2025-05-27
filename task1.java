import java.util.ArrayList;
import java.util.List;

public class Main {
    static int nulls(String s, int i) {
        while (i < s.length() && s.charAt(i) == '0') {
            if (s.charAt(i + 1) == '1') return i + 1;
            else if (s.charAt(i + 1) != '0') return 0;
            i++;
        }
        return 0;
    }

    static List<String> findPattern(String s) {
        int last;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                switch (s.charAt(i+1)){
                    case '0':
                        last = nulls(s, i + 1);
                        if (last != 0) {
                            res.add(s.substring(i, last+1));
                            i = last;
                        }
                        break;
                    case '1':
                        last = nulls(s, i + 1);
                        if (last != 0) {
                            res.add(s.substring(i, last+1));
                            i = last;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "1101gdyY1101tf11flb10001";
        List<String> v = findPattern(str);
        if (v.isEmpty()) System.out.println("Not found");
        else for (String item : v) System.out.print(item + " ");
    }
}