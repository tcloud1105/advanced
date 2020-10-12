package generic;

public class Generic_Methods_11 {
    public static void main(String args[]){
        Integer[] iray = {1,2,3,4,5,6};
        Character[] cray = {'c','e','d','r','i','c'};

        printMe(iray);
        printMe(cray);
        System.out.println(max(1,2,4));
        System.out.println(max('c','a','h'));
    }

    // generic method
    private static <T> void printMe(T[] x) {
        for(T t : x)
            System.out.printf("%s ", t);
        System.out.println();
    }

    // generic return type
    public static <T extends Comparable<T>> T max(T a, T b, T c){
        T m = a;
        if(b.compareTo(a) > 0)
            m = b;
        if(c.compareTo(m) > 0)
            m = c;
        return m;
    }


}
