package com.example.java_training_august_2023.access_modifier.basic;

public class Book {
    int modifierOne = 20;
    public int modifierTwo = 21;
    private int modifierThree = 22;
    protected int modifierFour = 23;

    public int getModifierOne() {
        return modifierOne;
    }

    public int getModifierThree() {
        return modifierThree;
    }

    public int getModifierFour() {
        return modifierFour;
    }

    public void setModifierOne(int modifierOne) {
        this.modifierOne = modifierOne;
    }

    protected void setModifierThree(int modifierThree) {
        if(modifierThree<10 || modifierThree>500){
            return;
        }
        this.modifierThree = modifierThree;
    }

    public void setModifierFour(int modifierFour) {
        this.modifierFour = modifierFour;
    }

    void printValues(){
        System.out.println(modifierOne);
        System.out.println(modifierTwo);
        System.out.println(modifierThree);
        System.out.println(modifierFour);
    }
}
