import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;
import javax.swing.*;

public class MyCanvas extends JComponent {

    public int x;
    public int y;
    public int lato;
    public int raggio;
    public int numeroDaValutare;
    public int numeroDiCicli;
    public Color colorPrimeNumbers;
    public Color colorTwinNumbers;
    public Color colorNumbers;
    public boolean findTwinsPrimes = true;

    // numeri interessanti dopo cui andare accapo: 77, ...
    public void paint(Graphics g) {

        // pulisco lo schermo
        g.clearRect(0, 0, 2000, 1000);

//        setSize(1700, 1400);
//        setBackground(Color.PINK);


        // E' importante ricrearsi delle variabili locali, altrimenti il metodo paint lavora male (così mi è sembrato)
        IsPrime num = new IsPrime();
        int x = this.x;
        int y = this.y;
        int lato = this.lato;
        int raggio = this.raggio;
        int numeroDaValutare = this.numeroDaValutare;
        int numeroDiCicli = this.numeroDiCicli;
        boolean findTwinsPrimes = this.findTwinsPrimes;
        Color colorPrimeNumbers = this.colorPrimeNumbers;
        Color colorTwinNumbers = this.colorTwinNumbers;
        Color colorNumbers = this.colorNumbers;

        int aDestra = 1;
        int inAlto = 1;
        int aSinistra = 2;
        int inBasso = 2;
        int numeroPerSpostamentiDestraAlto = 3;
        int numeroPerSpostamentiSinistraBasso = 4;
        int i = 0;
        int j = 0;
        int q = 0;
        int r = 0;

        for (int l = 0; l < numeroDiCicli; l++) {
            while (i < aDestra) {
                if (num.trovaNumeriPrimi(numeroDaValutare)) {
                    g.setColor(colorPrimeNumbers);
                    // Verifico se si tratta di numeri primi gemelli
                    if (findTwinsPrimes) {
                        if (num.trovaNumeriPrimi(numeroDaValutare + 2) || num.trovaNumeriPrimi(numeroDaValutare - 2)) {
                            g.setColor(colorTwinNumbers);
                        }
                    }
                } else {
                    g.setColor(colorNumbers);
                }

                g.fillOval(x, y, raggio, raggio);
                x += raggio;
                numeroDaValutare++;
                i++;
            }
            while (j < inAlto) {
                if (num.trovaNumeriPrimi(numeroDaValutare)) {
                    g.setColor(colorPrimeNumbers);
                    // Verifico se si tratta di numeri primi gemelli
                    if (findTwinsPrimes) {
                        if (num.trovaNumeriPrimi(numeroDaValutare + 2) || num.trovaNumeriPrimi(numeroDaValutare - 2)) {
                            g.setColor(colorTwinNumbers);
                        }
                    }
                } else {
                    g.setColor(colorNumbers);
                }
                g.fillOval(x, y, raggio, raggio);
                y -= raggio;
                numeroDaValutare++;
                j++;
            }
            while (q < aSinistra) {
                if (num.trovaNumeriPrimi(numeroDaValutare)) {
                    g.setColor(colorPrimeNumbers);
                    // Verifico se si tratta di numeri primi gemelli
                    if (findTwinsPrimes) {
                        if (num.trovaNumeriPrimi(numeroDaValutare + 2) || num.trovaNumeriPrimi(numeroDaValutare - 2)) {
                            g.setColor(colorTwinNumbers);
                        }
                    }
                } else {
                    g.setColor(colorNumbers);
                }
                g.fillOval(x, y, raggio, raggio);
                x -= raggio;
                numeroDaValutare++;
                q++;
            }
            while (r < inBasso) {
                if (num.trovaNumeriPrimi(numeroDaValutare)) {
                    g.setColor(colorPrimeNumbers);
                    // Verifico se si tratta di numeri primi gemelli
                    if (findTwinsPrimes) {
                        if (num.trovaNumeriPrimi(numeroDaValutare + 2) || num.trovaNumeriPrimi(numeroDaValutare - 2)) {
                            g.setColor(colorTwinNumbers);
                        }
                    }
                } else {
                    g.setColor(colorNumbers);
                }
                g.fillOval(x, y, raggio, raggio);
                y += raggio;
                numeroDaValutare++;
                r++;
            }
            aDestra += numeroPerSpostamentiDestraAlto;
            inAlto += numeroPerSpostamentiDestraAlto;
            aSinistra += numeroPerSpostamentiSinistraBasso;
            inBasso += numeroPerSpostamentiSinistraBasso;
            // Il numeroPerSpostamenti va aumentato ad ogni ciclo di 2 unità
            // Senza questo particolare non si ottiene la spirale quadrata!!
            numeroPerSpostamentiDestraAlto += 2;
            numeroPerSpostamentiSinistraBasso += 2;
        }

//        for (int i = 0; i < numeroDiRighe; i++) {
//            for (int j = 0; j < accapo; j += 1) {
//                if (num.trovaNumeriPrimi(numeroDaValutare)) {
//                    g.setColor(Color.BLUE);
//                } else {
//                    g.setColor(Color.PINK);
//                }
////                g.fillRect(x, y, larghezza, altezza);
//                g.fillOval(x, y, raggio, raggio);
//                x += raggio;
//                numeroDaValutare++;
//            }
//            // Riporto la x a 0 e vado a capo di una riga
//            x = 0;
//            y += raggio;
//        }
    }
}
