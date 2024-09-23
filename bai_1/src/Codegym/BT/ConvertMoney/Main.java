package Codegym.BT.ConvertMoney;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter usd:");
        double inputUsd = new Scanner(System.in).nextDouble();
        System.out.println("VND: " + inputUsd * 23000);
    }
}
