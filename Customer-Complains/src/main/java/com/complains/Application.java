package com.complains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Application {


  public static void main(String... args) {
    System.out.println("Email List:");
    try{
      File file = new File("src/main/resources/emailList.txt");
      Scanner reader = new Scanner(file);
      while(reader.hasNextLine()){
        String data = reader.nextLine();
        System.out.println(data);
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred");
      e.printStackTrace();
    }
    SpringApplication.run(Application.class, args);

  }



}