package MVC;
import java.util.ArrayList;
import java.util.Collections;


public class Polinom {
    String[] monomString;
    ArrayList<Monom> monom = new ArrayList<Monom>();
    public int x;

    public Polinom(String[] monomStrimg, int x) {
        this.monomString = monomStrimg;
        this.x = x;
        for(int i=0; i<monomString.length; i++) {
            System.out.println(monomString[i]);
            monom.add(new Monom(monomString[i]));
        }
        for (int i = 0; i < monom.size(); i++) {
            Monom temp = monom.get(i);
            temp.afisare();
        }
        this.sort_min();
        this.sort_min();
    }

    private Polinom(int x) {
        this.x = x;
    }

    private Polinom(Monom monom, int x) {
        this.x = x;
        this.monom.add(monom);
    }

    private void delete() {
        for(int i=0;i<monom.size();i++) {
            if(monom.get(i).coeficient == 0) monom.remove(i);
        }
    }

    public String afisare() {
        String s = new String("");
        for(int i=0;i<monom.size();i++) {
            if(monom.get(i).coeficient < 0) {
                s=s+ monom.get(i).getMonom();
            } else {
                if (0 == i) s = s + monom.get(i).getMonom() ;
                else s=s + "+" + monom.get(i).getMonom();
            }
        }
        return s;
    }

    public double valoare() {
        double d = 0;
        for(int i=0;i<monom.size(); i++) {
            d = d +monom.get(i).valoare(x);
        }
        return d;
    }

    public int Grad() {
        int g=-1;
        for(int i=0;i<monom.size();i++) {
            if(g < monom.get(i).getPutere()) g = monom.get(i).getPutere();
        }
        return g;
    }

    private void sort_min() {
        for(int i=0;i<monom.size();i++) {
            int p = monom.get(i).getPutere();
            for(int j=i+1;j<monom.size();j++) {
                int tp = monom.get(j).getPutere();
                if(p == tp) {
                    monom.get(i).addCoeficient(monom.get(j).getCoeficient());
                    this.monom.remove(j);
                }
            }
        }
        Collections.sort(this.monom, Monom.CompByPutere());
    }


    public Polinom adunare(Polinom p2) {
        Polinom p3 = new Polinom(x);

        for(int i=0;i<this.monom.size();i++) {
            int pu1 = this.monom.get(i).getPutere();
            int co1 = this.monom.get(i).getCoeficient();

            int i_p = p2.IndexPutere(pu1);
            if(i_p == -1) {
                p3.monom.add(new Monom(co1, pu1));
            } else {
                int pu3 = p2.monom.get(i_p).getPutere();
                int co3 = p2.monom.get(i_p).getCoeficient();
                p3.monom.add(new Monom(co1+co3, pu3));
                p2.monom.remove(i_p);
            }
        }
        for(int j=0;j<p2.monom.size();j++) {
            int pu2 = p2.monom.get(j).getPutere();
            int co2 = p2.monom.get(j).getCoeficient();
            p3.monom.add(new Monom(co2, pu2));
        }
        return p3;
    }

    public Polinom inmultire(Polinom p2) {
        Polinom p3 = new Polinom(x);
        for(int i=0;i<this.monom.size();i++) {
            Monom mo1 = this.monom.get(i);
            for(int j=0;j<p2.monom.size();j++) {
                Monom mo2 = p2.monom.get(j);
                Monom mo3 = mo1.inmultire(mo2);
                p3.monom.add(mo3);
            }
        }
        p3.sort_min();
        p3.sort_min();
        return p3;
    }

    public Polinom scadere(Polinom p2) {
        Polinom p3;
        for(int i=0;i<p2.monom.size();i++) {
            p2.monom.get(i).coeficient = p2.monom.get(i).coeficient*(-1);
        }
        p3 = this.adunare(p2);
        p3.delete();
        return p3;
    }

    private int IndexPutere(int putere) {
        for(int i=0;i<monom.size();i++) {
            Monom m = monom.get(i);
            if(putere == m.getPutere())
                return i;
        }
        return -1;
    }

    private Monom cautaMaxim(Polinom p) {
        int putere = p.Grad();
        int d = p.IndexPutere(putere);
        return p.monom.get(d);
    }


    public ArrayList<Polinom> impartire(Polinom impartitor) {
        ArrayList<Polinom> p = new ArrayList<Polinom>();
        Polinom c = new Polinom(x);
        Polinom r = new Polinom(x);
        r = this;
        if(r.Grad() < impartitor.Grad()) {
            c.monom.add(new Monom(0,0));
        } else {
            while(r.Grad() >= impartitor.Grad()) {
                Monom dmax = cautaMaxim(r);
                Monom imax = cautaMaxim(impartitor);
                Monom monom = dmax.impartire(imax);
                Polinom pmax= new Polinom(monom, x);
                c.monom.add(monom);
                r = r.scadere(impartitor.inmultire(pmax));
            }
        }
        if(r.monom.isEmpty()) r.monom.add(new Monom(0,0));
        p.add(c);
        p.add(r);
        return p;
    }
}
