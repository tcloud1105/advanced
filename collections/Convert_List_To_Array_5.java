package collections;

import java.util.Arrays;
import java.util.LinkedList;

public class Convert_List_To_Array_5 {
    public static void main(String args[]){
        String[] stuff = {"babies","watermelong","melong","fudge"};
        LinkedList<String> thelist = new LinkedList<>(Arrays.asList(stuff));
        thelist.add("pumpkin");
        thelist.addFirst("firstthing");

        //convert back to an array
        stuff = thelist.toArray(new String[thelist.size()]);
        for(String x : stuff)
            System.out.printf("%s ",x );
    }
}
