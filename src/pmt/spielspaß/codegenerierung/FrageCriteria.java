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

public class FrageCriteria extends AbstractORMCriteria {
	public final StringExpression frage;
	public final StringExpression antwort1;
	public final StringExpression antwort2;
	public final StringExpression antwortrichtig;
	public final StringExpression tippAufAntwort;
	public final CollectionExpression Besitzer;
	
	public FrageCriteria(Criteria criteria) {
		super(criteria);
		frage = new StringExpression("frage", this);
		antwort1 = new StringExpression("antwort1", this);
		antwort2 = new StringExpression("antwort2", this);
		antwortrichtig = new StringExpression("antwortrichtig", this);
		tippAufAntwort = new StringExpression("tippAufAntwort", this);
		Besitzer = new CollectionExpression("ORM_Besitzer", this);
	}
	
	public FrageCriteria(PersistentSession session) {
		this(session.createCriteria(Frage.class));
	}
	
	public FrageCriteria() throws PersistentException {
		this(pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession());
	}
	
	public pmt.spielspaß.codegenerierung.QRCodeCriteria createBesitzerCriteria() {
		return new pmt.spielspaß.codegenerierung.QRCodeCriteria(createCriteria("ORM_Besitzer"));
	}
	
	public Frage uniqueFrage() {
		return (Frage) super.uniqueResult();
	}
	
	public Frage[] listFrage() {
		java.util.List list = super.list();
		return (Frage[]) list.toArray(new Frage[list.size()]);
	}
}

