/**
 * Licensee: Jan(Hochschule Heilbronn)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListPMTBUGAData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Kletterwand...");
		pmt.spielspaß.codegenerierung.Kletterwand[] pMTSpielSpaßCodeGenerierungKletterwands = pmt.spielspaß.codegenerierung.KletterwandDAO.listKletterwandByQuery(null, null);
		int length = Math.min(pMTSpielSpaßCodeGenerierungKletterwands.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pMTSpielSpaßCodeGenerierungKletterwands[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing QRCode...");
		pmt.spielspaß.codegenerierung.QRCode[] pMTSpielSpaßCodeGenerierungQRCodes = pmt.spielspaß.codegenerierung.QRCodeDAO.listQRCodeByQuery(null, null);
		length = Math.min(pMTSpielSpaßCodeGenerierungQRCodes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pMTSpielSpaßCodeGenerierungQRCodes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Benutzer...");
		pmt.spielspaß.codegenerierung.Benutzer[] pMTSpielSpaßCodeGenerierungBenutzers = pmt.spielspaß.codegenerierung.BenutzerDAO.listBenutzerByQuery(null, null);
		length = Math.min(pMTSpielSpaßCodeGenerierungBenutzers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pMTSpielSpaßCodeGenerierungBenutzers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Admin...");
		pmt.spielspaß.codegenerierung.Admin[] pMTSpielSpaßCodeGenerierungAdmins = pmt.spielspaß.codegenerierung.AdminDAO.listAdminByQuery(null, null);
		length = Math.min(pMTSpielSpaßCodeGenerierungAdmins.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pMTSpielSpaßCodeGenerierungAdmins[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Frage...");
		pmt.spielspaß.codegenerierung.Frage[] pMTSpielSpaßCodeGenerierungFrages = pmt.spielspaß.codegenerierung.FrageDAO.listFrageByQuery(null, null);
		length = Math.min(pMTSpielSpaßCodeGenerierungFrages.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pMTSpielSpaßCodeGenerierungFrages[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Zeit...");
		pmt.spielspaß.codegenerierung.Zeit[] pMTSpielSpaßCodeGenerierungZeits = pmt.spielspaß.codegenerierung.ZeitDAO.listZeitByQuery(null, null);
		length = Math.min(pMTSpielSpaßCodeGenerierungZeits.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pMTSpielSpaßCodeGenerierungZeits[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing BugaBesucher...");
		pmt.spielspaß.codegenerierung.BugaBesucher[] pMTSpielSpaßCodeGenerierungBugaBesuchers = pmt.spielspaß.codegenerierung.BugaBesucherDAO.listBugaBesucherByQuery(null, null);
		length = Math.min(pMTSpielSpaßCodeGenerierungBugaBesuchers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(pMTSpielSpaßCodeGenerierungBugaBesuchers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Kletterwand by Criteria...");
		pmt.spielspaß.codegenerierung.KletterwandCriteria pMTSpielSpaßCodeGenerierungKletterwandCriteria = new pmt.spielspaß.codegenerierung.KletterwandCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pMTSpielSpaßCodeGenerierungKletterwandCriteria.name.eq();
		pMTSpielSpaßCodeGenerierungKletterwandCriteria.setMaxResults(ROW_COUNT);
		pmt.spielspaß.codegenerierung.Kletterwand[] pMTSpielSpaßCodeGenerierungKletterwands = pMTSpielSpaßCodeGenerierungKletterwandCriteria.listKletterwand();
		int length =pMTSpielSpaßCodeGenerierungKletterwands== null ? 0 : Math.min(pMTSpielSpaßCodeGenerierungKletterwands.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pMTSpielSpaßCodeGenerierungKletterwands[i]);
		}
		System.out.println(length + " Kletterwand record(s) retrieved."); 
		
		System.out.println("Listing QRCode by Criteria...");
		pmt.spielspaß.codegenerierung.QRCodeCriteria pMTSpielSpaßCodeGenerierungQRCodeCriteria = new pmt.spielspaß.codegenerierung.QRCodeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pMTSpielSpaßCodeGenerierungQRCodeCriteria.name.eq();
		pMTSpielSpaßCodeGenerierungQRCodeCriteria.setMaxResults(ROW_COUNT);
		pmt.spielspaß.codegenerierung.QRCode[] pMTSpielSpaßCodeGenerierungQRCodes = pMTSpielSpaßCodeGenerierungQRCodeCriteria.listQRCode();
		length =pMTSpielSpaßCodeGenerierungQRCodes== null ? 0 : Math.min(pMTSpielSpaßCodeGenerierungQRCodes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pMTSpielSpaßCodeGenerierungQRCodes[i]);
		}
		System.out.println(length + " QRCode record(s) retrieved."); 
		
		System.out.println("Listing Benutzer by Criteria...");
		pmt.spielspaß.codegenerierung.BenutzerCriteria pMTSpielSpaßCodeGenerierungBenutzerCriteria = new pmt.spielspaß.codegenerierung.BenutzerCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pMTSpielSpaßCodeGenerierungBenutzerCriteria.username.eq();
		pMTSpielSpaßCodeGenerierungBenutzerCriteria.setMaxResults(ROW_COUNT);
		pmt.spielspaß.codegenerierung.Benutzer[] pMTSpielSpaßCodeGenerierungBenutzers = pMTSpielSpaßCodeGenerierungBenutzerCriteria.listBenutzer();
		length =pMTSpielSpaßCodeGenerierungBenutzers== null ? 0 : Math.min(pMTSpielSpaßCodeGenerierungBenutzers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pMTSpielSpaßCodeGenerierungBenutzers[i]);
		}
		System.out.println(length + " Benutzer record(s) retrieved."); 
		
		System.out.println("Listing Admin by Criteria...");
		pmt.spielspaß.codegenerierung.AdminCriteria pMTSpielSpaßCodeGenerierungAdminCriteria = new pmt.spielspaß.codegenerierung.AdminCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pMTSpielSpaßCodeGenerierungAdminCriteria.username.eq();
		pMTSpielSpaßCodeGenerierungAdminCriteria.setMaxResults(ROW_COUNT);
		pmt.spielspaß.codegenerierung.Admin[] pMTSpielSpaßCodeGenerierungAdmins = pMTSpielSpaßCodeGenerierungAdminCriteria.listAdmin();
		length =pMTSpielSpaßCodeGenerierungAdmins== null ? 0 : Math.min(pMTSpielSpaßCodeGenerierungAdmins.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pMTSpielSpaßCodeGenerierungAdmins[i]);
		}
		System.out.println(length + " Admin record(s) retrieved."); 
		
		System.out.println("Listing Frage by Criteria...");
		pmt.spielspaß.codegenerierung.FrageCriteria pMTSpielSpaßCodeGenerierungFrageCriteria = new pmt.spielspaß.codegenerierung.FrageCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pMTSpielSpaßCodeGenerierungFrageCriteria.frage.eq();
		pMTSpielSpaßCodeGenerierungFrageCriteria.setMaxResults(ROW_COUNT);
		pmt.spielspaß.codegenerierung.Frage[] pMTSpielSpaßCodeGenerierungFrages = pMTSpielSpaßCodeGenerierungFrageCriteria.listFrage();
		length =pMTSpielSpaßCodeGenerierungFrages== null ? 0 : Math.min(pMTSpielSpaßCodeGenerierungFrages.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pMTSpielSpaßCodeGenerierungFrages[i]);
		}
		System.out.println(length + " Frage record(s) retrieved."); 
		
		System.out.println("Listing Zeit by Criteria...");
		pmt.spielspaß.codegenerierung.ZeitCriteria pMTSpielSpaßCodeGenerierungZeitCriteria = new pmt.spielspaß.codegenerierung.ZeitCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pMTSpielSpaßCodeGenerierungZeitCriteria.ID.eq();
		pMTSpielSpaßCodeGenerierungZeitCriteria.setMaxResults(ROW_COUNT);
		pmt.spielspaß.codegenerierung.Zeit[] pMTSpielSpaßCodeGenerierungZeits = pMTSpielSpaßCodeGenerierungZeitCriteria.listZeit();
		length =pMTSpielSpaßCodeGenerierungZeits== null ? 0 : Math.min(pMTSpielSpaßCodeGenerierungZeits.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pMTSpielSpaßCodeGenerierungZeits[i]);
		}
		System.out.println(length + " Zeit record(s) retrieved."); 
		
		System.out.println("Listing BugaBesucher by Criteria...");
		pmt.spielspaß.codegenerierung.BugaBesucherCriteria pMTSpielSpaßCodeGenerierungBugaBesucherCriteria = new pmt.spielspaß.codegenerierung.BugaBesucherCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//pMTSpielSpaßCodeGenerierungBugaBesucherCriteria.username.eq();
		//pMTSpielSpaßCodeGenerierungBugaBesucherCriteria.listeDerErrungenschaften.eq();
		pMTSpielSpaßCodeGenerierungBugaBesucherCriteria.setMaxResults(ROW_COUNT);
		pmt.spielspaß.codegenerierung.BugaBesucher[] pMTSpielSpaßCodeGenerierungBugaBesuchers = pMTSpielSpaßCodeGenerierungBugaBesucherCriteria.listBugaBesucher();
		length =pMTSpielSpaßCodeGenerierungBugaBesuchers== null ? 0 : Math.min(pMTSpielSpaßCodeGenerierungBugaBesuchers.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(pMTSpielSpaßCodeGenerierungBugaBesuchers[i]);
		}
		System.out.println(length + " BugaBesucher record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListPMTBUGAData listPMTBUGAData = new ListPMTBUGAData();
			try {
				listPMTBUGAData.listTestData();
				//listPMTBUGAData.listByCriteria();
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
