package Week5;

import java.util.Scanner;

public class DonationTracker {
    public static void donationGoal(int moneyGoal, int moneyRaised) {
        System.out.println("How much money has been raised today?");
        Scanner scn = new Scanner(System.in);
        moneyRaised = scn.nextInt() + moneyRaised;
        System.out.println("Total Raised: " + moneyRaised);

        if (moneyGoal <= moneyRaised) {
            System.out.println("The goal has been reached. Thank you for donating.");
        } else {
            donationGoal(moneyGoal, moneyRaised);
        }
    }

    public static void main(String[] args) {
        System.out.println("Please input the amount you would like to raise:");
        Scanner scn = new Scanner(System.in);
        int moneyGoal = scn.nextInt();
        donationGoal(moneyGoal, 0);
    }
}

