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

public class QRCodeCriteria extends AbstractORMCriteria {
	public final StringExpression name;
	public final StringExpression nextQRCodeId;
	public final AssociationExpression nextQRCode;
	public final StringExpression SpielerId;
	public final AssociationExpression Spieler;
	public final StringExpression AufgabeId;
	public final AssociationExpression Aufgabe;
	public final StringExpression Hinweis;
	public final FloatExpression lat;
	public final FloatExpression lon;
	public final CollectionExpression superuser;
	
	public QRCodeCriteria(Criteria criteria) {
		super(criteria);
		name = new StringExpression("name", this);
		nextQRCodeId = new StringExpression("nextQRCode.name", this);
		nextQRCode = new AssociationExpression("nextQRCode", this);
		SpielerId = new StringExpression("Spieler.username", this);
		Spieler = new AssociationExpression("Spieler", this);
		AufgabeId = new StringExpression("Aufgabe.frage", this);
		Aufgabe = new AssociationExpression("Aufgabe", this);
		Hinweis = new StringExpression("Hinweis", this);
		lat = new FloatExpression("lat", this);
		lon = new FloatExpression("lon", this);
		superuser = new CollectionExpression("ORM_Superuser", this);
	}
	
	public QRCodeCriteria(PersistentSession session) {
		this(session.createCriteria(QRCode.class));
	}
	
	public QRCodeCriteria() throws PersistentException {
		this(pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession());
	}
	
	public QRCodeCriteria createNextQRCodeCriteria() {
		return new QRCodeCriteria(createCriteria("nextQRCode"));
	}
	
	public BugaBesucherCriteria createSpielerCriteria() {
		return new BugaBesucherCriteria(createCriteria("Spieler"));
	}
	
	public FrageCriteria createAufgabeCriteria() {
		return new FrageCriteria(createCriteria("Aufgabe"));
	}
	
	public pmt.spielspaß.codegenerierung.AdminCriteria createSuperuserCriteria() {
		return new pmt.spielspaß.codegenerierung.AdminCriteria(createCriteria("ORM_Superuser"));
	}
	
	public QRCode uniqueQRCode() {
		return (QRCode) super.uniqueResult();
	}
	
	public QRCode[] listQRCode() {
		java.util.List list = super.list();
		return (QRCode[]) list.toArray(new QRCode[list.size()]);
	}
}

