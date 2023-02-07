package br.com.ada.pablo.inputs;

import br.com.ada.pablo.controller.HandleFile;
import br.com.ada.pablo.enums.MFileAnnotationTypeEnum;
import br.com.ada.pablo.modelos.MFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static br.com.ada.pablo.enums.MFileAnnotationTypeEnum.*;

public class Inputs {

    Scanner scanner = new Scanner(System.in);

    private HandleFile handleFile = new HandleFile();
    public void menuScreen() throws IOException {

        System.out.println("O que deseja fazer:");
        System.out.println(
                """
                        1 - Criar diretório
                        2 - Criar pasta
                        3 - listar arquivos de um diretório
                        4 - Adicionar arquivo
                        5 - Adicionar imagem
                        6 - Remover pasta
                        7 - Remover arquivo
                        8 - Abrir arquivo""");
        int opcao = scanner.nextInt();
        scanner.skip("((?<!\\R)\\s)*");
        switch (opcao){
            case 1 -> telaCriarDiretorio();
            case 2 -> CriarPasta();
            case 3 -> screenListFiles();
            case 4 -> adicionarArquivo();
            case 5 -> adicionarImagem();
            case 6 -> removingFolder();
            case 7 -> removeFile();
            case 8 -> openFile();
            default -> System.out.println("Opção inválida");
        }
    }

    private void removeFile() throws IOException {
        System.out.println("Digite o caminho do arquivo que deseja deletar:");
        String path = scanner.nextLine();
        System.out.println("Digite o nome do arquivo:");
        String nameFile = scanner.nextLine();
        handleFile.removeFile(path, nameFile);
        menuScreen();
    }

    private void adicionarImagem() throws IOException {
        MFile mFile = new MFile();
        System.out.println("Digite o nome do arquivo:");
        mFile.setNameFile(scanner.nextLine());
        System.out.println("Digite o endereço da URL");
        mFile.setContent(scanner.nextLine());
        System.out.println("Digite o caminho que deseja salvar o arquivo:");
        mFile.setPath(scanner.nextLine());

        handleFile.createImage(mFile);
        menuScreen();
    }

    private void adicionarArquivo() throws IOException {
        MFile mFile = new MFile();
        System.out.println("Digite o nome do arquivo:");
        mFile.setNameFile(scanner.nextLine());
        System.out.println("Digite o conteúdo do arquivo:");
        mFile.setContent(scanner.next());
        System.out.println("Digite o tipo de arquivo que deseja salvar:");
        MFileAnnotationTypeEnum enumType = returnEnum();
        mFile.setType(enumType);
        scanner.nextLine();
        System.out.println("Digite o caminho do diretório:");
        mFile.setPath(scanner.nextLine());
        try {
            handleFile.SaveFileWithDirectory(mFile);
        } catch (IOException ex) {
            System.out.println();
        }
        menuScreen();
    }

    private void screenListFiles() throws IOException {
        System.out.println("Digite o endereço do diretório");
        String endereco = scanner.nextLine();
        handleFile.listFiles(endereco);
        menuScreen();
    }

    private void CriarPasta() throws IOException {
        System.out.println("Digite o nome da pasta");
        String folderName = scanner.nextLine();

        handleFile.createFolder(folderName);
        menuScreen();
    }

    private void telaCriarDiretorio() throws IOException {
        MFileAnnotationTypeEnum typeEnum = returnEnum();
        System.out.println("Digite o caminho do diretório:");
        String directory = scanner.nextLine();
        handleFile.createDirectory(directory, typeEnum);

        menuScreen();
    }

    private void removingFolder() {
        System.out.println("Digite o caminho da pasta que deseja deletar");
        String path = scanner.nextLine();
        File file = new File(path);
        handleFile.removeFolder(file);
    }

    public void openFile() throws IOException {
        System.out.println("Digite o caminho do arquivo que deseja deletar:");
        String path = scanner.nextLine();
        System.out.println("Digite o nome do arquivo:");
        String nameFile = scanner.nextLine();
        handleFile.openFile(path, nameFile);
        
        menuScreen();
    }

    public MFileAnnotationTypeEnum returnEnum() {
        MFileAnnotationTypeEnum type = null;
        System.out.println("Que tipo de arquivo deseja salvar:\n" +
                "1 - REMINDER\n2 - IMPORTANT\n3 - SIMPLE");
        int escolha = scanner.nextInt();
        switch (escolha){
            case 1 -> type = REMINDER;
            case 2 -> type = IMPORTANT;
            case 3 -> type = SIMPLE;
            case 4 -> type = IMAGE;
            default -> System.out.println("Opção inválida.");
        }
        return  type;
    }

}
