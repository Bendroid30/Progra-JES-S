import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CronometroApp {

    private JFrame frame;
    private JTextArea textArea;
    private JLabel labelTiempo;
    private JButton botonIniciar;
    private JButton botonDetener;
    private SwingWorker<Integer, Integer> cronometroWorker;

    private int tiempoTranscurrido = 0;

    public CronometroApp() {
        frame = new JFrame("Cronómetro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        frame.add(textArea, BorderLayout.CENTER);

        labelTiempo = new JLabel("Tiempo transcurrido: 0 segundos");
        frame.add(labelTiempo, BorderLayout.NORTH);

        botonIniciar = new JButton("Iniciar");
        botonDetener = new JButton("Detener");

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonIniciar);
        panelBotones.add(botonDetener);

        frame.add(panelBotones, BorderLayout.SOUTH);

        botonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarCronometro();
            }
        });

        botonDetener.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detenerCronometro();
            }
        });

        frame.setVisible(true);
    }

    private void iniciarCronometro() {
        botonIniciar.setEnabled(false);
        botonDetener.setEnabled(true);
        textArea.setEnabled(true);

        cronometroWorker = new SwingWorker<Integer, Integer>() {
            @Override
            protected Integer doInBackground() {
                while (!isCancelled()) {
                    try {
                        Thread.sleep(1000); // Esperar un segundo
                    } catch (InterruptedException e) {
                        break;
                    }
                    tiempoTranscurrido++;
                    publish(tiempoTranscurrido);
                }
                return tiempoTranscurrido;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                int ultimoTiempo = chunks.get(chunks.size() - 1);
                labelTiempo.setText("Tiempo transcurrido: " + ultimoTiempo + " segundos");
            }
        };

        cronometroWorker.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("state".equals(evt.getPropertyName()) && SwingWorker.StateValue.DONE == evt.getNewValue()) {
                    botonIniciar.setEnabled(true);
                    botonDetener.setEnabled(false);
                }
            }
        });

        cronometroWorker.execute();
    }

    private void detenerCronometro() {
        if (cronometroWorker != null && !cronometroWorker.isDone()) {
            cronometroWorker.cancel(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CronometroApp();
            }
        });
    }
}
