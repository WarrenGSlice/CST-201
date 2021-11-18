/* * * * * * * * * * * * * * *
 * Created by Warren Peterson
 * For CST-201 11/18/2021  * *
 * Project-1 MyString  * * * *
 * MyString Class  * * * * * *
 * * * * * * * * * * * * * * */

import java.util.Arrays;

public class MyString {
	//1) A char array reference (or pointer) for the array of characters that make up the string
    char[] charArr; //stores each character of the MyString in a charArray.
    //2) An integer curr_length representing the number of characters in the string
    int curr_length; //stores the length of the MyString.

    //REQUIRED METHODS
    //3) A constructor that initializes the array to null and the curr_length to 0
    public MyString() {//O(1) Constant Time (The number of operations stays the same, independent of the number of elements
        charArr = null; // initializes array to null
        curr_length = 0; //initializes curr_length to 0
    }
    
    //4) A constructor that takes a String parameter and initializes the char array to the characters in the String.  
    //curr_length should be appropriately initialized.
    public MyString(String string) {//O(n) Linear Time, The number of operations grows linearly with the number of elements n
        charArr = new char[1];
        curr_length = 0;
        for(int i = 0; i < string.length(); i++) {
            addChar(string.charAt(i));
        }
    }

    //5) a copy constructor that takes a MyString object and initializes a new MyString object 
    //so that it is a copy of the argument string
    public MyString(MyString myString) {//O(n) Linear Time
        //sets curr_length to the arguments curr_length
        curr_length = myString.curr_length;
        //initialize charArr to a new char array with the length of the charArr
        charArr = new char[myString.charArr.length];

        //copies each index of charArr over at each index respectively.
        for(int i = 0; i < myString.length(); i++) {
            charArr[i] = myString.charArr[i];
        }
    }

    //6) a length() method that returns the number of characters in the string
    //returns the length of the current MyString held within the curr_length int.
    public int length() { //O(1) Constant Time
        return curr_length;
    }

    //7) a private method, ensureCapacity(), that handles allocation of additional memory for the string
    //the following method checks if the array has enough capacity,if not we double it in size by making a new array double the size.
    private void ensureCapacity() { // ~O(log n) Logarithmic Time or O(n) Linear Time if the array length == curr_length else its O(n) Linear Time

        if(charArr == null)
            charArr = new char[1];

        if(charArr.length == curr_length) {
            //doubles the size of the array
            char[] tmpCharArr = new char[charArr.length * 2];

            //copies all the elements to the new array
            System.arraycopy(charArr, 0, tmpCharArr, 0, curr_length);

            charArr = tmpCharArr; //charArr now set to tmpCharArr
        }
    }

    //this method converts the MyString object to a String object and then returns it.
    //8) a toString() method that returns a String representation of the MyString object 
    public String toString() { //O(n) Linear Time

        StringBuilder returnString = new StringBuilder(curr_length); //initializes a new StringBuilder object with the curr_length variable.

        for (int i = 0; i < curr_length; i++) { //loops through each index of the charArr then adds it to StringBuilder
            returnString.append(charArr[i]); //appends the StringBuilder with index i of charArr from this instance of the object.
        }
        return returnString.toString(); //returns the returnString String Builder parsed to a string.
    }

    //9) a concat(MyString) method that takes a MyString parameter and returns a MyString object that is a concatenation of the calling object and the parameter 
    //this method adds the two MyString arguments together to one MyString object.
    public MyString concat(MyString myString) { //O(n) Linear Time
        MyString tmpMyStr = new MyString(this); //copy the MyString to the temp MyString;
        for (int i = 0; i < myString.curr_length; i++) { //loops through each index of the charArr in the MyString object.
            tmpMyStr.addChar(myString.charArr[i]); //adds the char at index i to the myStr charArr
        }
        return tmpMyStr; //returns the tempMyStr object.
    }

    //the following method adds a character to the charArray, it wasn't in the assignment but makes things easier.
    private void addChar(char c) { //O(1) Constant Time
        ensureCapacity(); //calls the ensureCapacity method to ensure the array has enough capacity and if not it doubles the array.
        charArr[curr_length++] = c; //adds a character at the index of (cur_length + 1) then adds one to the curr_length.
    }

    //10) a .equals(MyString) method that takes a MyString parameter and returns true if this MyString and the parameter are the same 
    //this method checks if the two MyString arguments are equal in all parameters.
    public boolean equals (MyString myString) { //O(n) Linear Time
        return Arrays.equals(charArr, myString.charArr) && curr_length == myString.curr_length;
    }

    //this method checks if the MyString argument is equal in all parameters regardless of circumstance.
    public boolean equalsIgnoreCase (MyString myString) {//O(n) linear Time

        MyString stringTempA = toLower(); //temp MyString for comparison converted to lowercase.
        MyString stringTempB = toLower(); //temp MyString for comparison converted to lowercase.

        //returns true or false depending on comparison.
        return Arrays.equals(stringTempB.charArr, stringTempA.charArr) && curr_length == myString.curr_length; //compares the two char arrays using the Array.equals method.
    }

    //11) a .compareTo(MyString) method that takes a MyString parameter and returns as follows 
    // 	0 if the parameter and this MyString are the same
    //	A negative integer if this MyString is alphabetically before the parameter
    //	A positive integer if this MyString is alphabetically after the parameter
    //this method compares the argument against this instance of a MyString object.
    public int compareTo(MyString myString) {//O(n) Linear Time
        //returns 0 in the case they are equal
        if(myString.equalsIgnoreCase(this)) {
            return 0;
        }

        int minimumDistance = Math.min(toLower().length(), myString.toLower().length()); //finds minimum distance between two strings.

        for(int i = 0; i < minimumDistance; i++) { //loops through each index of the charArr object
            if (toLower().charArr[i] == myString.toLower().charArr[i]) //if char arrays are equal then continue
                continue;

            //returns a value based on the ascii table and the chars
            return toLower().length() < myString.toLower().length() ? 1 : -1;
        }

        //returns this instance of MyString.length() if myString is less than the arguments length
        return this.length() < myString.length() ? 1 : -1;
    }

    //12).get(int) method that takes an integer and returns the character at that index location.  
    //PRE:  the integer must be in range 
    //this method returns the char at the index passed.
    public char get(int index) {//O(1) Constant Time
        try { //try catch for IndexOutOfBounds Exception
            return charArr[index]; //tries to return the charArr index at index of the argument passed.
        }
        catch (IndexOutOfBoundsException E) { //throws the index out of bounds exception.
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
    }

    //13a).toUpper() and .toLower() that return a MyString that is in all upper case (or lower case)
    //the following method makes each character in the charArr uppercase.
    public MyString toUpper() {//O(n) Linear Time
        for(int i = 0; i < curr_length; i++) { //loops through index of char array, sets it to its uppercase
            charArr[i] = Character.toUpperCase(charArr[i]);
        }
        return this;
    }

    //13b).toUpper() and .toLower() that return a MyString that is in all upper case (or lower case)
    //this method makes each character in charArr lowercase.
    public MyString toLower() {//O(n) Linear Time
        for(int i = 0; i < curr_length; i++) { //loops through index ofchar array, sets it to its lowercase
            charArr[i] = Character.toLowerCase(charArr[i]);
        }
        return this;
    }

    //14).substring(int) that takes an integer and returns the substring starting at that index
    public MyString substring(int index) {//O(n)
        try {
            MyString tempString = new MyString();
            for(int i = index; i < curr_length; i++)
            {
            	tempString.addChar(charArr[i]);
            }

           return tempString;
        } catch (IndexOutOfBoundsException E) {
            throw new IndexOutOfBoundsException("Out of Bound Exception on Index!");
        }
    }

    //15).substring(int n, int m) .  Return a MyString substring where n is the starting index and m is one past the ending index.
    public MyString substring(int n, int m) {//O(n) Linear Time
        m++;
        try {
            MyString tempString = new MyString();
            for(int i = n; i < m; i++)
            {
            	tempString.addChar(charArr[i]);
            }

            return tempString;
        } catch (IndexOutOfBoundsException E) {
            throw new IndexOutOfBoundsException("Out of Bounds Exception on Index!");
        }
    }

    //16a).indexOf(MyString) and .lastIndexOf(MyString) that take a MyString parameter and return the starting index of the first (or last)
    //occurrence of the MyString in the calling object.  If the parameter is not found in the calling object, the method should return -1.
    public int indexOf(MyString myString) {//O(n^2) Quadratic Time
        try { //try catch statement for returning -1 if there is an exception

            for(int i = 0; i < length() - myString.length() + 1; i++) { //loops through each index of the myString.length
                var checking = true; //boolean for checking where an equal comparison is found

                for(int x = 0; x < myString.length(); x++) {
                    if(charArr[i + x] != myString.charArr[x]) {
                    	checking = false;
                        break;
                    }
                }
                if(checking) {
                    return i; //returns index of the check boolean if it found an equal comparison.
                }
            }
            return - 1;
        }catch (Exception E) {
            return -1;
        }
    }

    //16b)indexOf(MyString) and .lastIndexOf(MyString) that take a MyString parameter and return the starting index of the first (or last)
    //occurrence of the MyString in the calling object.  If the parameter is not found in the calling object, the method should return -1.
    public int lastIndexOf(MyString myString) {//O(n^2) Quadratic Time
        try {
            for(int i = (length() - 1) - myString.length() + 1; i >= 0; i--) { //loops each index of the myString.length
                var check = true; //boolean for checking for equal comparisons

                for(int x = 0; x < myString.length(); x++) {
                    if(charArr[i + x] != myString.charArr[x]) {
                        check = false;
                        break;
                    }
                }
                if(check)
                    return i; //returns i if equal comparison is found
            }
            return - 1; //returns -1
        } catch (Exception E) { //returns -1 if there is an exception
            return  -1;
        }
    }
}