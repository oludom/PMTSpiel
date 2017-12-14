/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Jan(Hochschule Heilbronn)
 * License Type: Academic
 */
package pmt.spielspaß.codegenerierung;

public class Zeit {
	public Zeit() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_ZEIT_BUGABESUCHER) {
			this.bugaBesucher = (pmt.spielspaß.codegenerierung.BugaBesucher) owner;
		}
		
		else if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_ZEIT_KLETTERWAND) {
			this.kletterwand = (pmt.spielspaß.codegenerierung.Kletterwand) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private java.util.Date datum;
	
	private java.sql.Time gemesseneZeit;
	
	private pmt.spielspaß.codegenerierung.Kletterwand kletterwand;
	
	private pmt.spielspaß.codegenerierung.BugaBesucher bugaBesucher;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDatum(java.util.Date value) {
		this.datum = value;
	}
	
	public java.util.Date getDatum() {
		return datum;
	}
	
	public void setGemesseneZeit(java.sql.Time value) {
		this.gemesseneZeit = value;
	}
	
	public java.sql.Time getGemesseneZeit() {
		return gemesseneZeit;
	}
	
	public void setBugaBesucher(pmt.spielspaß.codegenerierung.BugaBesucher value) {
		if (bugaBesucher != null) {
			bugaBesucher.zeits.remove(this);
		}
		if (value != null) {
			value.zeits.add(this);
		}
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucher getBugaBesucher() {
		return bugaBesucher;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_BugaBesucher(pmt.spielspaß.codegenerierung.BugaBesucher value) {
		this.bugaBesucher = value;
	}
	
	private pmt.spielspaß.codegenerierung.BugaBesucher getORM_BugaBesucher() {
		return bugaBesucher;
	}
	
	public void setKletterwand(pmt.spielspaß.codegenerierung.Kletterwand value) {
		if (kletterwand != null) {
			kletterwand.zeits.remove(this);
		}
		if (value != null) {
			value.zeits.add(this);
		}
	}
	
	public pmt.spielspaß.codegenerierung.Kletterwand getKletterwand() {
		return kletterwand;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Kletterwand(pmt.spielspaß.codegenerierung.Kletterwand value) {
		this.kletterwand = value;
	}
	
	private pmt.spielspaß.codegenerierung.Kletterwand getORM_Kletterwand() {
		return kletterwand;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
