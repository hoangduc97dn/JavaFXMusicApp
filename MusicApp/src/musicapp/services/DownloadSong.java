package musicapp.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadSong {

    private static final int BUFFER_SIZE = 4096;

    public void downloadFile(String urlFile, String saveDir, String fileName) throws IOException {
        HttpURLConnection httpConn;
        try {
            URL url = new URL(urlFile);
            httpConn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            return;
        }

        int responceCode = httpConn.getResponseCode();
        int contentLength = httpConn.getContentLength();

        System.out.println("Server return responce code: " + responceCode);
        System.out.println("File size: " + contentLength);
        System.out.println("Waiting for download file...");
        if (responceCode == HttpURLConnection.HTTP_OK) {

            FileOutputStream ouputStream;
            try (InputStream inputStream = httpConn.getInputStream()) {
                String fileSave = saveDir + File.separator + fileName + ".mp3";
                ouputStream = new FileOutputStream(fileSave);
                int byteSize = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((byteSize = inputStream.read(buffer)) != -1) {
                    ouputStream.write(buffer, 0, byteSize);
                }
            }
            ouputStream.close();
            System.out.println("File was downloaded !!!");
        } else {
            System.out.println("Error with file you want to download");
        }

        httpConn.disconnect();

    }

}
