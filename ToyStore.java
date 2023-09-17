import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ToyStore {
    private ArrayList<Toy> listToys = new ArrayList<>();
    private ArrayList<Toy> listOfPrizeToys = new ArrayList<>();

    public void addToy(Toy toy) {
        listToys.add(toy);
    }

    public void changeWeightToy(int id, double newWeight) {
        for (Toy toy : listToys) {
            if (toy.getId() == id) {
                toy.setWeight(newWeight);
                return;
            }
        }
    }

    public void organizeDrawing() {
        // Организация розыгрыша.
        double totalWeight = 0.0;
    
    // Рассчитаем общий вес игрушек в магазине
    for (Toy toy : listToys) {
        totalWeight += toy.getWeight();
    }
    
    // Генерируем случайное число от 0 до 100
    double randomNumber = Math.random() * 100;
    
    double currentWeight = 0.0;
    Toy prizeToy = null;
    
    // Определяем, какая игрушка стала призом
    for (Toy toy : listToys) {
        currentWeight += toy.getWeight();
        if (randomNumber <= currentWeight) {
            prizeToy = toy;
            break;
        }
    }
    
    if (prizeToy != null) {
        listOfPrizeToys.add(prizeToy);
        System.out.println("Выиграна игрушка: " + prizeToy.getName());
    } else {
        System.out.println("Не удалось определить призовую игрушку.");
    }
    }

    public Toy getPrizeToy() {
        Toy prizeToy = listOfPrizeToys.remove(0); // Удаляем первую призовую игрушку.
        FileWriter(prizeToy);
        reduceCountInStore(prizeToy);
        return prizeToy;
    }

    private void FileWriter(Toy toy) {
        try {
            FileWriter writer = new FileWriter("призовые.txt", true);
            writer.write("Название: " + toy.getName() + ", ID: " + toy.getId() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reduceCountInStore(Toy toy) {
        for (Toy storeToy : listToys) {
            if (storeToy.getId() == toy.getId()) {
                storeToy.setCount(storeToy.getCount() - 1);
                return;
            }
        }
    }
}
