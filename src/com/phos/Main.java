package com.phos;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEARS = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        // initializers
        int principal = 0;
        float rate = 0.0F;
        byte period =0;

        //principal
        while(true){
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter an amount between 1000 and 1,000,000");
        }

        // annual interest rate
        while  (true){
            System.out.print("Annual Interest Rate: ");
            rate = scanner.nextFloat();
            if (rate >= 1 && rate <= 30)
                break;
            System.out.println("Enter a value greater than 0 and less  than 31");
        }


        // calculates the monthly interest rate
        Float monthlyRate = rate / (MONTHS_IN_YEARS * PERCENT);

        // Period in years
        while(true){
            System.out.print("Period (years): ");
            period = scanner.nextByte();
            if(period >= 1 && period <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        // calculates the period in months
        int monthlyPeriod = period * MONTHS_IN_YEARS;

        // calculates the (1 + r) ^ n
        Double power = Math.pow((1 + monthlyRate),monthlyPeriod);

        Double mortgage = principal * ((monthlyRate * power)/(power - 1));

        String currency = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: "+ currency);

    }
}