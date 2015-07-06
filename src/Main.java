import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        Window r = new Window("Окно!");//title
        r.setVisible(true);//видимость окна
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Чтоб окно можно было закрыть
        r.setSize(300,200);//размеры окна
        r.setResizable(false);//делает неизменными размеры окна
        r.setLocationRelativeTo(null);//позиционирует окно по центру



        Sklad sklad = new Sklad(100, "Main Sklad", "Nikolaev", "Fedotov");
        Sklad skladMilk = new Sklad(10, "Молочный склад", "Nikolaev", "Ivanov");
        Sklad skladBeer = new Sklad(20, "Пивной склад", "Nikolaev", "Petrov");
        Produckt milk = new Produckt("Burenka", Manufacture.Галичина, Category.Молочная_продукция, SyzeItem.Пакет_1л, 10, 15, 200);
        Produckt milk1 = new Produckt("Burenka", Manufacture.Галичина, Category.Молочная_продукция, SyzeItem.Пакет_1л, 10, 15, 200);
        Produckt milk2 = new Produckt("Burenka", Manufacture.Галичина, Category.Молочная_продукция, SyzeItem.Пакет_0_5л, 5, 15, 200);
        Produckt milk3 = new Produckt("Burenka", Manufacture.Галичина, Category.Молочная_продукция, SyzeItem.Пакет_1л, 10, 15, 200);
        Produckt beer = new Produckt("Десант", Manufacture.Оболонь, Category.Пиво, SyzeItem.Бутылка_0_5л, 12, 45, 200);
        Produckt beer1 = new Produckt("Obolon", Manufacture.Оболонь, Category.Пиво, SyzeItem.Бутылка_0_5л, 14, 45, 200);
        Produckt beer3 = new Produckt("Bavaria", Manufacture.Carlsberg, Category.Пиво, SyzeItem.Бутылка_0_33л, 25, 45, 200);
        Produckt beer2 = new Produckt("Obolon", Manufacture.Оболонь, Category.Пиво, SyzeItem.Пакет_0_5л, 14, 45, 200);
        User admin = new User("Admin", "00000000", "rrr@yyyy", "7777");
        User user1 = new User("Best", "066-111-22-33", "ysa.sergey@gmail.com", "1w23");
        User user2 = new User("Petrov", "066-111-22-34", "g.sergey@gmail.com", "3rrr6");
        User user3 = new User("Best", "066-111-22-34", "y.sergey@gmail.com.ua", "3rrr6");
        User user4 = new User("Best", "066-111-22-34", "y.sergey@gmail.com", "3rrr6");

        sklad.addSklad(skladMilk);
        sklad.addSklad(skladBeer);
        //   sklad.reportS();//вывод складов

        admin.addUser(user1);
        admin.addUser(user2);
        admin.addUser(user3);
        admin.addUser(user4);
//        admin.reportUser("Admin", "7777"); //вывод всех пользователей
//        user1.reportUser("Ivanov", "3333");//ошибка неправильный пароль
//        admin.reportUserPass("Best", "3rrr6"); //проверка логина и пароля
//        admin.changePass("Best", "3rrr6", "22222");//замена пароля пользователя
//        System.out.println();

        sklad.addProduckt(milk);
        sklad.addProduckt(milk1);
        sklad.addProduckt(milk2);
        sklad.addProduckt(milk3);
        sklad.addProduckt(beer);
        sklad.addProduckt(beer1);
        sklad.addProduckt(beer3);
        sklad.addProduckt(beer2);

        System.out.println();
        //       System.out.println(user1.searchName("Burenka", Sklad.goods));//сортировка по имени
        System.out.println();
//        Order order1=new Order(user1,"Burenka",Manufacture.Галичина,SyzeItem.Пакет_1л,6,5);
//        order1.addToBasket(order1);
//        Order order2=new Order(user1,"Burenka",Manufacture.Галичина,SyzeItem.Пакет_1л,6,12);
//        order1.addToBasket(order2);
//        sklad.remProdukt(beer3);
//        sklad.reportSklad();
//        sklad.reportSklad();
        Order order1 = new Order(user1, milk1, 45);//выбор товара
        order1.addToBasket(order1);//добавление товара в корзину
        Order order2 = new Order(user2, milk2, 43);//выбор товара
        order2.addToBasket(order2);//добавление товара в корзину
        Order order3 = new Order(user3, beer3, 97);//выбор товара
        order3.addToBasket(order3);//добавление товара в корзину
        Order order4 = new Order(user3, beer, 67);
        order4.addToBasket(order4);
        System.out.println(Order.userBasket + " Ордера всех покупателей");


//        order2.delItemsinBasket(order2);//удаление товара из корзины
//        System.out.println(user1.searchName("Burenka", Sklad.goods));//сортировка по товару
        System.out.println(order3.searchUser(user2, Order.userBasket) + " все ордера по пользователю ");//ордера по пользователю
        Zvit newZvit = new Zvit();//создаем объект newZvit
        newZvit.dayZvit();// вызываем метод dayZvit()
        sklad.reportSklad();//Отчет по складу после звита


//        System.out.println();
//        System.out.println(user1.searchCategory(Category.Молочная_продукция, User.goodsUser));//сортировка по категории
//        System.out.println();
//        System.out.println(user1.searchPrice(2, User.goodsUser));//сортировка по цене 1-от большего к меньшему, любое - от меньшего к большему
//        System.out.println();
//        System.out.println(user1.searchCategory(Category.Молочная_продукция, user1.searchName("Burenka", User.goodsUser)));//сотривовка по имени затем по категории затем цене
//
//        System.out.println(user1.searchPrice(0, user1.searchCategory(Category.Молочная_продукция, user1.searchName("Burenka", User.goodsUser))));//сотривовка по имени затем по категории затем цене

//        skladMilk.reportSkladCategory(Category.Молочная_продукция);
//        skladBeer.reportSkladCategory(Category.Пиво);
//        sklad.reportSkladManufacture(Manufacture.Оболонь);
//        sklad.reportSkladManufacture(Manufacture.Галичина);
//        sklad.reportSkladProdukt("Burenka");
//        sklad.reportSkladProdukt("Obolon");
//        sklad.reportSkladProdukt("Десант");
//        sklad.reportSkladProdukt("Bavaria");

    }
}