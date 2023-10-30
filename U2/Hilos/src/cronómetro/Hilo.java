package cronómetro;

import javax.swing.*;

public class Hilo extends SwingWorker<String, Integer> {
    private int segundos;
    JLabel cronometro;
    private int minutos;

    public Hilo(int segundos, int minutos, JLabel cronometro) {
        this.segundos = segundos;
        this.minutos = minutos;
        this.cronometro = cronometro;
    }

    @Override
    protected String doInBackground() throws Exception {
        while (!isCancelled()) {
            try {
                Thread.sleep(1000); // Esperar un segundo
            } catch (InterruptedException e) {
                System.out.println("Espera");
                break;
            }
            if (minutos < 10) {
                if (segundos < 10) {
                    segundos++;
//                    cronometro.setText("0" + minutos + ":0" + segundos);

                } else if (segundos != 59) {
                    segundos++;
//                    cronometro.setText("0" + minutos + ":" + segundos);
                } else {
                    minutos++;
                    segundos = 0;
//                    cronometro.setText("0"+minutos+":0"+segundos);
                }

            } else {
                if (segundos < 10) {
                    segundos++;
//                    cronometro.setText("0" + minutos + ":0" + segundos);

                } else if (segundos != 59) {
                    segundos++;
//                    cronometro.setText("0" + minutos + ":" + segundos);
                } else {
                    minutos++;
                    segundos = 0;
//                    cronometro.setText("0"+minutos+":0"+segundos);
                }
            }
            publish(minutos, segundos);


        }
        return cronometro.getText();
    }

    @Override
    protected void process(java.util.List<Integer> chunks) {
        int minuto = chunks.get(chunks.size() - 2);
        int segundos = chunks.get(chunks.size() - 1);
        if (minuto < 10) {
            if (segundos < 10) {
                cronometro.setText("0" + minuto + ":0" + segundos);
            }else {
                cronometro.setText("0" + minuto + ":" + segundos);
            }

        }else {
            if (segundos < 10) {
                cronometro.setText(minuto + ":0" + segundos);
            }else {
                cronometro.setText(minuto + ":" + segundos);
            }
        }

    }
}
