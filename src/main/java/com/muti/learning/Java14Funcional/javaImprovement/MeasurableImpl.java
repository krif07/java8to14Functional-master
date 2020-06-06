package com.muti.learning.Java14Funcional.javaImprovement;

public class MeasurableImpl implements Measurable {

   public static void main(final String[] args) {
      final Measurable s = new MeasurableImpl();
      s.calculatePerimeter(2);
   }
   
   
   public void saySomething() {
      System.out.println("Hola, soy un metodo privado");
   }
}
