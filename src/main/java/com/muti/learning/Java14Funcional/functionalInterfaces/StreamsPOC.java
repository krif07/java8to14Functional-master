package com.muti.learning.Java14Funcional.functionalInterfaces;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPOC {
   
   final static Supplier<Integer> intRandomGenerator = () -> {
      Random rand = new Random();
      return rand.nextInt(20);
   };

   public static void main(final String[] args) {

      final List<Worker> workers = workerBuilder(5);
      workers.stream().forEach(System.out::println);
      // FlatMap can take every list with the objects of an stream and make all of those elements into a single list
      // Requires a Function<Worker, Stream<T>> 
      final Optional<String> allSkills = workers.stream()
            .flatMap(worker -> worker.getSkills().stream())
            .reduce((x, y) -> x + "," + y);
      allSkills.ifPresent(System.out::println);
   }

   public static List<Worker> workerBuilder(final int amount) {
      return Stream.iterate(1, x -> x + 1)
            .limit(amount)
            .map(x -> Worker.builder().Id(x + "").skills(addElements(x)).build())
            .collect(Collectors.toList());
   }

   public static List<String> addElements(final int amount) {
      final Function<Integer, String> intToAscii = x -> (char) x.intValue() + "-Skill";
      return Stream.iterate(100+intRandomGenerator.get(), x -> x + 1)
            .limit(amount)
            .map(intToAscii::apply)
            .collect(Collectors.toList());
   }

}
