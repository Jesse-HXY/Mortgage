package com.neu.Pattern.observer;

import com.neu.Pattern.strategy.Mortgage;

import java.util.Observable;
import java.util.Observer;

public class MortgageObserver implements Observer {
    Observable observable;

    public MortgageObserver(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Mortgage){
            Mortgage mortgage = (Mortgage)o;
            display();
        }

    }
    public void display(){
        System.out.println("Mortgage has been updated");
    }
}
