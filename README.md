
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    // Объявление всех компонентов калькулятора.
    int b,y;
    int lo, jo, jolo, i,sequel;
    boolean min = false;
    boolean plu = false;
    boolean ymj = false;
    boolean del = false;
    boolean operation = false;



    newClass g = new newClass();

    JPanel windowContent;
    JTextField displayField;

    JButton [] numButtons = new JButton[12];

    JButton buttonEqual;
    JPanel p1;

    JButton button01;
    JButton button11;
    JButton delete;
    JButton znak;
    JPanel east;

    JButton button31;
    JButton button21;

//В конструкторе создаются все компоненты
//и добавляются на фрейм с помощью комбинации
//Borderlayout и Gridlayout

    Main(){
        windowContent= new JPanel();

//Задаём схему для этой панели

        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);

//Создаём и отображаем поле
//Добавляем его в Северную область окна

        displayField = new JTextField("0",20);
        displayField.setEditable(false);

        windowContent.add("North",displayField);

//Создаём кнопки, используя конструктор
//класса JButton, который принимает текст
//кнопки в качестве параметра
        int i;
        for (i=0;i<=11;i++){
            numButtons[i] = new JButton(""+ i);
        }
        buttonEqual=new JButton("=");
        button11 = new JButton("+");
        button01 = new JButton("-");
        delete = new JButton("C");
        button31 = new JButton("*");
        button21 = new JButton("/");
        znak = new JButton("+/-");

//Создаём панель с GridLayout
//которая содержит 12 кнопок - 10 кнопок с числами
//и кнопки с точкой и знаком равно

        p1 = new JPanel();
        GridLayout nl = new GridLayout(5,3);
        p1.setLayout(nl);

//Добавляем кнопки на панель p1

        for (i=0;i<=11;i++){
            p1.add(numButtons[i]);
        }

        p1.add(delete);
        p1.add(buttonEqual);

// Помещаем панель p1 в центральную область окна

        windowContent.add("Center",p1);

        east = new JPanel();
        GridLayout el = new GridLayout(5,1);
        east.setLayout(el);
        east.add(znak);
        east.add(button11);
        east.add(button01);
        east.add(button31);
        east.add(button21);

        windowContent.add("East",east);

        for(y=0;y<=9;y++){
            numButtons[y].addActionListener(g);
        }

        delete.addActionListener(g);
        button11.addActionListener(g);
        button01.addActionListener(g);
        button21.addActionListener(g);
        button31.addActionListener(g);
        buttonEqual.addActionListener(g);
        znak.addActionListener(g);

//Создаём фрейм и задаём его основную панель

        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);
// делаем размер окна достаточным

// для того, чтобы вместить все компоненты

        frame.setSize(240, 200);
// Наконец, отображаем окно

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    public class newClass implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try{
                for(b=0;b<=11;b++){
                    if (e.getSource()==numButtons[b]){
                        if(operation == true && plu == true || operation == true && min == true || operation == true && ymj == true ||operation == true && del == true){
                            displayField.setText(""+ b);
                            min = false; operation = false;
                            plu = false;
                            ymj = false;
                            del = false;
                        }
                        else{
                            i = Integer.parseInt(displayField.getText());
                            if(i == 0){
                                displayField.setText(""+ b);

                            }
                            else{
                                displayField.setText(i +""+ b);

                            }
                        }
                    }
                }
                if (e.getSource()==delete){
                    displayField.setText("0");
                    min = false;
                    plu = false;  operation = false;
                    ymj = false;
                    del = false;
                }

                if(e.getSource()==button11){
                    jo = Integer.parseInt(displayField.getText());
                    displayField.setText("0");
                    min = false;
                    plu = true;    operation = false;
                    ymj = false;
                    del = false;
                }

                if(e.getSource()==button01){
                    jo = Integer.parseInt(displayField.getText());
                    displayField.setText("0");
                    min = true;
                    plu = false;  operation = false;
                    ymj = false;
                    del = false;
                }

                if(e.getSource()==button31){
                    jo = Integer.parseInt(displayField.getText());
                    displayField.setText("0");
                    min = false;
                    plu = false;   operation = false;
                    ymj = true;
                    del = false;
                }

                if(e.getSource()==button21){
                    jo = Integer.parseInt(displayField.getText());
                    displayField.setText("0");
                    min = false;
                    plu = false;   operation = false;
                    ymj = false;
                    del = true;
                }

                if(e.getSource()==buttonEqual){
                    if(plu == true){
                        if(operation == true){
                            jo = Integer.parseInt(displayField.getText());
                            jolo = jo + lo;
                            displayField.setText(""+ jolo);
                            operation = true;

                        }
                        else{
                            lo = Integer.parseInt(displayField.getText());
                            jolo = jo + lo;
                            displayField.setText(""+ jolo);
                            operation = true;

                        }
                    }
                    if(min == true){
                        if(operation == true){
                            jo = Integer.parseInt(displayField.getText());
                            jolo = jo - lo;
                            displayField.setText(""+ jolo);
                            operation = true;

                        }
                        else{
                            lo = Integer.parseInt(displayField.getText());
                            jolo = jo - lo;
                            displayField.setText(""+ jolo);
                            operation = true;

                        }

                    }
                    if(ymj == true){
                        if(operation == true){
                            jo = Integer.parseInt(displayField.getText());
                            jolo = jo * lo;
                            displayField.setText(""+ jolo);
                            operation = true;

                        }
                        else{
                            lo = Integer.parseInt(displayField.getText());
                            jolo = jo * lo;
                            displayField.setText(""+ jolo);
                            operation = true;

                        }
                    }
                    if(del == true){
                        if(operation == true){
                            jo = Integer.parseInt(displayField.getText());
                            jolo = jo / lo;
                            displayField.setText(""+ jolo);
                            operation = true;

                        }
                        else{
                            lo =Integer.parseInt(displayField.getText());
                            jolo = jo / lo;
                            displayField.setText(""+ jolo);
                            operation = true;

                        }
                    }
                }
                if(e.getSource()==znak){
                    sequel = Integer.parseInt(displayField.getText());
                    sequel = sequel - sequel - sequel;
                    displayField.setText(sequel + "");
                }

            }catch (Exception ex){JOptionPane.showMessageDialog(null,"Слишком длинное число");
                displayField.setText("0");
            }

        }

    }


    public static void main(String[] args) {
        Main calc = new Main();


    }

}
