package acsse.csc2a.fantasy.model;

import java.io.Serializable;

public class Player implements Serializable, Comparable<Player>
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8903161084236596553L;
	private String PLAYER_PLAYER_ID; //the unique playerID of the Player (String)
	private String PLAYER_ROLE; //the role of the Player (String)
	private int PLAYER_PROWESS; //the prowess of the Player (int)
	private double PLAYER_MANA; //the mana of the Player (double)
	
    public Player(String playerId, String role, int prowess, double mana) {
        this.PLAYER_PLAYER_ID = playerId;
        this.PLAYER_ROLE = role;
        this.PLAYER_PROWESS = prowess;
        this.PLAYER_MANA = mana;
    }
    
    public String getPLAYER_PLAYER_ID() {
		return PLAYER_PLAYER_ID;
	}
	
	public void setPLAYER_PLAYER_ID(String pLAYER_PLAYER_ID) {
		PLAYER_PLAYER_ID = pLAYER_PLAYER_ID;
	}
	
	public String getPLAYER_ROLE() {
		return PLAYER_ROLE;
	}
	
	public void setPLAYER_ROLE(String pLAYER_ROLE) {
		PLAYER_ROLE = pLAYER_ROLE;
	}
	
	public int getPLAYER_PROWESS() {
		return PLAYER_PROWESS;
	}
	
	public void setPLAYER_PROWESS(int pLAYER_PROWESS) {
		PLAYER_PROWESS = pLAYER_PROWESS;
	}
	
	public double getPLAYER_MANA() {
		return PLAYER_MANA;
	}
	
	public void setPLAYER_MANA(double pLAYER_MANA) {
		PLAYER_MANA = pLAYER_MANA;
	}

	
	@Override
	public int compareTo(Player o)
	{
		if(PLAYER_PROWESS < o.PLAYER_PROWESS)
			return -1;
		else if(PLAYER_PROWESS > o.PLAYER_PROWESS)
			return 1;
		else if(PLAYER_MANA < o.PLAYER_MANA)
			return -1;
		else if(PLAYER_MANA > o.PLAYER_MANA)
			return 1;
		return 0;
	}
	
}
