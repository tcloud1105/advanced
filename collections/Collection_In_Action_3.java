package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Collection_In_Action_3 {
    public static void main(String args[]){
        String[] things = {"eggs","lasers","hats","pie"};
        List<String> list1 = new ArrayList<String>();

        //add array items in list
        for(String x : things)
            list1.add(x);

        String[] morethings = {"lasers","hats"};
        List<String> list2 = new ArrayList<String>();

        //add array items in list
        for(String y : morethings)
            list2.add(y);

        for(int i=0; i<list1.size();i++){
            System.out.printf("%s ", list1.get(i));
        }

        editlist(list1, list2);
        System.out.println();

        //print out list 1
        for(int i=0; i<list1.size();i++){
            System.out.printf("%s ",list1.get(i));
        }
    }

    private static void editlist(Collection<String> list1, Collection<String> list2) {
        Iterator<String> it = list1.iterator();
        while(it.hasNext()){
            if(list2.contains(it.next()))
                it.remove();
        }
    }
}
