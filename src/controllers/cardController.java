package controllers;

import java.util.Vector;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import javax.swing.JFrame;
import javax.swing.JLabel;
import models.Card;
import views.*;
public class CardController implements ActionListener{
    private Vector turnedCards;
    private Timer turnDownTimer;
    private int count=0;
    private final int turnDownDelaty=500; //in terms of millisec.
    public  CardController(){
        this.turnedCards=new Vector(2);
        this.turnDownTimer=new Timer(this.turnDownDelaty,this);
        this.turnDownTimer.setRepeats(false);
    }
    /*
    Consider Card Class is Created in another package(models)
    @for Kartik Patkar only.
    */
    public boolean turnUp(Card card){
        if(this.turnedCards.size()<2)return doAddCard(card);
        return false;
    }
    
    private boolean doAddCard(Card card)
    {
        this.turnedCards.add(card);
        if(this.turnedCards.size()==2){
            Card otherCard=(Card)this.turnedCards.get(0);
            if(otherCard.getNum()==card.getNum()){
                this.turnedCards.clear();
                count+=2;
                if(count==16){
                    currentTimingWindow(Instant.now());
                }
            }
            else this.turnDownTimer.start();
        }
        return true;
    }
    
    void currentTimingWindow(Instant end){
        //Calculating time
        Instant start = matchingGame.start;
        matchingGame.end = end;
        Duration timeElapsed = Duration.between(start, matchingGame.end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        
        //DecimalFormat myDecimalFormatter = new DecimalFormat("###,###.###");
        //System.out.println(myDecimalFormatter.format(((double)start.-matchingGame.end)/1000);
        JFrame currentTiming = new JFrame("Your Score");
        currentTiming.setSize(300, 300);
        currentTiming.setLocation(815,300);
        currentTiming.setVisible(true);
        currentTiming.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0){
        for(int i=0;i<this.turnedCards.size();i++){
            Card card=(Card)this.turnedCards.get(i);
            card.turnDown();
        }
        this.turnedCards.clear();
    }
    //Code Snippetabout controller to the Card and matchingGame Classes.
} 