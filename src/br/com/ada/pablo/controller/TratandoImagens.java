package br.com.ada.pablo.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class TratandoImagens {

    URL url;
    public Boolean ehUrl(String url) {
        try {
            this.url = new URL(url);
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    public URL getUrl() {
        return url;
    }
}
