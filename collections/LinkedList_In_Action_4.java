package collections;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedList_In_Action_4 {
    public static void main(String[] args){
        String[] things = {"apples","bacon","sponge","bacon","goat"};
        List<String> list1 = new LinkedList<String>();
        for(String x : things)
            list1.add(x);

        String[] things2 = {"sausage","bacon","goats","harrypotter"};
        List<String> list2  = new LinkedList<String>();
        for(String y : things2)
            list1.add(y);

        list1.addAll(list2);
        list2 = null;
        printMe(list1);
        removeStuff(list1, 2, 5);
        printMe(list1);
        reverseMe(list1);
    }

    private static void reverseMe(List<String> list1) {
        ListIterator<String> li = list1.listIterator(list1.size());
        while(li.hasPrevious())
            System.out.printf("%s ", li.previous());
    }

    private static void removeStuff(List<String> list1, int from, int to) {
        list1.subList(from, to).clear();
    }

    private static void printMe(List<String> list1) {
        for(String b : list1)
            System.out.printf("%s ", b);
        System.out.println();
    }
}
