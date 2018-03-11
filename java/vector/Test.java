import java.util.*;


public class Test {

    public static void main(String [] args) {
        testVectorIterator();
    }



    public static void testVectorIterator() {


        // initialize the vector with capacity with 8
        List<Integer> vector = new Vector<>(3);

        // element will be added to vector at pre allocated places
        vector.add(0, 1);
        vector.add(1, 2);
        vector.add(2, 3);

        // now vector will be expanded to add new element
        vector.add(3, 4);
        vector.add(4, 5);


        System.out.println("vector size: " + vector.size());
        printCollection(vector);

        System.out.println("vector swap at position 0 and position 2 ");
        Collections.swap(vector, 0, 2);
        printCollection(vector);

        System.out.println("------------------------------------");

        System.out.println("vector sub vector between position 0 and position 2:");
        List subVector = vector.subList(0, 2);
        System.out.println("subVector class:" + subVector.getClass());
        System.out.println("subVector size:" + subVector.size());
        printCollection(subVector);

        // note: subvector only reference the position of vector
        //       if vector value changed at postion 0 or positon 1 or else, subvector will change
        //       because subvector always points to vector elements at postion [0, 2]
        vector.set(0, 567);
        vector.set(1, 789);

        printCollection(subVector);


        System.out.println("------------------------------------");
        System.out.println("vector reverse:");
        Collections.reverse(vector);
        printCollection(vector);
        //subvector still points the vector position [0, 2]
        printCollection(subVector);


        System.out.println("------------------------------------");

        Iterator it = vector.iterator();
        while(it.hasNext()) {
            Integer i = (Integer) it.next();
            it.remove();
        }
        System.out.println("After remove all elements in vector; vector size: " + vector.size());
        printCollection(vector);


        System.out.println("------------------------------------");
        List<Integer> vector2 = new Vector<>();
        vector2.add(7);
        vector2.add(7);
        vector2.add(7);
        vector2.add(8);
        vector2.add(8);
        vector2.add(9);

        System.out.println("vector2 size: " + vector2.size());
        printCollection(vector2);

        System.out.println("vector and vector2 disjoint: " + Collections.disjoint(vector, vector2));
        System.out.println("vector2 7 frequency: " + Collections.frequency(vector2, 7));
        System.out.println("vector2 9 frequency: " + Collections.frequency(vector2, 9));




    }


    // <T> must be declared before void to indicate compiler this is a generic method
    static <T> void printCollection(Collection<T> c) {
        StringBuilder sb = new StringBuilder();
        for(Iterator it = c.iterator(); it.hasNext(); ){
            sb.append(it.next() + " -> ");
        }
        System.out.println(sb.toString());

        // or
        // for(T t : c ){
        //    sb.append(c);
        // }
        // System.out.println(sb.toString());
    }
}
