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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BenutzerCriteria extends AbstractORMCriteria {
	public final StringExpression username;
	public final StringExpression password;
	public final CollectionExpression gespeicherteKletterwände;
	public final CollectionExpression gespeicherteQRCodes;
	
	public BenutzerCriteria(Criteria criteria) {
		super(criteria);
		username = new StringExpression("username", this);
		password = new StringExpression("password", this);
		gespeicherteKletterwände = new CollectionExpression("ORM_GespeicherteKletterwände", this);
		gespeicherteQRCodes = new CollectionExpression("ORM_GespeicherteQRCodes", this);
	}
	
	public BenutzerCriteria(PersistentSession session) {
		this(session.createCriteria(Benutzer.class));
	}
	
	public BenutzerCriteria() throws PersistentException {
		this(pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession());
	}
	
	public pmt.spielspaß.codegenerierung.KletterwandCriteria createGespeicherteKletterwändeCriteria() {
		return new pmt.spielspaß.codegenerierung.KletterwandCriteria(createCriteria("ORM_GespeicherteKletterwände"));
	}
	
	public pmt.spielspaß.codegenerierung.QRCodeCriteria createGespeicherteQRCodesCriteria() {
		return new pmt.spielspaß.codegenerierung.QRCodeCriteria(createCriteria("ORM_GespeicherteQRCodes"));
	}
	
	public Benutzer uniqueBenutzer() {
		return (Benutzer) super.uniqueResult();
	}
	
	public Benutzer[] listBenutzer() {
		java.util.List list = super.list();
		return (Benutzer[]) list.toArray(new Benutzer[list.size()]);
	}
}

