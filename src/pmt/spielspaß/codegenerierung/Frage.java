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

public class Frage {
	public Frage() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Frage))
			return false;
		Frage frage = (Frage)aObj;
		if ((getFrage() != null && !getFrage().equals(frage.getFrage())) || (getFrage() == null && frage.getFrage() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getFrage() == null ? 0 : getFrage().hashCode());
		return hashcode;
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_FRAGE_BESITZER) {
			return ORM_besitzer;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private String frage;
	
	private String antwort1;
	
	private String antwort2;
	
	private String antwortrichtig;
	
	private String tippAufAntwort;
	
	private java.util.Set ORM_besitzer = new java.util.HashSet();
	
	public void setFrage(String value) {
		this.frage = value;
	}
	
	public String getFrage() {
		return frage;
	}
	
	public String getORMID() {
		return getFrage();
	}
	
	public void setAntwort1(String value) {
		this.antwort1 = value;
	}
	
	public String getAntwort1() {
		return antwort1;
	}
	
	public void setAntwort2(String value) {
		this.antwort2 = value;
	}
	
	public String getAntwort2() {
		return antwort2;
	}
	
	public void setAntwortrichtig(String value) {
		this.antwortrichtig = value;
	}
	
	public String getAntwortrichtig() {
		return antwortrichtig;
	}
	
	public void setTippAufAntwort(String value) {
		this.tippAufAntwort = value;
	}
	
	public String getTippAufAntwort() {
		return tippAufAntwort;
	}
	
	private void setORM_Besitzer(java.util.Set value) {
		this.ORM_besitzer = value;
	}
	
	private java.util.Set getORM_Besitzer() {
		return ORM_besitzer;
	}
	
	public final pmt.spielspaß.codegenerierung.QRCodeSetCollection besitzer = new pmt.spielspaß.codegenerierung.QRCodeSetCollection(this, _ormAdapter, pmt.spielspaß.codegenerierung.ORMConstants.KEY_FRAGE_BESITZER, pmt.spielspaß.codegenerierung.ORMConstants.KEY_QRCODE_AUFGABE, pmt.spielspaß.codegenerierung.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getFrage());
	}
	
}
