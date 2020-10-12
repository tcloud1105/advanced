package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class More_Collection_7 {
    public static void main(String args[]){
        // convert stuff array to a list
        String[] stuff = {"apples","beef","corn","ham"};
        List<String> list1 = Arrays.asList(stuff);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("youtube");
        list2.add("facebook");
        list2.add("google");

        for(String x : list2)
            System.out.printf("%s ",x);

        System.out.println();
        Collections.addAll(list2, stuff);
        for(String c: list2)
            System.out.printf("%s ", c);

        System.out.println();
        System.out.println(Collections.frequency(list2,"facebook"));

        boolean tof = Collections.disjoint(list1, list2);
        System.out.println(tof);
        if(tof)
            System.out.println("these lists do not have elements in common");
        else
            System.out.println("these list must have something in common");


    }
}
