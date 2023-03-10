package MVC;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;

public class Controller implements ActionListener {
    View panel;
    String[] monoame1;
    String[] monoame2;

    public Controller(View panel) {
        this.panel = panel;
    }

    public void actionPerformed(ActionEvent e) {
        String comanda = e.getActionCommand();
        if (panel.valoare.getText().isEmpty()) panel.x=0;
        else
            panel.x =Integer.parseInt(panel.valoare.getText());

        if(comanda.equals("validare1"))  {
            String q = panel.polinom.getText();
            Polinom poli = this.createPoli(q);
            panel.cLabel1.setText("Rezultat polinom 1:");
            panel.sLabel1.setText(poli.afisare());
        } else if(comanda.equals("validare2")) {
            String q = panel.polinom2.getText();
            Polinom poli =  this.createPoli(q);
            panel.cLabel2.setText("Rezultat polinom 2:");
            panel.sLabel2.setText( poli.afisare());
        } else if(comanda.equals("plus")) {
            String q1 = panel.polinom.getText();
            String q2 = panel.polinom2.getText();
            Polinom poli3 = this.adunare(q1, q2);
            panel.cLabel3.setText("Rezultat suma polinoame:");
            panel.sLabel3.setText(poli3.afisare());
        } else if(comanda.equals("minus")) {
            String q1 = panel.polinom.getText();
            String q2 = panel.polinom2.getText();
            Polinom poli3 = this.sub(q1, q2);
            panel.cLabel4.setText("Rezultat scadere polinoame:");
            panel.sLabel4.setText(poli3.afisare());
        } else if(comanda.equals("ori")) {
            String q1 = panel.polinom.getText();
            String q2 = panel.polinom2.getText();
            Polinom poli3 = this.inmultire(q1, q2);
            panel.cLabel5.setText("Rezultat inmultire polinoame:");
            panel.sLabel5.setText(poli3.afisare() );
        } else if(comanda.equals("impartire")) {
            String q1 = panel.polinom.getText();
            String q2 = panel.polinom2.getText();
            ArrayList<Polinom> polis = new ArrayList<Polinom>();
            polis = this.impartire(q1, q2);
            panel.cLabel6.setText("Rezultat impartire polinoame:");
            panel.sLabel6.setText(polis.get(0).afisare() + " ,avand rest:  " + polis.get(1).afisare());
        }
    }

    private Polinom createPoli(String s) {
        String monoame[];
        String fb,ab;
        if(s.contains("-")) ab=s.replace("-", "+-");
        else ab=s;
        if (ab.charAt(0) == '+') fb=ab.substring(1);
        else fb= ab;
        monoame = fb.split("\\+");
        Polinom poli = new Polinom(monoame, panel.x);
        return poli;
    }

    private Polinom adunare(String q1, String q2) {
        Polinom poli1, poli2, poli3;
        poli1 = createPoli(q1);
        poli2 = createPoli(q2);
        poli3 = poli1.adunare(poli2);
        return poli3;
    }

    private Polinom sub(String q1, String q2) {
        Polinom poli1, poli2, poli3;
        poli1 = createPoli(q1);
        poli2 = createPoli(q2);
        poli3 = poli1.scadere(poli2);
        return poli3;
    }

    private Polinom inmultire(String q1, String q2) {
        Polinom poli1, poli2, poli3;
        poli1 = createPoli(q1);
        poli2 = createPoli(q2);
        poli3 = poli1.inmultire(poli2);
        return poli3;
    }

    private ArrayList<Polinom> impartire(String q1, String q2) {
        Polinom poli1, poli2;
        ArrayList<Polinom> polis = new ArrayList<Polinom>();
        poli1 = createPoli(q1);
        poli2 = createPoli(q2);
        polis = poli1.impartire(poli2);
        return polis;
    }

}

