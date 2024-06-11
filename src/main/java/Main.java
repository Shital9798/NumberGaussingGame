import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    // User character initialization
    
    String userName = "Brave Adventurer";
    int userHealth = 100;
    int userIntelligence = 50;

    // Treasure chest contents
    
    String[] treasureChestContents = { "Golden Coin", "Magic Amulet", "Ancient Scroll", "Mysterious Potion" };

    // Welcome message
    
    System.out.println("Welcome to Simple Treasure Hunt!");
    System.out.println("You are " + userName + ".");
    System.out.println("Your health: " + userHealth + ", Intelligence: " + userIntelligence);

    // Generate secret number outside the loop
    
    int secretNumber = rand.nextInt(50) + 1;

    // Loop until the user finds the treasure or quits
    
    while (true) {
      System.out.print("Enter your guess (1-50): ");
      int userGuess = scanner.nextInt();

      if (userGuess == secretNumber) {
        System.out.println("Congratulations! You found the treasure!");
        System.out.println("The correct answer was " + secretNumber);

        // Display and choose treasure
        
        System.out.println("You open the treasure chest and find:");
        for (int i = 0; i < treasureChestContents.length; i++) {
          System.out.println((i + 1) + ". " + treasureChestContents[i]);
        }
        
        System.out.print("Which item do you want to take? (1-4): ");
        int itemChoice = scanner.nextInt();
        String chosenItem = treasureChestContents[itemChoice - 1];
        System.out.println("You take the " + chosenItem + ".");

        // Apply effects and print the increase message
        
        if (chosenItem.equals("Golden Coin")) {
          userHealth += 20;
          System.out.println("Your health increases by 20.");
        } else if (chosenItem.equals("Magic Amulet")) {
          userIntelligence += 10;
          System.out.println("Your intelligence increases by 10.");
        } else if (chosenItem.equals("Mysterious Potion")) {
          userHealth += 10;
          System.out.println("Your health increases by 10.");
        }

        
        System.out.println("Your health is now " + userHealth + ", Intelligence is now " + userIntelligence);
        break;

        
      } else if (userGuess < secretNumber) {
        System.out.println("You're just grazing the surface of the treasure! Aim a bit higher!");
      } else {
        System.out.println("You're reaching for the stars! But the treasure is still out of reach. Aim a bit lower!");
      }

      System.out.print("Do you want to quit? (1) Yes, (2) No: ");
      int quitChoice = scanner.nextInt();
      if (quitChoice == 1) {
        System.out.println("You decide to quit. Better luck next time!");
        break;
      }
    }

    // Farewell message
    
    System.out.println("Thanks for playing Simple Treasure Hunt!");
  }
}
