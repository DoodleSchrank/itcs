import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Give me a number to get it's cubic root:");
        double x = input.nextDouble();
        input.close();
        double y = x / 3;
        double diff = 0.000000001;
        double prevY;
        do {
            prevY = y;
            y = ((2*y) + (x/(y*y))) / 3;
        }     while (Math.abs(y - prevY) > diff);

        System.out.println("The approximate cube root is " + y);

    }
}