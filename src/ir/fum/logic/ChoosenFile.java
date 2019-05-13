package ir.fum.logic;

import ir.fum.logic.Exceptions.FileTypeException;

import javax.swing.*;
import java.io.File;

public class ChoosenFile extends File {
    private  String filePath;

    public ChoosenFile(String pathname) {
        super(pathname);
        try {
            setMFile(pathname);
        }catch (FileTypeException e ){
        String error = e.getError();
            JOptionPane.showMessageDialog(null, error);

        }



    }



    public void setMFile(String filePath) throws FileTypeException{
        if(filePath.endsWith(".m")){
            this.filePath = filePath;

        }else {
            throw  new FileTypeException(filePath);
        }

    }
}
