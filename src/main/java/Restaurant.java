import controller.RestaurantController;
import entity.Client;
import view.RestaurantView;

public class Restaurant {
    public static void main(String[] args) {
        RestaurantView view = new RestaurantView();
        Client client = new Client();
        RestaurantController controller = new RestaurantController(view, client);
        controller.run();
    }
}
