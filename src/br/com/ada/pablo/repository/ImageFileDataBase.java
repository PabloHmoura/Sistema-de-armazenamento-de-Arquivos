package br.com.ada.pablo.repository;

public interface ImageFileDataBase {

    void saveImageFile(String directory, String content, String nameFile);
    void recoveryImageFile(String directory);
    void removeImageFile(String directory, String nameFile);
    void listAllImageFilles(String directory);
}
