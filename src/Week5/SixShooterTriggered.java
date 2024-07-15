package Week5;

import java.util.Scanner;

public class SixShooterTriggered {

    // Recursive method to simulate shooting the gun with limited ammo
    public static void shootGun(int currentShot, int bulletsLeft, Scanner scanner) {
        if (bulletsLeft <= 0) {
            System.out.println("Out of Ammo! Exiting.");
            return;
        }

        if (currentShot > 6) {
            System.out.println("You've shot 6 times. Reload by pressing 'r' or type 'quit' to exit.");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("r")) {
                shootGun(1, bulletsLeft, scanner); // Reload and continue with remaining bullets
            } else if (input.equals("quit")) {
                System.out.println("Exiting.");
                return; // Exit
            } else {
                System.out.println("Invalid command. Exiting.");
                return;
            }
        }

        System.out.println("Press 'enter' to fire shot " + currentShot + ". Bullets left: " + bulletsLeft);
        scanner.nextLine(); // Wait for user to press enter to fire the next shot
        System.out.println("Bang! Shot " + currentShot);
        shootGun(currentShot + 1, bulletsLeft - 1, scanner); // Recursive call, increment shot count, decrease bullet count
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalBullets = 24; // Total bullets available
            System.out.println("Ready to fire! You have " + totalBullets + " bullets.");
            shootGun(1, totalBullets, scanner); // Start the recursive function with the first shot
        }
    }
}
