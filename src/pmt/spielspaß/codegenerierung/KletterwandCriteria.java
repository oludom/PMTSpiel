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

public class KletterwandCriteria extends AbstractORMCriteria {
	public final StringExpression name;
	public final StringExpression startTag;
	public final StringExpression endTag;
	public final FloatExpression lat;
	public final FloatExpression lon;
	public final CollectionExpression zeits;
	public final CollectionExpression superuser;
	
	public KletterwandCriteria(Criteria criteria) {
		super(criteria);
		name = new StringExpression("name", this);
		startTag = new StringExpression("startTag", this);
		endTag = new StringExpression("endTag", this);
		lat = new FloatExpression("lat", this);
		lon = new FloatExpression("lon", this);
		zeits = new CollectionExpression("ORM_Zeits", this);
		superuser = new CollectionExpression("ORM_Superuser", this);
	}
	
	public KletterwandCriteria(PersistentSession session) {
		this(session.createCriteria(Kletterwand.class));
	}
	
	public KletterwandCriteria() throws PersistentException {
		this(pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession());
	}
	
	public pmt.spielspaß.codegenerierung.ZeitCriteria createZeitsCriteria() {
		return new pmt.spielspaß.codegenerierung.ZeitCriteria(createCriteria("ORM_Zeits"));
	}
	
	public pmt.spielspaß.codegenerierung.AdminCriteria createSuperuserCriteria() {
		return new pmt.spielspaß.codegenerierung.AdminCriteria(createCriteria("ORM_Superuser"));
	}
	
	public Kletterwand uniqueKletterwand() {
		return (Kletterwand) super.uniqueResult();
	}
	
	public Kletterwand[] listKletterwand() {
		java.util.List list = super.list();
		return (Kletterwand[]) list.toArray(new Kletterwand[list.size()]);
	}
}

