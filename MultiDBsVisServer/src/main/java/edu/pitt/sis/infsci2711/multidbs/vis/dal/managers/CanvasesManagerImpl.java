package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.List;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.dao.CanvasesDAO;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.dao.CanvasesDAOImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Canvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.utils.HibernateUtil;

/**
 * @author xiaotingli
 *
 */
public class CanvasesManagerImpl extends GeneralManagerImpl<CanvasesDAO, Canvases, Integer>
		implements CanvasesManager {

	Logger logger = LogManager.getLogger(CanvasesManagerImpl.class.getName());
	
	public CanvasesManagerImpl() {
		super(new CanvasesDAOImpl(), Canvases.class);
	}
	
	public Canvases createNewCanvas(Users canvasOwner, String name) {
		Canvases newCanvas = new Canvases(new Date(), new Date());
		newCanvas.setUsers(canvasOwner);
		newCanvas.setName(name);
		
		try {
			HibernateUtil.beginTransaction();
			
			_dao.save(newCanvas);
			
			HibernateUtil.commitTransaction();
			
		}
		catch (Exception ex) {
			HibernateUtil.rollbackTransaction();
			
			this.logger.error("getTableInfo failed HibernateException", ex);
			throw ex;
		}
		
		return newCanvas;
	}
	
	public List<Canvases> findByName(String name){
		
		try {
			HibernateUtil.beginTransaction();
			
			String hql = "SELECT C FROM Canvases C WHERE C.name = :name";

			Query query = HibernateUtil.getSession().createQuery(hql);
			query.setParameter("name", name);
			
			List<Canvases> result = _dao.findMany(query);
			
			for (Canvases canvas : result) { // lazy
				Hibernate.initialize(canvas.getUsers());
			}
			
			HibernateUtil.commitTransaction();
			
			return result;
		}
		catch(Exception ex){
			HibernateUtil.rollbackTransaction();
			
			this.logger.error("Cannot find the records", ex);
			throw ex;
		}	
		
	}
	
	//add, may need to delete
	public List<Canvases> findCanvasByUser(Users users){
		try{
			HibernateUtil.beginTransaction();
			
			//int userId = users.getUserId();
			String hql = "SELECT C FROM Canvases C WHERE C.users = :users";

			Query query = HibernateUtil.getSession().createQuery(hql);
			query.setParameter("users", users);
			
			List<Canvases> result = _dao.findMany(query);
			
			for (Canvases canvas : result) { // lazy
				Hibernate.initialize(canvas.getUsers());
			}
			
			HibernateUtil.commitTransaction();
			
			return result;
			
		}catch(Exception ex){
            HibernateUtil.rollbackTransaction();
			
			this.logger.error("Cannot find the records", ex);
			throw ex;
		}
	}
	
}

