package test;

import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;

import main.akane.Akane;

public class TestRun {
    public static final String exitCommand = "exit";
    public static void main(String[] args){
        System.out.println("TEST START!!!");
        Akane akaneInstance = Akane.getInstance();
        Scanner sc = new Scanner(System.in);
        String sendWord;        
        do{
            sendWord = sc.nextLine();
            try {
				System.out.println(akaneInstance.toSay(sendWord));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
        }while(!(sendWord.equals(exitCommand)));
        System.out.println("Akane is sleeping.....zzz");
    }
}
