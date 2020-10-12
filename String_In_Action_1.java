public class String_In_Action_1 {
    public static void main(String args[]){
        String[] words = {"funk","chunk", "furry","baconator"};

        //startsWith method
        for(String w : words){
            if(w.startsWith("fu"))
                System.out.println(w + " starts with fu");
        }

        // endsWith method
        for(String w : words){
            if(w.endsWith("unk"))
                System.out.println(w + " starts with unk");
        }

        String s = "kayimfotsokayimfotso";
        System.out.println(s.indexOf("k",5));// returns -1 if not found
        System.out.println(s.indexOf("fot"));

        String a = "Bacon ";
        String b = "Monster";

        System.out.println(a.concat(b));

        System.out.println(a.replace("Ba","ced"));
        System.out.println(b.toUpperCase());

        String c = "      hello world     ";
        System.out.println(c.trim());
    }
}
