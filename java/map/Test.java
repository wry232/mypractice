import java.util.*;


public class Test {

    public static void main(String [] args) {
        testHashMapIterator();
    }



    public static void testHashMapIterator() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 500);
        map.put(1, 100);
        map.put(3, 300);
        map.put(2, 200);

        System.out.println("map size: " + map.size());
        System.out.println(map);

        System.out.println("map contains 1: " + map.containsKey(1));
        System.out.println("map remove 1 " );
        map.remove(1);
        System.out.println(map);
        System.out.println("map contains 1: " + map.containsKey(1));

        // iterate by map entry
        System.out.println("Iterate by map entry:");
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            System.out.println("entry: key: "+ entry.getKey() + ", value:" + entry.getValue());
        }

        // iterate by map keys
        System.out.println("Iterate by map keyset:");
        for(Integer key: map.keySet()) {
            System.out.println("entry: key: "+ key + ", value:" + map.get(key));
        }

        // iterate by map values
        System.out.println("Iterate by map valueset:");
        for(Integer value: map.values()) {
            System.out.println("entry: value: "+ value);
        }

        System.out.println("map contains 5: " + map.containsKey(5));
        System.out.println("map remove 5 " );
        map.remove(5);
        System.out.println(map);
        System.out.println("map contains 5: " + map.containsKey(5));



        System.out.println("map contains value 200: " + map.containsValue(200));
        System.out.println(map);
        map.remove(2, 200);
        System.out.println("map contains value 200: " + map.containsValue(200));
        System.out.println(map);

        // Note: the followings iterate the map; very slow
        // remove value 300
        map.values().remove(300);

        System.out.println("map contains 2: " + map.containsKey(2));
        System.out.println(map);

        map.remove(1);
        map.remove(2);
        map.remove(1);
        map.remove(2);
        map.remove(1);
        map.remove(2);
        System.out.println(map);

        // sorted map: TreeMap is sorted based on the order of keys
        Map<Integer, Integer> sortedMap = new TreeMap<>();

    }


}
