package com.zsz.raiting;

import com.zsz.model.ERPSystem;

import java.util.List;

public abstract class SystemRanker <T extends ERPSystem>{
    protected List<T> systems;

    public SystemRanker(List<T> systems) {
        this.systems = systems;
    }

    public void printResults(int n){
        int counter = 1;
        for(ERPSystem sys : systems.subList(0, n)) {
            System.out.println(counter++ + ": " + sys.toString());
        }
    }
    public void printResults(){
        int counter = 1;
        for(ERPSystem sys : systems) {
            System.out.println(counter++ + ": " + sys.toString());
        }
    }
}
