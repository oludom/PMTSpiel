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

public class ZeitCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression SpielerId;
	public final AssociationExpression Spieler;
	public final DateExpression datum;
	public final TimeExpression gemesseneZeit;
	public final StringExpression kletterwandId;
	public final AssociationExpression kletterwand;
	public final StringExpression bugaBesucherId;
	public final AssociationExpression bugaBesucher;
	
	public ZeitCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		SpielerId = new StringExpression("Spieler.username", this);
		Spieler = new AssociationExpression("Spieler", this);
		datum = new DateExpression("datum", this);
		gemesseneZeit = new TimeExpression("gemesseneZeit", this);
		kletterwandId = new StringExpression("ORM_Kletterwand.null", this);
		kletterwand = new AssociationExpression("ORM_Kletterwand", this);
		bugaBesucherId = new StringExpression("ORM_BugaBesucher.null", this);
		bugaBesucher = new AssociationExpression("ORM_BugaBesucher", this);
	}
	
	public ZeitCriteria(PersistentSession session) {
		this(session.createCriteria(Zeit.class));
	}
	
	public ZeitCriteria() throws PersistentException {
		this(pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession());
	}
	
	public BugaBesucherCriteria createSpielerCriteria() {
		return new BugaBesucherCriteria(createCriteria("Spieler"));
	}
	
	public KletterwandCriteria createKletterwandCriteria() {
		return new KletterwandCriteria(createCriteria("ORM_Kletterwand"));
	}
	
	public BugaBesucherCriteria createBugaBesucherCriteria() {
		return new BugaBesucherCriteria(createCriteria("ORM_BugaBesucher"));
	}
	
	public Zeit uniqueZeit() {
		return (Zeit) super.uniqueResult();
	}
	
	public Zeit[] listZeit() {
		java.util.List list = super.list();
		return (Zeit[]) list.toArray(new Zeit[list.size()]);
	}
}

