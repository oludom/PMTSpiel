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

public class QRCodeDAO {
	public static QRCode loadQRCodeByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadQRCodeByORMID(session, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode getQRCodeByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return getQRCodeByORMID(session, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode loadQRCodeByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadQRCodeByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode getQRCodeByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return getQRCodeByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode loadQRCodeByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (QRCode) session.load(pmt.spielspaß.codegenerierung.QRCode.class, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode getQRCodeByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (QRCode) session.get(pmt.spielspaß.codegenerierung.QRCode.class, name);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode loadQRCodeByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (QRCode) session.load(pmt.spielspaß.codegenerierung.QRCode.class, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode getQRCodeByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (QRCode) session.get(pmt.spielspaß.codegenerierung.QRCode.class, name, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryQRCode(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return queryQRCode(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryQRCode(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return queryQRCode(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode[] listQRCodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return listQRCodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode[] listQRCodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return listQRCodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryQRCode(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.QRCode as QRCode");
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
	
	public static List queryQRCode(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.QRCode as QRCode");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("QRCode", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode[] listQRCodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryQRCode(session, condition, orderBy);
			return (QRCode[]) list.toArray(new QRCode[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode[] listQRCodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryQRCode(session, condition, orderBy, lockMode);
			return (QRCode[]) list.toArray(new QRCode[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode loadQRCodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadQRCodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode loadQRCodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return loadQRCodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode loadQRCodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		QRCode[] qRCodes = listQRCodeByQuery(session, condition, orderBy);
		if (qRCodes != null && qRCodes.length > 0)
			return qRCodes[0];
		else
			return null;
	}
	
	public static QRCode loadQRCodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		QRCode[] qRCodes = listQRCodeByQuery(session, condition, orderBy, lockMode);
		if (qRCodes != null && qRCodes.length > 0)
			return qRCodes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateQRCodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return iterateQRCodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateQRCodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession();
			return iterateQRCodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateQRCodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.QRCode as QRCode");
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
	
	public static java.util.Iterator iterateQRCodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From pmt.spielspaß.codegenerierung.QRCode as QRCode");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("QRCode", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode createQRCode() {
		return new pmt.spielspaß.codegenerierung.QRCode();
	}
	
	public static boolean save(pmt.spielspaß.codegenerierung.QRCode qRCode) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().saveObject(qRCode);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(pmt.spielspaß.codegenerierung.QRCode qRCode) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().deleteObject(qRCode);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(pmt.spielspaß.codegenerierung.QRCode qRCode)throws PersistentException {
		try {
			if (qRCode.getAufgabe() != null) {
				qRCode.getAufgabe().besitzer.remove(qRCode);
			}
			
			pmt.spielspaß.codegenerierung.Benutzer[] lSuperusers = qRCode.superuser.toArray();
			for(int i = 0; i < lSuperusers.length; i++) {
				lSuperusers[i].gespeicherteQRCodes.remove(qRCode);
			}
			return delete(qRCode);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(pmt.spielspaß.codegenerierung.QRCode qRCode, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (qRCode.getAufgabe() != null) {
				qRCode.getAufgabe().besitzer.remove(qRCode);
			}
			
			pmt.spielspaß.codegenerierung.Benutzer[] lSuperusers = qRCode.superuser.toArray();
			for(int i = 0; i < lSuperusers.length; i++) {
				lSuperusers[i].gespeicherteQRCodes.remove(qRCode);
			}
			try {
				session.delete(qRCode);
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
	
	public static boolean refresh(pmt.spielspaß.codegenerierung.QRCode qRCode) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession().refresh(qRCode);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(pmt.spielspaß.codegenerierung.QRCode qRCode) throws PersistentException {
		try {
			pmt.spielspaß.codegenerierung.PMTBUGAPersistentManager.instance().getSession().evict(qRCode);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static QRCode loadQRCodeByCriteria(QRCodeCriteria qRCodeCriteria) {
		QRCode[] qRCodes = listQRCodeByCriteria(qRCodeCriteria);
		if(qRCodes == null || qRCodes.length == 0) {
			return null;
		}
		return qRCodes[0];
	}
	
	public static QRCode[] listQRCodeByCriteria(QRCodeCriteria qRCodeCriteria) {
		return qRCodeCriteria.listQRCode();
	}
}
