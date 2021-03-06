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

public class Benutzer {
	public Benutzer() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_BENUTZER_GESPEICHERTEKLETTERWÄNDE) {
			return ORM_gespeicherteKletterwände;
		}
		else if (key == pmt.spielspaß.codegenerierung.ORMConstants.KEY_BENUTZER_GESPEICHERTEQRCODES) {
			return ORM_gespeicherteQRCodes;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	public String username;
	
	public String password;
	
	private java.util.Set ORM_gespeicherteKletterwände = new java.util.HashSet();
	
	private java.util.Set ORM_gespeicherteQRCodes = new java.util.HashSet();
	
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getORMID() {
		return getUsername();
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	private void setORM_GespeicherteKletterwände(java.util.Set value) {
		this.ORM_gespeicherteKletterwände = value;
	}
	
	private java.util.Set getORM_GespeicherteKletterwände() {
		return ORM_gespeicherteKletterwände;
	}
	
	public final pmt.spielspaß.codegenerierung.KletterwandSetCollection gespeicherteKletterwände = new pmt.spielspaß.codegenerierung.KletterwandSetCollection(this, _ormAdapter, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BENUTZER_GESPEICHERTEKLETTERWÄNDE, pmt.spielspaß.codegenerierung.ORMConstants.KEY_KLETTERWAND_SUPERUSER, pmt.spielspaß.codegenerierung.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_GespeicherteQRCodes(java.util.Set value) {
		this.ORM_gespeicherteQRCodes = value;
	}
	
	private java.util.Set getORM_GespeicherteQRCodes() {
		return ORM_gespeicherteQRCodes;
	}
	
	public final pmt.spielspaß.codegenerierung.QRCodeSetCollection gespeicherteQRCodes = new pmt.spielspaß.codegenerierung.QRCodeSetCollection(this, _ormAdapter, pmt.spielspaß.codegenerierung.ORMConstants.KEY_BENUTZER_GESPEICHERTEQRCODES, pmt.spielspaß.codegenerierung.ORMConstants.KEY_QRCODE_SUPERUSER, pmt.spielspaß.codegenerierung.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getUsername());
	}
	
}
