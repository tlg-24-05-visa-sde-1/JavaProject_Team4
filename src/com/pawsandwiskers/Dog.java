package com.pawsandwiskers;

public class Dog implements Pet {
    private String name;
    private int energy = 50;
    private int life = 2;
    private int potty = 0;
    private int hungerThirst = 20;

    //constructors
    public Dog(String name) {
        setName(name);
    }

    public Dog(String name, int energy, int life, int potty, int hungerThirst) {
        setName(name);
        setEnergy(energy);
        setLife(life);
        setPotty(potty);
        setHungerThirst(hungerThirst);
    }

    @Override
    public void eat() {
        hungerThirst = Math.max(hungerThirst - 10, 0);
        System.out.println(getName() + " is eating!");
        increaseLife();
    }

    @Override
    public void walk() {
        energy = Math.max(energy - 10, 0);
        potty = Math.max(potty - 10, 100);
        System.out.println(getName() + " is walking.");
        increaseLife();
    }

    @Override
    public void exercise() {
        energy = Math.max(energy - 15, 0);
        System.out.println(getName() + " is exercising.");
    }

    @Override
    public void play() {
        energy = Math.max(energy - 20, 0);
        System.out.println(getName() + " is playing.");
    }

    @Override
    public void love() {
        energy = Math.max(energy + 5, 100);
        System.out.println(getName() + " is being loved ❤ ");
        increaseLife();
    }

    @Override
    public void cuddle() {
        energy = Math.min(100, energy + 10); // Increase energy by 10, capped at 100
        System.out.println(getName() + " is being cuddled.");
    }

    @Override
    public void pet() {
        energy = Math.max(energy + 5, 100);
        System.out.println(getName() + " is being petted.");
        increaseLife();
    }

    @Override
    public void die() {
        if (life <= 0) {
            System.out.println(getName() + " died ﮩ٨ـﮩﮩ٨ـ♡ﮩ٨ـﮩﮩ٨ـ");
        }
    }

    @Override
    public void sleep() {
        energy = Math.max(energy + 20, 100);
        System.out.println(getName() + " is sleeping.");
        increaseLife();
    }

    @Override
    public void displayStatus() {
            String hearts = "❤".repeat(life) + "♡".repeat(3 - life);
            System.out.printf("%s's status - Energy: %d, Life: %s, Potty: %d, Hunger/Thirst: %d\n",
                    getName(), getEnergy(), hearts, getPotty(), getHungerThirst());

//        String hearts = "❤".repeat(life) + "♡".repeat(3 - life);
//        System.out.printf("%s's status - Energy: %d, Life: %s, Potty: %d, Hunger/Thirst: %d\n",
//                getName(), getEnergy(), hearts, getPotty(), getHungerThirst());

//        System.out.printf("%s's status - Energy: %d, Life: %d, Potty: %d, Hunger/Thirst: %d\n",
//                getName(), getEnergy(), getLife(), getPotty(), getHungerThirst());

    }

    @Override
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

    @Override
    public void decreaseLife() {
        life--;
        if (life <= 0) {
            die();
        }
    }

    @Override
    public void checkNeeds() {
        if (getEnergy() <= 0 || getPotty() >= 100 || getHungerThirst() >= 100) {
            life--;
            System.out.println(getName() + " has not been taken care of and has lost a life.");
            if (life <= 0) {
                die();
            }
        }
    }

    private void increaseLife() {
        if (life < 3) {
            life++;
            System.out.println(name + " has gained a life.");
        }
    }

    @Override
    public void increasePottyLevel() {
        potty = Math.min(potty + 10, 100);
       // potty += 10;
    }

    @Override
    public void decreasePottyLevel() {
        potty = Math.max(potty - 20, 0);
        System.out.println(getName() + " feels relieved after the walk.");
//        potty -= 20;
//        if (potty < 0) {
//            potty = 0;
//        }
//        System.out.println(getName() + " feels relieved after the walk.");
    }

    @Override
    public void decreaseEnergyLevel(int amount) {
        energy = Math.max(energy - amount, 0);
        System.out.println(getName() + " is feeling tired after exercising.");


//        energy -= amount;
//        if (energy < 0) {
//            energy = 0;
//        }
//        System.out.println(getName() + " is feeling tired after exercising.");
    }

    //Setter and Getters
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public int getPotty() {
        return potty;
    }

    @Override
    public int getHungerThirst() {
        return hungerThirst;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setEnergy(int energy) {

       // this.energy = Math.min(Math.max(energy, 0), 100);

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
        this.life = Math.min(Math.max(energy, 0), 3);
    }

    public void setPotty(int potty) {
        this.potty = Math.min(Math.max(potty, 0), 100);


//        if (potty > 100) {
//            this.potty = 100;
//            life--; // Pet loses a heart if potty exceeds 100
//        }
//        this.potty = potty;
//    }
    }

        public void setHungerThirst ( int hungerThirst){
            this.hungerThirst = Math.min(Math.max(hungerThirst, 0), 100);
            // this.hungerThirst = hungerThirst;

        }
    }
