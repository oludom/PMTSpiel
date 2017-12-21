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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class KletterwandDAO {
	public static Kletterwand loadKletterwandByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadKletterwandByORMID(session, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand getKletterwandByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return getKletterwandByORMID(session, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand loadKletterwandByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadKletterwandByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand getKletterwandByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return getKletterwandByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand loadKletterwandByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (Kletterwand) session.load(pmt.spielspaß.codegenerierung.Kletterwand.class, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand getKletterwandByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (Kletterwand) session.get(pmt.spielspaß.codegenerierung.Kletterwand.class, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand loadKletterwandByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Kletterwand) session.load(pmt.spielspaß.codegenerierung.Kletterwand.class, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand getKletterwandByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Kletterwand) session.get(pmt.spielspaß.codegenerierung.Kletterwand.class, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryKletterwand(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return queryKletterwand(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryKletterwand(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return queryKletterwand(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand[] listKletterwandByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return listKletterwandByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand[] listKletterwandByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return listKletterwandByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryKletterwand(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.Kletterwand as Kletterwand");
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
	
	public static List queryKletterwand(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.Kletterwand as Kletterwand");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Kletterwand", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand[] listKletterwandByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryKletterwand(session, condition, orderBy);
			return (Kletterwand[]) list.toArray(new Kletterwand[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand[] listKletterwandByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryKletterwand(session, condition, orderBy, lockMode);
			return (Kletterwand[]) list.toArray(new Kletterwand[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand loadKletterwandByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadKletterwandByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand loadKletterwandByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadKletterwandByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand loadKletterwandByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Kletterwand[] kletterwands = listKletterwandByQuery(session, condition, orderBy);
		if (kletterwands != null && kletterwands.length > 0)
			return kletterwands[0];
		else
			return null;
	}
	
	public static Kletterwand loadKletterwandByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Kletterwand[] kletterwands = listKletterwandByQuery(session, condition, orderBy, lockMode);
		if (kletterwands != null && kletterwands.length > 0)
			return kletterwands[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateKletterwandByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return iterateKletterwandByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateKletterwandByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return iterateKletterwandByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateKletterwandByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.Kletterwand as Kletterwand");
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
	
	public static java.util.Iterator iterateKletterwandByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.Kletterwand as Kletterwand");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Kletterwand", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand createKletterwand() {
		return new pmt.spielspaß.codegenerierung.Kletterwand();
	}
	
	public static boolean save(pmt.spielspaß.codegenerierung.Kletterwand kletterwand) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().saveObject(kletterwand);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(pmt.spielspaß.codegenerierung.Kletterwand kletterwand) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().deleteObject(kletterwand);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(pmt.spielspaß.codegenerierung.Kletterwand kletterwand)throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.Zeit[] lZeitss = kletterwand.zeits.toArray();
			for(int i = 0; i < lZeitss.length; i++) {
				lZeitss[i].setKletterwand(null);
			}
			pmt.spielspaß.codegenerierung.Benutzer[] lSuperusers = kletterwand.superuser.toArray();
			for(int i = 0; i < lSuperusers.length; i++) {
				lSuperusers[i].gespeicherteKletterwände.remove(kletterwand);
			}
			return delete(kletterwand);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(pmt.spielspaß.codegenerierung.Kletterwand kletterwand, org.orm.PersistentSession session)throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.Zeit[] lZeitss = kletterwand.zeits.toArray();
			for(int i = 0; i < lZeitss.length; i++) {
				lZeitss[i].setKletterwand(null);
			}
			pmt.spielspaß.codegenerierung.Benutzer[] lSuperusers = kletterwand.superuser.toArray();
			for(int i = 0; i < lSuperusers.length; i++) {
				lSuperusers[i].gespeicherteKletterwände.remove(kletterwand);
			}
			try {
				session.delete(kletterwand);
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
	
	public static boolean refresh(pmt.spielspaß.codegenerierung.Kletterwand kletterwand) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession().refresh(kletterwand);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(pmt.spielspaß.codegenerierung.Kletterwand kletterwand) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession().evict(kletterwand);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Kletterwand loadKletterwandByCriteria(KletterwandCriteria kletterwandCriteria) {
		Kletterwand[] kletterwands = listKletterwandByCriteria(kletterwandCriteria);
		if(kletterwands == null || kletterwands.length == 0) {
			return null;
		}
		return kletterwands[0];
	}
	
	public static Kletterwand[] listKletterwandByCriteria(KletterwandCriteria kletterwandCriteria) {
		return kletterwandCriteria.listKletterwand();
	}
}
