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

public class BugaBesucherDAO {
	public static BugaBesucher loadBugaBesucherByORMID(String username) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadBugaBesucherByORMID(session, username);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher getBugaBesucherByORMID(String username) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return getBugaBesucherByORMID(session, username);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher loadBugaBesucherByORMID(String username, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadBugaBesucherByORMID(session, username, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher getBugaBesucherByORMID(String username, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return getBugaBesucherByORMID(session, username, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher loadBugaBesucherByORMID(PersistentSession session, String username) throws PersistentException {
		try {
			return (BugaBesucher) session.load(pmt.spielspaß.codegenerierung.BugaBesucher.class, username);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher getBugaBesucherByORMID(PersistentSession session, String username) throws PersistentException {
		try {
			return (BugaBesucher) session.get(pmt.spielspaß.codegenerierung.BugaBesucher.class, username);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher loadBugaBesucherByORMID(PersistentSession session, String username, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (BugaBesucher) session.load(pmt.spielspaß.codegenerierung.BugaBesucher.class, username, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher getBugaBesucherByORMID(PersistentSession session, String username, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (BugaBesucher) session.get(pmt.spielspaß.codegenerierung.BugaBesucher.class, username, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBugaBesucher(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return queryBugaBesucher(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBugaBesucher(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return queryBugaBesucher(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher[] listBugaBesucherByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return listBugaBesucherByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher[] listBugaBesucherByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return listBugaBesucherByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBugaBesucher(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.BugaBesucher as BugaBesucher");
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
	
	public static List queryBugaBesucher(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.BugaBesucher as BugaBesucher");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("BugaBesucher", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher[] listBugaBesucherByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryBugaBesucher(session, condition, orderBy);
			return (BugaBesucher[]) list.toArray(new BugaBesucher[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher[] listBugaBesucherByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryBugaBesucher(session, condition, orderBy, lockMode);
			return (BugaBesucher[]) list.toArray(new BugaBesucher[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher loadBugaBesucherByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadBugaBesucherByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher loadBugaBesucherByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadBugaBesucherByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher loadBugaBesucherByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		BugaBesucher[] bugaBesuchers = listBugaBesucherByQuery(session, condition, orderBy);
		if (bugaBesuchers != null && bugaBesuchers.length > 0)
			return bugaBesuchers[0];
		else
			return null;
	}
	
	public static BugaBesucher loadBugaBesucherByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		BugaBesucher[] bugaBesuchers = listBugaBesucherByQuery(session, condition, orderBy, lockMode);
		if (bugaBesuchers != null && bugaBesuchers.length > 0)
			return bugaBesuchers[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateBugaBesucherByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return iterateBugaBesucherByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBugaBesucherByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return iterateBugaBesucherByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBugaBesucherByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.BugaBesucher as BugaBesucher");
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
	
	public static java.util.Iterator iterateBugaBesucherByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.BugaBesucher as BugaBesucher");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("BugaBesucher", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher createBugaBesucher() {
		return new pmt.spielspaß.codegenerierung.BugaBesucher();
	}
	
	public static boolean save(pmt.spielspaß.codegenerierung.BugaBesucher bugaBesucher) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().saveObject(bugaBesucher);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(pmt.spielspaß.codegenerierung.BugaBesucher bugaBesucher) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().deleteObject(bugaBesucher);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(pmt.spielspaß.codegenerierung.BugaBesucher bugaBesucher)throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.Zeit[] lZeitss = bugaBesucher.zeits.toArray();
			for(int i = 0; i < lZeitss.length; i++) {
				lZeitss[i].setBugaBesucher(null);
			}
			pmt.spielspaß.codegenerierung.QRCode[] lCodes = bugaBesucher.code.toArray();
			for(int i = 0; i < lCodes.length; i++) {
				lCodes[i].setSpieler(null);
			}
			pmt.spielspaß.codegenerierung.Zeit[] lLeistungs = bugaBesucher.leistung.toArray();
			for(int i = 0; i < lLeistungs.length; i++) {
				lLeistungs[i].setSpieler(null);
			}
			return delete(bugaBesucher);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(pmt.spielspaß.codegenerierung.BugaBesucher bugaBesucher, org.orm.PersistentSession session)throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.Zeit[] lZeitss = bugaBesucher.zeits.toArray();
			for(int i = 0; i < lZeitss.length; i++) {
				lZeitss[i].setBugaBesucher(null);
			}
			pmt.spielspaß.codegenerierung.QRCode[] lCodes = bugaBesucher.code.toArray();
			for(int i = 0; i < lCodes.length; i++) {
				lCodes[i].setSpieler(null);
			}
			pmt.spielspaß.codegenerierung.Zeit[] lLeistungs = bugaBesucher.leistung.toArray();
			for(int i = 0; i < lLeistungs.length; i++) {
				lLeistungs[i].setSpieler(null);
			}
			try {
				session.delete(bugaBesucher);
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
	
	public static boolean refresh(pmt.spielspaß.codegenerierung.BugaBesucher bugaBesucher) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession().refresh(bugaBesucher);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(pmt.spielspaß.codegenerierung.BugaBesucher bugaBesucher) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession().evict(bugaBesucher);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static BugaBesucher loadBugaBesucherByCriteria(BugaBesucherCriteria bugaBesucherCriteria) {
		BugaBesucher[] bugaBesuchers = listBugaBesucherByCriteria(bugaBesucherCriteria);
		if(bugaBesuchers == null || bugaBesuchers.length == 0) {
			return null;
		}
		return bugaBesuchers[0];
	}
	
	public static BugaBesucher[] listBugaBesucherByCriteria(BugaBesucherCriteria bugaBesucherCriteria) {
		return bugaBesucherCriteria.listBugaBesucher();
	}
}
