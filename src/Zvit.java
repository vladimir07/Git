public class Zvit {
    int sum = 0;

    public void dayZvit() {
        for (Produckt tmp : Sklad.goods) {
            for (Order tmp1 : Order.userBasket) {
                if (tmp.name.equals(tmp1.name) && tmp.syzeItem.equals(tmp1.syzeItem) && tmp.manufacture.equals(tmp1.manufacture)) {
//                    tmp.items = tmp.items- tmp1.salesitem;
                    sum += (tmp.priceUser - tmp.price) * tmp1.salesitem;
                }
            }

        }
        System.out.println();
        System.out.println("Сегодня мы заработали - " + (sum) + " грн.");
        System.out.println();
    }

}
