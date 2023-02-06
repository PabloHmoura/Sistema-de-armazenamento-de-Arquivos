package br.com.ada.pablo.repository;

import java.net.MalformedURLException;

public interface ImageFileDataBase {

    void saveImageFile(String directory, String content, String nameFile) throws MalformedURLException;
    void recoveryImageFile(String directory);
    void removeImageFile(String directory, String nameFile);
    void listAllImageFilles(String directory);
}
