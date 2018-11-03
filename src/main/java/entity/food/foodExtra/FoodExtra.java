package entity.food.foodExtra;

import entity.food.foodEffect.FoodEffect;

public class FoodExtra {
    private String type;
    private double effect;
    private boolean nullifyFoodEffect;
    private boolean isQuantifier;

    FoodExtra(String type, double effect, boolean nullifyFoodEffect, boolean isQuantifier) {
        this.type = type;
        this.effect = effect;
        this.nullifyFoodEffect = nullifyFoodEffect;
        this.isQuantifier = isQuantifier;
    }

    public String getType() {
        return type;
    }

    public double getEffect() {
        return effect;
    }

    public boolean isNullifyFoodEffect() {
        return nullifyFoodEffect;
    }

    public boolean isQuantifier() {
        return isQuantifier;
    }

    public void processFoodEffect(FoodEffect foodEffect) {
        double foodEffectValue = foodEffect.getEffect();
        if (isQuantifier) {
            foodEffectValue *= effect;
        } else {
            if(nullifyFoodEffect) {
                foodEffectValue = 0;
                foodEffect.setPercent(false);
            }
            foodEffectValue += effect;
        }
        foodEffect.setEffect(foodEffectValue);
    }
}
