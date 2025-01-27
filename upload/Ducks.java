package ting;

import java.io.*;

public class Ducks {

    public static void main(String[] args) {
        // TODO: Simulate and output the number of ducks after 50 and 100 months!

        // read file ducks
        String filePath = "ducks";
        try {
            // Read the content in ducks
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine(); // file ducks only has one line
            br.close();

            // split string
            String[] stringNumbers = line.split(",");

            // convert into integer array
            int[] numbers = new int[stringNumbers.length];
            for (int i = 0; i < stringNumbers.length; i++) {
                numbers[i] = Integer.parseInt(stringNumbers[i].trim()); // remove space and convert into integer
            }

            // print the result
            // System.out.println("Integer array: " + Arrays.toString(numbers));

            // NOTE: These numbers -- each in one line -- are
            //       THE ONLY output to System.out!
            int[] test = {1, 2, 5};

            System.out.println(DuckCounter(numbers, 50)); // number of ducks after 50 months
            System.out.println(DuckCounter(numbers, 100)); // number of ducks after 100 months
        } catch (IOException e) {
            System.err.println("Error to read the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Wrong number format: " + e.getMessage());
        }
    }

    // sum of the original ducks, the children of each duck, and the children of each children and so on
    public static int DuckCounter(int[] initialState, int month) {
        int count = initialState.length;
        for (int oneDuck : initialState) {
            count += DucklingCounter(oneDuck, month);
        }
        return count;
    }

    // Count the children of each original duck, and the children of each children and so on
    public static int DucklingCounter(int oneDuck, int month) {
        int count = 0;
        // base case, no child
        if (oneDuck >= month) {
            return 0;
        } else {
            count++; // add the first child of the original duck
            month = month - oneDuck - 1; // the rest month while original duck(5), with a new duck(8)
            count += DucklingCounter(8, month);
            // for the rest child of the original duck, add itself and the children of it
            for (int i = 0; i < month / 6; i++) {
                count++; // add the child of the original duck
                count += DucklingCounter(8, month - 6); // add the child of the child
            }
            return count;
        }
    }
}
