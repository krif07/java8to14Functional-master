package com.muti.learning.Java14Funcional.functionalInterfaces;

@FunctionalInterface
public interface Trifunction<T, U, V, W> {
   W apply(T operadorTipoT, U operadorTipoU, V operadorTipoV) throws Exception;
}