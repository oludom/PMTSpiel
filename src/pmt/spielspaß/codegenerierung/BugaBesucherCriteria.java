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

public class BugaBesucherCriteria extends AbstractORMCriteria {
	public final StringExpression username;
	public final StringExpression password;
	public final StringExpression offeneAnfragenId;
	public final AssociationExpression offeneAnfragen;
	public final StringExpression freundeId;
	public final AssociationExpression freunde;
	public final StringExpression profilbild;
	public final CollectionExpression zeits;
	public final CollectionExpression Code;
	public final CollectionExpression Leistung;
	
	public BugaBesucherCriteria(Criteria criteria) {
		super(criteria);
		username = new StringExpression("username", this);
		password = new StringExpression("password", this);
		offeneAnfragenId = new StringExpression("offeneAnfragen.username", this);
		offeneAnfragen = new AssociationExpression("offeneAnfragen", this);
		freundeId = new StringExpression("freunde.username", this);
		freunde = new AssociationExpression("freunde", this);
		profilbild = new StringExpression("profilbild", this);
		zeits = new CollectionExpression("ORM_Zeits", this);
		Code = new CollectionExpression("ORM_Code", this);
		Leistung = new CollectionExpression("ORM_Leistung", this);
	}
	
	public BugaBesucherCriteria(PersistentSession session) {
		this(session.createCriteria(BugaBesucher.class));
	}
	
	public BugaBesucherCriteria() throws PersistentException {
		this(pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession());
	}
	
	public BugaBesucherCriteria createOffeneAnfragenCriteria() {
		return new BugaBesucherCriteria(createCriteria("offeneAnfragen"));
	}
	
	public BugaBesucherCriteria createFreundeCriteria() {
		return new BugaBesucherCriteria(createCriteria("freunde"));
	}
	
	public pmt.spielspaß.codegenerierung.ZeitCriteria createZeitsCriteria() {
		return new pmt.spielspaß.codegenerierung.ZeitCriteria(createCriteria("ORM_Zeits"));
	}
	
	public pmt.spielspaß.codegenerierung.QRCodeCriteria createCodeCriteria() {
		return new pmt.spielspaß.codegenerierung.QRCodeCriteria(createCriteria("ORM_Code"));
	}
	
	public pmt.spielspaß.codegenerierung.ZeitCriteria createLeistungCriteria() {
		return new pmt.spielspaß.codegenerierung.ZeitCriteria(createCriteria("ORM_Leistung"));
	}
	
	public BugaBesucher uniqueBugaBesucher() {
		return (BugaBesucher) super.uniqueResult();
	}
	
	public BugaBesucher[] listBugaBesucher() {
		java.util.List list = super.list();
		return (BugaBesucher[]) list.toArray(new BugaBesucher[list.size()]);
	}
}

