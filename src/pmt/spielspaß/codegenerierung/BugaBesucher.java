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
		if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_ZEITS) {
			return ORM_zeits;
		}
		else if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_OFFENEANFRAGEN) {
			return ORM_offeneAnfragen;
		}
		else if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_FREUNDE) {
			return ORM_freunde;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_SPIELERMITANFRAGEN) {
			this.spielerMitAnfragen = (pmt.spielspaß.codegenerierung.BugaBesucher) owner;
		}
		
		else if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_SPIELERMITFREUNDEN) {
			this.spielerMitFreunden = (pmt.spielspaß.codegenerierung.BugaBesucher) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private pmt.spielspaß.codegenerierung.BugaBesucher spielerMitFreunden;
	
	private pmt.spielspaß.codegenerierung.BugaBesucher spielerMitAnfragen;
	
	private String profilbild;
	
	private int punktzahl;
	
	private String listeDerErrungenschaften;
	
	private java.util.Set ORM_zeits = new java.util.HashSet();
	
	private java.util.Set ORM_offeneAnfragen = new java.util.HashSet();
	
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
	
	public void setSpielerMitAnfragen(pmt.spielspaß.codegenerierung.BugaBesucher value) {
		if (spielerMitAnfragen != null) {
			spielerMitAnfragen.offeneAnfragen.remove(this);
		}
		if (value != null) {
			value.offeneAnfragen.add(this);
		}
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucher getSpielerMitAnfragen() {
		return spielerMitAnfragen;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_SpielerMitAnfragen(pmt.spielspaß.codegenerierung.BugaBesucher value) {
		this.spielerMitAnfragen = value;
	}
	
	private pmt.spielspaß.codegenerierung.BugaBesucher getORM_SpielerMitAnfragen() {
		return spielerMitAnfragen;
	}
	
	public void setSpielerMitFreunden(pmt.spielspaß.codegenerierung.BugaBesucher value) {
		if (spielerMitFreunden != null) {
			spielerMitFreunden.freunde.remove(this);
		}
		if (value != null) {
			value.freunde.add(this);
		}
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucher getSpielerMitFreunden() {
		return spielerMitFreunden;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_SpielerMitFreunden(pmt.spielspaß.codegenerierung.BugaBesucher value) {
		this.spielerMitFreunden = value;
	}
	
	private pmt.spielspaß.codegenerierung.BugaBesucher getORM_SpielerMitFreunden() {
		return spielerMitFreunden;
	}
	
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
	
	private void setORM_OffeneAnfragen(java.util.Set value) {
		this.ORM_offeneAnfragen = value;
	}
	
	private java.util.Set getORM_OffeneAnfragen() {
		return ORM_offeneAnfragen;
	}
	
	public final pmt.spielspaß.codegenerierung.BugaBesucherSetCollection offeneAnfragen = new pmt.spielspaß.codegenerierung.BugaBesucherSetCollection(this, _ormAdapter, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_OFFENEANFRAGEN, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_SPIELERMITANFRAGEN, pmt.spielspaß.codegenerierung.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Freunde(java.util.Set value) {
		this.ORM_freunde = value;
	}
	
	private java.util.Set getORM_Freunde() {
		return ORM_freunde;
	}
	
	public final pmt.spielspaß.codegenerierung.BugaBesucherSetCollection freunde = new pmt.spielspaß.codegenerierung.BugaBesucherSetCollection(this, _ormAdapter, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_FREUNDE, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BUGABESUCHER_SPIELERMITFREUNDEN, pmt.spielspaß.codegenerierung.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
