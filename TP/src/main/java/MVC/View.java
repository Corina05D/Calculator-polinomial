package MVC;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class View {
    public JFrame mainFrame;
    public JLabel cLabel1, sLabel1,
            cLabel2, sLabel2,
            cLabel3, sLabel3,
            cLabel4, sLabel4,
            cLabel5, sLabel5,
            cLabel6, sLabel6;
    public JPanel poli1,poli2, mesaje;
    public JTextField polinom, polinom2, valoare;
    public JButton plus, minus, inmultire, impartire;
    public int x;

    public View(){
        panel();
    }

    private void panel(){
        mainFrame = new JFrame("Calculator polinoame");
        mainFrame.setSize(500,500);
        mainFrame.setLayout(new GridLayout(1,1));
        JPanel Column = new JPanel();
        mainFrame.add(Column);


        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        JPanel poli0 = new JPanel();
        poli0.setLayout(new GridLayout(1,0));
        valoare = new JTextField(5);
        poli0.add(valoare);

        poli1 = new JPanel();
        poli1.setLayout(new FlowLayout());
        poli2 = new JPanel();
        poli2.setLayout(new FlowLayout());

        polinom = new JTextField(20);
        polinom2 = new JTextField(20);

        poli1.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.blue));
        poli1.add(new JLabel("Polinom1: ", JLabel.LEFT));
        poli1.add(polinom);

        poli2.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.red));
        poli2.add(new JLabel("Polinom2: ", JLabel.LEFT));
        poli2.add(polinom2);


        cLabel1 = new JLabel("", JLabel.LEFT);
        cLabel1.setPreferredSize(new Dimension(350,20));
        cLabel1.setText("Polinomul 1");
        sLabel1 = new JLabel("",JLabel.LEFT);
        sLabel1.setVerticalTextPosition(JLabel.TOP);
        sLabel1.setPreferredSize(new Dimension(350,20));
        JPanel cm = new JPanel();
        cm.setLayout(new GridLayout(2,1));
        cm.add(cLabel1);
        cm.add(sLabel1);
        cm.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.BLUE));

        cLabel2 = new JLabel("", JLabel.LEFT);
        cLabel2.setPreferredSize(new Dimension(350,20));
        cLabel2.setText("Polinomul 2");
        sLabel2 = new JLabel("",JLabel.LEFT);
        sLabel2.setVerticalTextPosition(JLabel.TOP);
        sLabel2.setPreferredSize(new Dimension(350,20));
        JPanel cm2 = new JPanel();
        cm2.setLayout(new GridLayout(2,1));
        cm2.add(cLabel2);
        cm2.add(sLabel2);
        cm2.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.red));

        cLabel3 = new JLabel("", JLabel.LEFT);
        cLabel3.setPreferredSize(new Dimension(350,20));
        cLabel3.setText("Suma celor doua polinoame");
        sLabel3 = new JLabel("",JLabel.LEFT);
        sLabel3.setVerticalTextPosition(JLabel.TOP);
        sLabel3.setPreferredSize(new Dimension(350,20));
        JPanel cm3 = new JPanel();
        cm3.setLayout(new GridLayout(2,1));
        cm3.add(cLabel3);
        cm3.add(sLabel3);
        cm3.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.green));

        cLabel4 = new JLabel("", JLabel.LEFT);
        cLabel4.setPreferredSize(new Dimension(350,20));
        cLabel4.setText("Diferenta celor doua polinoame");
        sLabel4 = new JLabel("",JLabel.LEFT);
        sLabel4.setVerticalTextPosition(JLabel.TOP);
        sLabel4.setPreferredSize(new Dimension(350,20));
        JPanel cm4 = new JPanel();
        cm4.setLayout(new GridLayout(2,1));
        cm4.add(cLabel4);
        cm4.add(sLabel4);
        cm4.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.green));

        cLabel5 = new JLabel("", JLabel.LEFT);
        cLabel5.setPreferredSize(new Dimension(350,20));
        cLabel5.setText("Inmultirea celor doua polinoame");
        sLabel5 = new JLabel("",JLabel.LEFT);
        sLabel5.setVerticalTextPosition(JLabel.TOP);
        sLabel5.setPreferredSize(new Dimension(350,20));
        JPanel cm5 = new JPanel();
        cm5.setLayout(new GridLayout(2,1));
        cm5.add(cLabel5);
        cm5.add(sLabel5);
        cm5.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.green));

        cLabel6 = new JLabel("", JLabel.LEFT);
        cLabel6.setPreferredSize(new Dimension(350,20));
        cLabel6.setText("Impartirea celor doua polinoame");
        sLabel6 = new JLabel("",JLabel.LEFT);
        sLabel6.setVerticalTextPosition(JLabel.TOP);
        sLabel6.setPreferredSize(new Dimension(350,20));
        JPanel cm6 = new JPanel();
        cm6.setLayout(new GridLayout(2,1));
        cm6.add(cLabel6);
        cm6.add(sLabel6);
        cm6.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.green));

        JPanel operatori = new JPanel();
        GridLayout op = new GridLayout(1,4);
        op.setHgap(20);
        operatori.setLayout(op);
        plus = View.createSimpleButton("+");
        minus = View.createSimpleButton("-");
        inmultire = View.createSimpleButton("x");
        impartire = View.createSimpleButton("/");
        operatori.add(plus);
        operatori.add(minus);
        operatori.add(inmultire);
        operatori.add(impartire);


        Column.add(poli1);
        Column.add(poli2);
        Column.add(operatori);
        Column.add(cm);
        Column.add(cm2);
        Column.add(cm3);
        Column.add(cm4);
        Column.add(cm5);
        Column.add(cm6);
        Column.setVisible(true);
    }

    private static JButton createSimpleButton(String text) {
        JButton buton = new JButton(text);
        buton.setForeground(Color.BLACK);
        buton.setBackground(Color.YELLOW);
        Border linie = BorderFactory.createLineBorder(Color.BLACK);
        Border margine = new EmptyBorder(5, 15, 5, 15);
        Border compunere = new CompoundBorder(linie, margine);
        buton.setBorder(compunere);
        return buton;
    }

    public void showEvents(){
        JButton validare1 = new JButton("Validare");
        JButton validare2 =  new JButton("Validare");
        validare1.setActionCommand("validare1");
        validare2.setActionCommand("validare2");
        plus.setActionCommand("plus");
        minus.setActionCommand("minus");
        inmultire.setActionCommand("ori");
        impartire.setActionCommand("impartire");
        validare1.addActionListener(new Controller(this));
        validare2.addActionListener(new Controller(this));
        plus.addActionListener(new Controller(this));
        minus.addActionListener(new Controller(this));
        inmultire.addActionListener(new Controller(this));
        impartire.addActionListener(new Controller(this));


        poli1.add(validare1);
        poli2.add(validare2);

        mainFrame.setVisible(true);
    }

}
