package homeWork17;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sandbox {
    public static void main(String[] args) {
        Integer uneven = IntStream
                .range(1, 4)
                .filter(n -> n % 2 != 0)
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(uneven);
        List<Integer> collection = Arrays.asList(1, 2, 3, 4, 5);
        Integer odd = collection.stream()
                .filter(p -> p % 2 != 0)
                .reduce((c1, c2) -> c1 + c2)
                .orElse(0);
        System.out.println(odd);
        Stream.generate(new Random()::nextInt/*() -> new Random().nextInt(30)*/)
                .limit(5)
                .forEach(System.out::println);
        Stream.iterate(0, e -> e - 1)
                .limit(5)
                .forEach(System.out::println);
        Collections.shuffle(collection);
        System.out.println(collection);
        System.out.println(collection = collection.stream()
                .sorted()
                .collect(Collectors.toList()));
        Collections.shuffle(collection);
        System.out.println(collection);
        System.out.println(collection.stream()
                .sorted()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining(" ")));
        System.out.println(collection.stream().findFirst().orElse(0));
        System.out.println(collection.stream().max(Integer::compare).get());
        System.out.println(Arrays.toString(collection.stream().skip(2).limit(2).toArray()));
        System.out.println();
    }
}