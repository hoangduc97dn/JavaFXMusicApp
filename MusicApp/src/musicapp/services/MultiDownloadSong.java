package musicapp.services;

import musicapp.model.Download;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiDownloadSong {

    public void MultiDownload(ArrayList<Download> listSong) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        listSong.forEach((song) -> {
            executor.execute(() -> {
                DownloadSong downloadSong = new DownloadSong();
                try {
                    System.out.println("Trying to download: " + song.getSaveName());
                    downloadSong.downloadFile(song.getUrlDownload(), song.getSaveDir(), song.getSaveName());
                    System.out.println(song.getSaveName() + " was downloaded!!!");
                } catch (IOException ex) {
                    Logger.getLogger(MultiDownloadSong.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        });
        executor.shutdown();
    }
}
