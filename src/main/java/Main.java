import com.sun.javafx.robot.FXRobotImage;
import com.sun.org.apache.bcel.internal.generic.LUSHR;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public String frequencySort(String s) {

        if (s == null || s.length() == 0) return "";

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        final ArrayList<Character> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> map.get(o1) - map.get(o2));

        final StringBuffer buffer = new StringBuffer();

        for (Character key : keys) {

            final Integer keyNums = map.get(key);
            for (int i = 0; i < keyNums; i++) {
                buffer.append(key);
            }


        }


        return buffer.toString();


    }

}


class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    Random random = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {

        if (map.containsKey(val)) return false;

        map.put(val, list.size());
        list.add(list.size(), val);

        return true;

    }

    public boolean remove(int val) {

        if (!map.containsKey(val)) return false;

        int lastElem = list.get(list.size() - 1);
        int removeValIndex = map.get(val);

        list.set(removeValIndex, lastElem);
        map.put(lastElem, removeValIndex);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;

    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}



