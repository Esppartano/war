package View;

import Model.Match;
import javax.swing.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class SaveView {
    void saveGame(Match match) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a directory to save your game file: ");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            if (!filePath.endsWith(".txt")) {
                filePath += ".txt";
            }
            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(match.saveGameState());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void continueGame(Match match)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a directory to open your game file: ");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int userSelection = fileChooser.showOpenDialog(fileChooser);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            // if (!filePath.endsWith(".txt")) {
            //     filePath += ".txt";
            // }
            try (FileReader fileReader = new FileReader(filePath)) {
                //fileReader.read(match.saveGameState());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
