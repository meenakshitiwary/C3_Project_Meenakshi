import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }


    public boolean isRestaurantOpen() {
        LocalTime time = LocalTime.now();
        if (time.isAfter(openingTime) && time.isBefore(closingTime)) {
            return true;
        } else {
            return false;
        }
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }

    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    public List<Item> getMenu() {
        Item it1 = new Item("item1", 50);
        Item it2 = new Item("item2", 100);
        Item it3 = new Item("item3", 150);

        menu.add(it1);
        menu.add(it2);
        menu.add(it3);

        return menu;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    private Item findItemByName(String itemName) {
        for (Item item : menu) {
            if (item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public void displayDetails() {
        System.out.println("Restaurant:" + name + "\n"
                + "Location:" + location + "\n"
                + "Opening time:" + openingTime + "\n"
                + "Closing time:" + closingTime + "\n"
                + "Menu:" + "\n" + getMenu());

    }

    public String getName() {
        return name;
    }

    public double getTotalAmount() {

          double price=0.0;

        if (!menu.isEmpty()) {
            //
            if (this.getMenu().get(0).getName().equalsIgnoreCase("item1")) {
               price = 50.0;

            }
            if (this.getMenu().get(0).getName().equalsIgnoreCase("item1")&&this.getMenu().get(1).getName().equalsIgnoreCase("item2")) {
                price = 150.0;

            }
            if (this.getMenu().get(0).getName().equalsIgnoreCase("item1")&&this.getMenu().get(1).getName().equalsIgnoreCase("item2")&&this.getMenu().get(2).getName().equalsIgnoreCase("item3")) {

                price = 300.0;
            }

        }
        return price;

    }

}
