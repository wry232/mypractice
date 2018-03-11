import java.util.*;


public class Test {

    public static void main(String [] args) {
        testIterator();
    }



    public static void testIterator() {


        // Create list [1, 2, 3]
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);


        printCollection(list);

        // Note iterator does not point to any element in the collection
        // it is always between two elements, or it is before the first element, or after the last element
        // So, when list.iterator() get called, iterator will be located before the first element
        //   [it (Noref)| 1 | 2 | 3 ]
        Iterator<Integer> it = list.iterator();


        // when it.remove() called, it will remove the element before it
        // this will throws runtime exception java.lang.IllegalStateException,
        // because there is no element before iterator it
        // it.remove();

        // Every time it.next get called, iterator it will move to next element
        //   [1 | it(ref position at value 1) | 2 | 3 ]
        //it.next();

        printCollection(list);

//        while(it.hasNext()) {
//            Integer i = it.next();
//            System.out.println("i: "+ i);
//
//            //it.remove();
//        }

        // ListIterator has more rich functionalities
        // ListIterator lit should be at beginning of the list
        ListIterator<Integer> lit = list.listIterator();

        // lit.previousIndex() should be return -1, since lit is at the beginning of the list
        System.out.println("lit.previousIndex(): " + lit.previousIndex());
        // lit.nextIndex() should be return 0, since lit is at the beginning of the list
        System.out.println("lit.nextIndex(): " + lit.nextIndex());


        // [lit (no ref)| 1 | 2 | 3]
        // when lit.set(999) called, lit will set the element it referenced
        // Here if we cal lt.set(999) directly, it will fail
        // this will throws java.lang.IllegalStateException, since there is no element before it
        //lit.set(999);

        System.out.println("lit.previousIndex(): " + lit.previousIndex());
        System.out.println("lit.nextIndex(): " + lit.nextIndex());

        // we can add 1 element to lit
        // [888| lit (no ref)| 1 | 2 | 3]
        lit.add(888);
        printCollection(list);

        System.out.println("lit.previousIndex(): " + lit.previousIndex());
        System.out.println("lit.nextIndex(): " + lit.nextIndex());

        // If we use lit to set element 888 value directly, it will fail(Throw IllegalStateException)
        // To use lit.set, it must by be referenced by next() or previous() first
        // previous
        // [ lit(ref position at value 888)| 888| 1 | 2 | 3]

        lit.previous();
        lit.set(22);
        // [ lit(ref position at value 22)| 22| 1 | 2 | 3]
        printCollection(list);

        lit.set(999);
        // [ lit(ref position at value 999)| 999| 1 | 2 | 3]
        printCollection(list);



        // [ lit(ref position at value 999)| 999| 1 | 2 | 3]
        // [ lit2(no ref) | 999| 1 | 2 | 3 ]
        ListIterator<Integer> lit2 = list.listIterator();

        // similar to set, lit.remove() must reference some position, before it get called
        // only next and previous can initialize this kind of reference
        // eg. the followings will fail
//        lit2.remove();
//        printCollection(list);

        // To make remove work, we need to let lit2 to reference a position
        lit2.next();
        // Now lit2 reference the element of the list
        // [ 999 | lit2(ref position at value 000)| 1 | 2 | 3]
        // now we call list2.remove()
        // it will remove 999, the reference to nothing,
        // and if any other iterator reference to 999, the refernce will be marked as null
        //
        lit2.remove();
        printCollection(list);
        // [ lit2(no ref)| 1 | 2 | 3]


        // After lit2 remove 999
        // Now lit becomes orphan ?? because it next 999 is gone?
        // lit next is null
        // before lit2 remove: [ lit(ref position at value 999)| 999| 1 | 2 | 3]
        // after: [ lit(no ref) (ref position at value 999)| 999] lit doest not know where is 999's next
        // since it's not in list any more????
        // lit.next();   //<----- fail [ lit(no ref) (ref position at value 999)| 999]


        // to make it work we need make sure lit is not dangling anymore
        // To make it work we need to set lit to list.iterator()
        // [ lit(no ref)| 1 | 2 | 3]
        lit = list.listIterator();


        // [ 100 | lit| 1 | 2 | 3]
        lit.add(100);

        // Add one element at position lit, since lit is at the beginning of the list,
        // so the new element will become the first element of the list
        // and lit position does not change, but new element will be before lit
        // lit's next is still 1, but lit's previous becomes 100
        lit.add(100);
        System.out.println("--- lit.add(100) ----");
        System.out.println("lit.previousIndex(): " + lit.previousIndex());
        System.out.println("lit.nextIndex(): " + lit.nextIndex());


//        while(lit.hasPrevious()) {
//            Integer i = lit.next();
//            System.out.println("i: "+ i);
//            lit.remove();
//        }

        lit.add(100);

        System.out.println("lit.previousIndex(): " + lit.previousIndex());

        System.out.println("lit.nextIndex(): " + lit.nextIndex());

        Integer val = lit.next();
        lit.set(0);

        Iterator<Integer> it2 = list.iterator();

        while(it2.hasNext()) {
            Integer i = it2.next();
            System.out.println("i: "+ i);
            //it.remove();
        }

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

