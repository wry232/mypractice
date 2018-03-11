import java.util.*;


public class Test {

    public static void main(String [] args) {
        testHashSetIterator();
    }



    public static void testHashSetIterator() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(2);
        System.out.println("set size: " + set.size());
        System.out.println(set);
        System.out.println("set remove 1 " );
        set.remove(1);
        System.out.println(set);

        System.out.println("set contains 1: " + set.contains(1));
        System.out.println(set);

        set.remove(1);
        set.remove(2);
        set.remove(1);
        set.remove(2);
        set.remove(1);
        set.remove(2);
        System.out.println(set);

        // sorted set: treeset
        Set<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(3);
        sortedSet.add(4);
        sortedSet.add(6);
        sortedSet.add(2);
        sortedSet.add(3);
        sortedSet.add(4);
        sortedSet.add(2);
        sortedSet.add(1);
        sortedSet.add(3);
        sortedSet.add(5);
        sortedSet.add(6);
        System.out.println("sortedSet size: " + sortedSet.size());
        System.out.println(sortedSet);
        System.out.println("sortedSet remove 1 " );
        sortedSet.remove(1);
        System.out.println(sortedSet);

        System.out.println("sortedSet contains 1: " + sortedSet.contains(1));
        System.out.println(sortedSet);

        sortedSet.remove(1);
        sortedSet.remove(2);
        sortedSet.remove(1);
        sortedSet.remove(2);
        sortedSet.remove(1);
        sortedSet.remove(2);
        System.out.println(sortedSet);

    }


}
