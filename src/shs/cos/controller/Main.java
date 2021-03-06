package shs.cos.controller;

import org.apache.commons.io.FileUtils;
import shs.cos.model.items.Item;
import shs.cos.model.Room;
import shs.cos.model.entities.Monster;
import shs.cos.model.entities.Player;
import shs.cos.model.puzzles.Puzzle;
import shs.cos.view.gui.GUIGame;
import shs.cos.view.gui.GUILogin;

import java.io.*;

public class Main {
    public static Player player;

    /**
     * This is what we call to run the game.
     * The loading process is then tossed off to GUILogin to handle logging into the game properly.
     */
    public static void main(String[] args) {
        GUILogin.main(null);
//        player = new Player();
//        loadFinalize();
    }

    /**
     * GUILogin calls this method after successfully logging in.
     */
    public static void loadFinalize() {
        loadGameData();
        new GUIGame();
    }

    /**
     * Handles loading all our custom game data from the text files into memory.
     * Add to this method as necessary as more data is created.
     */
    private static void loadGameData() {
        if (!(Room.readRoomFile(new File(selectFile("Rooms.txt")))))
//        if (!(Room.readRoomFile(selectFileFromJar("Rooms.txt"))))
            GUILogin.displayWarning("The following data file was not found, or contains invalid data: Rooms.txt");
        if (!(Monster.readMonsterFile(new File(selectFile("Monsters.txt")))))
//        if (!(Monster.readMonsterFile(selectFileFromJar("Monsters.txt"))))
            GUILogin.displayWarning("The following data file was not found, or contains invalid data: Monsters.txt");
        if (!(Item.readItemFile(new File(selectFile("Items.txt")))))
//        if (!(Item.readItemFile(selectFileFromJar("Items.txt"))))
            GUILogin.displayWarning("The following data file was not found, or contains invalid data: Items.txt");
        if (!(Puzzle.loadPuzzleFile(new File(selectFile("Puzzles.txt")))))
//        if (!(Puzzle.loadPuzzleFile(selectFileFromJar("Puzzles.txt"))))
            GUILogin.displayWarning("The following data file was not found, or contains invalid data: Puzzles.txt");
    }

//    private static File selectFileFromJar(String s) {
//        String dataDirectory = "/resources/data/";
//        try {
//            File f = File.createTempFile(s, "temp");
//            f.deleteOnExit();
//            InputStream streamIn = Main.class.getResourceAsStream(dataDirectory + s);
//            FileUtils.copyInputStreamToFile(streamIn, f);
//            streamIn.close();
//            return f;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    private static String selectFile(String s) {
        String dataDirectory = "res/resources/data/";
        return dataDirectory + s;
    }
}
