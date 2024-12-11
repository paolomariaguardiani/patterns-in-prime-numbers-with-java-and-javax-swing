import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame {

    private PannelloForm pannelloForm;
    public MyCanvas mc;

    public Frame() {
        super("Ulam Spiral Square in Java");

        // Definisco il tipo di Layout
        setLayout(new BorderLayout());

        pannelloForm = new PannelloForm();
        mc = new MyCanvas();


        pannelloForm.setFormListener(new FormListener() {
            @Override
            public void formEventListener(FormEvent fe) {
                // mc.repaint(0, 0, 2000, 1000);
                mc.repaint();

                mc.x = fe.getX();
                mc.y = fe.getY();
                mc.raggio = fe.getRaggio();
                mc.numeroDaValutare = fe.getNumeroDaValutare();
                mc.numeroDiCicli = fe.getNumeroDiCicli();
                mc.findTwinsPrimes = fe.isFindTwinsPrimes();
                mc.colorPrimeNumbers = fe.getColorPrimeNumbers();
                mc.colorTwinNumbers = fe.getColorTwinNumbers();
                mc.colorNumbers = fe.getColorNumbers();
//                mc.setBackground(Color.PINK);
            }
        });

        // Aggiungo i KeyListener per il controllo con la tastiera
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Ridisegno l'immagine
                mc.repaint();
                // Modifico il numero di partenza
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    mc.numeroDaValutare++;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    mc.numeroDaValutare--;
                }
                // Regolo il numero di cicli
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    mc.numeroDiCicli--;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    mc.numeroDiCicli++;
                }
                // Ingrandisco e rimpicciolisco i cerchi
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    mc.raggio--;
                }
                if (e.getKeyCode() == KeyEvent.VK_T) {
                    mc.raggio++;
                }
                // Scrivo le informazioni nel titolo della finestra
                setTitle("Initial number: " + mc.numeroDaValutare + " --- Numero of cycles: " + mc.numeroDiCicli + " --- Radius: " + mc.raggio + " pixels");
                // Scelgo se visualizzare i numeri primi gemelli oppure no
                if (e.getKeyCode() == KeyEvent.VK_I) {
                    mc.findTwinsPrimes = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_O) {
                    mc.findTwinsPrimes = false;
                }
                mc.repaint();

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        add(pannelloForm, BorderLayout.LINE_START);

        add(mc, BorderLayout.CENTER);



        setSize(1700, 1000);

        setLocationRelativeTo(null);  // la finestra compare al centro

        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }

    public void keyPressed(KeyEvent e) {

    }

}
