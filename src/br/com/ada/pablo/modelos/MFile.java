package br.com.ada.pablo.modelos;

import br.com.ada.pablo.enums.MFileAnnotationTypeEnum;

public class MFile {

    String content;
    String nameFile;
    MFileAnnotationTypeEnum type;

    public String getContent() {
        return content;
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
