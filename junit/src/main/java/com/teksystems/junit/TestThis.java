package com.teksystems.junit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestThis {

    List<String> names = new ArrayList<>(
        Arrays.asList("Mike", "Bairon", "Tony"));

    public String getNameAtIndex(int index){
        return names.get(index);
    }

    public void addName(String name){
        names.add(name);
    }

    public List<String> getNames(){
        return names;
    }

}