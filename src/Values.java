public class Values {
    private int x;
    private int y;
    private int lato;
    private int raggio;
    private int numeroDaValutare;
    private int accapo;
    private int numeroDiRighe;

    // Creo un costruttore di default
    public Values() {

    }

    // Creo un costruttore completo
    public Values(int x, int y, int lato, int raggio, int numeroDaValutare, int accapo, int numeroDiRighe) {
        setX(x);
        setY(y);
        setLato(lato);
        setRaggio(raggio);
        setNumeroDaValutare(numeroDaValutare);
        setAccapo(accapo);
        setNumeroDiRighe(numeroDiRighe);
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLato() {
        return lato;
    }

    public void setLato(int lato) {
        this.lato = lato;
    }

    public int getRaggio() {
        return raggio;
    }

    public void setRaggio(int raggio) {
        this.raggio = raggio;
    }

    public int getNumeroDaValutare() {
        return numeroDaValutare;
    }

    public void setNumeroDaValutare(int numeroDaValutare) {
        this.numeroDaValutare = numeroDaValutare;
    }

    public int getAccapo() {
        return accapo;
    }

    public void setAccapo(int accapo) {
        this.accapo = accapo;
    }

    public int getNumeroDiRighe() {
        return numeroDiRighe;
    }

    public void setNumeroDiRighe(int numeroDiRighe) {
        this.numeroDiRighe = numeroDiRighe;
    }
}
