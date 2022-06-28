/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author filog
 */
public class Game {
    Player arr_player[]=new Player[4]; // for Player 
    Card cardDeck []= new Card[52];
    static int highScore ;

    void generate_Cards (){
        int place =0;
        for(int s = 0;s < 4;s++)
        {
            int value =1;
            for(int r = 0;r<13;r++){
                if(r<10){
                    
                    cardDeck[place]=new Card(s,r,value);
                    value++;
                }
                else{
                    value = 10;
                    cardDeck[place]=new Card(s,r,value);
                }
                place++;
            }
        }
    }
    Card rand_card(){              // Give one card
        Random rand = new Random();
        int random_card_choice = rand.nextInt(52);
        while(true){
            if(cardDeck[random_card_choice] == null){
               random_card_choice = rand.nextInt(52) ;
            }
            else 
                break;
        }
        Card temprary = cardDeck[random_card_choice];
        cardDeck[random_card_choice]=null;
        return temprary;
    }
    void Start(){
        Scanner input = new Scanner(System.in);
        for(int i=0;i<4;i++){           // take Names
            System.out.print(" Enter player "+ (i+1) +" Name : ");
            arr_player[i]=new Player();
            arr_player[i].Name= input.nextLine();
        }
        for(int i=0;i<4;i++){          // draw 2 cards
            arr_player[i].arr_card_obj[0]=rand_card();
            arr_player[i].arr_card_obj[1]=rand_card();
           
        }
    }
    void Calc_Score(Player existing_player_Score){
        existing_player_Score.Score=0;
        for(int i=0;i<11;i++){
            if(existing_player_Score.arr_card_obj[i] == null)
                break;
            else
                existing_player_Score.Score+=existing_player_Score.arr_card_obj[i].getValue();
        }                
    }
    void Max_Score(Player existing_player_game){
       int max_Value=21;
       if(existing_player_game.Score > highScore && existing_player_game.Score <=max_Value){
        highScore = existing_player_game.Score;
  } 
    }
    
}

