package br.com.ada.pablo.inputs;

import br.com.ada.pablo.controller.HandleFile;
import br.com.ada.pablo.enums.MFileAnnotationTypeEnum;
import br.com.ada.pablo.modelos.FileOrchestrator;
import br.com.ada.pablo.modelos.FolderOrchestrator;

import java.util.Scanner;

public class Inputs {

    FolderOrchestrator folderOrchestrator = new FolderOrchestrator();
    FileOrchestrator fileOrchestrator = new FileOrchestrator();
    HandleFile handleFile = new HandleFile();
    public void telaMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("O que deseja fazer:");
        System.out.println(
                "1 - Create directory" +
                        "\n2 - Create folder" +
                        "\n3 - listar arquivos de um diretório\n" +
                        "4 - Adicionar arquivo\n" +
                        "5 - Adicionar imagem");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1 -> telaCriarDiretorio();
            case 2 -> telaCriarPasta();
            case 3 -> telaListarArquivos();
            default -> System.out.println("Opção inválida");
        }
    }

    private void telaListarArquivos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o endereço do diretório");
        String endereco = scanner.nextLine();

        FileOrchestrator fileOrchestrator = new FileOrchestrator();
        fileOrchestrator.listAllFiles(endereco);
    }

    private void telaCriarPasta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome da pasta");
        String nomeDaPasta = scanner.nextLine();

        folderOrchestrator.createFolder(nomeDaPasta);
    }

    private void telaCriarDiretorio() {
        MFileAnnotationTypeEnum tipoEnum = handleFile.retornaEscolhaDeEnum();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho do diretório:");
        String directory = scanner.nextLine();
        fileOrchestrator.criarDiretorioPorEnum(directory, tipoEnum);

    }


}
