package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("           --Welcome to BlackJACK --          ");
        System.out.println("--The better the gambler, the worse the man.--");

        System.out.print("Enter number of players: ");
        int playerCount = Integer.parseInt(scanner.nextLine());
        ArrayList<String> playerNames = new ArrayList<>();
        ArrayList<Hand> hands = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            playerNames.add(name);
            hands.add(new Hand());
        }

        Deck deck = new Deck();
        deck.shuffle();

        // Deal 2 cards to each player
        for (int i = 0; i < 2; i++) {
            for (Hand hand : hands) {
                hand.deal((deck.deal()));
            }
        }

        // Display each hand and determine the winner
        int highest = 0;
        String winner = "";
        ArrayList<String> topScorers = new ArrayList<>();

        for (int i = 0; i < hands.size(); i++) {
            String name = playerNames.get(i);
            Hand hand = hands.get(i);
            int value = hand.getValue();
            System.out.println(name + "'s hand: " + hand.displayHand() + " => Value: " + value);

           /* if (value > highest && value <= 21) {
                highest = value;
                winner = name;
            }*/
            if (value > highest && value <= 21) {
                highest = value;
                topScorers.clear();
                topScorers.add(name);
            } else if (value == highest && value <= 21) {
                topScorers.add(name);
            }
        }

        /*if (!winner.isEmpty()) {
            System.out.println("Winner is: " + winner + " with a hand value of " + highest);
        } else {
            System.out.println("No winner. All players busted.");
        }*/
        if (topScorers.size() == 1) {
            System.out.println("Winner is: " + topScorers.get(0) + " with a hand value of " + highest);
        } else if (topScorers.size() > 1) {
            System.out.println("Push! Players " + topScorers + " tied. Dealer wins.");
        } else {
            System.out.println("No winner. All players busted.");
        }
    }
}
