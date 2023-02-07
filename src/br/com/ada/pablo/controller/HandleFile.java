package br.com.ada.pablo.controller;

import br.com.ada.pablo.enums.MFileAnnotationTypeEnum;
import br.com.ada.pablo.modelos.FileOrchestrator;
import br.com.ada.pablo.modelos.FolderOrchestrator;
import br.com.ada.pablo.modelos.MFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static br.com.ada.pablo.enums.MFileAnnotationTypeEnum.*;


public class HandleFile {

    FileOrchestrator fileOrchestrator = new FileOrchestrator();
    FolderOrchestrator folderOrchestrator = new FolderOrchestrator();

    public void SaveFileWithDirectory(MFile mFile) throws IOException {
        fileOrchestrator.saveFile(mFile.getPath(), mFile.getContent(), mFile.getType(), mFile.getNameFile());
    }

    public void listFiles(String endereco) {
        fileOrchestrator.listAllFiles(endereco);
    }

    public void createFolder(String nameFolder) {
        folderOrchestrator.createFolder(nameFolder);
    }

    public void createImage(MFile imageFile) {
        fileOrchestrator.saveImageFile(imageFile.getPath(), imageFile.getContent(), imageFile.getNameFile());
    }

    public void createDirectory(String directory, MFileAnnotationTypeEnum tipoEnum) {
        fileOrchestrator.criarDiretorioPorEnum(directory, tipoEnum);
    }

    public void removeFolder(File file) {
        folderOrchestrator.removeFolder(file);
    }

    public void removeFile() {

    }

}
