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

public class FrageDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression frage;
	public final StringExpression antwort1;
	public final StringExpression antwort2;
	public final StringExpression antwortrichtig;
	public final StringExpression tippAufAntwort;
	public final CollectionExpression Besitzer;
	
	public FrageDetachedCriteria() {
		super(pmt.spielspaß.codegenerierung.Frage.class, pmt.spielspaß.codegenerierung.FrageCriteria.class);
		frage = new StringExpression("frage", this.getDetachedCriteria());
		antwort1 = new StringExpression("antwort1", this.getDetachedCriteria());
		antwort2 = new StringExpression("antwort2", this.getDetachedCriteria());
		antwortrichtig = new StringExpression("antwortrichtig", this.getDetachedCriteria());
		tippAufAntwort = new StringExpression("tippAufAntwort", this.getDetachedCriteria());
		Besitzer = new CollectionExpression("ORM_Besitzer", this.getDetachedCriteria());
	}
	
	public FrageDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, pmt.spielspaß.codegenerierung.FrageCriteria.class);
		frage = new StringExpression("frage", this.getDetachedCriteria());
		antwort1 = new StringExpression("antwort1", this.getDetachedCriteria());
		antwort2 = new StringExpression("antwort2", this.getDetachedCriteria());
		antwortrichtig = new StringExpression("antwortrichtig", this.getDetachedCriteria());
		tippAufAntwort = new StringExpression("tippAufAntwort", this.getDetachedCriteria());
		Besitzer = new CollectionExpression("ORM_Besitzer", this.getDetachedCriteria());
	}
	
	public pmt.spielspaß.codegenerierung.QRCodeDetachedCriteria createBesitzerCriteria() {
		return new pmt.spielspaß.codegenerierung.QRCodeDetachedCriteria(createCriteria("ORM_Besitzer"));
	}
	
	public Frage uniqueFrage(PersistentSession session) {
		return (Frage) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Frage[] listFrage(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Frage[]) list.toArray(new Frage[list.size()]);
	}
}

