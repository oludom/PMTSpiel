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

public class KletterwandDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression name;
	public final StringExpression startTag;
	public final StringExpression endTag;
	public final FloatExpression lat;
	public final FloatExpression lon;
	public final CollectionExpression zeits;
	public final CollectionExpression superuser;
	
	public KletterwandDetachedCriteria() {
		super(pmt.spielspaß.codegenerierung.Kletterwand.class, pmt.spielspaß.codegenerierung.KletterwandCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
		startTag = new StringExpression("startTag", this.getDetachedCriteria());
		endTag = new StringExpression("endTag", this.getDetachedCriteria());
		lat = new FloatExpression("lat", this.getDetachedCriteria());
		lon = new FloatExpression("lon", this.getDetachedCriteria());
		zeits = new CollectionExpression("ORM_Zeits", this.getDetachedCriteria());
		superuser = new CollectionExpression("ORM_Superuser", this.getDetachedCriteria());
	}
	
	public KletterwandDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, pmt.spielspaß.codegenerierung.KletterwandCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
		startTag = new StringExpression("startTag", this.getDetachedCriteria());
		endTag = new StringExpression("endTag", this.getDetachedCriteria());
		lat = new FloatExpression("lat", this.getDetachedCriteria());
		lon = new FloatExpression("lon", this.getDetachedCriteria());
		zeits = new CollectionExpression("ORM_Zeits", this.getDetachedCriteria());
		superuser = new CollectionExpression("ORM_Superuser", this.getDetachedCriteria());
	}
	
	public pmt.spielspaß.codegenerierung.ZeitDetachedCriteria createZeitsCriteria() {
		return new pmt.spielspaß.codegenerierung.ZeitDetachedCriteria(createCriteria("ORM_Zeits"));
	}
	
	public pmt.spielspaß.codegenerierung.BenutzerDetachedCriteria createSuperuserCriteria() {
		return new pmt.spielspaß.codegenerierung.BenutzerDetachedCriteria(createCriteria("ORM_Superuser"));
	}
	
	public Kletterwand uniqueKletterwand(PersistentSession session) {
		return (Kletterwand) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Kletterwand[] listKletterwand(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Kletterwand[]) list.toArray(new Kletterwand[list.size()]);
	}
}

