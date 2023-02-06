package br.com.ada.pablo.inputs;

import br.com.ada.pablo.controller.HandleFile;
import br.com.ada.pablo.enums.MFileAnnotationTypeEnum;
import br.com.ada.pablo.modelos.FileOrchestrator;
import br.com.ada.pablo.modelos.FolderOrchestrator;
import br.com.ada.pablo.modelos.MFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static br.com.ada.pablo.enums.MFileAnnotationTypeEnum.*;

public class Inputs {

    Scanner scanner = new Scanner(System.in);
    private FolderOrchestrator folderOrchestrator;
    private FileOrchestrator fileOrchestrator;
    private HandleFile handleFile = new HandleFile();
    public void telaMenu() throws IOException {

        System.out.println("O que deseja fazer:");
        System.out.println(
                """
                        1 - Create directory
                        2 - Create folder
                        3 - listar arquivos de um diretório
                        4 - Adicionar arquivo
                        5 - Adicionar imagem""");
        int opcao = scanner.nextInt();
        scanner.skip("((?<!\\R)\\s)*");
        switch (opcao){
            case 1 -> telaCriarDiretorio();
            case 2 -> CriarPasta();
            case 3 -> telaListarArquivos();
            case 4 -> adicionarArquivo();
            case 5 -> adicionarImagem();
            default -> System.out.println("Opção inválida");
        }
    }

    private void adicionarImagem() {
        MFile mFile = new MFile();
        System.out.println("Digite o nome do arquivo:");
        mFile.setNameFile(scanner.nextLine());
        System.out.println("Digite o endereço da URL");
        mFile.setContent(scanner.nextLine());
        System.out.println("Digite o caminho que deseja salvar o arquivo:");
        mFile.setPath(scanner.nextLine());

        handleFile.createImage(mFile);
    }

    private void adicionarArquivo() throws IOException {
        MFile mFile = new MFile();
        System.out.println("Digite o nome do arquivo:");
        mFile.setNameFile(scanner.nextLine());
        System.out.println("Digite o conteúdo do arquivo:");
        mFile.setContent(scanner.next());
        System.out.println("Digite o tipo de arquivo que deseja salvar:");
        MFileAnnotationTypeEnum tipoEnum = retornaEscolhaDeEnum();
        mFile.setType(tipoEnum);
        scanner.nextLine();
        System.out.println("Digite o caminho do diretório:");
        mFile.setPath(scanner.nextLine());
        try {
            handleFile.SaveFileWithDirectory(mFile);
        } catch (IOException ex) {
            System.out.println();
        }
        telaMenu();
    }

    private void telaListarArquivos() throws IOException {
        System.out.println("Digite o endereço do diretório");
        String endereco = scanner.nextLine();

        handleFile.listFiles(endereco);

        /*FileOrchestrator fileOrchestrator = new FileOrchestrator();
        fileOrchestrator.listAllFiles(endereco);*/

        telaMenu();
    }

    private void CriarPasta() throws IOException {
        System.out.println("Digite o nome da pasta");
        String nomeDaPasta = scanner.nextLine();

        handleFile.createFolder(nomeDaPasta);
        telaMenu();
    }

    private void telaCriarDiretorio() throws IOException {
        MFileAnnotationTypeEnum tipoEnum = retornaEscolhaDeEnum();
        System.out.println("Digite o caminho do diretório:");
        String directory = scanner.nextLine();
        fileOrchestrator.criarDiretorioPorEnum(directory, tipoEnum);

        telaMenu();
    }

    private void removendoFolder() {
        System.out.println("Digite o caminho do arquivo que deseja deletar");
        File file = new File("C:\\new Folder");
        folderOrchestrator.removeFolder(file);
    }

    public MFileAnnotationTypeEnum retornaEscolhaDeEnum() {
        MFileAnnotationTypeEnum tipo = null;
        System.out.println("Que tipo de arquivo deseja salvar:\n" +
                "1 - REMINDER\n2 - IMPORTANT\n3 - SIMPLE");
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
