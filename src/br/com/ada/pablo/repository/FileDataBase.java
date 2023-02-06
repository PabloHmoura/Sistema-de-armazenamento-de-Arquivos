package br.com.ada.pablo.repository;

import br.com.ada.pablo.enums.MFileAnnotationTypeEnum;

import java.io.IOException;

public interface FileDataBase {

    void saveFile(String directory, String content, MFileAnnotationTypeEnum tipo, String nameFile) throws IOException;
    void recoveryFile (String directory, String nameFile);
    boolean removeFile (String diretorio, String nameFile);
    void listAllFiles(String diretorio);
}
