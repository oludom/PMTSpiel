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
	
	public BenutzerDetachedCriteria() {
		super(pmt.spielspaß.codegenerierung.Benutzer.class, pmt.spielspaß.codegenerierung.BenutzerCriteria.class);
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
	}
	
	public BenutzerDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, pmt.spielspaß.codegenerierung.BenutzerCriteria.class);
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
	}
	
	public Benutzer uniqueBenutzer(PersistentSession session) {
		return (Benutzer) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Benutzer[] listBenutzer(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Benutzer[]) list.toArray(new Benutzer[list.size()]);
	}
}

