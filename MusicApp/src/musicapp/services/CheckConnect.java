/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicapp.services;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author butch
 */
public class CheckConnect {
    
    public boolean checkConnect(String[] args) {

        try {
            URL url = new URL("https://google.com.vn");
            URLConnection con = url.openConnection();
            con.connect();
            if(con.getConnectTimeout() > 15000){
                System.out.println("Your connect is very low, "
                        + "it will be effect to expirient of you"
                        + "we suggest you try it later!!!" 
                        + con.getConnectTimeout());
                
            }
            else {
                System.out.println("You are conneting to server..." + con.getConnectTimeout());
            }
        } catch (IOException e) {
            System.out.println("Have error while try connect to server!!!");
            return false;
        }
        return true;
    }
    
}
