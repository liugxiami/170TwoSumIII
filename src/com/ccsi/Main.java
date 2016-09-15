package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    TwoSum TS=new TwoSum();
        TS.add(1);
        TS.add(3);
        TS.add(5);
        TS.add(7);
        System.out.println(TS.find(8));
    }
    //Design and implement a TwoSum class,It should support the following operations:add and find.
    //add---Add the number to an internal data structure.
    //find---Find if there exists any pair of numbers which sum is equal to the value.

}
class TwoSum{
    private List<Integer> list=new ArrayList<>();
    private Map<Integer,Boolean> cache=new HashMap<>();
    private boolean changed=false;

    public void add(int number){
        this.list.add(number);
        this.changed=true;
    }
    public boolean find(int value){
        Set<Integer> diffset=new HashSet<>();
        if(!cache.containsKey(value)||(changed&&cache.get(value)==false)){
            cache.put(value,false);
            for (int i = 0; i < list.size(); i++) {
                if(diffset.contains(list.get(i))){
                    cache.put(value,true);
                    break;
                }else{
                    diffset.add(value-list.get(i));
                }
            }
        }
        this.changed=false;
        return cache.get(value);
    }
}
