import java.io.*;
import java.util.*;

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

            System.out.println(countDucks(numbers, 50)); // number of ducks after 50 months
            System.out.println(countDucks(numbers, 100)); // number of ducks after 100 months
        } catch (IOException e) {
            System.err.println("Error to read the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Wrong number format: " + e.getMessage());
        }
    }

    public static int countDucks(int[] state, int months) {
        int[] states = new int[9];
        Arrays.stream(state).forEach(s -> states[s]++);

        for(int month = 0; month < months; month++) {
            int breeding = states[0];
            for(int s = 1; s < states.length; s++) {
                states[s - 1] = states[s];
            }
            // new ducklings
            states[states.length - 1] = breeding;
            // old ducklings
            states[5] += breeding;
        }
        return Arrays.stream(states).sum();
    }
}
