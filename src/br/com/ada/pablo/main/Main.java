package br.com.ada.pablo.main;

import br.com.ada.pablo.controller.HandleFile;
import br.com.ada.pablo.enums.MFileAnnotationTypeEnum;
import br.com.ada.pablo.inputs.Inputs;
import br.com.ada.pablo.modelos.FileOrchestrator;
import br.com.ada.pablo.modelos.MFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Inputs inputs = new Inputs();
        inputs.telaMenu();


        /*System.out.println("Digite o nome do arquivo:");
        String fileName = scanner.nextLine();
        file.setNameFile(fileName + ".txt");
        OutputStream fos = new FileOutputStream(file.getNameFile(), true);
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter escrever = new BufferedWriter(osw);

        System.out.println("Digite o conteúdo do arquivo:");
        String content = scanner.nextLine();
        file.setContent(content);
        escrever.write(file.getContent());
        file.setType(new HandleFile().retornaEscolhaDeEnum());

        orchestrator.saveFile(endereco,file.getContent(), file.getType(), file.getNameFile());*/



        /*URL url = new URL(entradaDaUrl);

        if (entradaDaUrl.endsWith("jpeg") || entradaDaUrl.endsWith("png")){
            image = ImageIO.read(url);
            ImageIO.write(image,"jpeg", new File("C:\\Users\\Public\\Pictures\\imagens"));
        }else {
            image = ImageIO.read(url);
            ImageIO.write(image, "jpeg", new File("C:\\Users\\Public\\Pictures\\imagens"));
        }*/
    }
}
