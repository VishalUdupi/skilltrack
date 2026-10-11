package com.skilltrack.utils;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static double readDouble(String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter a decimal number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static String readString(String message) {
        System.out.print(message);
        return scanner.next();
    }

    public static String readLine(String message) {
        System.out.print(message);
        scanner.nextLine(); // Clear buffer
        return scanner.nextLine();
    }
}