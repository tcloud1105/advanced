package collections;

import java.util.*;

public class HashSet_In_Action_10 {
    public static void main(String args[]){
        String[] things = {"apple","bob","ham","bob","bacon"};
        List<String> list = Arrays.asList(things);

        System.out.printf("%s ",list);
        System.out.println();

        Set<String> set = new HashSet<>(list);
        System.out.printf("%s ",set);
        System.out.println();
    }
}
