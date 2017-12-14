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

public class QRCodeDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public QRCodeDetachedCriteria() {
		super(pmt.spielspaß.codegenerierung.QRCode.class, pmt.spielspaß.codegenerierung.QRCodeCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
		nextQRCodeId = new StringExpression("nextQRCode.name", this.getDetachedCriteria());
		nextQRCode = new AssociationExpression("nextQRCode", this.getDetachedCriteria());
		SpielerId = new StringExpression("Spieler.username", this.getDetachedCriteria());
		Spieler = new AssociationExpression("Spieler", this.getDetachedCriteria());
		AufgabeId = new StringExpression("Aufgabe.frage", this.getDetachedCriteria());
		Aufgabe = new AssociationExpression("Aufgabe", this.getDetachedCriteria());
		Hinweis = new StringExpression("Hinweis", this.getDetachedCriteria());
		lat = new FloatExpression("lat", this.getDetachedCriteria());
		lon = new FloatExpression("lon", this.getDetachedCriteria());
		superuser = new CollectionExpression("ORM_Superuser", this.getDetachedCriteria());
	}
	
	public QRCodeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, pmt.spielspaß.codegenerierung.QRCodeCriteria.class);
		name = new StringExpression("name", this.getDetachedCriteria());
		nextQRCodeId = new StringExpression("nextQRCode.name", this.getDetachedCriteria());
		nextQRCode = new AssociationExpression("nextQRCode", this.getDetachedCriteria());
		SpielerId = new StringExpression("Spieler.username", this.getDetachedCriteria());
		Spieler = new AssociationExpression("Spieler", this.getDetachedCriteria());
		AufgabeId = new StringExpression("Aufgabe.frage", this.getDetachedCriteria());
		Aufgabe = new AssociationExpression("Aufgabe", this.getDetachedCriteria());
		Hinweis = new StringExpression("Hinweis", this.getDetachedCriteria());
		lat = new FloatExpression("lat", this.getDetachedCriteria());
		lon = new FloatExpression("lon", this.getDetachedCriteria());
		superuser = new CollectionExpression("ORM_Superuser", this.getDetachedCriteria());
	}
	
	public pmt.spielspaß.codegenerierung.QRCodeDetachedCriteria createNextQRCodeCriteria() {
		return new pmt.spielspaß.codegenerierung.QRCodeDetachedCriteria(createCriteria("nextQRCode"));
	}
	
	public pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria createSpielerCriteria() {
		return new pmt.spielspaß.codegenerierung.BugaBesucherDetachedCriteria(createCriteria("Spieler"));
	}
	
	public pmt.spielspaß.codegenerierung.FrageDetachedCriteria createAufgabeCriteria() {
		return new pmt.spielspaß.codegenerierung.FrageDetachedCriteria(createCriteria("Aufgabe"));
	}
	
	public pmt.spielspaß.codegenerierung.AdminDetachedCriteria createSuperuserCriteria() {
		return new pmt.spielspaß.codegenerierung.AdminDetachedCriteria(createCriteria("ORM_Superuser"));
	}
	
	public QRCode uniqueQRCode(PersistentSession session) {
		return (QRCode) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public QRCode[] listQRCode(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (QRCode[]) list.toArray(new QRCode[list.size()]);
	}
}

