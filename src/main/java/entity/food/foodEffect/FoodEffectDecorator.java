package entity.food.foodEffect;

import entity.food.foodExtra.FoodExtra;

import java.util.ArrayList;
import java.util.List;

public class FoodEffectDecorator extends FoodEffect {
    private FoodEffect foodEffect;
    private List<FoodExtra> foodExtras;

    public FoodEffectDecorator(FoodEffect foodEffect) {
        this.foodEffect = foodEffect;
        foodExtras = new ArrayList<>();
    }

    @Override
    public double processHappiness(double happiness) {
        for(FoodExtra foodExtra: foodExtras) {
            foodExtra.processFoodEffect(foodEffect);
        }
        return foodEffect.processHappiness(happiness);
    }

    public void setFoodExtras(FoodExtra foodExtra) {
        this.foodExtras.add(foodExtra);
    }
}
