package br.com.ada.pablo.modelos;

import br.com.ada.pablo.enums.MFileAnnotationTypeEnum;

public class MFile {

    String content;
    String nameFile;
    String path;
    MFileAnnotationTypeEnum type;

    public String getContent() {
        return content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public MFileAnnotationTypeEnum getType() {
        return type;
    }

    public void setType(MFileAnnotationTypeEnum type) {
        this.type = type;
    }
}
