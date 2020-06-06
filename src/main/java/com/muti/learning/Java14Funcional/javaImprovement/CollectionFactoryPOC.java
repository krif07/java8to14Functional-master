package com.muti.learning.Java14Funcional.javaImprovement;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFactoryPOC {

   public static void main(String[] args) {
      Set<Object> set = new HashSet<>();
      set.add("a");
      set.add("b");
      set.add("c");
      set = Collections.unmodifiableSet(set);
      printCollection(set);
      // Java 9: Factory methods for collections to create compact, unmodifiable collection instances
      printCollection(Set.of("d", "e", "f", "g"));
      printCollection(List.of("h","i","j"));
      printCollection(Map.of("llave1","valor1","llave2","valor2"));

   }
   
   
   
   public static void printCollection(final Collection<Object> collection) {
      collection.stream().forEach(System.out::println);
   }
   
   public static void printCollection(final Map<Object,Object> collection) {
      collection.forEach( (x,y) -> System.out.println(x+","+y));
   }
   
}
