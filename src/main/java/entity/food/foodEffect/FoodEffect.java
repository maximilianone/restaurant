package entity.food.foodEffect;

public class FoodEffect {
    private double effect;
    private boolean isPercent;

    public FoodEffect() {
    }

    public FoodEffect(double effect, boolean isPercent) {
        this.effect = effect;
        this.isPercent = isPercent;
    }

    public FoodEffect(double effect) {
        this(effect, false);
    }

    public double processHappiness(double happiness) {
        if (isPercent) {
            happiness += effect * happiness;
        } else {
            happiness += effect;
        }
        return happiness;
    }

    public double getEffect() {
        return effect;
    }

    public void setEffect(double effect) {
        this.effect = effect;
    }

    public void setPercent(boolean percent) {
        isPercent = percent;
    }
}
