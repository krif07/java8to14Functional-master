package com.muti.learning.Java14Funcional.functionalInterfaces;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceStreamsPOC {

   public static void main(final String[] args) {

//      mapChainStream();
//      reduceStream();
//      intStreamLimit();
//      peekAndReduceSeries();
//      sumOfFirstNNumbers(10);
//      reduceOperators();

   }

   private static void mapChainStream() {
      final String names[] = { "Uno", "Dos", "Ultraviolento", "Y AHORA QUE PASA?", "UNO" };
      final Stream<String> streamNames = Stream.of(names);
      // Final operations return an object, even a Void object as the case of forEach
      streamNames.map(name -> name + "!!").filter(name -> name.contains("U")).forEach(System.out::println);

      // Streams cannot be operated more than one time. Chaining is recommended.
      //      final Stream<String> emphasisStream = streamNames.map(name -> name + "!!");
      //      emphasisStream.forEach(name -> System.out.println(name));
   }

   private static void reduceStream() {
      // Streams can also be created adding the elements as an array
      final Stream<String> aLongStoryStream = Stream.of("Cuando", null, "el", "dinosaurio", "todavía", "estaba",
            "allí.");
      // Reduce operation in this case applies a Binary Accumulator between the accumulated element and the next element
      // on the stream until just one element is left.
      final Optional<String> longStoryOptional = aLongStoryStream
            .reduce((previousStory, nextPart) -> previousStory + " " + nextPart);
      longStoryOptional.ifPresent(System.out::println);
   }

   private static void peekAndReduceSeries() {
      // Not adding a limit when an iterate is created will make the execution keeps adding elements infinitely
      final Stream<Double> convergentSeriesHalfs = Stream.iterate(0.0, x -> 1 / Math.pow(2, x));
      final Optional<Double> sumOfInfinity = convergentSeriesHalfs.limit(1000).peek(System.out::println)
            .reduce((a, x) -> a + x);
      sumOfInfinity.ifPresent(System.out::println);
   }

   private static void sumOfFirstNNumbers(final int limit) {
      final Stream<Integer> firstTenNumbersStream = Stream.iterate(0, i -> i + 1).limit(limit);
      final int sumOfFirstTen = firstTenNumbersStream.reduce(-45, Integer::sum);// 90 + sum(0...10)
      System.out.println(sumOfFirstTen);
   }

   private static void reduceOperators() {
      // Another type of reduction can be done with a binaryFunction and a BinaryOperator that first will map each
      // element and then will accumulate the values in a single result
      final Stream<String> aLongStoryStreamAgain = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía",
            "estaba", "allí.");
      final int charCount = aLongStoryStreamAgain.filter(name -> name.contains("u")).reduce(0, (count, word) -> count + word.length(), Integer::sum);
      System.out.println(charCount);
   }

   private static void intStreamLimit() {
      // IntStream is an obligatory class when defining a Stream of Integers
      // Using .iterate will fill the stream with items that follow the function
      final IntStream infinityStream = IntStream.iterate(0, x -> x + 1);
      // ... until a limit is defined
      // Also, the parallel method will allow the stream to operate in threads, which in this case will print the
      // elements almost randomly
      infinityStream.limit(1000).parallel().filter(x -> x % 9 == 0).forEach(System.out::println);
   }

}
