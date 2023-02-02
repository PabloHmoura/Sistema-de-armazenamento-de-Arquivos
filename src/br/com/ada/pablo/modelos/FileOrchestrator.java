package br.com.ada.pablo.modelos;

import br.com.ada.pablo.enums.MFileAnnotationTypeEnum;
import br.com.ada.pablo.repository.FileDataBase;
import br.com.ada.pablo.repository.ImageFileDataBase;

import java.io.*;
import java.util.List;

public class FileOrchestrator extends FolderOrchestrator implements ImageFileDataBase, FileDataBase {

    public void saveAllListOfFiles(List mFileList){

    }

    public void saveAllListOfImage(List mImageFileList){

    }

    public void criarDiretorioPorEnum(String directory, MFileAnnotationTypeEnum tipo) {
        File dir = null;
        if (tipo.equals(MFileAnnotationTypeEnum.REMINDER)) {
            dir = new File(directory + "\\reminder");
            boolean isDirectoryCreated = dir.mkdir();
            if (isDirectoryCreated) {
                System.out.println("successfully");
            } else {
                System.out.println("not");
            }
        } else if (tipo.equals(MFileAnnotationTypeEnum.IMPORTANT)) {
            dir = new File(directory + "\\important");
            boolean isDirectoryCreated = dir.mkdir();
            if (isDirectoryCreated) {
                System.out.println("successfully");
            } else {
                System.out.println("not");
            }
        } else if (tipo.equals(MFileAnnotationTypeEnum.SIMPLE)) {
            dir = new File(directory);
            boolean isDirectoryCreated = dir.mkdir();
            if (isDirectoryCreated) {
                System.out.println("successfully");
            } else {
                System.out.println("not");
            }
        }

    }
    //ARQUIVOS//

    @Override
    public void saveFile(String directory, String content, MFileAnnotationTypeEnum type, String nameFile) throws IOException {
        String dir = "";
        switch (type){
            case REMINDER -> dir = "reminders";
            case IMPORTANT -> dir = "importants";
            case IMAGE -> dir = "imagens";
            default -> dir = "";
        }
        String path = directory + "\\" + dir + "\\" + nameFile + "txt";
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "utf-8"))){
            writer.write(content);
            System.out.println("Archive created sussefully");
        } catch (IOException ex){
            ex.printStackTrace();
            System.out.println("Generic error to create archive.");
        }
    }

    @Override
    public void recoveryFile(String directory, String nameFile) {

    }

    @Override
    public void removeFile(String diretorio, String nameFile) {

    }

    @Override
    public void listAllFiles(String diretorio) {
        File file = new File(diretorio);
        File[] arquivos = file.listFiles();

        if (arquivos != null) {
            for (File fileTmp : arquivos) {
                System.out.println(fileTmp.getName());
            }
        }
    }

    //IMAGENS//

    @Override
    public void saveImageFile(String directory, String content, String nameFile) {

    }

    @Override
    public void recoveryImageFile(String directory) {

    }

    @Override
    public void removeImageFile(String directory, String nameFile) {

    }

    @Override
    public void listAllImageFilles(String directory) {

    }
}
