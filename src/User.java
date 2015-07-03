import java.util.*;


public class User implements Comparable<User> {
    static Set<User> usersV = new TreeSet<>();
    static double nasenka = 1.3;
    String userName;
    String userPhone;
    String userMail;
    String password;


    public User(String userName, String userFome, String userMail, String password) {
        this.userName = userName;
        this.userPhone = userFome;
        this.userMail = userMail;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Имя пользователя -'" + userName + '\'' +
                ", телефон пользователя -'" + userPhone + '\'' +
                ", электронная почта -'" + userMail + '\'' +
                ", пароль -" + password + '\'';
    }


    public void addUser(User user) {
        for (User temp : usersV) {
            if (temp.userName.equals(user.userName) && temp.userMail.equals(user.userMail)) {
                System.out.println("Пользователь " + temp.userName + " с электонной почтой - " + temp.userMail + " уже существует ");
                System.out.println();
            }
        }
        usersV.add(user);

    }

    public void reportUser(String userName, String pass) {
        if (userName.equals("Admin") && pass == "7777") {
            System.out.println("Все пользователи в базе");
            {
                for (User temp : usersV) {
                    System.out.println(temp);
                }
            }
        } else System.out.println("\n" + "Для посмотра списка пользователей введите правильное имя и пароль" + "\n");


    }


    public void reportUserPass(String userName, String password) {
        for (User temp : usersV) {
            if (temp.userName.equals(userName) && temp.password.equals(password)) {
                System.out.println("Ваш логин и пароль");
                System.out.println(temp);
            }
        }
    }

    public void changePass(String userName, String password, String newPass) {
        for (User tmp : usersV) {
            if (tmp.userName.equals(userName) && tmp.password.equals(password)) {
                usersV.remove(tmp);
                tmp.password = newPass;
                usersV.add(tmp);
                System.out.println();
                System.out.println("Пароль пользователя - " + tmp.userName + " был замененен на -" + newPass);
                System.out.println();

            }
        }
    }

    public Collection<Produckt> searchName(String name, Collection<Produckt> searchNam) {
        Vector<Produckt> sName = new Vector<>();
        for (Produckt tmp : searchNam) {
            if (tmp.name.equals(name))
                sName.add(tmp);
        }
        if (sName.isEmpty()) {
            System.out.println("Что то не так с наименованием товара. Выводим весь товар.");
            searchNam.addAll(searchNam);
        }

        return sName;
    }


    public Collection<Produckt> searchCategory(Category category, Collection<Produckt> searchCat) {
        Vector<Produckt> sCategory = new Vector<>();
        for (Produckt tmp : searchCat) {
            if (tmp.category.equals(category))
                sCategory.add(tmp);
        }
        return sCategory;
    }

    public Collection<Produckt> searchPrice(int z, Collection<Produckt> searchPric) {
        ArrayList<Produckt> sPrice = new ArrayList<>();
        for (Produckt tmp : searchPric) {
            sPrice.add(tmp);
            switch (z) {
                case 1:
                    Collections.sort(sPrice, new SortedByPrice1());
                    break;
                default:
                    Collections.sort(sPrice, new SortedByPrice());
            }
        }
        return sPrice;
    }

    @Override
    public int compareTo(User t) {
        return (this.userName.compareTo(t.userName) * this.userMail.compareTo(t.userMail) + this.userPhone.compareTo(t.userPhone));

    }

}

class SortedByPrice implements Comparator<Produckt> {

    public int compare(Produckt t1, Produckt t2) {

        int price1 = t1.price;
        int price2 = t2.price;

        if (price1 > price2) {
            return 1;
        } else if (price1 < price2) {
            return -1;
        } else {
            return 0;
        }
    }
}

class SortedByPrice1 implements Comparator<Produckt> {

    public int compare(Produckt t1, Produckt t2) {

        int price1 = t2.price;
        int price2 = t1.price;

        if (price1 > price2) {
            return 1;
        } else if (price1 < price2) {
            return -1;
        } else {
            return 0;
        }
    }
}
