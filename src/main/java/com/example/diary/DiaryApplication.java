package com.example.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiaryApplication.class, args);
		
		Runnable consoleRunnable = new ConsoleRunnable();
		Thread consoleThread = new Thread(consoleRunnable);
		consoleThread.start();
	}

}
