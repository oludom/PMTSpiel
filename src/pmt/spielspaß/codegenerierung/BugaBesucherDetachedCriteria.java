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
	public final CollectionExpression gespeicherteKletterwände;
	public final CollectionExpression gespeicherteQRCodes;
	public final CollectionExpression Angefragter;
	public final StringExpression profilbild;
	public final IntegerExpression punktzahl;
	public final StringExpression listeDerErrungenschaften;
	public final CollectionExpression bugaBesucher;
	public final CollectionExpression zeits;
	public final CollectionExpression Anfragen;
	public final CollectionExpression freunde;
	
	public BugaBesucherDetachedCriteria() {
		super(pmt.spielspaß.codegenerierung.BugaBesucher.class, pmt.spielspaß.codegenerierung.BugaBesucherCriteria.class);
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		gespeicherteKletterwände = new CollectionExpression("ORM_GespeicherteKletterwände", this.getDetachedCriteria());
		gespeicherteQRCodes = new CollectionExpression("ORM_GespeicherteQRCodes", this.getDetachedCriteria());
		Angefragter = new CollectionExpression("ORM_Angefragter", this.getDetachedCriteria());
		profilbild = new StringExpression("profilbild", this.getDetachedCriteria());
		punktzahl = new IntegerExpression("punktzahl", this.getDetachedCriteria());
		listeDerErrungenschaften = new StringExpression("listeDerErrungenschaften", this.getDetachedCriteria());
		bugaBesucher = new CollectionExpression("ORM_BugaBesucher", this.getDetachedCriteria());
		zeits = new CollectionExpression("ORM_Zeits", this.getDetachedCriteria());
		Anfragen = new CollectionExpression("ORM_Anfragen", this.getDetachedCriteria());
		freunde = new CollectionExpression("ORM_Freunde", this.getDetachedCriteria());
	}
	
	public BugaBesucherDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, pmt.spielspaß.codegenerierung.BugaBesucherCriteria.class);
		username = new StringExpression("username", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		gespeicherteKletterwände = new CollectionExpression("ORM_GespeicherteKletterwände", this.getDetachedCriteria());
		gespeicherteQRCodes = new CollectionExpression("ORM_GespeicherteQRCodes", this.getDetachedCriteria());
		Angefragter = new CollectionExpression("ORM_Angefragter", this.getDetachedCriteria());
		profilbild = new StringExpression("profilbild", this.getDetachedCriteria());
		punktzahl = new IntegerExpression("punktzahl", this.getDetachedCriteria());
		listeDerErrungenschaften = new StringExpression("listeDerErrungenschaften", this.getDetachedCriteria());
		bugaBesucher = new CollectionExpression("ORM_BugaBesucher", this.getDetachedCriteria());
		zeits = new CollectionExpression("ORM_Zeits", this.getDetachedCriteria());
		Anfragen = new CollectionExpression("ORM_Anfragen", this.getDetachedCriteria());
		freunde = new CollectionExpression("ORM_Freunde", this.getDetachedCriteria());
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria createAngefragterCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria(createCriteria("ORM_Angefragter"));
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria createBugaBesucherCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria(createCriteria("ORM_BugaBesucher"));
	}
	
	public pmt.spielspaß.codegenerierung.ZeitDetachedCriteria createZeitsCriteria() {
		return new pmt.spielspaß.codegenerierung.ZeitDetachedCriteria(createCriteria("ORM_Zeits"));
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria createAnfragenCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria(createCriteria("ORM_Anfragen"));
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria createFreundeCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria(createCriteria("ORM_Freunde"));
	}
	
	public pmt.spielspaß.codegenerierung.KletterwandDetachedCriteria createGespeicherteKletterwändeCriteria() {
		return new pmt.spielspaß.codegenerierung.KletterwandDetachedCriteria(createCriteria("ORM_GespeicherteKletterwände"));
	}
	
	public pmt.spielspaß.codegenerierung.QRCodeDetachedCriteria createGespeicherteQRCodesCriteria() {
		return new pmt.spielspaß.codegenerierung.QRCodeDetachedCriteria(createCriteria("ORM_GespeicherteQRCodes"));
	}
	
	public BugaBesucher uniqueBugaBesucher(PersistentSession session) {
		return (BugaBesucher) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public BugaBesucher[] listBugaBesucher(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (BugaBesucher[]) list.toArray(new BugaBesucher[list.size()]);
	}
}

