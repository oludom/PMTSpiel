/**
 * Licensee: Jan(Hochschule Heilbronn)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdatePMTBUGAData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession().beginTransaction();
		try {
			pmt.spielspaß.codegenerierung.Kletterwand pMTSpielSpaßCodeGenerierungKletterwand = pmt.spielspaß.codegenerierung.KletterwandDAO.loadKletterwandByQuery(null, null);
			// Update the properties of the persistent object
			pmt.spielspaß.codegenerierung.KletterwandDAO.save(pMTSpielSpaßCodeGenerierungKletterwand);
			pmt.spielspaß.codegenerierung.QRCode pMTSpielSpaßCodeGenerierungQRCode = pmt.spielspaß.codegenerierung.QRCodeDAO.loadQRCodeByQuery(null, null);
			// Update the properties of the persistent object
			pmt.spielspaß.codegenerierung.QRCodeDAO.save(pMTSpielSpaßCodeGenerierungQRCode);
			pmt.spielspaß.codegenerierung.Benutzer pMTSpielSpaßCodeGenerierungBenutzer = pmt.spielspaß.codegenerierung.BenutzerDAO.loadBenutzerByQuery(null, null);
			// Update the properties of the persistent object
			pmt.spielspaß.codegenerierung.BenutzerDAO.save(pMTSpielSpaßCodeGenerierungBenutzer);
			pmt.spielspaß.codegenerierung.Admin pMTSpielSpaßCodeGenerierungAdmin = pmt.spielspaß.codegenerierung.AdminDAO.loadAdminByQuery(null, null);
			// Update the properties of the persistent object
			pmt.spielspaß.codegenerierung.AdminDAO.save(pMTSpielSpaßCodeGenerierungAdmin);
			pmt.spielspaß.codegenerierung.Frage pMTSpielSpaßCodeGenerierungFrage = pmt.spielspaß.codegenerierung.FrageDAO.loadFrageByQuery(null, null);
			// Update the properties of the persistent object
			pmt.spielspaß.codegenerierung.FrageDAO.save(pMTSpielSpaßCodeGenerierungFrage);
			pmt.spielspaß.codegenerierung.Zeit pMTSpielSpaßCodeGenerierungZeit = pmt.spielspaß.codegenerierung.ZeitDAO.loadZeitByQuery(null, null);
			// Update the properties of the persistent object
			pmt.spielspaß.codegenerierung.ZeitDAO.save(pMTSpielSpaßCodeGenerierungZeit);
			pmt.spielspaß.codegenerierung.BugaBesucher pMTSpielSpaßCodeGenerierungBugaBesucher = pmt.spielspaß.codegenerierung.BugaBesucherDAO.loadBugaBesucherByQuery(null, null);
			// Update the properties of the persistent object
			pmt.spielspaß.codegenerierung.BugaBesucherDAO.save(pMTSpielSpaßCodeGenerierungBugaBesucher);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Kletterwand by KletterwandCriteria");
		pmt.spielspaß.codegenerierung.KletterwandCriteria pMTSpielSpaßCodeGenerierungKletterwandCriteria = new pmt.spielspaß.codegenerierung.KletterwandCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pMTSpielSpaßCodeGenerierungKletterwandCriteria.name.eq();
		System.out.println(pMTSpielSpaßCodeGenerierungKletterwandCriteria.uniqueKletterwand());
		
		System.out.println("Retrieving QRCode by QRCodeCriteria");
		pmt.spielspaß.codegenerierung.QRCodeCriteria pMTSpielSpaßCodeGenerierungQRCodeCriteria = new pmt.spielspaß.codegenerierung.QRCodeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pMTSpielSpaßCodeGenerierungQRCodeCriteria.name.eq();
		System.out.println(pMTSpielSpaßCodeGenerierungQRCodeCriteria.uniqueQRCode());
		
		System.out.println("Retrieving Benutzer by BenutzerCriteria");
		pmt.spielspaß.codegenerierung.BenutzerCriteria pMTSpielSpaßCodeGenerierungBenutzerCriteria = new pmt.spielspaß.codegenerierung.BenutzerCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pMTSpielSpaßCodeGenerierungBenutzerCriteria.username.eq();
		System.out.println(pMTSpielSpaßCodeGenerierungBenutzerCriteria.uniqueBenutzer());
		
		System.out.println("Retrieving Admin by AdminCriteria");
		pmt.spielspaß.codegenerierung.AdminCriteria pMTSpielSpaßCodeGenerierungAdminCriteria = new pmt.spielspaß.codegenerierung.AdminCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pMTSpielSpaßCodeGenerierungAdminCriteria.username.eq();
		System.out.println(pMTSpielSpaßCodeGenerierungAdminCriteria.uniqueAdmin());
		
		System.out.println("Retrieving Frage by FrageCriteria");
		pmt.spielspaß.codegenerierung.FrageCriteria pMTSpielSpaßCodeGenerierungFrageCriteria = new pmt.spielspaß.codegenerierung.FrageCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pMTSpielSpaßCodeGenerierungFrageCriteria.frage.eq();
		System.out.println(pMTSpielSpaßCodeGenerierungFrageCriteria.uniqueFrage());
		
		System.out.println("Retrieving Zeit by ZeitCriteria");
		pmt.spielspaß.codegenerierung.ZeitCriteria pMTSpielSpaßCodeGenerierungZeitCriteria = new pmt.spielspaß.codegenerierung.ZeitCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pMTSpielSpaßCodeGenerierungZeitCriteria.ID.eq();
		System.out.println(pMTSpielSpaßCodeGenerierungZeitCriteria.uniqueZeit());
		
		System.out.println("Retrieving BugaBesucher by BugaBesucherCriteria");
		pmt.spielspaß.codegenerierung.BugaBesucherCriteria pMTSpielSpaßCodeGenerierungBugaBesucherCriteria = new pmt.spielspaß.codegenerierung.BugaBesucherCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//pMTSpielSpaßCodeGenerierungBugaBesucherCriteria.username.eq();
		//pMTSpielSpaßCodeGenerierungBugaBesucherCriteria.listeDerErrungenschaften.eq();
		System.out.println(pMTSpielSpaßCodeGenerierungBugaBesucherCriteria.uniqueBugaBesucher());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdatePMTBUGAData retrieveAndUpdatePMTBUGAData = new RetrieveAndUpdatePMTBUGAData();
			try {
				retrieveAndUpdatePMTBUGAData.retrieveAndUpdateTestData();
				//retrieveAndUpdatePMTBUGAData.retrieveByCriteria();
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
