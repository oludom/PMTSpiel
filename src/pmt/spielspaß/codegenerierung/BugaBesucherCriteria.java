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
	
	public BugaBesucherCriteria(Criteria criteria) {
		super(criteria);
		username = new StringExpression("username", this);
		password = new StringExpression("password", this);
		gespeicherteKletterwände = new CollectionExpression("ORM_GespeicherteKletterwände", this);
		gespeicherteQRCodes = new CollectionExpression("ORM_GespeicherteQRCodes", this);
		Angefragter = new CollectionExpression("ORM_Angefragter", this);
		profilbild = new StringExpression("profilbild", this);
		punktzahl = new IntegerExpression("punktzahl", this);
		listeDerErrungenschaften = new StringExpression("listeDerErrungenschaften", this);
		bugaBesucher = new CollectionExpression("ORM_BugaBesucher", this);
		zeits = new CollectionExpression("ORM_Zeits", this);
		Anfragen = new CollectionExpression("ORM_Anfragen", this);
		freunde = new CollectionExpression("ORM_Freunde", this);
	}
	
	public BugaBesucherCriteria(PersistentSession session) {
		this(session.createCriteria(BugaBesucher.class));
	}
	
	public BugaBesucherCriteria() throws PersistentException {
		this(pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession());
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherCriteria createAngefragterCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherCriteria(createCriteria("ORM_Angefragter"));
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherCriteria createBugaBesucherCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherCriteria(createCriteria("ORM_BugaBesucher"));
	}
	
	public pmt.spielspaß.codegenerierung.ZeitCriteria createZeitsCriteria() {
		return new pmt.spielspaß.codegenerierung.ZeitCriteria(createCriteria("ORM_Zeits"));
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherCriteria createAnfragenCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherCriteria(createCriteria("ORM_Anfragen"));
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherCriteria createFreundeCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherCriteria(createCriteria("ORM_Freunde"));
	}
	
	public pmt.spielspaß.codegenerierung.KletterwandCriteria createGespeicherteKletterwändeCriteria() {
		return new pmt.spielspaß.codegenerierung.KletterwandCriteria(createCriteria("ORM_GespeicherteKletterwände"));
	}
	
	public pmt.spielspaß.codegenerierung.QRCodeCriteria createGespeicherteQRCodesCriteria() {
		return new pmt.spielspaß.codegenerierung.QRCodeCriteria(createCriteria("ORM_GespeicherteQRCodes"));
	}
	
	public BugaBesucher uniqueBugaBesucher() {
		return (BugaBesucher) super.uniqueResult();
	}
	
	public BugaBesucher[] listBugaBesucher() {
		java.util.List list = super.list();
		return (BugaBesucher[]) list.toArray(new BugaBesucher[list.size()]);
	}
}

