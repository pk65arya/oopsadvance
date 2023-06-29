package com.oops;


import java.util.Random;
import java.util.Scanner;

class Card {
        String suit;
        String rank;

        Card(String cardSuit, String cardRank){
            this.suit = cardSuit;
            this.rank = cardRank;
        }
    }
class Dealer {
    private static final int SIZE = 52;
    private static Card[] deckOfCards = new Card[SIZE];

    static Card[] getDeckOfCards() {

        int count = 0;

        String[] suits = {"Diamonds", "Clubs", "Hearts", "Spades"};
        String[] ranks = {"King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Deuce", "Ace"};

        for (String s : suits) {
            for (String r : ranks) {

                Card card = new Card(s, r);
                deckOfCards[count] = card;
                count++;
            }
        }

        return deckOfCards;

    }

    static Card[] shuffleCards(Card[] deckOfCards) {
        Random rand = new Random();
        int j;
        for (int i = 0; i < SIZE; i++) {
            j = rand.nextInt(SIZE);
            Card temp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[j];
            deckOfCards[j] = temp;
        }
        return deckOfCards;
    }

    static void showCards(Card[] deckOfCards) {
        System.out.println("---------------------------------------------");
        int count = 0;
        for (Card card : deckOfCards) {
            System.out.printf("%s of %s\t", card.rank, card.suit); //use print f with \t (tab character)
            count++;
            if (count % 4 == 0)
                System.out.println();
        }
        System.out.println("---------------------------------------------");
    }

    static Players[] dealCards(Players[] players, Card[] deck) {
        int numOfCardsPerPlayer = deck.length / players.length;
        for (int i = 0; i < deck.length; i++) {
            int positionInHand = i % numOfCardsPerPlayer;
            players[i % players.length].receiveCard(deck[i], positionInHand);
        }

        return players;
    }
}
class Players {

    private String name;
    private Card[] cards = new Card[13];

    Players(String name){
        this.name = name;
    }
    void showPlayerCards(){
        System.out.println("---------------------------------------------");
        for (Card card : cards){
            //you had been checking here if this was null, but there was no need for that check
            System.out.printf("%s  of %s\n", card.rank, card.suit);
        }
        System.out.println("---------------------------------------------");
    }
    void receiveCard(Card card, int position){
        cards[position] = card;
    }
    String getName(){
        return name;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Players[] players = new Players[4];
        Card[] deck = Dealer.getDeckOfCards();

        System.out.println("Un-shuffled Cards.");
        Dealer.showCards(deck);
        Card[] shuffledCards = Dealer.shuffleCards(deck);
        System.out.println("Shuffled Cards.");
        Dealer.showCards(shuffledCards);

        for(int i = 0; i < players.length; i++) {
            System.out.println("Enter Player Name: ");
            players[i] = new Players(input.nextLine());
        }

        Players[] playersWithCards = Dealer.dealCards(players, shuffledCards);

        System.out.println("---------------------------------------------");

        for(Players player : playersWithCards) {
            System.out.println(player.getName());
            player.showPlayerCards();
        }

    }

}

