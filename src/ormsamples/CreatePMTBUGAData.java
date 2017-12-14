/**
 * Licensee: Micha(Hochschule Heilbronn)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreatePMTBUGAData {
	public void createTestData() throws PersistentException {
		// Insert sample data
		PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
		PersistentTransaction transaction = session.beginTransaction();
		try {
			session.doWork(new org.hibernate.jdbc.Work() {
				public void execute(java.sql.Connection conn) throws java.sql.SQLException {
					java.sql.Statement statement = conn.createStatement();
					statement.executeUpdate("INSERT INTO Kletterwand(Name, StartTag, EndTag, Lat, Lon) VALUES ('Kletterwand Ost', 'start1', 'end1', 42.0, 9.2)");
					statement.executeUpdate("INSERT INTO Frage(Frage, Antwort1, Antwort2, Antwortrichtig, TippAufAntwort) VALUES ('Was ist 1+1?', '1', '2', '3', 'überleg mal...')");
					statement.executeUpdate("INSERT INTO Benutzer(Username, BenutzerUsername2, BenutzerUsername, Password, Profilbild, Discriminator) VALUES ('michaheiss', null, null, 'password1', 'http://example.com/image.jpg', 'admin')");
					statement.executeUpdate("INSERT INTO Benutzer(Username, BenutzerUsername2, BenutzerUsername, Password, Profilbild, Discriminator) VALUES ('janleppich', null, null, 'S4fe-Pw', 'http://example.net/image.png', 'user')");
					statement.executeUpdate("INSERT INTO QRCode(Name, QRCodeName, BenutzerUsername, FrageFrage, Hinweis, Lat, Lon) VALUES ('QRCode Orchideenbeet', null, null, 'Was ist 1+1?', 'geh zum HHN Hotspot', 42.0, 9.2)");
					statement.close();
				}
			});
			transaction.commit();
		}
		catch (Exception e) {
			try {
				transaction.rollback();
			}
			catch (PersistentException e1) {
				e.printStackTrace();
			}
			e.printStackTrace();
		}
		
		PersistentTransaction t = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession().beginTransaction();
		try {
			pmt.spielspaß.codegenerierung.Kletterwand pMTSpielSpaßCodeGenerierungKletterwand = pmt.spielspaß.codegenerierung.KletterwandDAO.createKletterwand();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : superuser, zeits, lon, lat, name
			pmt.spielspaß.codegenerierung.KletterwandDAO.save(pMTSpielSpaßCodeGenerierungKletterwand);
			pmt.spielspaß.codegenerierung.QRCode pMTSpielSpaßCodeGenerierungQRCode = pmt.spielspaß.codegenerierung.QRCodeDAO.createQRCode();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : superuser, lon, lat, Aufgabe, name
			pmt.spielspaß.codegenerierung.QRCodeDAO.save(pMTSpielSpaßCodeGenerierungQRCode);
			pmt.spielspaß.codegenerierung.Benutzer pMTSpielSpaßCodeGenerierungBenutzer = pmt.spielspaß.codegenerierung.BenutzerDAO.createBenutzer();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : username
			pmt.spielspaß.codegenerierung.BenutzerDAO.save(pMTSpielSpaßCodeGenerierungBenutzer);
			pmt.spielspaß.codegenerierung.Admin pMTSpielSpaßCodeGenerierungAdmin = pmt.spielspaß.codegenerierung.AdminDAO.createAdmin();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : gespeicherteQRCodes, gespeicherteKletterwände
			pmt.spielspaß.codegenerierung.AdminDAO.save(pMTSpielSpaßCodeGenerierungAdmin);
			pmt.spielspaß.codegenerierung.Frage pMTSpielSpaßCodeGenerierungFrage = pmt.spielspaß.codegenerierung.FrageDAO.createFrage();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Besitzer, frage
			pmt.spielspaß.codegenerierung.FrageDAO.save(pMTSpielSpaßCodeGenerierungFrage);
			pmt.spielspaß.codegenerierung.Zeit pMTSpielSpaßCodeGenerierungZeit = pmt.spielspaß.codegenerierung.ZeitDAO.createZeit();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : bugaBesucher, kletterwand
			pmt.spielspaß.codegenerierung.ZeitDAO.save(pMTSpielSpaßCodeGenerierungZeit);
			pmt.spielspaß.codegenerierung.BugaBesucher pMTSpielSpaßCodeGenerierungBugaBesucher = pmt.spielspaß.codegenerierung.BugaBesucherDAO.createBugaBesucher();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : zeits
			pmt.spielspaß.codegenerierung.BugaBesucherDAO.save(pMTSpielSpaßCodeGenerierungBugaBesucher);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreatePMTBUGAData createPMTBUGAData = new CreatePMTBUGAData();
			try {
				createPMTBUGAData.createTestData();
			}
			finally {
				pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
