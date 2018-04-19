package musicapp.controller;

import musicapp.model.Song;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class getlinkDownloadFromNhaccuatui {

    private final static String urlSearch = "https://www.nhaccuatui.com/tim-kiem/bai-hat?q=";
    private static ArrayList<Song> listSongDownload = new ArrayList<Song>();

    private String tenbh = "";
    private String singer = "";
    private String maxQuality = "";
    private String url = "";
    private String urlDownload = "";
    private String urlDownload128 = "";
    private String urlDownload320 = "";
    private String urlDownloadll = "";
    private String source = "Nhaccuatui.com";
    private String lyric = "";
    private ArrayList<Song> listSongFromKeyword = new ArrayList<Song>();
    private ArrayList<String> listSongQuality = new ArrayList<String>();

    protected String getLinkDownload(String songID) {

        String str = null;
        try {
            URL url = new URL("https://www.nhaccuatui.com/download/song/" + songID);
            HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
            httpcon.setRequestProperty("Cookie", "NCT_AUTH=a84f5f763fc6c0775fcc55db8692582f6ab3d8751e7cd0115aea19b00260669f; "
                    + "NCT_LastLogin=1522112379849; NCT_BALLOON_INDEX-lamtinhcntt=true; "
                    + "session_id_web=di43yj2ozrs1522112381964");

            httpcon.addRequestProperty("referer", "https://www.nhaccuatui.com/");
            httpcon.connect();
            System.out.println(httpcon.getResponseCode());
            InputStream input = httpcon.getInputStream();
            BufferedReader bufferRD = new BufferedReader(new InputStreamReader(input));
            String line = bufferRD.readLine();
            str = line;

        } catch (Exception e) {

        }
        //System.out.println(str);
        if (str.contains("waiting_approve")) {
            return "";
        }
        str = str.replaceAll(Pattern.quote("\\"), "").split("stream_url\":\"")[1].split("\"")[0];
        System.out.println(str);
        return str;

    }

    protected ArrayList<Song> getListSongFromKeyword(String keyword) {

        try {
            Document doc = Jsoup.connect(urlSearch + keyword).get();
            Elements elements = doc.select("li.list_song.search div.item_content");
            for (Element element : elements) {
                tenbh = element.select("h3 a").text();
                url = element.select("h3 a").attr("href");
                singer = element.select("li.list_song.search div.item_content a span").text();
                listSongFromKeyword.add(new Song(tenbh, url, singer, maxQuality, urlDownload, listSongQuality, source, lyric));

            }
        } catch (Exception e) {
        }
        return listSongFromKeyword;

    }

    // Get link download and put it to listSongDownload
    protected ArrayList<Song> getFullInfo(ArrayList<Song> listSongFromKeyword) {

        for (Song song : listSongFromKeyword) {
            urlDownload128 = getLinkDownload(song.getUrl().split(Pattern.quote("."))[3] + "_128");
            urlDownload320 = getLinkDownload(song.getUrl().split(Pattern.quote("."))[3]);
            urlDownloadll = getLinkDownload(song.getUrl().split(Pattern.quote("."))[3] + "_lossless");
            listSongQuality.add(urlDownload128);
            listSongQuality.add(urlDownload320);
            listSongQuality.add(urlDownloadll);
            listSongDownload.add(new Song(tenbh, url, singer, maxQuality, urlDownload, listSongQuality, source, lyric));

        }
        return listSongDownload;

    }

}
