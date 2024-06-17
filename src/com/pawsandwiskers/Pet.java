package com.pawsandwiskers;

public abstract class Pet {
    private String name;
    private int energy;
    private int life;
    private int potty;
    private int hungerThirst;

    public Pet(String name) {
        this.name = name;
        this.energy = 50;
        this.life = 2;
        this.potty = 0;
        this.hungerThirst = 20;
    }

    public Pet(String name, int energy, int life, int potty, int hungerThirst) {
        this.name = name;
        this.energy = energy;
        this.life = life;
        this.potty = potty;
        this.hungerThirst = hungerThirst;
    }

    public abstract void eat();
    public abstract void walk();
    public abstract void exercise();
    public abstract void play();
    public abstract void love();
    public abstract void cuddle();
    public abstract void pet();
    public abstract void die();
    public abstract void sleep();

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
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
        String hearts = "❤".repeat(life) + "♡".repeat(3 - life);
        System.out.printf("%s's status - Energy: %d, Life: %s, Potty: %d, Hunger/Thirst: %d\n",
                getName(), getEnergy(), hearts, getPotty(), getHungerThirst());
    }

    public void checkHungerThirst() {
        if (hungerThirst >= 100) {
            life--;
            hungerThirst = 0; // Reset hunger/thirst after affecting life
            System.out.println(name + " has not been fed for a while and has lost a life.");
            if (life <= 0) {
                die();
            }
        }
    }

    public void setEnergy(int energy) {
        if (energy > 100) {
            this.energy = 100;
            life--; // Pet loses a heart if energy exceeds 100
            if (life <= 0) {
                die(); // Pet dies if life reaches 0
            }
        } else {
            this.energy = Math.max(0, energy);
        }
    }

    public void setLife(int life) { //sets life for 0 as min and 3 as max
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
        potty = Math.max(potty - 20, 0);
        System.out.println(getName() + " feels relieved after the walk.");
    }

    public void decreaseEnergyLevel(int amount) {
        energy = Math.max(energy - amount, 0);
        System.out.println(getName() + " is feeling tired after exercising.");
    }

    public void decreaseLife() {
        life--;
        if (life <= 0) {
            die();
        }
    }

    public void checkNeeds() {
        if (getEnergy() <= 0 || getPotty() >= 100 || getHungerThirst() >= 100) {
            life--;
            System.out.println(getName() + " has not been taken care of and has lost a life.");
            if (life <= 0) {
                die();
            }
        }
    }

    protected void increaseLife() {
        if (life < 3) {
            life++;
            System.out.println(name + " has gained a life.");
        }
    }
}
