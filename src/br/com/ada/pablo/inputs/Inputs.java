package br.com.ada.pablo.inputs;

import br.com.ada.pablo.controller.HandleFile;
import br.com.ada.pablo.enums.MFileAnnotationTypeEnum;
import br.com.ada.pablo.modelos.FileOrchestrator;
import br.com.ada.pablo.modelos.FolderOrchestrator;
import br.com.ada.pablo.modelos.MFile;

import java.io.IOException;
import java.util.Scanner;

public class Inputs {

    FolderOrchestrator folderOrchestrator = new FolderOrchestrator();
    FileOrchestrator fileOrchestrator = new FileOrchestrator();
    HandleFile handleFile = new HandleFile();
    public void telaMenu() throws IOException {
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
            case 4 -> adicionarArquivo();
            case 5 -> adicionarImagem();
            default -> System.out.println("Opção inválida");
        }
    }

    private void adicionarImagem() {
    }

    private void adicionarArquivo() throws IOException {
        MFile mFile = new MFile();
        System.out.println("Digite o nome do arquivo:");
        Scanner scanner = new Scanner(System.in);
        mFile.setNameFile(scanner.nextLine());
        System.out.println("Digite o conteúdo do arquivo:");
        mFile.setContent(scanner.next());
        System.out.println("Digite o tipo de arquivo que deseja salvar:");
        MFileAnnotationTypeEnum tipoEnum = handleFile.retornaEscolhaDeEnum();
        mFile.setType(tipoEnum);
        System.out.println("Digite o caminho do diretório:");
        mFile.setPath(scanner.nextLine());

        handleFile.SaveFileWithDirectory(mFile);
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
