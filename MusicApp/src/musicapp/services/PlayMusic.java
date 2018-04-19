package musicapp.services;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlayMusic extends Thread {

    private final Media media = new Media(getClass().getResource("nlo.mp3").toString());
    private final MediaPlayer mediaPlayer = new MediaPlayer(media);

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            
        }
    }
}
