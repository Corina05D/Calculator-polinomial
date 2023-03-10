package MVC;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Monom {
    public String monom;
    public int putere;
    public int coeficient;
    public double dcoeficient;
    private String[] q;

    public Monom(String monom) {
        if(validare(monom))  {
            this.monom = monom;
        }
        dcoeficient = (double)coeficient;
    }

    public Monom(int coeficient, int putere) {
        this.putere = putere;
        this.coeficient = coeficient;
        dcoeficient = coeficient;
        this.monom = format();
    }

    public Monom(double dcoeficient, int coeficient, int putere) {
        this.putere = putere;
        this.coeficient = coeficient;
        this.dcoeficient = dcoeficient;
        this.monom = format();
    }

    private String format() {
        String c = new String(this.dcoeficient + "x^" + this.putere);
        return c;
    }


    public boolean isNegative() {
        if (this.coeficient < 0) return true;
        else return false;
    }

    public String getMonom() {
        if (putere == 0) return Double.toString(dcoeficient);
        else return dcoeficient + "x^" + putere;
    }

    public void afisare() {
        System.out.println("Putere: " + putere + " Coeficient: " + coeficient + "\n");
    }

    public int getCoeficient() {
        return this.coeficient;
    }

    public int getPutere() {
        return this.putere;
    }

    public int valoare(int x) {
        return (int) (dcoeficient * Math.pow(x, putere));
    }

    public double dValoare(double x) {
        return dcoeficient * Math.pow(x, putere);
    }

    public void addCoeficient(int x) {
        this.coeficient =this.coeficient + x;
        this.dcoeficient = (double)coeficient;
    }

    public Monom inmultire(Monom monom1) {
        Monom m;
        double coef = this.dcoeficient * monom1.dcoeficient;
        int dcoef = (int)coef;
        int put = this.getPutere() + monom1.getPutere();
        m = new Monom(coef,dcoef,put);
        return m;
    }

    public Monom impartire(Monom divizor) {
        Monom ret;
        double c = this.dcoeficient / divizor.dcoeficient;
        int d = (int)c;
        int p = this.getPutere() - divizor.getPutere();
        ret = new Monom(c, d, p);
        return ret;
    }

    public static Comparator<Monom> CompByPutere() {
        Comparator<Monom> comp = new Comparator<Monom>(){
            public int compare(Monom s1, Monom s2) {
                return Integer.compare(s1.putere, s2.putere);
            }
        };
        return comp;
    }

    private boolean validare(String monom) {
        if(!monom.matches("^[a-zA-Z0-9\\^\\*\\- ]*")) return false;
        Pattern formatPolinom = Pattern.compile("\\^");
        Matcher m = formatPolinom.matcher(monom);
        String s = new String();
        while(m.find()) {
            s = m.group();
        }
        if(s.isEmpty()) {
            q = monom.split("[a-zA-Z]");
            if(q.length == 0) {
                coeficient = 1;
                putere = 1;
            } else {
                if(!q[0].isEmpty())coeficient = Integer.parseInt(q[0]);
                else coeficient = 1;
                if(q[0] == monom) putere = 0 ;
                else putere = 1;
            }
        } else {
            q = monom.split("\\^");
            try {
                String nString = new String();
                for(int i = 0; i < q[0].length(); i++){
                    char a = q[0].charAt(i);
                    if(a == 45) nString = nString + a;
                    if(a > 47 && a < 58) nString = nString + a;
                }
                if(nString.isEmpty()) coeficient = 1 ;
                else coeficient=Integer.parseInt(nString);
                putere = Integer.parseInt(q[1]);
            } catch(NumberFormatException e) {
                System.out.println("Format invalid");
            }
        }
        return true;
    }
}


