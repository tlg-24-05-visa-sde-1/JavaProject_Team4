package com.pawsandwhiskers;

import java.util.HashMap;
import java.util.Map;

public abstract class Pet {
    private String name;
    private int life;
    private int potty;
    private int hungerThirst;
    private Map<String, Integer> attributes;

    public Pet(String name) {
        this.name = name;
        this.life = 2;
        this.potty = 0;
        this.hungerThirst = 20;
        this.attributes = new HashMap<>();
        this.attributes.put("energy", 50); // Initialize energy to 50
    }

    public Pet(String name, int energy, int life, int potty, int hungerThirst) {
        this.name = name;
        this.life = life;
        this.potty = potty;
        this.hungerThirst = hungerThirst;
        this.attributes = new HashMap<>();
        this.attributes.put("energy", energy); // Initialize energy
    }

    public abstract void eat();
    public abstract void exercise();
    public abstract void play();
    public abstract void love();
    public abstract void cuddle();
    public abstract void pet();
    public abstract String die();
    public abstract void sleep();

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return attributes.get("energy");
    }

    public int getLife() {
        return life;
    }

    public int getPotty() {
        return potty;
    }

    public int getHungerThirst() {
        return hungerThirst;
    }

    public void displayStatus() {
        int displayedLife = calculateDisplayedLife();
        System.out.printf("%s's status - Energy: %d, Life: %d, Potty: %d, Hunger/Thirst: %d\n",
                getName(), getEnergy(), displayedLife, getPotty(), getHungerThirst());
    }

    private int calculateDisplayedLife() {
        int currentLife = getLife();
        int currentEnergy = getEnergy();

        // Adjust life display based on conditions
        if (currentEnergy > 100 && !hasBeenWalkedExercisedOrPlayed()) {
            currentLife--; // Pet loses a heart due to excessive energy and lack of activity
        }

        // Ensure life is within valid range (0 to 3)
        return Math.max(0, Math.min(currentLife, 3));
    }

    private boolean hasBeenWalkedExercisedOrPlayed() {
        return getEnergy() < 100 || getPotty() < 100 || getHungerThirst() < 100;
    }

    public void setEnergy(int energy) {
        this.attributes.put("energy", Math.min(Math.max(energy, 0), 100));
    }

    public void setLife(int life) {
        this.life = Math.min(Math.max(life, 0), 3);
    }

    public void setPotty(int potty) {
        this.potty = Math.min(Math.max(potty, 0), 100);
    }

    public void setHungerThirst(int hungerThirst) {
        this.hungerThirst = Math.min(Math.max(hungerThirst, 0), 100);
    }

    public void increasePottyLevel() {
        potty = Math.min(potty + 10, 100);
    }

    public void decreasePottyLevel() {
        potty = Math.max(potty - 40, 0);
        System.out.println(getName() + " feels relieved after the walk.");
    }

    public void decreaseEnergyLevel(int amount) {
        int newEnergy = getEnergy() - amount;
        setEnergy(newEnergy);
        System.out.println(getName() + " is feeling tired after exercising.");
    }

    public void decreaseLife() {
        life--;
        if (life <= 0) {
            die();
        }
    }

    public void checkNeeds() {
        if (getEnergy() >= 90) {
            System.out.println(getName() + " is too excited and has lost a life.");
            decreaseLife();

            if (getLife() <= 0){
                System.out.println(getName() + " has died of a heart attack.");
            }
        }

        if (getHungerThirst() >= 100) {
            System.out.println(getName() + " is too hungry and has lost a life.");
            decreaseLife();

            if (getLife() <= 0){
                System.out.println(getName() + " has died of hunger.");
            }
        }

        if (getPotty() >= 100) {
            System.out.println(getName() + " has had an accident and has lost a life.");
            decreaseLife();
        }
    }

    public void increaseLife() {
        life = Math.min(life + 1, 3); // Increase life but cap it at 3
    }
}
