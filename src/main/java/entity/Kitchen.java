package entity;

import entity.food.Food;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public class Kitchen {
    private final BlockingQueue<Food> foodQueue;
    private final ExecutorService service;

    public Kitchen(ExecutorService service) {
        foodQueue = new LinkedBlockingQueue<>();
        this.service = service;
    }

    public void cookDish(Food food) {
        try {
            foodQueue.put(food);
            service.submit(() -> cook(foodQueue.take()));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private Food cook(Food food) {
        try {
            Thread.sleep(food.getCookingTime());
            food.setReady(true);
        } catch (InterruptedException ignore) {}
        return food;
    }
}
