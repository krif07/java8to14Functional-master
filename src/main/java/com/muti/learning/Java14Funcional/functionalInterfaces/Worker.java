package com.muti.learning.Java14Funcional.functionalInterfaces;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Worker {
   private String Id;
   private List<String> skills;
}