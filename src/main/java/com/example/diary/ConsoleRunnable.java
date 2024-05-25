package com.example.diary;

import java.util.Scanner;

public class ConsoleRunnable implements Runnable {

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("exitでアプリケーションを終了します");
                String input = scanner.nextLine();
                if (input.equals("exit")) {
                    System.out.println("アプリケーションを終了します");
                    System.exit(0);
                }
            }
        }
        catch(Exception e){
            System.out.print("コンソールエラー");
        }
    }
    
}
