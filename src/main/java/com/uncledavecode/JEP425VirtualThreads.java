package com.uncledavecode;

import java.time.Duration;
import java.time.Instant;

public class JEP425VirtualThreads {

    //JEP 425 - Virtual Threads (Preview)
    //https://openjdk.java.net/jeps/425

    public static void main(String... args) {
        JEP425VirtualThreads jep425VirtualThreads = new JEP425VirtualThreads();
        jep425VirtualThreads.platformThreads();
        jep425VirtualThreads.virtualThreads();
    }

    public void platformThreads() {
        final Instant start = Instant.now();
        for (int i = 0; i < 50_000; i++) {
            if (i % 10_000 == 0) {
                System.out.println(i);
            }
            new Thread(() -> {
                try {
                    Thread.sleep(5_000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println("Platform threads");
        printReadableDate(Duration.between(start, Instant.now()));
    }

    public  void virtualThreads(){
        final Instant start = Instant.now();
        for (int i = 0; i < 50_000; i++) {
            if (i % 10_000 == 0) {
                System.out.println(i);
            }
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(5_000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println("Virtual threads");
        printReadableDate(Duration.between(start, Instant.now()));
    }

    private void printReadableDate(Duration duration) {
        long seconds = duration.getSeconds() % 60;
        long millis = duration.toMillis() % 1000;
        System.out.println(String.format("Time:  %d seconds, %d milliseconds", seconds, millis));
    }
}
