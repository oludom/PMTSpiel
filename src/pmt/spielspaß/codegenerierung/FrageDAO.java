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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class FrageDAO {
	public static Frage loadFrageByORMID(String frage) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadFrageByORMID(session, frage);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage getFrageByORMID(String frage) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return getFrageByORMID(session, frage);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage loadFrageByORMID(String frage, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadFrageByORMID(session, frage, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage getFrageByORMID(String frage, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return getFrageByORMID(session, frage, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage loadFrageByORMID(PersistentSession session, String frage) throws PersistentException {
		try {
			return (Frage) session.load(pmt.spielspaß.codegenerierung.Frage.class, frage);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage getFrageByORMID(PersistentSession session, String frage) throws PersistentException {
		try {
			return (Frage) session.get(pmt.spielspaß.codegenerierung.Frage.class, frage);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage loadFrageByORMID(PersistentSession session, String frage, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Frage) session.load(pmt.spielspaß.codegenerierung.Frage.class, frage, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage getFrageByORMID(PersistentSession session, String frage, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Frage) session.get(pmt.spielspaß.codegenerierung.Frage.class, frage, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFrage(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return queryFrage(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFrage(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return queryFrage(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage[] listFrageByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return listFrageByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage[] listFrageByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return listFrageByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFrage(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.Frage as Frage");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryFrage(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.Frage as Frage");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Frage", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage[] listFrageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryFrage(session, condition, orderBy);
			return (Frage[]) list.toArray(new Frage[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage[] listFrageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryFrage(session, condition, orderBy, lockMode);
			return (Frage[]) list.toArray(new Frage[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage loadFrageByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadFrageByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage loadFrageByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadFrageByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage loadFrageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Frage[] frages = listFrageByQuery(session, condition, orderBy);
		if (frages != null && frages.length > 0)
			return frages[0];
		else
			return null;
	}
	
	public static Frage loadFrageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Frage[] frages = listFrageByQuery(session, condition, orderBy, lockMode);
		if (frages != null && frages.length > 0)
			return frages[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateFrageByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return iterateFrageByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFrageByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return iterateFrageByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFrageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.Frage as Frage");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFrageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.Frage as Frage");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Frage", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage createFrage() {
		return new pmt.spielspaß.codegenerierung.Frage();
	}
	
	public static boolean save(pmt.spielspaß.codegenerierung.Frage frage) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().saveObject(frage);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(pmt.spielspaß.codegenerierung.Frage frage) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().deleteObject(frage);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(pmt.spielspaß.codegenerierung.Frage frage)throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.QRCode[] lBesitzers = frage.besitzer.toArray();
			for(int i = 0; i < lBesitzers.length; i++) {
				lBesitzers[i].setAufgabe(null);
			}
			return delete(frage);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(pmt.spielspaß.codegenerierung.Frage frage, org.orm.PersistentSession session)throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.QRCode[] lBesitzers = frage.besitzer.toArray();
			for(int i = 0; i < lBesitzers.length; i++) {
				lBesitzers[i].setAufgabe(null);
			}
			try {
				session.delete(frage);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(pmt.spielspaß.codegenerierung.Frage frage) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession().refresh(frage);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(pmt.spielspaß.codegenerierung.Frage frage) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession().evict(frage);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Frage loadFrageByCriteria(FrageCriteria frageCriteria) {
		Frage[] frages = listFrageByCriteria(frageCriteria);
		if(frages == null || frages.length == 0) {
			return null;
		}
		return frages[0];
	}
	
	public static Frage[] listFrageByCriteria(FrageCriteria frageCriteria) {
		return frageCriteria.listFrage();
	}
}
