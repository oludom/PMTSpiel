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

public class ZeitDAO {
	public static Zeit loadZeitByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadZeitByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit getZeitByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return getZeitByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit loadZeitByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadZeitByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit getZeitByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return getZeitByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit loadZeitByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Zeit) session.load(pmt.spielspaß.codegenerierung.Zeit.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit getZeitByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Zeit) session.get(pmt.spielspaß.codegenerierung.Zeit.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit loadZeitByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Zeit) session.load(pmt.spielspaß.codegenerierung.Zeit.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit getZeitByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Zeit) session.get(pmt.spielspaß.codegenerierung.Zeit.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryZeit(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return queryZeit(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryZeit(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return queryZeit(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit[] listZeitByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return listZeitByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit[] listZeitByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return listZeitByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryZeit(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.Zeit as Zeit");
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
	
	public static List queryZeit(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.Zeit as Zeit");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Zeit", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit[] listZeitByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryZeit(session, condition, orderBy);
			return (Zeit[]) list.toArray(new Zeit[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit[] listZeitByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryZeit(session, condition, orderBy, lockMode);
			return (Zeit[]) list.toArray(new Zeit[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit loadZeitByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadZeitByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit loadZeitByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadZeitByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit loadZeitByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Zeit[] zeits = listZeitByQuery(session, condition, orderBy);
		if (zeits != null && zeits.length > 0)
			return zeits[0];
		else
			return null;
	}
	
	public static Zeit loadZeitByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Zeit[] zeits = listZeitByQuery(session, condition, orderBy, lockMode);
		if (zeits != null && zeits.length > 0)
			return zeits[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateZeitByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return iterateZeitByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateZeitByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return iterateZeitByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateZeitByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.Zeit as Zeit");
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
	
	public static java.util.Iterator iterateZeitByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.Zeit as Zeit");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Zeit", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit createZeit() {
		return new pmt.spielspaß.codegenerierung.Zeit();
	}
	
	public static boolean save(pmt.spielspaß.codegenerierung.Zeit zeit) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().saveObject(zeit);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(pmt.spielspaß.codegenerierung.Zeit zeit) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().deleteObject(zeit);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(pmt.spielspaß.codegenerierung.Zeit zeit)throws PersistentException {
		try {
			if (zeit.getSpieler() != null) {
				zeit.getSpieler().leistung.remove(zeit);
			}
			
			if (zeit.getKletterwand() != null) {
				zeit.getKletterwand().zeits.remove(zeit);
			}
			
			if (zeit.getBugaBesucher() != null) {
				zeit.getBugaBesucher().zeits.remove(zeit);
			}
			
			return delete(zeit);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(pmt.spielspaß.codegenerierung.Zeit zeit, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (zeit.getSpieler() != null) {
				zeit.getSpieler().leistung.remove(zeit);
			}
			
			if (zeit.getKletterwand() != null) {
				zeit.getKletterwand().zeits.remove(zeit);
			}
			
			if (zeit.getBugaBesucher() != null) {
				zeit.getBugaBesucher().zeits.remove(zeit);
			}
			
			try {
				session.delete(zeit);
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
	
	public static boolean refresh(pmt.spielspaß.codegenerierung.Zeit zeit) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession().refresh(zeit);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(pmt.spielspaß.codegenerierung.Zeit zeit) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession().evict(zeit);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Zeit loadZeitByCriteria(ZeitCriteria zeitCriteria) {
		Zeit[] zeits = listZeitByCriteria(zeitCriteria);
		if(zeits == null || zeits.length == 0) {
			return null;
		}
		return zeits[0];
	}
	
	public static Zeit[] listZeitByCriteria(ZeitCriteria zeitCriteria) {
		return zeitCriteria.listZeit();
	}
}
