package musicapp.model;

import java.util.ArrayList;

public class Song {

    private String name;
    private String url;
    private String singer = "";
    private String maxQuality = "";
    private String urlDownload;
    private String urlDownload128;
    private String urlDownload320;
    private String urlDownload500;
    private String urlDownloadll;
    private String source;
    private String lyric;
    private ArrayList<String> qualityDownload = new ArrayList<String>();

    public Song(String name, String url, String singer, String maxQuality,
            String urlDownload, ArrayList<String> qualityDownload, String source, String lyric) {
        super();
        this.name = name;
        this.url = url;
        this.singer = singer;
        this.maxQuality = maxQuality;
        this.urlDownload = urlDownload;
        this.qualityDownload = qualityDownload;
        this.source = source;
        this.lyric = lyric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlDownload() {
        return urlDownload;
    }

    public void setUrlDownload(String urlDownload) {
        this.urlDownload = urlDownload;
    }

    public String getUrlDownload128() {
        return urlDownload128;
    }

    public void setUrlDownload128(String urlDownload128) {
        this.urlDownload128 = urlDownload128;
    }

    public String getUrlDownload320() {
        return urlDownload320;
    }

    public void setUrlDownload320(String urlDownload320) {
        this.urlDownload320 = urlDownload320;
    }

    public String getUrlDownload500() {
        return urlDownload500;
    }

    public void setUrlDownload500(String urlDownload500) {
        this.urlDownload500 = urlDownload500;
    }

    public String getUrlDownloadll() {
        return urlDownloadll;
    }

    public void setUrlDownloadll(String urlDownloadll) {
        this.urlDownloadll = urlDownloadll;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMaxQuality() {
        return maxQuality;
    }

    public void setMaxQuality(String maxQuality) {
        this.maxQuality = maxQuality;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public ArrayList<String> getQualityDownload() {
        return qualityDownload;
    }

    public void setQualityDownload(ArrayList<String> qualityDownload) {
        for (String i : qualityDownload) {
            this.qualityDownload.add(i);
        }
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

}
