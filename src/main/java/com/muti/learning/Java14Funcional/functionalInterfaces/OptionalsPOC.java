package com.muti.learning.Java14Funcional.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class OptionalsPOC {


   
   public static final Consumer<String> charactersPrint = x -> System.out.print(x+"::Numero de Caracteres:"+x.length()+"--------------");
   
   public static void main(final String[] args) {

      final String names[] = { "Ali", null, "Xhi", null };
      List<Optional<String>> nameListWithNulls = new ArrayList<>();
      
      for (String name : names) {
         nameListWithNulls.add(mvpOptionalName(name));
      }
      
      for (Optional<String> optional : nameListWithNulls) {
         String uppercase = null;
         uppercase = optional.orElse("\nEsto es Nulo!").toUpperCase();
         System.out.println(uppercase);
         optional.ifPresent(charactersPrint);
      }
   }
   
   public static Optional<String> mvpOptionalName(final String name) {
      return Optional.of(name);
   }
   
   

}
