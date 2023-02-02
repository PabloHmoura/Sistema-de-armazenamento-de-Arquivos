package br.com.ada.pablo.modelos;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class FolderOrchestrator {

    public void createFolder(String folder){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo");
        String path = scanner.nextLine();
        File dir = new File(path + "\\" + folder);
        

        boolean isDirectoryCreated = dir.mkdir();
        if (isDirectoryCreated) {
            System.out.println("successfully");
        } else {
            System.out.println("Folder wasn´t create, check if the folder already exists in the path.");
        }
    }

    public boolean removeFolder(File folder){
        if (folder.isDirectory()) {
            String[] arquivos = folder.list();
            assert arquivos != null;
            for (String arquivo : arquivos) {
                boolean success = removeFolder(new File(folder, arquivo));
                if (!success) {

                    return false;
                }
            }
        }
        return folder.delete();
    }
}
