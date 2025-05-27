import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static List<String> findUnique(List<String> v) {
        Set<String> unique = new HashSet<>(v);
        return new ArrayList<>(unique);
    }

    static String formatEmail(String s) {
        StringBuilder result = new StringBuilder();
        boolean seenAt = false;
        boolean seenStar = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '@') seenAt = true;
            if (!seenAt) {
                if (c == '*') { seenStar = true; continue; }
                if (seenStar) continue;
                if (c == '.') continue;
            }
            result.append(c);
        }
        return result.toString();
    }

    static boolean isAllowed(String s) {
        char[] notAllowedChars = {'&', '=', '+', '-', '_', '<', '>', ',', '\''};
        if (s == null || s.isEmpty() || s.charAt(0) == '.') return false;
        if (!s.contains("@")) return false;
        
        int atIndex = s.indexOf('@');
        if (atIndex < 6 || atIndex > 30) return false;
        
        for (int i = 0; i < atIndex; i++) {
            for (char bad : notAllowedChars) {
                if (s.charAt(i) == bad) return false;
            }
        }
        
        int lastDot = s.lastIndexOf('.');
        if (lastDot <= atIndex || lastDot == -1) return false;
        return true;
    }

    public static void main(String[] args) {
        List<String> v = List.of(".555555@.", "1111.111@mail.ru", "11111111@.mailru", "1111111@.mailru", "11111111@.mailru");
        List<String> filtered = v.stream()
            .filter(Main::isAllowed)
            .map(Main::formatEmail)
            .toList();
        
        if (filtered.isEmpty()) {
            System.out.println("No unique emails");
        } else {
            System.out.println(findUnique(filtered).size());
        }
    }
}