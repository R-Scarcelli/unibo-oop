package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int UPPER_BOUND = 2000;
    private static final int LOWER_BOUND = 1000;
    private static final int HEAD = 0;
    private static final int ELEMS = 100_000;
    private static final int ELEMS_TO_READ = 10_000;
    private static final long AFRICA_POPULATION = 1_110_635_000L;
    private static final long AMERICAS_POPULATION = 972_005_000L;
    private static final long ANTARCTICA_POPULATION = 0L;
    private static final long ASIA_POPULATION = 4_298_723_000L;
    private static final long EUROPE_POPULATION = 742_452_000L;
    private static final long OCEANIA_POPULATION = 38_304_000L;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> aList = new ArrayList<Integer>();
        for (int i = LOWER_BOUND; i < UPPER_BOUND; i++) {
            aList.add(i);
        }
        System.out.println(aList);
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> lList = new LinkedList<Integer> (aList);
        System.out.println(lList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int element = aList.getLast();
        aList.set(aList.size() - 1, aList.getFirst());
        aList.set(HEAD, element);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer integer : aList) {
            System.out.println(integer);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            aList.addFirst(i);
        }
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + aList.size()
                + " ints to String and inserting them in a Set took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            lList.addFirst(i);
        }
        time = System.nanoTime() - time;
        final var lmillis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + lList.size()
                + " ints to String and inserting them in a Set took "
                + time
                + "ns ("
                + lmillis
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for (int i = 0; i < ELEMS_TO_READ; i++) {
            aList.get(aList.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println("Reading " + ELEMS_TO_READ + " elements in the middle of an ArrayList took " + time + "ns (" + TimeUnit.NANOSECONDS.toMillis(time) + "ms)");

        time = System.nanoTime();
        for (int i = 0; i < ELEMS_TO_READ; i++) {
            lList.get(lList.size() / 2); 
        }
        time = System.nanoTime() - time;
        System.out.println( "Reading " + ELEMS_TO_READ + " elements in the middle of a LinkedList took " + time + "ns (" + TimeUnit.NANOSECONDS.toMillis(time) + "ms)");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> worlMap = new HashMap<> ();
        worlMap.put("Africa", AFRICA_POPULATION);
        worlMap.put("Americas", AMERICAS_POPULATION);
        worlMap.put("Antartica", ANTARCTICA_POPULATION);
        worlMap.put("Asia", ASIA_POPULATION);
        worlMap.put("Europe", EUROPE_POPULATION);
        worlMap.put("Oceania", OCEANIA_POPULATION);
        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0;
        for (Long population : worlMap.values()) {
            worldPopulation += population;
        }
        System.out.println("World's population is: " + worldPopulation);
    }
}
