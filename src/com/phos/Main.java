package com.phos;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEARS = 12;
        final byte PERCENT = 100;

        //principal
        System.out.print("Principal: ");
        Scanner scanner = new Scanner(System.in);
        int principal = scanner.nextInt();

        // annual interest rate
        System.out.print("Annual Interest Rate: ");
        Double rate = scanner.nextDouble();

        // calculates the monthly interest rate
        Double monthlyRate = rate / (MONTHS_IN_YEARS * PERCENT);

        // Period in years
        System.out.print("Period (years): ");
        Double period = scanner.nextDouble();
        // calculates the period in months
        Double monthlyPeriod = period * MONTHS_IN_YEARS;

        // calculates the (1 + r) ^ n
        Double power = Math.pow((1 + monthlyRate),monthlyPeriod);

        Double mortgage = principal * ((monthlyRate * power)/(power - 1));

        String currency = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: "+ currency);

    }
}