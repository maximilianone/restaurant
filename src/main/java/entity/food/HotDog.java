package entity.food;

import entity.food.foodEffect.FoodEffect;

import static utils.Constants.HOT_DOG;

public class HotDog extends Food {
    HotDog() {
        super(HOT_DOG, 10000, new FoodEffect(2, false));
    }
}
