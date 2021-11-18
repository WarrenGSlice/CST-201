/* * * * * * * * * * * * * * *
 * Created by Warren Peterson
 * For CST-201 11/18/2021  * *
 * Project-1 MyString  * * * *
 * Driver Class  * * * * * * *
 * * * * * * * * * * * * * * */

import java.util.Scanner;

public class DriverClass {

    public static void main(String[] args)
    {
    	//User input
    	Scanner input = new Scanner(System.in);
    	System.out.println("1) Enter your First String: ");
        MyString firstString = new MyString(input.nextLine().toString());
        System.out.println("2) Enter your Second String");
        MyString secondString = new MyString(input.nextLine().toString());
        System.out.println("3) Enter your Third String");
        MyString thirdString = new MyString(input.nextLine().toString());

        //Test of the MyString.length()
        System.out.println("4) THIS IS A TEST OF MyString.length() " + firstString);
        System.out.println(firstString.toString() + " has a length of " + firstString.length() + ".\n");

        //Test of the MyString.toString()
        System.out.println("5) THIS IS A TEST OF MyString.toString()");
        System.out.println(firstString.toString() + "\n");

        //Test of the MyString.concat()
        System.out.println("6) THIS IS A TEST OF MyString.concat() method");

        MyString concatString = firstString.concat(new MyString(" Pineapple"));
        System.out.println(concatString.toString() + "\n");

        //Test of the MyString.equals()
        System.out.println("7) THIS IS A TEST OF MyString.equals() method ");
        if(!firstString.equals(secondString))
            System.out.println(firstString.toString() + " does not equal " + secondString.toString() + "\n");

        if(firstString.equals(firstString))
            System.out.println(firstString.toString() + " is equal to " + firstString.toString() + "\n");

        //Test of the MyString.compareTo()
        System.out.println("8) THIS IS A TEST OF MyString.compareTo() method ");
        System.out.println(secondString.compareTo(secondString));
        System.out.println(secondString.toUpper().compareTo(secondString.toLower()));
        System.out.println(concatString.compareTo(secondString));
        System.out.print(firstString.compareTo(thirdString));
        System.out.println("\n");

        //Test of the MyString.toUpper() and MyString.toLower()
        System.out.println("9) THIS IS A TEST OF MyString.toUpper() and MyString.toLower() methods ");
        System.out.println(concatString.toUpper().toString());
        System.out.println(concatString.toLower().toString() + "\n");


        //Test of the MyString.equalsIgnoreCase()
        System.out.println("10) THIS IS A TEST OF MyString.equalsIgnoreCase() method ");
        if(firstString.toUpper().equalsIgnoreCase(firstString.toLower()))
            System.out.println(firstString.toUpper().toString() + " equals " + firstString.toLower().toString() + "\n");

        if(!firstString.equals(thirdString))
            System.out.println(firstString.toUpper().toString() + " doesn't equal " + thirdString.toLower().toString() + "\n");

        //Test of the MyString.get()
        System.out.println("11) THIS IS A TEST OF MyString.get() method ");
        System.out.println("Index 1,2,3 of " + firstString + " is: " + firstString.get(1) + firstString.get(2) + firstString.get(3) + "\n");

        //Test of the MyString.indexOf()
        System.out.println("12) THIS IS A TEST OF MyString.indexOf method");
        System.out.println("First index of 'late' in " + concatString.toString() + ": " + concatString.indexOf(new MyString("er")));
        System.out.println("Last index of 'o' in " + concatString.toString() + ": " + concatString.lastIndexOf(new MyString("ing")) + "\n");

        //Test of the MyString.substring(int) and MyString.substring(int n, int m)
        System.out.println("13) THIS IS A TEST OF MyString.substring(int) and MyString.substring(int n, int m)");
        System.out.println(firstString + " starting index of 4: " + firstString.substring(4));

        System.out.println(firstString + " starting index of 4, ending of 6: " + firstString.substring(4, 6));

    }
}