package br.com.ada.pablo.repository;

public interface FolderManagement {

    void createAFolder(String path);
    void removeAFolder(String path);
    void listAllFoldersCreated();
}
