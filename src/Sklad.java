import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class Sklad {
    static Set<Produckt> goods = new TreeSet<>();
    Vector<Sklad> sklads = new Vector<>();

    int squre;
    String nameSklad;
    String adress;
    String mol;

    public Sklad(int squre, String nameSklad, String adress, String mol) {
        this.squre = squre;
        this.nameSklad = nameSklad;
        this.adress = adress;
        this.mol = mol;
    }

    @Override
    public String toString() {
        return "������������ - '" + nameSklad + '\'' +
                ", �������=" + squre +
                ", ������������='" + adress + '\'' +
                ", �������������='" + mol + "\n";
    }

    public boolean addSklad(Sklad sklad) {
        return sklads.add(sklad);
    }

    public boolean addProduckt(Produckt produckt) {
        return goods.add(produckt);
    }

    public boolean remProdukt(Produckt produckt) {
        return goods.remove(produckt);
    }


    public void reportS() {
        System.out.println(sklads + "\n");

    }

    public void reportSklad() {
        System.out.println(goods + "\n");

    }

    public void reportSkladCategory(Category category) {
        System.out.println("�� " + nameSklad + " ��������� ����� " + category + " � ����� ������������");
        goods.stream().filter(temp -> category == temp.category).forEach(temp ->
                System.out.println(" " + temp.name + " " + temp.syzeItem + "  " + temp.items + " �� ����� -  " + (temp.items * temp.price) + " ���."));
        System.out.println();
    }

    public void reportSkladManufacture(Manufacture manufacture) {
        int suum = 0;
        for (Produckt temp : goods) {
            if (manufacture == temp.manufacture) {
                suum += temp.price * temp.items;
                System.out.println("�� ������ ������ - " + temp.name + " �� ������������� - " + manufacture + " �� ����� - " + suum + " ���.");
                System.out.println();
            }
        }
    }

    public void reportSkladProdukt(String name) {
        goods.stream().filter(temp -> temp.name.equals(name)).forEach(temp ->
                System.out.println(" " + temp.name + " " + temp.syzeItem + "  " + temp.items + " �� ����� -  " + (temp.items * temp.price) + " ���.  ��������� " + mol));
        System.out.println();

    }

}