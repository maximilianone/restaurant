package entity.food;

import entity.food.foodEffect.FoodEffect;

import static utils.Constants.CHIPS;

public class Chips extends Food {
    Chips() {
        super(CHIPS, 1000, new FoodEffect(0.05, true));
    }
}
