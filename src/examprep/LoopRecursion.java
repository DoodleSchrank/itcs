package examprep;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class LoopRecursion {

    public static <T> T TailRecursion(
            BiFunction<T, Integer, T> f,
            T input,
            int counter,
            int to) {

        if (counter > to) return input;

        return f.apply(
                TailRecursion(f, input, counter + 1, to),
                counter
        );

    }

    public static <T> T Recursion(
            BiFunction<T, Integer, T> f,
            T input,
            int counter,
            int to) {

        if (counter > to) return input;

        var result = f.apply(input, counter);

        return Recursion(f, result, counter + 1, to);
    }

    public static <T> T ForLoop(BiFunction<T, Integer, T> f, T input, int counter, int to) {

        T result = input;

        for(; counter <= to; counter++) {

            result = f.apply(result, counter);

        }

        return result;
    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (Integer a, Integer b) -> {
            return a + b;
        };

        var tailRec =   TailRecursion(  add, 0, 0, 5);
        var rec =       Recursion(      add, 0, 0, 5);
        var loop =      ForLoop(        add, 0, 0, 5);

        System.out.printf("tail: %d vs rec: %d vs loop: %d%n%n%n", tailRec, rec, loop);



        BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>> append = (ArrayList<Integer> a, Integer b) -> {
            a.add(b);
            return a;
        };

        var tailRec2 =   TailRecursion(  append, new ArrayList<>(), 0, 5);
        var rec2 =       Recursion(      append, new ArrayList<>(), 0, 5);
        var loop2 =      ForLoop(        append, new ArrayList<>(), 0, 5);

        System.out.printf("tail: %s vs %nrec:  %s vs %nloop: %s%n", tailRec2.toString(), rec2.toString(), loop2.toString());
    }

}
