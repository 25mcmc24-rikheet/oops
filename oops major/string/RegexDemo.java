import java.util.*;

public class RegexDemo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String");

        String s = sc.nextLine();



        // =========================
        // BASIC REGEX
        // =========================

        // .  -> any single character
        System.out.println(
            ". operator : " +
            s.matches("."));



        // * -> zero or more
        System.out.println(
            "* operator : " +
            s.matches("[a-zA-Z]*"));



        // + -> one or more
        System.out.println(
            "+ operator : " +
            s.matches("[a-zA-Z]+"));



        // ? -> zero or one
        System.out.println(
            "? operator : " +
            s.matches("[a-zA-Z]?"));



        // {n} -> exactly n times
        System.out.println(
            "{n} operator : " +
            s.matches("\\d{5}"));



        // {n,m} -> between n and m times
        System.out.println(
            "{n,m} operator : " +
            s.matches("[a-zA-Z]{3,8}"));



        // {n,} -> minimum n times
        System.out.println(
            "{n,} operator : " +
            s.matches("\\d{4,}"));



        // =========================
        // CHARACTER CLASSES
        // =========================

        // \d -> digit
        System.out.println(
            "\\d : " +
            s.matches("\\d+"));



        // \D -> non digit
        System.out.println(
            "\\D : " +
            s.matches("\\D+"));



        // \w -> word character
        System.out.println(
            "\\w : " +
            s.matches("\\w+"));



        // \W -> non word character
        System.out.println(
            "\\W : " +
            s.matches("\\W+"));



        // \s -> whitespace
        System.out.println(
            "\\s : " +
            s.matches("\\s+"));



        // \S -> non whitespace
        System.out.println(
            "\\S : " +
            s.matches("\\S+"));



        // =========================
        // RANGE OPERATORS
        // =========================

        // lowercase letters
        System.out.println(
            "[a-z] : " +
            s.matches("[a-z]+"));



        // uppercase letters
        System.out.println(
            "[A-Z] : " +
            s.matches("[A-Z]+"));



        // alphabets
        System.out.println(
            "[a-zA-Z] : " +
            s.matches("[a-zA-Z]+"));



        // alphanumeric
        System.out.println(
            "[a-zA-Z0-9] : " +
            s.matches("[a-zA-Z0-9]+"));



        // not digits
        System.out.println(
            "[^0-9] : " +
            s.matches("[^0-9]+"));



        // vowels only
        System.out.println(
            "Vowels : " +
            s.matches("[aeiouAEIOU]+"));



        // =========================
        // SPECIAL REGEX
        // =========================

        // starts with capital
        System.out.println(
            "Starts with Capital : " +
            s.matches("[A-Z].*"));



        // ends with digit
        System.out.println(
            "Ends with Digit : " +
            s.matches(".*\\d"));



        // contains vowel
        System.out.println(
            "Contains Vowel : " +
            s.matches(".*[aeiouAEIOU].*"));



        // starts and ends with alphabet
        System.out.println(
            "Starts and Ends Alphabet : " +
            s.matches("[a-zA-Z].*[a-zA-Z]"));



        // =========================
        // VALIDATIONS
        // =========================

        // email validation
        System.out.println(
            "Email : " +
            s.matches(
                "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com"));



        // phone number
        System.out.println(
            "Phone : " +
            s.matches("\\d{10}"));



        // pin code
        System.out.println(
            "Pin Code : " +
            s.matches("\\d{6}"));



        // student id
        System.out.println(
            "Student ID : " +
            s.matches("STU\\d{3}"));



        // password validation
        System.out.println(
            "Strong Password : " +
            s.matches(
                "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}"));


        // date dd-mm-yyyy
        System.out.println(
            "Date : " +
            s.matches("\\d{2}-\\d{2}-\\d{4}"));


        // time hh:mm
        System.out.println(
            "Time : " +
            s.matches("\\d{2}:\\d{2}"));


        // =========================
        // replaceAll
        // =========================

        // remove digits
        System.out.println(
            "Remove Digits : " +
            s.replaceAll("\\d",""));



        // remove spaces
        System.out.println(
            "Remove Spaces : " +
            s.replaceAll("\\s",""));



        // remove non alphabets
        System.out.println(
            "Only Alphabets : " +
            s.replaceAll("[^a-zA-Z]",""));



        // replace spaces with _
        System.out.println(
            "Replace Spaces : " +
            s.replaceAll("\\s+","_"));



        // remove special characters
        System.out.println(
            "Remove Special Characters : " +
            s.replaceAll("[^a-zA-Z0-9 ]",""));



        // =========================
        // split()
        // =========================

        // split by spaces
        String arr[] = s.split("\\s+");

        System.out.println("Split Words");

        for(String x : arr)
        {
            System.out.println(x);
        }



        // split using comma or space
        String arr2[] = s.split("[, ]+");

        System.out.println("Split by comma/space");

        for(String x : arr2)
        {
            System.out.println(x);
        }

        sc.close();
    }
}