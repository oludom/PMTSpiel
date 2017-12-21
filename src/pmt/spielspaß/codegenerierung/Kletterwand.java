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

public class Kletterwand {
	public Kletterwand() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Kletterwand))
			return false;
		Kletterwand kletterwand = (Kletterwand)aObj;
		if ((getName() != null && !getName().equals(kletterwand.getName())) || (getName() == null && kletterwand.getName() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getName() == null ? 0 : getName().hashCode());
		return hashcode;
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_KLETTERWAND_ZEITS) {
			return ORM_zeits;
		}
		else if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_KLETTERWAND_SUPERUSER) {
			return ORM_superuser;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private String name;
	
	private String startTag;
	
	private String endTag;
	
	private float lat;
	
	private float lon;
	
	private java.util.Set ORM_zeits = new java.util.HashSet();
	
	private java.util.Set ORM_superuser = new java.util.HashSet();
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getORMID() {
		return getName();
	}
	
	public void setStartTag(String value) {
		this.startTag = value;
	}
	
	public String getStartTag() {
		return startTag;
	}
	
	public void setEndTag(String value) {
		this.endTag = value;
	}
	
	public String getEndTag() {
		return endTag;
	}
	
	public void setLat(float value) {
		this.lat = value;
	}
	
	public float getLat() {
		return lat;
	}
	
	public void setLon(float value) {
		this.lon = value;
	}
	
	public float getLon() {
		return lon;
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucher[] getBugaBesuchers() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = zeits.getIterator();lIter.hasNext();) {
			lValues.add(((pmt.spielspaß.codegenerierung.Zeit)lIter.next()).getBugaBesucher());
		}
		return (pmt.spielspaß.codegenerierung.BugaBesucher[])lValues.toArray(new pmt.spielspaß.codegenerierung.BugaBesucher[lValues.size()]);
	}
	
	public void removeBugaBesucher(pmt.spielspaß.codegenerierung.BugaBesucher aBugaBesucher) {
		pmt.spielspaß.codegenerierung.Zeit[] lZeits = zeits.toArray();
		for(int i = 0; i < lZeits.length; i++) {
			if(lZeits[i].getBugaBesucher().equals(aBugaBesucher)) {
				zeits.remove(lZeits[i]);
			}
		}
	}
	
	public void addBugaBesucher(pmt.spielspaß.codegenerierung.Zeit aZeit, pmt.spielspaß.codegenerierung.BugaBesucher aBugaBesucher) {
		aZeit.setBugaBesucher(aBugaBesucher);
		zeits.add(aZeit);
	}
	
	public pmt.spielspaß.codegenerierung.Zeit getZeitByBugaBesucher(pmt.spielspaß.codegenerierung.BugaBesucher aBugaBesucher) {
		pmt.spielspaß.codegenerierung.Zeit[] lZeits = zeits.toArray();
		for(int i = 0; i < lZeits.length; i++) {
			if(lZeits[i].getBugaBesucher().equals(aBugaBesucher)) {
				return lZeits[i];
			}
		}
		return null;
	}
	
	private void setORM_Zeits(java.util.Set value) {
		this.ORM_zeits = value;
	}
	
	private java.util.Set getORM_Zeits() {
		return ORM_zeits;
	}
	
	public final pmt.spielspaß.codegenerierung.ZeitSetCollection zeits = new pmt.spielspaß.codegenerierung.ZeitSetCollection(this, _ormAdapter, pmt.spielspaß.codegenerierung.ORMConstants.KEY_KLETTERWAND_ZEITS, pmt.spielspaß.codegenerierung.ORMConstants.KEY_ZEIT_KLETTERWAND, pmt.spielspaß.codegenerierung.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Superuser(java.util.Set value) {
		this.ORM_superuser = value;
	}
	
	private java.util.Set getORM_Superuser() {
		return ORM_superuser;
	}
	
	public final pmt.spielspaß.codegenerierung.BenutzerSetCollection superuser = new pmt.spielspaß.codegenerierung.BenutzerSetCollection(this, _ormAdapter, pmt.spielspaß.codegenerierung.ORMConstants.KEY_KLETTERWAND_SUPERUSER, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BENUTZER_GESPEICHERTEKLETTERWÄNDE, pmt.spielspaß.codegenerierung.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getName());
	}
	
}
