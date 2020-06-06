package com.muti.learning.Java14Funcional.javaImprovement;

import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("preview")
public class StringImprovementsPOC {

   final static String queryString = "SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`\n"
         + "WHERE `CITY` = 'INDIANAPOLIS'\n" + "ORDER BY `EMP_ID`, `LAST_NAME`;\n";

   // Java 13: Text Blocks
   final static String rowedQueryString = """
                                          SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
                                          WHERE `CITY` = 'INDIANAPOLIS'
                                          ORDER BY `EMP_ID`, `LAST_NAME`;
                                          """;

   public static void main(final String[] args) {
      System.out.println(queryString);
      System.out.println("------------------------------");
      System.out.println(rowedQueryString);
      System.out.println("------------------------------");
      
      // Java 11: String API updates and improvements
      System.out.println(rowedQueryString.indent(3));
      System.out.println("------------------------------");
      AtomicInteger counter = new AtomicInteger(0);
      rowedQueryString.lines().map(x -> (counter.addAndGet(1)) + "." + x).forEach(System.out::println);
      System.out.println("------------------------------");

      final String transformedHelloWorld = "hello".transform(input -> input + " world!");
      System.out.println(transformedHelloWorld.repeat(4));
      System.out.println(transformedHelloWorld.repeat(0).isBlank());
      System.out.println(transformedHelloWorld.indent(2));
      System.out.println(transformedHelloWorld.indent(2).strip());

   }

}
