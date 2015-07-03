import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;

public class Order {

    static ArrayList<Order> userBasket = new ArrayList<>();
    User user;
    Date datePurchases;
    String name;
    Manufacture manufacture;
    SyzeItem syzeItem;
    int price;
    int salesitem;
    int sum;

    public Order(User user, Produckt produckt, int salesitem) {
        this.user = user;
        this.name = produckt.name;
        this.manufacture = produckt.manufacture;
        this.syzeItem = produckt.syzeItem;
        this.price = produckt.priceUser;
        this.salesitem = salesitem;
        datePurchases = new Date();
    }


    public ArrayList<Order> addToBasket(Order order) {
        if (userBasket.add(order)) {
            for (Produckt tmt : Sklad.goods) {
                if (tmt.name.equals(this.name) && tmt.syzeItem.equals(this.syzeItem)) {
                    if (tmt.items >= salesitem)
                        tmt.items -= salesitem;
                    else {
                        System.out.println("Не хватает товара " + this.name + " " + this.syzeItem + " для пользователя " + this.user.userName);
                    }
                }
            }
        }
        sum = price * salesitem;
        return userBasket;
    }

    public ArrayList<Order> delItemsinBasket(Order order) {
        if (userBasket.remove(order)) {
            for (Produckt tmp : Sklad.goods) {
                if (tmp.name.equals(this.name) && tmp.syzeItem.equals(this.syzeItem)) {
                    tmp.items += salesitem;
                }
            }
        }
        sum = price * salesitem;
        System.out.println(userBasket);
        return userBasket;
    }

    public Collection<Order> searchUser(User user, Collection<Order> searchUse) {
        Vector<Order> sUse = new Vector<>();
        for (Order tmp : searchUse) {
            if (this.user.userName.equals(tmp.user.userName))
                sUse.add(tmp);
        }
        return sUse;
    }


    @Override
    public String toString() {
        return "Ордера -" +
                "пользователь - '" + user.userName + '\'' +
                " дата продажи - " + datePurchases + '\'' +
                " наименование товара - '" + name + '\'' +
                " поизводиталь -  " + manufacture +
                " упаковка - " + syzeItem +
                " цена - " + price +
                ", количество - " + salesitem +
                ", сумма - " + sum + '\n';
    }
}