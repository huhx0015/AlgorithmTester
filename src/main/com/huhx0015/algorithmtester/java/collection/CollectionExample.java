package main.com.huhx0015.algorithmtester.java.collection;

import java.util.*;

/**
 * Created by Michael Yoon Huh on 3/30/2017.
 */
public class CollectionExample {

    public static void main(String[] args) {

        // ArrayList:
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("one");
        arrayList.add("two");
        System.out.println("ArrayList 0 Element: " + arrayList.get(0));
        for (String s : arrayList) {
            System.out.println("ArrayList LOOP: " + s);
        }

        // Vector:
        Vector<String> vector = new Vector<>();
        vector.add("one");
        vector.add("two");
        System.out.println("Vector 0 Element: " + vector.get(0));
        for (String s : vector) {
            System.out.println("Vector LOOP: " + s);
        }

        // LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("one");
        linkedList.add("two");
        System.out.println("LinkedList 0 Element: " + linkedList.get(0));

        Iterator<String> iter = linkedList.iterator();
        while(iter.hasNext()) {
            System.out.println("LinkedList LOOP: " + linkedList.getFirst());
            linkedList.removeFirst();
        }

        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(0, "one");
        hashMap.put(1, "two");
        System.out.println("HashMap 0 Element: " + hashMap.get(0));
        for (int i = 0; i < hashMap.size(); i++) {
            System.out.println("HashMap LOOP: " + hashMap.get(i));
        }

        System.out.println("Program end.");
    }
}
