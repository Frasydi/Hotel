package com.example.hotel;

import javafx.application.Platform;

public class Function {
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                Platform.runLater(runnable);
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }
}
