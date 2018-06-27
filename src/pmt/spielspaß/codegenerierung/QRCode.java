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

public class QRCode {
	public QRCode() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof QRCode))
			return false;
		QRCode qrcode = (QRCode)aObj;
		if ((getName() != null && !getName().equals(qrcode.getName())) || (getName() == null && qrcode.getName() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getName() == null ? 0 : getName().hashCode());
		return hashcode;
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_QRCODE_SUPERUSER) {
			return ORM_superuser;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_QRCODE_AUFGABE) {
			this.Aufgabe = (pmt.spielspaß.codegenerierung.Frage) owner;
		}
		
		else if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_QRCODE_NEXTQRCODE) {
			this.nextQRCode = (pmt.spielspaß.codegenerierung.QRCode) owner;
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
	
	private String name;
	
	private pmt.spielspaß.codegenerierung.QRCode nextQRCode;
	
	private pmt.spielspaß.codegenerierung.Frage Aufgabe;
	
	private String Hinweis;
	
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
	
	public void setHinweis(String value) {
		this.Hinweis = value;
	}
	
	public String getHinweis() {
		return Hinweis;
	}

	private void setORM_Superuser(java.util.Set value) {
		this.ORM_superuser = value;
	}
	
	private java.util.Set getORM_Superuser() {
		return ORM_superuser;
	}
	
	public final pmt.spielspaß.codegenerierung.BenutzerSetCollection superuser = new pmt.spielspaß.codegenerierung.BenutzerSetCollection(this, _ormAdapter, pmt.spielspaß.codegenerierung.ORMConstants.KEY_QRCODE_SUPERUSER, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BENUTZER_GESPEICHERTEQRCODES, pmt.spielspaß.codegenerierung.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setAufgabe(pmt.spielspaß.codegenerierung.Frage value) {
		if (Aufgabe != null) {
			Aufgabe.besitzer.remove(this);
		}
		if (value != null) {
			value.besitzer.add(this);
		}
	}
	
	public pmt.spielspaß.codegenerierung.Frage getAufgabe() {
		return Aufgabe;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Aufgabe(pmt.spielspaß.codegenerierung.Frage value) {
		this.Aufgabe = value;
	}
	
	private pmt.spielspaß.codegenerierung.Frage getORM_Aufgabe() {
		return Aufgabe;
	}
	
	public void setNextQRCode(pmt.spielspaß.codegenerierung.QRCode value) {
		this.nextQRCode = value;
	}
	
	public pmt.spielspaß.codegenerierung.QRCode getNextQRCode() {
		return nextQRCode;
	}
	
	public String toString() {
		return String.valueOf(getName());
	}
	
}
