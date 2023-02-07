package br.com.ada.pablo.modelos;

import br.com.ada.pablo.controller.TratandoImagens;
import br.com.ada.pablo.enums.MFileAnnotationTypeEnum;
import br.com.ada.pablo.repository.FileDataBase;
import br.com.ada.pablo.repository.ImageFileDataBase;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

public class FileOrchestrator extends FolderOrchestrator implements ImageFileDataBase, FileDataBase {

    BufferedImage image = null;
    TratandoImagens tratandoImagens = new TratandoImagens();

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
                System.out.println("not successfully");
            }
        }

    }
    //ARQUIVOS//

    @Override
    public void saveFile(String directory, String content, MFileAnnotationTypeEnum type, String nameFile) {
        String dir = "";
        switch (type){
            case REMINDER -> dir = "reminders";
            case IMPORTANT -> dir = "importants";
            case IMAGE -> dir = "image";
            default -> dir = "";
        }
        File arquive = new File(directory + "\\" + dir);
        String file = directory + "\\" + dir +"\\" + nameFile + ".txt";

        if (arquive.exists()){
            if (dir.equals("image")){
                file = directory + "\\" + nameFile + ".txt";
            }

            try (FileWriter writer = new FileWriter(file)){
                writer.write(content);
                System.out.println("Archive created sussefully");
            } catch (IOException ex){
                ex.printStackTrace();
                System.out.println("Generic error to create archive.");
            }
        } else {
            boolean sucesso = arquive.mkdir();
            if (sucesso) {
                try (FileWriter writer = new FileWriter(file)){
                    writer.write(content);
                    System.out.println("Archive created sussefully");
                } catch (IOException ex){
                    ex.printStackTrace();
                    System.out.println("Generic error to create archive.");
                }
            } else {
                System.out.println("Não foi possível realizar a operação");
            }
        }
    }

    @Override
    public void recoveryFile(String directory, String nameFile) throws IOException {
        try{
            FileInputStream fis = new FileInputStream(directory + "\\" + nameFile + ".txt");
            Reader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            System.out.println("---" + nameFile + "---");
            System.out.println();
            String linha = br.readLine();

            while(linha != null) {
                System.out.println(linha);
                linha = br.readLine();
            }
            System.out.println();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        }
    }

    @Override
    public boolean removeFile(String directory, String fileName) {
        File file = new File(directory+"\\"+fileName + ".txt");
        if (file.isFile()) {
            boolean result = file.delete();
            if (result){
                System.out.println("Arquivo deletado!");
                System.out.println();
            }
            return result;
        }
        System.out.println("Erro ao deletar o arquivo");
        return false;
    }

    @Override
    public void listAllFiles(String directory) {
        File file = new File(directory);
        File[] archives = file.listFiles();

        if (archives != null) {
            for (File fileTmp : archives) {
                if (fileTmp.isFile()) {
                    System.out.println(fileTmp.getName());
                }
            }
        }
    }

    //IMAGENS//

    @Override
    public void saveImageFile(String directory, String content, String fileName) {
        if (tratandoImagens.ehUrl(content)) {
            try {
                image = ImageIO.read(tratandoImagens.getUrl());
                File file =  new File(directory + "\\" + fileName + ".png");
                System.out.println("Criou o new File");
                ImageIO.write(image, "png", file);
            } catch (IOException ex) {
                System.out.println("Imagem não encontrada");
            }
        }
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
