/* @file BinaryToDecimalLoop.java
@brief Using loops for binary to decimal conversion.
@author Sara Barker
@date 10/9/2018 */

    import java.util.Scanner;
    import java.util.regex.Pattern;

    public class BinaryToDecimalLoop {
        public static void main(String[] args) {
            Scanner frodo = new Scanner(System.in);
            String input;
            int i;
            int j = 0;
            System.out.print("Enter a binary number (of up to 63 bits): ");
            input = frodo.next();   // User enters the number as a string

            // Detect if input is anything but 0s and 1s
            // If that's the case then terminate the program inside the if statement
            if (Pattern.matches("[01]*", input) == false) {
                System.out.println("Wrong input");
                System.exit(0);
            }

            // Input contains 0s and 1s so now turn it into an array of ints
            int[] binNum = new int[input.length()]; // Length of array should be the same as that of input
            for(i = 0; i < input.length(); i++) {

                // input.charAt(i) returns the char ('0' or '1') at position i in the string
                // chars are stored as 16-bit numbers. '0' is stored as number 48 and interpreted as 'O'
                // when displayed in the screen
                // input.charAt(i) - '0' gives 0 or 1 which is then stored as a regular int in binNum[i]
                binNum[i] = input.charAt(i) - '0';
            }

            // Type long is an integer of 64 bits instead of 32. Use it to store the decimal representation
            // of the binary number
            long decNum = 0;

            // The loops that converts the binary to a decimal, using arrays
            for (i = binNum.length-1; i > -1; i--) {
            decNum = decNum + binNum[i] * (long) Math.pow(2,j);
            j++;
            }

            System.out.println("Your number is " + decNum);
        }
    }

