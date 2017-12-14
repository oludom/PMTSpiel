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

public class BugaBesucherDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression username;
	public final StringExpression password;
	public final StringExpression offeneAnfragenId;
	public final AssociationExpression offeneAnfragen;
	public final StringExpression freundeId;
	public final AssociationExpression freunde;
	public final StringExpression profilbild;
	public final CollectionExpression zeits;
	public final CollectionExpression Code;
	
	public BugaBesucherDetachedCriteria() {
		super(pmt.spielspaß.codegenerierung.BugaBesucher.class, pmt.spielspaß.codegenerierung.BugaBesucherCriteria.class);
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		offeneAnfragenId = new StringExpression("offeneAnfragen.username", this.getDetachedCriteria());
		offeneAnfragen = new AssociationExpression("offeneAnfragen", this.getDetachedCriteria());
		freundeId = new StringExpression("freunde.username", this.getDetachedCriteria());
		freunde = new AssociationExpression("freunde", this.getDetachedCriteria());
		profilbild = new StringExpression("profilbild", this.getDetachedCriteria());
		zeits = new CollectionExpression("ORM_Zeits", this.getDetachedCriteria());
		Code = new CollectionExpression("ORM_Code", this.getDetachedCriteria());
	}
	
	public BugaBesucherDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, pmt.spielspaß.codegenerierung.BugaBesucherCriteria.class);
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		offeneAnfragenId = new StringExpression("offeneAnfragen.username", this.getDetachedCriteria());
		offeneAnfragen = new AssociationExpression("offeneAnfragen", this.getDetachedCriteria());
		freundeId = new StringExpression("freunde.username", this.getDetachedCriteria());
		freunde = new AssociationExpression("freunde", this.getDetachedCriteria());
		profilbild = new StringExpression("profilbild", this.getDetachedCriteria());
		zeits = new CollectionExpression("ORM_Zeits", this.getDetachedCriteria());
		Code = new CollectionExpression("ORM_Code", this.getDetachedCriteria());
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria createOffeneAnfragenCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria(createCriteria("offeneAnfragen"));
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria createFreundeCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria(createCriteria("freunde"));
	}
	
	public pmt.spielspaß.codegenerierung.ZeitDetachedCriteria createZeitsCriteria() {
		return new pmt.spielspaß.codegenerierung.ZeitDetachedCriteria(createCriteria("ORM_Zeits"));
	}
	
	public pmt.spielspaß.codegenerierung.QRCodeDetachedCriteria createCodeCriteria() {
		return new pmt.spielspaß.codegenerierung.QRCodeDetachedCriteria(createCriteria("ORM_Code"));
	}
	
	public BugaBesucher uniqueBugaBesucher(PersistentSession session) {
		return (BugaBesucher) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public BugaBesucher[] listBugaBesucher(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (BugaBesucher[]) list.toArray(new BugaBesucher[list.size()]);
	}
}

