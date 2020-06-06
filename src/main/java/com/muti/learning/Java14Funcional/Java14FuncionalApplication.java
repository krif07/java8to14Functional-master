package com.muti.learning.Java14Funcional;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Java14FuncionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java14FuncionalApplication.class, args);
      final Function<Integer, Integer> multiply2 = x -> x * 2;
      final Function<Integer, Integer> power2 = x -> x * x;
      // With compose, it will do first the function within (power2) and the result will be used for the first function
      // (multiply2) => (4*4)*2 => 32
      System.out.println("Using compose:" + multiply2.compose(power2).apply(4));
      // With compose, it will use the first function (multiply2) and then it will do the function within (power2) =>
      // (4*2)(4*2) => 64
      System.out.println("Using andThen:" + multiply2.andThen(power2).apply(4));
	}

}
