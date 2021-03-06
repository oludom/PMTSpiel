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

public class BugaBesucher extends pmt.spielspaß.codegenerierung.Benutzer {
	public BugaBesucher() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_ANGEFRAGTER) {
			return ORM_angefragter;
		}
		else if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_BUGABESUCHER) {
			return ORM_bugaBesucher;
		}
		else if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_ZEITS) {
			return ORM_zeits;
		}
		else if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_ANFRAGEN) {
			return ORM_anfragen;
		}
		else if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_FREUNDE) {
			return ORM_freunde;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private java.util.Set ORM_angefragter = new java.util.HashSet();
	
	private String profilbild;
	
	private int punktzahl = 0;
	
	private String listeDerErrungenschaften;
	
	private java.util.Set ORM_bugaBesucher = new java.util.HashSet();
	
	private java.util.Set ORM_zeits = new java.util.HashSet();
	
	private java.util.Set ORM_anfragen = new java.util.HashSet();
	
	private java.util.Set ORM_freunde = new java.util.HashSet();
	
	public void setProfilbild(String value) {
		this.profilbild = value;
	}
	
	public String getProfilbild() {
		return profilbild;
	}
	
	public void setListeDerErrungenschaften(String value) {
		this.listeDerErrungenschaften = value;
	}
	
	public String getListeDerErrungenschaften() {
		return listeDerErrungenschaften;
	}
	
	public String getORMID() {
		return getListeDerErrungenschaften();
	}
	
	public void setPunktzahl(int value) {
		this.punktzahl = value;
	}
	
	public int getPunktzahl() {
		return punktzahl;
	}
	
	private void setORM_Angefragter(java.util.Set value) {
		this.ORM_angefragter = value;
	}
	
	private java.util.Set getORM_Angefragter() {
		return ORM_angefragter;
	}
	
	public final pmt.spielspaß.codegenerierung.BugaBesucherSetCollection angefragter = new pmt.spielspaß.codegenerierung.BugaBesucherSetCollection(this, _ormAdapter, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_ANGEFRAGTER, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_ANFRAGEN, pmt.spielspaß.codegenerierung.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_BugaBesucher(java.util.Set value) {
		this.ORM_bugaBesucher = value;
	}
	
	private java.util.Set getORM_BugaBesucher() {
		return ORM_bugaBesucher;
	}
	
	public final pmt.spielspaß.codegenerierung.BugaBesucherSetCollection bugaBesucher = new pmt.spielspaß.codegenerierung.BugaBesucherSetCollection(this, _ormAdapter, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_BUGABESUCHER, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_FREUNDE, pmt.spielspaß.codegenerierung.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public pmt.spielspaß.codegenerierung.Kletterwand[] getKletterwands() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = zeits.getIterator();lIter.hasNext();) {
			lValues.add(((pmt.spielspaß.codegenerierung.Zeit)lIter.next()).getKletterwand());
		}
		return (pmt.spielspaß.codegenerierung.Kletterwand[])lValues.toArray(new pmt.spielspaß.codegenerierung.Kletterwand[lValues.size()]);
	}
	
	public void removeKletterwand(pmt.spielspaß.codegenerierung.Kletterwand aKletterwand) {
		pmt.spielspaß.codegenerierung.Zeit[] lZeits = zeits.toArray();
		for(int i = 0; i < lZeits.length; i++) {
			if(lZeits[i].getKletterwand().equals(aKletterwand)) {
				zeits.remove(lZeits[i]);
			}
		}
	}
	
	public void addKletterwand(pmt.spielspaß.codegenerierung.Zeit aZeit, pmt.spielspaß.codegenerierung.Kletterwand aKletterwand) {
		aZeit.setKletterwand(aKletterwand);
		zeits.add(aZeit);
	}
	
	public pmt.spielspaß.codegenerierung.Zeit getZeitByKletterwand(pmt.spielspaß.codegenerierung.Kletterwand aKletterwand) {
		pmt.spielspaß.codegenerierung.Zeit[] lZeits = zeits.toArray();
		for(int i = 0; i < lZeits.length; i++) {
			if(lZeits[i].getKletterwand().equals(aKletterwand)) {
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
	
	public final pmt.spielspaß.codegenerierung.ZeitSetCollection zeits = new pmt.spielspaß.codegenerierung.ZeitSetCollection(this, _ormAdapter, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_ZEITS, pmt.spielspaß.codegenerierung.ORMConstants.KEY_ZEIT_BUGABESUCHER, pmt.spielspaß.codegenerierung.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Anfragen(java.util.Set value) {
		this.ORM_anfragen = value;
	}
	
	private java.util.Set getORM_Anfragen() {
		return ORM_anfragen;
	}
	
	public final pmt.spielspaß.codegenerierung.BugaBesucherSetCollection anfragen = new pmt.spielspaß.codegenerierung.BugaBesucherSetCollection(this, _ormAdapter, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_ANFRAGEN, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_ANGEFRAGTER, pmt.spielspaß.codegenerierung.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Freunde(java.util.Set value) {
		this.ORM_freunde = value;
	}
	
	private java.util.Set getORM_Freunde() {
		return ORM_freunde;
	}
	
	public final pmt.spielspaß.codegenerierung.BugaBesucherSetCollection freunde = new pmt.spielspaß.codegenerierung.BugaBesucherSetCollection(this, _ormAdapter, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_FREUNDE, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_BUGABESUCHER, pmt.spielspaß.codegenerierung.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
