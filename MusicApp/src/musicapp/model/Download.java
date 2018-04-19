/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicapp.model;

 
public class Download {
    private String urlDownload = "";
    private String saveDir = "";
    private String saveName = "";

    public Download(String urlDownload, String saveDir, String saveName) {
        this.urlDownload = urlDownload;
        this.saveDir = saveDir;
        this.saveName = saveName;
    }

    @Override
    public String toString() {
        return "ListDownload{" + "urlDownload=" + urlDownload + ", saveDir=" + saveDir + ", saveName=" + saveName + '}';
    }

    
    

    public String getUrlDownload() {
        return urlDownload;
    }

    public void setUrlDownload(String urlDownload) {
        this.urlDownload = urlDownload;
    }

    public String getSaveDir() {
        return saveDir;
    }

    public void setSaveDir(String saveDir) {
        this.saveDir = saveDir;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }
    
}
