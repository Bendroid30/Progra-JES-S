package cronómetro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronometro extends JFrame {
    private JPanel panelPrincipal;
    private JLabel cronometro;
    private JTextArea textArea1;
    private JButton iniciarButton;
    private JButton reiniciarButton;
    private JButton pararButton;

    public Cronometro(){
        setLocation(380,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panelPrincipal);
        pack();
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int segundos=0;
                int minutos=0;

            }
        });
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cronometro.setText("00:00");
            }
        });
    }
}
