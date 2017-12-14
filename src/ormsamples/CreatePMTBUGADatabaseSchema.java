/**
 * Licensee: Micha(Hochschule Heilbronn)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreatePMTBUGADatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance());
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
