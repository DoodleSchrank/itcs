import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HappyNumber {
    private static final Function<Integer, Integer> sumHappyIntegers = n ->
            Stream.iterate(n, x -> x > 0, x -> x / 10)
                    .map(x -> (x % 10) * (x % 10))
                    .mapToInt(Integer::intValue)
                    .sum();

    public static boolean isHappy(int n) {
        final var sum =
                Stream.iterate(n, nstep -> nstep > 0, nstep -> nstep / 10)
                .map(nstep -> (nstep * nstep) % 10)
                .mapToInt(Integer::intValue)
                .sum();
        //final var sum = Integer.toString(n).chars().map(c -> c - '0').map(i -> i * i).sum();
        return sum == 1 || sum != 4 && isHappy(sum);
    }
    public static int nextHappyNumber(int n) {
        while(!isHappy(n++));
        return --n;
    }

    public static void main(String[] args) {
        final int input = 185123;
        System.out.println(nextHappyNumber(input));
    }
}