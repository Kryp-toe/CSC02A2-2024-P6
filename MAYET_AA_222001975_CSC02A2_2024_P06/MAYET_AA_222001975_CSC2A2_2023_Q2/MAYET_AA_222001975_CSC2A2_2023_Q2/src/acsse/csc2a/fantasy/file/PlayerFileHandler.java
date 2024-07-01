package acsse.csc2a.fantasy.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import acsse.csc2a.fantasy.model.Player;

public class PlayerFileHandler
{
	
	
	public static ArrayList<Player> readPlayerData(File handle)
	{
		
	    ArrayList<Player> players = new ArrayList<>();
	    
	    try (FileInputStream fileInputStream = new FileInputStream(handle);
	         BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
	         DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);)
	    {
	        int itemCount = dataInputStream.readInt(); // Read the item count first
	        for (int i = 0; i < itemCount; i++) {
	        	
	        	String PLAYER_PLAYER_ID = dataInputStream.readUTF(); //the unique playerID of the Player (String)
	        	String PLAYER_ROLE = dataInputStream.readUTF(); //the role of the Player (String)
	        	int PLAYER_PROWESS = dataInputStream.readInt(); //the prowess of the Player (int)
	        	double PLAYER_MANA = dataInputStream.readDouble(); //the mana of the Player (double)
	            
	        	Player tempPlayer = new Player(PLAYER_PLAYER_ID, PLAYER_ROLE, PLAYER_PROWESS, PLAYER_MANA);
	        	
	        	players.add(tempPlayer);
	        	
	        }
	    } catch (FileNotFoundException e) {
	        System.err.println("File not found: " + handle);
	        e.printStackTrace();
	    } catch (IOException e) {
	        System.err.println("Error reading from file: " + handle);
	        e.printStackTrace();
	    }
	    
	    return players;
	}
	
	public static void writePlayerObj(File handle, ArrayList<Player> players)
	{
		try(FileOutputStream fileOutputStream = new FileOutputStream(handle);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);)
		{
			objectOutputStream.writeInt(players.size());
			for (Player player : players)
			{
				objectOutputStream.writeObject(player);
			}
		} catch (FileNotFoundException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch
			e.printStackTrace();
		}
	}
	 

}
