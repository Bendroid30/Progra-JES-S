package cronómetro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronometro extends JFrame {
    private JPanel panelPrincipal;
    protected JLabel temporizador;
    private JTextArea textArea1;
    private JButton iniciarButton;
    private JButton reiniciarButton;
    private JButton pararButton;

    public Cronometro() {
        setLocation(380, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panelPrincipal);
        pack();
        Hilo hilo = new Hilo(Integer.parseInt(temporizador.getText().substring(0, 2)), Integer.parseInt(temporizador.getText().substring(3, 5)), temporizador);
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!pararButton.isEnabled()) {
                    iniciarButton.setEnabled(false);
                    pararButton.setEnabled(true);
                    hilo.execute();
                }
            }
        });
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!iniciarButton.isEnabled()) {
                    try {
                        hilo.wait(10000000);
                    } catch (InterruptedException ex) {
                        System.out.println("Hilo detenido");
                    }
                    temporizador.setText("00:00");
                    iniciarButton.setEnabled(true);
                    pararButton.setEnabled(false);
                }

            }
        });
        pararButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hilo != null && !hilo.isDone()) {
                    hilo.cancel(true);
                }
                pararButton.setEnabled(false);
                iniciarButton.setEnabled(true);

            }
        });
    }

    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro();
    }
}
