package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Collection_Methods_6 {
    public static void main(String args[]){
        String[] stuff = {"apples","lemons","geese","bacon","youtube"};
        List<String> l1 = Arrays.asList(stuff);

        Collections.sort(l1);
        System.out.printf("%s\n",l1);

        Collections.sort(l1, Collections.reverseOrder());
        System.out.printf("%s\n",l1);

        // create an array and convert to list
        Character[] ray = {'p','a','w','n'};
        List<Character> l = Arrays.asList(ray);
        System.out.println("List is : ");
        output(l);

        // reverse and print out the list
        Collections.reverse(l);
        System.out.println("After reverse : ");
        output(l);

        // create new array and a new list
        Character[] newRay = new Character[4];
        List<Character> listCopy = Arrays.asList(newRay);

        // copy contents of list into listCopy
        Collections.copy(listCopy,l);
        System.out.println("Copy of list : ");
        output(listCopy);

        // fill collection with stuff
        Collections.fill(l,'X');
        System.out.println("After filling the list : ");
        output(l);
    }

    private static void output(List<Character> l) {
        for(Character thing : l)
            System.out.printf("%s ",thing);
        System.out.println();
    }
}
