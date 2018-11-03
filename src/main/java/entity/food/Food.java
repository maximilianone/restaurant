package entity.food;

import controller.Event;
import entity.food.foodEffect.FoodEffect;

public class Food {
    private String type;
    private int cookingTime;
    private FoodEffect effect;
    private boolean isReady;
    private Event<Food> handler;

    Food(String type, int cookingTime, FoodEffect effect) {
        this.type = type;
        this.cookingTime = cookingTime;
        this.effect = effect;
        this.isReady = false;
        handler = new Event<>();
    }

    public Event<Food> getHandler() {
        return handler;
    }

    public FoodEffect getEffect() {
        return effect;
    }

    public void setEffect(FoodEffect effect) {
        this.effect = effect;
    }

    public String getType() {
        return type;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean isReady) {
        if (this.isReady == isReady) return;
        this.isReady = isReady;
        handler.fire(this);
    }
}
