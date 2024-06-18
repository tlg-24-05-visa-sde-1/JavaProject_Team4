package com.pawsandwhiskers;

class DummyPet extends Pet{

    public DummyPet(String name) {
        super(name);
    }

    public DummyPet(String name, int energy, int life, int potty, int hungerThirst) {
        super(name, energy, life, potty, hungerThirst);
    }

    @Override
    public void eat() {

    }

    public void walk() {

    }

    @Override
    public void exercise() {

    }

    @Override
    public void play() {

    }

    @Override
    public void love() {

    }

    @Override
    public void cuddle() {

    }

    @Override
    public void pet() {

    }

    @Override
    public String die() {
        return "";
    }


    @Override
    public void sleep() {

    }
}
