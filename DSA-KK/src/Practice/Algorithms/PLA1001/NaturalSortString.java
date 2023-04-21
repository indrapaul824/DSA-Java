package Practice.Algorithms.PLA1001;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaturalSortString {
    public static void main(String[] args) {
        ArrayList<String> S = new ArrayList<>();
        S.add("Ep 1");
        S.add("Ep 21");
        S.add("Ep 2");
        S.add("Ep 12");
        S.add("Ep 11");
        System.out.println("Original Array: " + S);
        System.out.println("Sorted Array: " + naturalSort(S));
    }

    static ArrayList<String> naturalSort(ArrayList<String> arr) {
        Map<Integer, String> map = new HashMap<>();

        Pattern p = Pattern.compile("\\d+");
        for (String s : arr) {
            Matcher m = p.matcher(s);
            if (m.find())
                map.put(Integer.parseInt(m.group()), s);
        }

        ArrayList<Integer> sortedKey= new ArrayList<>(map.keySet());
        Collections.sort(sortedKey);
        ArrayList<String> sortedString = new ArrayList<>();
        for (int key : sortedKey) {
            sortedString.add(map.get(key));
        }

        return sortedString;
    }
}
