import java.util.Date;

enum Manufacture {
    Галичина, Carlsberg, Оболонь
}

enum Category {
    Пиво, Молочная_продукция
}

enum SyzeItem {
    Пакет_1л, Пакет_0_5л, Бутылка_0_5л, Бутылка_0_33л
}

public class Produckt implements Comparable<Produckt> {

    String name;
    Manufacture manufacture;
    Date dateGreat;
    Category category;
    SyzeItem syzeItem;
    int price;
    int dateFinal;
    int items;
    int priceUser;

    public Produckt(String name, Manufacture manufacture, Category category, SyzeItem syzeItem, int price, int dateFynal, int items) {
        this.name = name;
        this.dateGreat = new Date();
        this.manufacture = manufacture;
        this.category = category;
        this.syzeItem = syzeItem;
        this.price = price;
        this.dateFinal = dateFynal;
        this.items = items;
        this.priceUser = (int) (price * User.nasenka);
    }


    @Override
    public int compareTo(Produckt t) {
        int res = 0;
        res = (this.name.compareTo(t.name) + this.manufacture.compareTo(t.manufacture) + this.syzeItem.compareTo(t.syzeItem));

        if (res == 0) {
            this.items += t.items;
        }
        return res;
    }

    @Override
    public String toString() {
        return

                " товар - " + name + " " +
                        " производитель - " + manufacture + " " +
                        " дата выпуска - " + dateGreat + " " +
                        " категория - " + category + " " +
                        " упаковка - " + syzeItem + " " +
                        " цена - " + price + " грн.  " +
                        " срок хранения - " + dateFinal + " дней " +
                        " количество - " + items + " " +
                        " цена для покупателей - " + priceUser + " \n";

    }
}