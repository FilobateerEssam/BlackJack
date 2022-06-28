/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author filog
 */
public class BlackJack {
    
    Game main = new Game();
    void Dellar(GUI gui){
        boolean trace = true;
        int hit_counter_dellar=2;
        main.Calc_Score(main.arr_player[3]);
        System.out.println("Score of "+main.arr_player[3].Name+" is : "+main.arr_player[3].Score);
        while(trace){
            if(Game.highScore > main.arr_player[3].Score){
                 main.arr_player[3].arr_card_obj[hit_counter_dellar] = main.rand_card();
                 gui.updateDealerHand(main.arr_player[3].arr_card_obj[hit_counter_dellar], main.cardDeck);
                 main.Calc_Score(main.arr_player[3]);
                 hit_counter_dellar++;
           }
            else if (main.arr_player[3].Score == 21){
                System.out.println("Player "+main.arr_player[3].Name+" is a blackJack");
                trace = false;
            }
            else if (main.arr_player[3].Score > 21){
                System.out.println("Player "+main.arr_player[3].Name+" is a Busted");
                trace = false;
            }
            else
                trace = false;

            
        }
        main.Max_Score(main.arr_player[3]);
    }
    void Status_Player(){
       int Counter_Winner =0;
       for(int i=0;i<4;i++){
           if(Game.highScore == main.arr_player[i].Score)
                Counter_Winner++;
       }
       if(Counter_Winner >1)
            System.out.println("Push");
       
       else if(Counter_Winner == 1)
           for(int i=0;i<4;i++){
               if(Game.highScore ==main.arr_player[i].Score)
                   System.out.println("Winner is "+main.arr_player[i].Name);
           }
               
           
       
    }
     
    public static void main(String[] args) {
        GUI gui = new GUI();
        BlackJack opj = new BlackJack();
        opj.main.generate_Cards();
        opj.main.Start();
        gui.runGUI(opj.main.cardDeck,opj.main.arr_player[0].arr_card_obj,opj.main.arr_player[1].arr_card_obj,opj.main.arr_player[2].arr_card_obj,opj.main.arr_player[3].arr_card_obj);
        int choice;
        Scanner input = new  Scanner(System.in);
            for(int i =0;i<3;i++)
            {
                 int hit_counter = 2;
                 boolean while_opj=true;
                 opj.main.Calc_Score(opj.main.arr_player[i]);
                while(while_opj ==true){
                    System.out.println("Score of "+opj.main.arr_player[i].Name+" is : "+opj.main.arr_player[i].Score);
                    if(opj.main.arr_player[i].Score>21){
                        System.out.println("Player "+opj.main.arr_player[i].Name+" is Busted ");
                        while_opj =false;
                        break;
                   }
                    
                     System.out.println("Do you want to hit \' 1 \' or Stand \' 2 \' : ");
                     choice = input.nextInt();
                     if(choice==1){
                         
                         opj.main.arr_player[i].arr_card_obj[hit_counter] = opj.main.rand_card();
                         gui.updatePlayerHand(opj.main.arr_player[i].arr_card_obj[hit_counter], i);
                         opj.main.Calc_Score(opj.main.arr_player[i]);
                         hit_counter++;
                }
                else if (choice==2)
                    while_opj=false;
                     
                if(opj.main.arr_player[i].Score==21){
                        System.out.println("Player "+opj.main.arr_player[i].Name+" is BlackJack ");
                        while_opj =false;
                        break;
                   }     
            }
             opj.main.Max_Score(opj.main.arr_player[i]);
               
                
        }
            opj.Dellar(gui);
            opj.Status_Player(); 
    }
    
}
