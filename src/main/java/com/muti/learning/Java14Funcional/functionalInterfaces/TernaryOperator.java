package com.muti.learning.Java14Funcional.functionalInterfaces;

@FunctionalInterface
public interface TernaryOperator<T> {
   T apply(T operadorTipoT, T operadorTipoU, T operadorTipoV);
}