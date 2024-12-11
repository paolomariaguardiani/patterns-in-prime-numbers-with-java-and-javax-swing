import java.awt.*;
import java.util.EventObject;

public class FormEvent extends EventObject {

    private int x;
    private int y;
    private int raggio;
    private int numeroDaValutare;
    private int numeroDiCicli;
    private boolean findTwinsPrimes;
    private Color colorPrimeNumbers;
    private Color colorTwinNumbers;
    private Color colorNumbers;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public FormEvent(Object source) {
        super(source);
    }

    // Generiamo un costruttore
    public FormEvent(Object source, int x, int y, int raggio, int numeroDaValutare, int numeroDiCicli,
                     boolean findTwinsPrimes, Color colorPrimeNumbers, Color colorTwinNumbers, Color colorNumbers) {
        super(source);
        this.x = x;
        this.y = y;
        this.raggio = raggio;
        this.numeroDaValutare = numeroDaValutare;
        this.numeroDiCicli = numeroDiCicli;
        this.findTwinsPrimes = findTwinsPrimes;
        this.colorPrimeNumbers = colorPrimeNumbers;
        this.colorTwinNumbers = colorTwinNumbers;
        this.colorNumbers = colorNumbers;
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

    public int getNumeroDiCicli() {
        return numeroDiCicli;
    }

    public void setNumeroDiCicli(int numeroDiCicli) {
        this.numeroDiCicli = numeroDiCicli;
    }

    public boolean isFindTwinsPrimes() {
        return findTwinsPrimes;
    }

    public void setFindTwinsPrimes(boolean findTwinsPrimes) {
        this.findTwinsPrimes = findTwinsPrimes;
    }

    public Color getColorPrimeNumbers() {
        return colorPrimeNumbers;
    }

    public void setColorPrimeNumbers(Color colorPrimeNumbers) {
        this.colorPrimeNumbers = colorPrimeNumbers;
    }

    public Color getColorTwinNumbers() { return colorTwinNumbers; }

    public void setColorTwinNumbers(Color ColorTwinNumbers) { this.colorTwinNumbers = colorTwinNumbers; }

    public Color getColorNumbers() {
        return colorNumbers;
    }

    public void setColorNumbers(Color colorNumbers) {
        this.colorNumbers = colorNumbers;
    }
}
