/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Micha(Hochschule Heilbronn)
 * License Type: Academic
 */
package pmt.spielspaß.codegenerierung;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AdminCriteria extends AbstractORMCriteria {
	public final StringExpression username;
	public final StringExpression password;
	public final CollectionExpression gespeicherteKletterwände;
	public final CollectionExpression gespeicherteQRCodes;
	
	public AdminCriteria(Criteria criteria) {
		super(criteria);
		username = new StringExpression("username", this);
		password = new StringExpression("password", this);
		gespeicherteKletterwände = new CollectionExpression("ORM_GespeicherteKletterwände", this);
		gespeicherteQRCodes = new CollectionExpression("ORM_GespeicherteQRCodes", this);
	}
	
	public AdminCriteria(PersistentSession session) {
		this(session.createCriteria(Admin.class));
	}
	
	public AdminCriteria() throws PersistentException {
		this(pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession());
	}
	
	public pmt.spielspaß.codegenerierung.KletterwandCriteria createGespeicherteKletterwändeCriteria() {
		return new pmt.spielspaß.codegenerierung.KletterwandCriteria(createCriteria("ORM_GespeicherteKletterwände"));
	}
	
	public pmt.spielspaß.codegenerierung.QRCodeCriteria createGespeicherteQRCodesCriteria() {
		return new pmt.spielspaß.codegenerierung.QRCodeCriteria(createCriteria("ORM_GespeicherteQRCodes"));
	}
	
	public Admin uniqueAdmin() {
		return (Admin) super.uniqueResult();
	}
	
	public Admin[] listAdmin() {
		java.util.List list = super.list();
		return (Admin[]) list.toArray(new Admin[list.size()]);
	}
}

