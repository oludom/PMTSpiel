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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BenutzerDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression username;
	public final StringExpression password;
	public final CollectionExpression gespeicherteKletterwände;
	public final CollectionExpression gespeicherteQRCodes;
	
	public BenutzerDetachedCriteria() {
		super(pmt.spielspaß.codegenerierung.Benutzer.class, pmt.spielspaß.codegenerierung.BenutzerCriteria.class);
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		gespeicherteKletterwände = new CollectionExpression("ORM_GespeicherteKletterwände", this.getDetachedCriteria());
		gespeicherteQRCodes = new CollectionExpression("ORM_GespeicherteQRCodes", this.getDetachedCriteria());
	}
	
	public BenutzerDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, pmt.spielspaß.codegenerierung.BenutzerCriteria.class);
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		gespeicherteKletterwände = new CollectionExpression("ORM_GespeicherteKletterwände", this.getDetachedCriteria());
		gespeicherteQRCodes = new CollectionExpression("ORM_GespeicherteQRCodes", this.getDetachedCriteria());
	}
	
	public pmt.spielspaß.codegenerierung.KletterwandDetachedCriteria createGespeicherteKletterwändeCriteria() {
		return new pmt.spielspaß.codegenerierung.KletterwandDetachedCriteria(createCriteria("ORM_GespeicherteKletterwände"));
	}
	
	public pmt.spielspaß.codegenerierung.QRCodeDetachedCriteria createGespeicherteQRCodesCriteria() {
		return new pmt.spielspaß.codegenerierung.QRCodeDetachedCriteria(createCriteria("ORM_GespeicherteQRCodes"));
	}
	
	public Benutzer uniqueBenutzer(PersistentSession session) {
		return (Benutzer) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Benutzer[] listBenutzer(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Benutzer[]) list.toArray(new Benutzer[list.size()]);
	}
}

