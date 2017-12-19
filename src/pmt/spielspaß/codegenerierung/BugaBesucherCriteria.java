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

public class BugaBesucherCriteria extends AbstractORMCriteria {
	public final StringExpression username;
	public final StringExpression password;
	public final StringExpression spielerMitFreundenId;
	public final AssociationExpression spielerMitFreunden;
	public final StringExpression spielerMitAnfragenId;
	public final AssociationExpression spielerMitAnfragen;
	public final StringExpression profilbild;
	public final IntegerExpression punktzahl;
	public final StringExpression listeDerErrungenschaften;
	public final CollectionExpression zeits;
	public final CollectionExpression offeneAnfragen;
	public final CollectionExpression freunde;
	
	public BugaBesucherCriteria(Criteria criteria) {
		super(criteria);
		username = new StringExpression("username", this);
		password = new StringExpression("password", this);
		spielerMitFreundenId = new StringExpression("spielerMitFreunden.username", this);
		spielerMitFreunden = new AssociationExpression("spielerMitFreunden", this);
		spielerMitAnfragenId = new StringExpression("spielerMitAnfragen.username", this);
		spielerMitAnfragen = new AssociationExpression("spielerMitAnfragen", this);
		profilbild = new StringExpression("profilbild", this);
		punktzahl = new IntegerExpression("punktzahl", this);
		listeDerErrungenschaften = new StringExpression("listeDerErrungenschaften", this);
		zeits = new CollectionExpression("ORM_Zeits", this);
		offeneAnfragen = new CollectionExpression("ORM_OffeneAnfragen", this);
		freunde = new CollectionExpression("ORM_Freunde", this);
	}
	
	public BugaBesucherCriteria(PersistentSession session) {
		this(session.createCriteria(BugaBesucher.class));
	}
	
	public BugaBesucherCriteria() throws PersistentException {
		this(pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession());
	}
	
	public BugaBesucherCriteria createSpielerMitFreundenCriteria() {
		return new BugaBesucherCriteria(createCriteria("spielerMitFreunden"));
	}
	
	public BugaBesucherCriteria createSpielerMitAnfragenCriteria() {
		return new BugaBesucherCriteria(createCriteria("spielerMitAnfragen"));
	}
	
	public pmt.spielspaß.codegenerierung.ZeitCriteria createZeitsCriteria() {
		return new pmt.spielspaß.codegenerierung.ZeitCriteria(createCriteria("ORM_Zeits"));
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherCriteria createOffeneAnfragenCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherCriteria(createCriteria("ORM_OffeneAnfragen"));
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherCriteria createFreundeCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherCriteria(createCriteria("ORM_Freunde"));
	}
	
	public BugaBesucher uniqueBugaBesucher() {
		return (BugaBesucher) super.uniqueResult();
	}
	
	public BugaBesucher[] listBugaBesucher() {
		java.util.List list = super.list();
		return (BugaBesucher[]) list.toArray(new BugaBesucher[list.size()]);
	}
}

