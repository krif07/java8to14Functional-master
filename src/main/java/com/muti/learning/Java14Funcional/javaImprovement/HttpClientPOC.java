package com.muti.learning.Java14Funcional.javaImprovement;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientPOC {

   // Java 11 - HttpClient class to sent HTTP request and get their responses
   public static void main(final String[] args) throws IOException, InterruptedException {
      
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://restcountries-v1.p.rapidapi.com/all"))
            .header("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
            .header("x-rapidapi-key", "5878766664msh7f7e7fe3a427361p166e35jsn524a74b4d3b3")
            .build();
      
      
      client.sendAsync(request, BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println)
            .join();
      
      
//      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
//      System.out.println(response.statusCode());
//      System.out.println(response.body());
   }

}
