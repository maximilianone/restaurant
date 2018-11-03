package entity;

import entity.food.Food;

public class Client {
    private double happiness;

    public double getHappiness() {
        return happiness;
    }

    public void setHappiness(double happiness) {
        this.happiness = happiness;
    }

    public void eatFood(Food food) {
        happiness = food.getEffect().processHappiness(happiness);
    }
}
