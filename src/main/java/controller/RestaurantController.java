package controller;

import entity.Client;
import entity.Kitchen;
import entity.food.Food;
import entity.food.FoodFactory;
import entity.food.foodEffect.FoodEffectDecorator;
import entity.food.foodExtra.FoodExtra;
import view.RestaurantView;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static utils.Constants.*;

public class RestaurantController {
    private ExecutorService executor;
    private RestaurantView view;
    private Client client;
    private Kitchen kitchen;
    private boolean isRunning;
    private Scanner scanner;
    private FoodFactory foodFactory;

    public RestaurantController(RestaurantView view, Client client) {
        this.view = view;
        this.client = client;
        executor = Executors.newSingleThreadExecutor();
        kitchen = new Kitchen(executor);
        isRunning = true;
        scanner = new Scanner(System.in);
        foodFactory = new FoodFactory(view);
    }

    public void run() {
        while (isRunning) {
            view.displayMessage(ENTER_MENU);
            processInput(scanner.nextLine());
        }
    }

    private void processInput(String statement) {
        switch (statement) {
            case ORDER:
                makeOrder();
                break;
            case EXIT:
                exit();
                break;
            default:
                view.displayMessage(UNKNOWN_COMMAND);
        }
    }

    private void makeOrder() {
        view.displayMessage(AVAILABLE_DISHES + HOT_DOG + ", " + CHIPS);
        view.displayMessage(ENTER_DISH_NAME);

        Food food = foodFactory.getDish(scanner.nextLine());
        if (food != null) {
            view.displayMessage(AVAILABLE_EXTRAS + KETCHUP + ", " + MUSTARD);
            view.displayMessage(ENTER_EXTRA_NAME);

            FoodExtra foodExtra = foodFactory.getExtra(scanner.nextLine());

            if (foodExtra != null) {
                FoodEffectDecorator foodEffectDecorator = new FoodEffectDecorator(food.getEffect());
                foodEffectDecorator.setFoodExtras(foodExtra);
                food.setEffect(foodEffectDecorator);
            }

            food.getHandler().addHandler(x -> giveDishToClient(food));

            kitchen.cookDish(food);
        }
    }

    private void exit() {
        executor.shutdown();
        isRunning = false;
        scanner.close();
    }

    private void giveDishToClient(Food food) {
        client.eatFood(food);
        view.displayMessage(CLIENT_HAPPINESS + client.getHappiness());
    }
}
