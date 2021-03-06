package keympc;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class KeyMPC {

    String b[] = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"};
    Action[] actions = new AbstractAction[26];
    public static AudioStream audioStream1, audioStream2, audioStream3, audioStream4, audioStream5, audioStream6, audioStream7, audioStream8, audioStream9, audioStream10;
    public static AudioStream[] a;

    public KeyMPC() throws Exception {

        JFrame frame = new JFrame();

        JButton[] buttons = new JButton[26];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(b[i]);
            buttons[i].setSize(80, 80);
            buttons[i].addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    try {
                        InputStream audioInputStream;
                        //please change file location for wav files, I will upload wav files soon.
                        if (e.getKeyChar() == 'd') {
                            audioInputStream = new FileInputStream("/home/chandubaba/Desktop/play/kick.wav");
                            a[0] = new AudioStream(audioInputStream);
                            AudioPlayer.player.start(a[0]);
                        }
                        else if (e.getKeyChar() == 'e') {
                            audioInputStream = new FileInputStream("/home/chandubaba/Desktop/play/snare.wav");
                            a[1] = new AudioStream(audioInputStream);
                            AudioPlayer.player.start(a[1]);
                        }
                        else if (e.getKeyChar() == 'z') {
                            audioInputStream = new FileInputStream("/home/chandubaba/Desktop/play/bhee2.wav");
                            a[2] = new AudioStream(audioInputStream);
                            AudioPlayer.player.start(a[2]);
                        }
                        else if (e.getKeyChar() == 'x') {
                            audioInputStream = new FileInputStream("/home/chandubaba/Desktop/play/bhee3.wav");
                            a[3] = new AudioStream(audioInputStream);
                            AudioPlayer.player.start(a[3]);
                        }
                        else if (e.getKeyChar() == 'c') {
                            audioInputStream = new FileInputStream("/home/chandubaba/Desktop/play/bhee4.wav");
                            a[4] = new AudioStream(audioInputStream);
                            AudioPlayer.player.start(a[4]);
                        }
                        else if (e.getKeyChar() == 'v') {
                            audioInputStream = new FileInputStream("/home/chandubaba/Desktop/play/bhee5.wav");
                            a[5] = new AudioStream(audioInputStream);
                            AudioPlayer.player.start(a[5]);
                        }
                        else if (e.getKeyChar() == 'b') {
                            audioInputStream = new FileInputStream("/home/chandubaba/Desktop/play/bhee1.wav");
                            a[6] = new AudioStream(audioInputStream);
                            AudioPlayer.player.start(a[6]);
                        }
                        
                        //clip = AudioSystem.getClip();
                        //clip.open(audioInputStream);
                        //clip.start();
                    } catch (IOException ex) {
                        System.out.println("Error with playing sound." + ex.toString());
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                     if(e.getKeyChar()=='d'){
                        // AudioPlayer.player.stop(a[0]);
                     } if(e.getKeyChar()=='e'){
                        // AudioPlayer.player.stop(a[1]);
                     }
                    // if (audioStream1 != null) {
                    //  AudioPlayer.player.stop(audioStream1);
                    // }
                }

            });
            frame.add(buttons[i]);
        }

        JPanel contentPane = (JPanel) frame.getContentPane();

        frame.setLayout(new GridLayout(3, 5, 5, 3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        a = new AudioStream[]{audioStream1, audioStream2, audioStream3, audioStream4, audioStream5, audioStream6, audioStream7, audioStream8, audioStream9, audioStream10};
        SwingUtilities.invokeLater(() -> {
            try {
                KeyMPC keyMPC;
                keyMPC = new KeyMPC();
            } catch (Exception e) {
            }
        });

    }


}
