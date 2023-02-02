package br.com.ada.pablo.controller;

import br.com.ada.pablo.enums.MFileAnnotationTypeEnum;
import br.com.ada.pablo.modelos.FileOrchestrator;
import br.com.ada.pablo.modelos.FolderOrchestrator;
import br.com.ada.pablo.modelos.MFile;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static br.com.ada.pablo.enums.MFileAnnotationTypeEnum.*;


public class HandleFile {

    MFile mFile = new MFile();
    FileOrchestrator fileOrchestrator;


    public void SaveFileWithDirectory(MFile mFile) throws IOException {
        fileOrchestrator.saveFile(mFile.getPath(), mFile.getContent(), mFile.getType(), mFile.getNameFile());
    }


    public MFileAnnotationTypeEnum retornaEscolhaDeEnum() {
        MFileAnnotationTypeEnum tipo = null;
        System.out.println("Que tipo de arquivo deseja salvar:\n" +
                "1 - REMINDER\n2 - IMPORTANT\n3 - SIMPLE");
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        switch (escolha){
            case 1 -> tipo = REMINDER;
            case 2 -> tipo = IMPORTANT;
            case 3 -> tipo = SIMPLE;
            default -> System.out.println("Opção inválida.");
        }
        return  tipo;
    }
}
