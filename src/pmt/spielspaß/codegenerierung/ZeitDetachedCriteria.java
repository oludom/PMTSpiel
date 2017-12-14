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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ZeitDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression SpielerId;
	public final AssociationExpression Spieler;
	public final DateExpression datum;
	public final TimeExpression gemesseneZeit;
	public final StringExpression kletterwandId;
	public final AssociationExpression kletterwand;
	public final StringExpression bugaBesucherId;
	public final AssociationExpression bugaBesucher;
	
	public ZeitDetachedCriteria() {
		super(pmt.spielspaß.codegenerierung.Zeit.class, pmt.spielspaß.codegenerierung.ZeitCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		SpielerId = new StringExpression("Spieler.username", this.getDetachedCriteria());
		Spieler = new AssociationExpression("Spieler", this.getDetachedCriteria());
		datum = new DateExpression("datum", this.getDetachedCriteria());
		gemesseneZeit = new TimeExpression("gemesseneZeit", this.getDetachedCriteria());
		kletterwandId = new StringExpression("ORM_Kletterwand.null", this.getDetachedCriteria());
		kletterwand = new AssociationExpression("ORM_Kletterwand", this.getDetachedCriteria());
		bugaBesucherId = new StringExpression("ORM_BugaBesucher.null", this.getDetachedCriteria());
		bugaBesucher = new AssociationExpression("ORM_BugaBesucher", this.getDetachedCriteria());
	}
	
	public ZeitDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, pmt.spielspaß.codegenerierung.ZeitCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		SpielerId = new StringExpression("Spieler.username", this.getDetachedCriteria());
		Spieler = new AssociationExpression("Spieler", this.getDetachedCriteria());
		datum = new DateExpression("datum", this.getDetachedCriteria());
		gemesseneZeit = new TimeExpression("gemesseneZeit", this.getDetachedCriteria());
		kletterwandId = new StringExpression("ORM_Kletterwand.null", this.getDetachedCriteria());
		kletterwand = new AssociationExpression("ORM_Kletterwand", this.getDetachedCriteria());
		bugaBesucherId = new StringExpression("ORM_BugaBesucher.null", this.getDetachedCriteria());
		bugaBesucher = new AssociationExpression("ORM_BugaBesucher", this.getDetachedCriteria());
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria createSpielerCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria(createCriteria("Spieler"));
	}
	
	public pmt.spielspaß.codegenerierung.KletterwandDetachedCriteria createKletterwandCriteria() {
		return new pmt.spielspaß.codegenerierung.KletterwandDetachedCriteria(createCriteria("kletterwand"));
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria createBugaBesucherCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria(createCriteria("bugaBesucher"));
	}
	
	public Zeit uniqueZeit(PersistentSession session) {
		return (Zeit) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Zeit[] listZeit(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Zeit[]) list.toArray(new Zeit[list.size()]);
	}
}

