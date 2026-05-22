import java.util.*;

public class StringOperationsDemo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String");

        String s = sc.nextLine();



        // length of string
        System.out.println(
            "Length : " + s.length());



        // convert to uppercase
        System.out.println(
            "Uppercase : " + s.toUpperCase());



        // convert to lowercase
        System.out.println(
            "Lowercase : " + s.toLowerCase());



        // remove leading and trailing spaces
        System.out.println(
            "Trim : " + s.trim());



        // character at index
        if(s.length() > 0)
        {
            System.out.println(
                "Character at 0 : " +
                s.charAt(0));
        }



        // substring
        if(s.length() >= 5)
        {
            System.out.println(
                "Substring(0,5) : " +
                s.substring(0,5));
        }



        // contains
        System.out.println(
            "Contains Java : " +
            s.contains("Java"));



        // startsWith
        System.out.println(
            "Starts with Hello : " +
            s.startsWith("Hello"));



        // endsWith
        System.out.println(
            "Ends with . : " +
            s.endsWith("."));



        // indexOf
        System.out.println(
            "Index of a : " +
            s.indexOf('a'));



        // lastIndexOf
        System.out.println(
            "Last Index of a : " +
            s.lastIndexOf('a'));



        // replace
        System.out.println(
            "Replace a with x : " +
            s.replace('a','x'));



        // equals
        System.out.println(
            "Equals Java : " +
            s.equals("Java"));



        // equalsIgnoreCase
        System.out.println(
            "EqualsIgnoreCase java : " +
            s.equalsIgnoreCase("java"));



        // compareTo
        System.out.println(
            "CompareTo abc : " +
            s.compareTo("abc"));



        // split
        String arr[] = s.split(" ");

        System.out.println("Split Words");

        for(String x : arr)
        {
            System.out.println(x);
        }



        // string to char array
        char ch[] = s.toCharArray();

        System.out.println("Characters");

        for(char c : ch)
        {
            System.out.print(c + " ");
        }

        System.out.println();



        // StringBuilder
        StringBuilder sb =
            new StringBuilder(s);

        sb.reverse();

        System.out.println(
            "Reverse : " + sb);

            // =========================
// STRINGBUILDER METHODS
// =========================

StringBuilder sb =
    new StringBuilder(s);



// append
sb.append(" Java");

System.out.println(
    "append() : " + sb);



// insert
sb.insert(0,"Hello ");

System.out.println(
    "insert() : " + sb);



// delete
if(sb.length() >= 5)
{
    sb.delete(0,5);

    System.out.println(
        "delete() : " + sb);
}



// deleteCharAt
if(sb.length() > 0)
{
    sb.deleteCharAt(0);

    System.out.println(
        "deleteCharAt() : " + sb);
}



// replace
if(sb.length() >= 4)
{
    sb.replace(0,4,"JAVA");

    System.out.println(
        "replace() : " + sb);
}



// reverse
sb.reverse();

System.out.println(
    "reverse() : " + sb);



// capacity
System.out.println(
    "capacity() : " +
    sb.capacity());



// length
System.out.println(
    "length() : " +
    sb.length());



// charAt
if(sb.length() > 0)
{
    System.out.println(
        "charAt() : " +
        sb.charAt(0));
}



// setCharAt
if(sb.length() > 0)
{
    sb.setCharAt(0,'X');

    System.out.println(
        "setCharAt() : " + sb);
}



// substring
if(sb.length() >= 5)
{
    System.out.println(
        "substring() : " +
        sb.substring(0,5));
}



// indexOf
System.out.println(
    "indexOf() : " +
    sb.indexOf("a"));



// lastIndexOf
System.out.println(
    "lastIndexOf() : " +
    sb.lastIndexOf("a"));



// ensureCapacity
sb.ensureCapacity(100);

System.out.println(
    "ensureCapacity() : " +
    sb.capacity());



// trimToSize
sb.trimToSize();

System.out.println(
    "trimToSize() : " +
    sb.capacity());



// setLength
sb.setLength(5);

System.out.println(
    "setLength() : " + sb);



// convert to String
String str = sb.toString();

System.out.println(
    "toString() : " + str);




        // =========================
        // REGEX OPERATIONS
        // =========================



        // only alphabets
        System.out.println(
            "Only Alphabets : " +
            s.matches("[a-zA-Z]+"));



        // only digits
        System.out.println(
            "Only Digits : " +
            s.matches("\\d+"));



        // alphabets and spaces
        System.out.println(
            "Alphabets and Spaces : " +
            s.matches("[a-zA-Z ]+"));



        // starts with capital letter
        System.out.println(
            "Starts with Capital : " +
            s.matches("[A-Z].*"));



        // email validation
        System.out.println(
            "Valid Email : " +
            s.matches(
                "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com"));



        // phone number validation
        System.out.println(
            "Valid Phone Number : " +
            s.matches("\\d{10}"));



        // student id validation
        System.out.println(
            "Student ID : " +
            s.matches("STU\\d{3}"));



        // remove non alphabets
        System.out.println(
            "Remove Non Alphabets : " +
            s.replaceAll("[^a-zA-Z ]",""));



        // replace multiple spaces
        System.out.println(
            "Single Spaces : " +
            s.replaceAll("\\s+"," "));



        // remove digits
        System.out.println(
            "Remove Digits : " +
            s.replaceAll("\\d",""));



        // check if string contains vowels
        System.out.println(
            "Contains Vowel : " +
            s.matches(".*[aeiouAEIOU].*"));



        // split using regex
        String words[] =
            s.split("[ ,.!?]+");

        System.out.println(
            "Regex Split");

        for(String x : words)
        {
            System.out.println(x);
        }



        // check date format dd-mm-yyyy
        System.out.println(
            "Date Format : " +
            s.matches("\\d{2}-\\d{2}-\\d{4}"));



        // check password
        System.out.println(
            "Strong Password : " +
            s.matches(
                "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}"));


        sc.close();
    }
}