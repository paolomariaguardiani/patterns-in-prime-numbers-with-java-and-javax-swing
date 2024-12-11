import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class PannelloForm extends JPanel {

    private int x = 1400 / 2;  // posiziono le immagini al centro dell'area di disegno
    private int y = 900 / 2;   // posiziono le immagini al centro dell'area di disegno

    private JLabel labelInitialNumber;
    private JTextField fieldInialNumber;

    private JLabel labelIterations;
    private JTextField fieldIterations;

    private JLabel labelTwinPrimes;
    private JCheckBox checkTwinPrimes;

    private JLabel labelCircleSize;
    private JTextField fieldCirleSize;

    private JButton buttonStart;
    private FormListener formListener;

    private JLabel labelIncrementNumbers;
    private JButton buttonNumMinus;
    private JButton buttonNumPlus;

    private JLabel labelIncrementIterations;
    private JButton buttonNumMinus2;
    private JButton buttonNumPlus2;

    private JLabel labelIncrementRadius;
    private JButton buttonNumMinus3;
    private JButton buttonNumPlus3;

    private Color colorPrimeNumbers;
    private JButton buttonColorPrimes;
    private JLabel labelColorPrimes;

    private Color colorTwinNumbers;
    private JButton buttonColorTwins;
    private JLabel labelColorTwins;

    private Color colorNumbers;
    private JButton buttonColorNumbers;
    private JLabel labelColorNumbers;

    private JButton buttonWest;
    private JButton buttonNorthWest;
    private JButton buttonNorth;
    private JButton buttonNorthEast;
    private JButton buttonEast;
    private JButton buttonSouthEast;
    private JButton buttonSouth;
    private JButton buttonSouthWest;
    private JButton buttonCenter;

    PannelloForm() {

        setPreferredSize(new Dimension(400, 100));
        setLayout(new GridBagLayout());

        Border bordoInterno = BorderFactory.createTitledBorder("Settings");
        Border bordoEsterno = BorderFactory.createEmptyBorder(0, 5, 5, 5);
        Border bordoFinale = BorderFactory.createCompoundBorder(bordoEsterno, bordoInterno);

        setBorder(bordoFinale);

        // Initial number
        labelInitialNumber = new JLabel("Initial number: ");
        fieldInialNumber = new JTextField("0", 10);  // è sempre bene specificare il numero di colonne

        // Iterations
        labelIterations = new JLabel("Iterations: ");
        fieldIterations = new JTextField("50", 10);

        // Twin Prime Numbers
        labelTwinPrimes = new JLabel("See Twin Primes: ");
        checkTwinPrimes = new JCheckBox("", true);

        // Circle size
        labelCircleSize = new JLabel("Circle size: ");
        fieldCirleSize = new JTextField("5", 10);

        // Bottone per generare le immagini
        // Icon arrow = new ImageIcon("arrow.gif");
        buttonStart = new JButton("START!");
        buttonStart.setMnemonic(KeyEvent.VK_S);

        // Aggiungo un ActionListener al bottone START
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw();
            }
        });


        // Label per incrementare il numero iniziale
        labelIncrementNumbers = new JLabel("Change Initial Number");
        labelIncrementNumbers.setPreferredSize(new Dimension(180, 30));

        // Bottone per decrementare il numero iniziale
        buttonNumMinus = new JButton("-");
        buttonNumMinus.setMnemonic(KeyEvent.VK_UP);  // alt + freccia in su per attivare il tasto

        buttonNumMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(fieldInialNumber.getText());
                numero--;
                fieldInialNumber.setText(String.valueOf(numero));

                draw();
            }
        });

        // Bottone per incrementare il numero iniziale
        buttonNumPlus = new JButton("+");
        buttonNumPlus.setMnemonic(KeyEvent.VK_DOWN);

        buttonNumPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(fieldInialNumber.getText());
                numero++;
                fieldInialNumber.setText(String.valueOf(numero));

                draw();
            }
        });


        // label per modificare il raggio dei cerchi
        labelIncrementIterations = new JLabel("Change Iterations");
        labelIncrementIterations.setPreferredSize(new Dimension(180, 30));

        // Bottone per decrementare il numero di iterazioni
        buttonNumMinus2 = new JButton("-");
        buttonNumMinus2.setMnemonic(KeyEvent.VK_LEFT);


        buttonNumMinus2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(fieldIterations.getText());
                numero--;
                fieldIterations.setText(String.valueOf(numero));

                draw();
            }
        });

        // Bottone per incrementare le iterazioni
        buttonNumPlus2 = new JButton("+");
        buttonNumPlus2.setMnemonic(KeyEvent.VK_RIGHT);

        buttonNumPlus2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(fieldIterations.getText());
                numero++;
                fieldIterations.setText(String.valueOf(numero));

                draw();
            }
        });

        // label per modificare il raggio dei cerchi
        labelIncrementRadius = new JLabel("Zoom In and Out");
        labelIncrementRadius.setPreferredSize(new Dimension(180, 30));

        // Bottone per decrementare il raggio dei cerchi
        buttonNumMinus3 = new JButton("-");

        buttonNumMinus3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(fieldCirleSize.getText());
                if (numero > 2) {  // se il raggio è minore di due non si vedono più i cerchi
                    numero--;
                }
                fieldCirleSize.setText(String.valueOf(numero));

                draw();
            }
        });

        // Bottone per incrementare il raggio dei cerchi
        buttonNumPlus3 = new JButton("+");

        buttonNumPlus3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(fieldCirleSize.getText());
                numero++;
                fieldCirleSize.setText(String.valueOf(numero));

                draw();
            }
        });

        // Selezione del colore per i numeri primi
        colorPrimeNumbers = new Color(0, 0, 255);
        buttonColorPrimes = new JButton("Prime Numbers: ");
        buttonColorPrimes.setPreferredSize(new Dimension(180, 30));
        labelColorPrimes = new JLabel();
        labelColorPrimes.setOpaque(true);  // per poterla colorare dopo
        labelColorPrimes.setBackground(colorPrimeNumbers);
        labelColorPrimes.setPreferredSize(new Dimension(25, 25));

        buttonColorPrimes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorPrimeNumbers = JColorChooser.showDialog(new JFrame(), "Select a color for prime numbers",
                        Color.BLUE);
                labelColorPrimes.setBackground(colorPrimeNumbers);
                draw();
            }
        });

        // Selezione del colore per i numeri primi gemelli
        colorTwinNumbers = new Color(255, 0, 0);
        buttonColorTwins = new JButton("Twin Primes:");
        buttonColorTwins.setPreferredSize(new Dimension(180, 30));
        labelColorTwins = new JLabel();
        labelColorTwins.setOpaque(true);  // per poterla colorare dopo
        labelColorTwins.setBackground(colorTwinNumbers);
        labelColorTwins.setPreferredSize(new Dimension(25, 25));

        buttonColorTwins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorTwinNumbers = JColorChooser.showDialog(new JFrame(), "Select a color for twin prime numbers",
                        Color.RED);
                labelColorTwins.setBackground(colorTwinNumbers);
                draw();
            }
        });

        // Selezione del colore per i numeri normali
        colorNumbers = new Color(192, 192, 192);
        buttonColorNumbers = new JButton("Other Numbers:");
        buttonColorNumbers.setPreferredSize(new Dimension(180, 30));
        labelColorNumbers = new JLabel();
        labelColorNumbers.setOpaque(true);  // per poterla colorare dopo
        labelColorNumbers.setBackground(colorNumbers);
        labelColorNumbers.setPreferredSize(new Dimension(25, 25));

        buttonColorNumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorNumbers = JColorChooser.showDialog(new JFrame(), "Select a color for twin prime numbers",
                        Color.LIGHT_GRAY);
                labelColorNumbers.setBackground(colorNumbers);
                draw();
            }
        });

        // Pannello per lo spostamento del disegno
        buttonWest = new JButton("4");
        buttonWest.setMnemonic(KeyEvent.VK_NUMPAD4);
        buttonWest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x -= 20;
                draw();
            }
        });

        buttonNorthWest = new JButton("7");
        buttonNorthWest.setMnemonic(KeyEvent.VK_NUMPAD7);
        buttonNorthWest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x -= 20;
                y -= 20;
                draw();
            }
        });

        buttonNorth = new JButton("8");
        buttonNorth.setMnemonic(KeyEvent.VK_NUMPAD8);
        buttonNorth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y -= 20;
                draw();
            }
        });

        buttonNorthEast = new JButton("9");
        buttonNorthEast.setMnemonic(KeyEvent.VK_NUMPAD9);
        buttonNorthEast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x += 20;
                y -= 20;
                draw();
            }
        });

        buttonEast = new JButton("6");
        buttonEast.setMnemonic(KeyEvent.VK_NUMPAD6);
        buttonEast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x += 20;
                draw();
            }
        });

        buttonSouthEast = new JButton("3");
        buttonSouthEast.setMnemonic(KeyEvent.VK_NUMPAD3);
        buttonSouthEast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x += 20;
                y += 20;
                draw();
            }
        });

        buttonSouth = new JButton("2");
        buttonSouth.setMnemonic(KeyEvent.VK_NUMPAD2);
        buttonSouth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y += 20;
                draw();
            }
        });

        buttonSouthWest = new JButton("1");
        buttonSouthWest.setMnemonic(KeyEvent.VK_NUMPAD1);
        buttonSouthWest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x -= 20;
                y += 20;
                draw();
            }
        });

        buttonCenter = new JButton("5");
        buttonCenter.setMnemonic(KeyEvent.VK_NUMPAD5);
        buttonCenter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Riporto al centro l'immagine
                x = 1400 / 2;
                y = 900 / 2;
                draw();
            }
        });

        // Layout
        GridBagConstraints gbc = new GridBagConstraints();

        // Riga 1: label Inital Number
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(labelInitialNumber, gbc);

        // Riga 1: field Inital Number
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(fieldInialNumber, gbc);

        // Riga 2: label number of cycles
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(labelIterations, gbc);

        // Riga 2: field number of cycles
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(fieldIterations, gbc);

        // Riga 3: label twin prime numbers
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(labelTwinPrimes, gbc);

        // Riga 3: checkbox twin prime numbers
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(checkTwinPrimes, gbc);

        // Riga 4: label circle size
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(labelCircleSize, gbc);

        // Riga 4: field circle size
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(fieldCirleSize, gbc);

        // Button START
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(20, 0, 20, 0);
        add(buttonStart, gbc);


        // Chose Prime Numbers color - button
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(buttonColorPrimes, gbc);

        // Chose Prime Numbers Color - Label
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(labelColorPrimes, gbc);

        // Chose Twin Prime Numbers color - button
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(buttonColorTwins, gbc);

        // Chose Twin Prime Numbers Color - Label
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(labelColorTwins, gbc);

        // Chose Normal Numbers color - button
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(buttonColorNumbers, gbc);

        // Chose Normal Numbers Color - Label
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(labelColorNumbers, gbc);

        // Line for the increment of the initial number
        JPanel rigaIncrementNumbers = new JPanel();
        rigaIncrementNumbers.setLayout(new FlowLayout());
        rigaIncrementNumbers.add(labelIncrementNumbers);
        rigaIncrementNumbers.add(buttonNumMinus);
        rigaIncrementNumbers.add(buttonNumPlus);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(20, 0, 0, 5);
        add(rigaIncrementNumbers, gbc);

        // Line for the increment of the iterations
        JPanel rigaIncrementIterations = new JPanel();
        rigaIncrementIterations.setLayout(new FlowLayout());
        rigaIncrementIterations.add(labelIncrementIterations);
        rigaIncrementIterations.add(buttonNumMinus2);
        rigaIncrementIterations.add(buttonNumPlus2);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(20, 0, 0, 5);
        add(rigaIncrementIterations, gbc);

        // Line for the increment of the radius
        JPanel rigaIncrementRadius = new JPanel();
        rigaIncrementRadius.setLayout(new FlowLayout());
        rigaIncrementRadius.add(labelIncrementRadius);
        rigaIncrementRadius.add(buttonNumMinus3);
        rigaIncrementRadius.add(buttonNumPlus3);
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(20, 0, 0, 5);
        add(rigaIncrementRadius, gbc);

        // First line of commands for the shifting of the image
        JPanel firstLineImageShift = new JPanel();
        firstLineImageShift.setLayout(new FlowLayout());
        firstLineImageShift.add(buttonNorthWest);
        firstLineImageShift.add(buttonNorth);
        firstLineImageShift.add(buttonNorthEast);
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(0, 30, 0, 5);
        add(firstLineImageShift, gbc);

        // Second line of commands for the shifting of the image
        JPanel secondLineImageShift = new JPanel();
        secondLineImageShift.setLayout(new FlowLayout());
        secondLineImageShift.add(buttonWest);
        secondLineImageShift.add(buttonCenter);
        secondLineImageShift.add(buttonEast);
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(0, 30, 0, 5);
        add(secondLineImageShift, gbc);

        // Third line of commands for the shifting of the image
        JPanel thirdLineImageShift = new JPanel();
        thirdLineImageShift.setLayout(new FlowLayout());
        thirdLineImageShift.add(buttonSouthWest);
        thirdLineImageShift.add(buttonSouth);
        thirdLineImageShift.add(buttonSouthEast);
//        thirdLineImageShift.add(buttonSouthWest);
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(0, 30, 0, 5);
        add(thirdLineImageShift, gbc);

    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

    public void draw() {
        // invio i nuovi dati al form event e al form listener
        x = this.x;
        y = this.y;
        int numeroDaValutare = Integer.parseInt(fieldInialNumber.getText());
        int numeroDiCicli = Integer.parseInt(fieldIterations.getText());
        int raggio = Integer.parseInt(fieldCirleSize.getText());
        boolean findTwinsPrimes = checkTwinPrimes.isSelected();

        FormEvent formEvent = new FormEvent(this, x, y, raggio, numeroDaValutare, numeroDiCicli,
                findTwinsPrimes, colorPrimeNumbers, colorTwinNumbers, colorNumbers);

        // Controlliamo se esiste il formListener
        if (formListener != null) {
            formListener.formEventListener(formEvent);
        }
    }
}
