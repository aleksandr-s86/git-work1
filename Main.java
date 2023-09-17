public class Main {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();

        // Добавляем игрушки в магазин
        store.addToy(new Toy(1, "Мяч", 10, 20.0));
        store.addToy(new Toy(2, "Кукла", 8, 15.0));
        store.addToy(new Toy(3, "Машинка", 12, 10.0));

        // Изменяем вес (частоту выпадения) игрушек
        store.changeWeightToy(1, 25.0);

        // Организуем розыгрыш
        store.organizeDrawing();

        // Получаем призовую игрушку
        Toy prizeToy = store.getPrizeToy();

        // Выводим информацию о призовой игрушке
        if (prizeToy != null) {
            System.out.println("Поздравляем! Вы выиграли: " + prizeToy.getName());
        } else {
            System.out.println("Не удалось определить призовую игрушку.");
        }
    }
}
