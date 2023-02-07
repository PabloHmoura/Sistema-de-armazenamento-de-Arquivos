package br.com.ada.pablo.controller;

import br.com.ada.pablo.enums.MFileAnnotationTypeEnum;
import br.com.ada.pablo.modelos.FileOrchestrator;
import br.com.ada.pablo.modelos.FolderOrchestrator;
import br.com.ada.pablo.modelos.MFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HandleFile {

    FileOrchestrator fileOrchestrator = new FileOrchestrator();
    FolderOrchestrator folderOrchestrator = new FolderOrchestrator();

    public void SaveFileWithDirectory(MFile mFile) throws IOException {
        fileOrchestrator.saveFile(mFile.getPath(), mFile.getContent(), mFile.getType(), mFile.getNameFile());
    }

    public void listFiles(String directory) {
        fileOrchestrator.listAllFiles(directory);
    }

    public void createFolder(String nameFolder) {
        folderOrchestrator.createFolder(nameFolder);
    }

    public void createImage(MFile imageFile) {
        fileOrchestrator.saveImageFile(imageFile.getPath(), imageFile.getContent(), imageFile.getNameFile());
    }

    public void createDirectory(String directory, MFileAnnotationTypeEnum enumType) {
        fileOrchestrator.criarDiretorioPorEnum(directory, enumType);
    }

    public void removeFolder(File file) {
        folderOrchestrator.removeFolder(file);
    }

    public void removeFile(String path, String fileName) {
        fileOrchestrator.removeFile(path, fileName);
    }

    public void openFile(String path, String fileName) throws IOException {
        fileOrchestrator.recoveryFile(path, fileName);
    }

}
