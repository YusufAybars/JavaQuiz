package java_code_quizz;

import java.util.*;

public class JavaQuiz {
    public static void main(String[] args) {

        //1-Java Program to Find the First Non-repeated Character in a String
        //Girilen sitring bir ifadede tekrar etmeyen ilk karakteri getiren kodu yazınız.

        Scanner input1 = new Scanner(System.in);
        System.out.println("Please write a word");
        String s = input1.nextLine();

        String[] characters = s.split("");
        HashMap<String, Integer> myMap = new HashMap<>();
        for (String w : characters){
            Integer count = myMap.get(w);
            if (count == null){
                myMap.put(w,1);
            }else {
                myMap.put(w, count + 1);
            }
        }

        for (String w : characters) {
            if (myMap.get(w) == 1) {
                System.out.println("First non-repeating character: " + w);
                break;
            }
        }

        //2-Java Program to Check Palindrome String
        //Verilen String ifadenin palindrome olup olmadığını kontrol eden kod yazınız

        Scanner input = new Scanner(System.in);
        System.out.println("Please Write a Word");
        String word = input.nextLine();
        String reversed = "";

        int n = word.length() - 1;

        while (n >= 0){
            reversed = reversed + word.charAt(n);
            n--;
        }

        if (word.equalsIgnoreCase(reversed)){
            System.out.println("Is a Palindrome.");
        } else {
            System.out.println("Not a Palindrome");
        }


        //3- Java Program to Find Duplicate Characters in a String
        //*
        //Verilen String içinde tekrar eden karakterleri ve tekrer sayısını veren bir kod yazınız

        Scanner input2 = new Scanner(System.in);
        System.out.println("Please write a word");
        String s1 = input2.nextLine();

        String[] characters1 = s1.split("");
        HashMap<String, Integer> myMap1 = new HashMap<>();
        for (String q : characters1){
            Integer count = myMap1.get(q);
            if (count == null){
                myMap1.put(q,1);
            }else {
                myMap1.put(q, count + 1);
            }
        }
        System.out.println(myMap1);

        //4-Java Program to Find Duplicate Words in a String
        //Verilen bir string cümle içinde tekrar eden kelimeleri ve bu kelimelerin sayısını veren kod yazınız

        Scanner input3 = new Scanner(System.in);
        System.out.println("Please write a sentence");
        String sentence = input3.nextLine();

        sentence = sentence.replaceAll("\\p{Punct}", "").toLowerCase();

        String[] words = sentence.split(" ");

        HashMap<String, Integer> myMap5 = new HashMap<>();

        for (String k : words) {

            Integer appearance = myMap5.get(k);

            if (appearance == null) {
                myMap5.put(k, 1);
            } else {
                myMap5.put(k, appearance + 1);
            }
        }

        Set<Map.Entry<String, Integer>> mySet = myMap5.entrySet();
        for (Map.Entry<String, Integer> w : mySet){
            if (w.getValue() > 1){
                System.out.println(w);
            }
        }


        //5-Java Program to Find All the Permutations of a String
        //Girilen String bir ifadenin harfleri yer değiştirilerek oluşturulabilecek anlamlı anlamsız bütün
        // kelimeleri alt alta gösteren bir program yazınız
        //Bu soruyu Yapay Zekadan yardım alarak yaptım

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = scanner.nextLine();
        scanner.close();

        Set<String> permutations = getPermutations(str);
        System.out.println("Permutations of " + str + " are: ");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static Set<String> getPermutations(String str) {
        Set<String> permutations = new HashSet<>();
        if (str == null || str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char firstChar = str.charAt(0);
        String remainingString = str.substring(1);
        Set<String> words = getPermutations(remainingString);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);
                permutations.add(prefix + firstChar + suffix);
            }
        }
        return permutations;


    }

}
