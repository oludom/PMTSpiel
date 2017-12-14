/**
 * Licensee: Jan(Hochschule Heilbronn)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeletePMTBUGAData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession().beginTransaction();
		try {
			pmt.spielspaß.codegenerierung.Kletterwand pMTSpielSpaßCodeGenerierungKletterwand = pmt.spielspaß.codegenerierung.KletterwandDAO.loadKletterwandByQuery(null, null);
			// Delete the persistent object
			pmt.spielspaß.codegenerierung.KletterwandDAO.delete(pMTSpielSpaßCodeGenerierungKletterwand);
			pmt.spielspaß.codegenerierung.QRCode pMTSpielSpaßCodeGenerierungQRCode = pmt.spielspaß.codegenerierung.QRCodeDAO.loadQRCodeByQuery(null, null);
			// Delete the persistent object
			pmt.spielspaß.codegenerierung.QRCodeDAO.delete(pMTSpielSpaßCodeGenerierungQRCode);
			pmt.spielspaß.codegenerierung.Benutzer pMTSpielSpaßCodeGenerierungBenutzer = pmt.spielspaß.codegenerierung.BenutzerDAO.loadBenutzerByQuery(null, null);
			// Delete the persistent object
			pmt.spielspaß.codegenerierung.BenutzerDAO.delete(pMTSpielSpaßCodeGenerierungBenutzer);
			pmt.spielspaß.codegenerierung.Admin pMTSpielSpaßCodeGenerierungAdmin = pmt.spielspaß.codegenerierung.AdminDAO.loadAdminByQuery(null, null);
			// Delete the persistent object
			pmt.spielspaß.codegenerierung.AdminDAO.delete(pMTSpielSpaßCodeGenerierungAdmin);
			pmt.spielspaß.codegenerierung.Frage pMTSpielSpaßCodeGenerierungFrage = pmt.spielspaß.codegenerierung.FrageDAO.loadFrageByQuery(null, null);
			// Delete the persistent object
			pmt.spielspaß.codegenerierung.FrageDAO.delete(pMTSpielSpaßCodeGenerierungFrage);
			pmt.spielspaß.codegenerierung.Zeit pMTSpielSpaßCodeGenerierungZeit = pmt.spielspaß.codegenerierung.ZeitDAO.loadZeitByQuery(null, null);
			// Delete the persistent object
			pmt.spielspaß.codegenerierung.ZeitDAO.delete(pMTSpielSpaßCodeGenerierungZeit);
			pmt.spielspaß.codegenerierung.BugaBesucher pMTSpielSpaßCodeGenerierungBugaBesucher = pmt.spielspaß.codegenerierung.BugaBesucherDAO.loadBugaBesucherByQuery(null, null);
			// Delete the persistent object
			pmt.spielspaß.codegenerierung.BugaBesucherDAO.delete(pMTSpielSpaßCodeGenerierungBugaBesucher);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeletePMTBUGAData deletePMTBUGAData = new DeletePMTBUGAData();
			try {
				deletePMTBUGAData.deleteTestData();
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
