package com.muti.learning.Java14Funcional.javaImprovement;

import java.util.function.Function;
import java.util.stream.Stream;

@SuppressWarnings("preview")
public class SwitchImprovedPOC {
   
   
   
   final static Function <SwitchShapesEnum, String> printNumberOfSides = x -> x + ":" + numeroDeLados(x); 
   
   final static Function <SwitchShapesEnum, String> printImprovedNumberOfSides = x -> x + ":" + numeroDeLadosMejorado(x); 
   
   
   public static void main(final String[] args) {
      
      System.out.println("----------------Normal Switch----------------------");
      Stream.of(SwitchShapesEnum.values()).map(printNumberOfSides).forEach(System.out::println);
      System.out.println("----------------Java 12+ Switch----------------------");
      Stream.of(SwitchShapesEnum.values()).map(printImprovedNumberOfSides).forEach(System.out::println);

      
      
   }
   
   
   
   
   public static int numeroDeLados(final SwitchShapesEnum poligono) {
      int sides = 0;
      switch (poligono) {
         case TRIANGLE: sides =  3; break;
         case RECTANGLE: 
         case SQUARE: 
         case RHOMBUS: 
         case KITE:
         case TRAPEZIUM: 
            sides =  4; break;
         case PENAGON: 
            sides =  5; break;
         case HEXAGON: 
            sides =  6; break;
         default:
            sides = 0;
      }
      return sides;
   }   
   
   
   public static  int numeroDeLadosMejorado(final SwitchShapesEnum poligono) {
      //JAVA 12: Switch Expressions (using a simplified notation similar that the one with lambdas)
      return 
      switch (poligono) {
         case TRIANGLE -> 3; 
         case RECTANGLE, SQUARE, RHOMBUS, TRAPEZIUM, KITE ->  4; 
         case PENAGON ->  5; 
         case HEXAGON ->  6; 
         default -> throw new IllegalStateException("Invalid shape");
      };
   }
   
   

}
