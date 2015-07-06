import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {

    JButton b1, b2;
    JLabel l1, l2, l3, l4;
    JTextField t1, t2;
    String a, b;
    int i, k;
    eHandler handler = new eHandler();

    public Window(String s) {
        super(s);
        setLayout(new FlowLayout());
        b1 = new JButton("Очистить");
        b2 = new JButton("Посчитать");
        l1 = new JLabel("Введите первое число: ");
        l2 = new JLabel("Введите второе число: ");
        l3 = new JLabel("");
        l4 = new JLabel("");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        add(b1);
        add(b2);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(l4);
        b2.addActionListener(handler);
        b1.addActionListener(handler);
    }

    public class eHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == b2) {//если источник события(e.getSource()=нашей кнопке(b2))
                    i = Integer.parseInt(t1.getText());//i=отображение всего того что введено в поле 1(t1)
                    k = Integer.parseInt(t2.getText());//k=отображение всего того что введено в поле 2(t2)
                    i++;
                    k++;
                    a = "Ваше первое число теперь равно: " + i;
                    b = "Ваше второе число теперь равно: " + k;
                    l3.setText(a);
                    l4.setText(b);
                }
                if (e.getSource() == b1) {
                    t1.setText(null);
                    t2.setText(null);
                    l3.setText(null);
                    l4.setText(null);
                }
            }catch (Exception ex){JOptionPane.showMessageDialog(null,"Bведите число!");}
        }
    }
}
