import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import acsse.csc2a.fantasy.model.Player;
import acsse.csc2a.fantasy.file.*;

public class Main {
    
    public static void main(String[] args) {
        String[] fileStrings = {"data/fantasy-small.dat", 
                "data/fantasy-medium.dat", "data/fantasy-large.dat"};
        
        ArrayList<Player> players;
        String newFileString;
        
        for (String fileString : fileStrings)
        {
            File handlerFile = new File(fileString);
            players = PlayerFileHandler.readPlayerData(handlerFile);
            
            if (players != null)
            {
                System.out.println("Players from file " + fileString + ":");
                for (Player player : players)
                {
                	System.out.println(player);
                }
                
                newFileString = fileString.substring(0, fileString.lastIndexOf(".")) + "objects.dat";
                File newFile = new File(newFileString);
                
                Collections.sort(players);
                PlayerFileHandler.writePlayerObj(newFile, players);
                
            } else {
                System.err.println("Error reading from file: " + fileString);
            }
        }
    }
}
