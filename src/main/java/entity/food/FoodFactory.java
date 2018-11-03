package entity.food;

import entity.food.foodExtra.FoodExtra;
import entity.food.foodExtra.Ketchup;
import entity.food.foodExtra.Mustard;
import view.RestaurantView;

import static utils.Constants.*;

public class FoodFactory {
    private RestaurantView view;

    public FoodFactory(RestaurantView view) {
        this.view = view;
    }

    public Food getDish(String type) {
        switch (type) {
            case HOT_DOG:
                return new HotDog();
            case CHIPS:
                return new Chips();
            default:
                view.displayMessage(UNKNOWN_DISH);
                return null;
        }
    }

    public FoodExtra getExtra(String type) {
        switch (type) {
            case KETCHUP:
                return new Ketchup();
            case MUSTARD:
                return new Mustard();
            default:
                view.displayMessage(UNKNOWN_EXTRA);
                return null;
        }
    }
}
