package com.muti.learning.Java14Funcional.javaImprovement;


//Java 8 & 9: Default and Private interface methods
public interface Measurable {

   default float calculatePerimeter(int side) {
      saySomething();
      sayPolitely();
      return side * side;
   }

   // Private method inside interface
   default void saySomething() {
      System.out.println("Hello... I'm private method");
   }

   // Private static method inside interface
   private static void sayPolitely() {
      System.out.println("I'm private static method");
   }
}

