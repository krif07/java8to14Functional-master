package com.muti.learning.Java14Funcional.functionalInterfaces;

import java.util.ArrayList;
import java.util.function.Function;

@SuppressWarnings("preview")
public class InferenceTypePOC {
   //Java 11 - var usage for Lambda Parameters
   final Function<String,Integer> countChar = (var x) -> x.chars().reduce(0, Integer::sum);
   
   public static void main(final String[] args) {
      //Java 10 - Local Variable Type inference 
      var unaLista = new ArrayList<Object>();
      unaLista.add("Primero");
      unaLista.add("Segundo");
      unaLista.add("Tercero");
      var unStream = unaLista.stream();
      var unNumero = 25;
      
      System.out.println(notBlankString(unNumero));
      System.out.println(notBlankString(unStream));
      System.out.println(notBlankString(unStream.findFirst().get()));
      System.out.println(notBlankString(unaLista));
      System.out.println(notBlankString(unaLista.get(0)));
   }
   
   public static boolean notBlankString(Object o) {
      //Java 14 - Pattern Matching for Instance Of operator
      return (o instanceof String s) && !s.isBlank();
   }
}
