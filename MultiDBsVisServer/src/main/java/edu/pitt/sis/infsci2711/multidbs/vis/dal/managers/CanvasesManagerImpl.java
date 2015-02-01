package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.List;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.dao.CanvasesDAO;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.dao.CanvasesDAOImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.ColfusionCanvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.ColfusionUsers;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.utils.HibernateUtil;

/**
 * @author xiaotingli
 *
 */
public class CanvasesManagerImpl extends GeneralManagerImpl<CanvasesDAO, ColfusionCanvases, Integer>
		implements CanvasesManager {

	Logger logger = LogManager.getLogger(CanvasesManagerImpl.class.getName());
	
	public CanvasesManagerImpl() {
		super(new CanvasesDAOImpl(), ColfusionCanvases.class);
	}
	
	public ColfusionCanvases createNewCanvas(ColfusionUsers canvasOwner, String name) {
		ColfusionCanvases newCanvas = new ColfusionCanvases(new Date(), new Date());
		newCanvas.setColfusionUsers(canvasOwner);
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
	
	public List<ColfusionCanvases> findByName(String name){
		
		try {
			HibernateUtil.beginTransaction();
			
			String hql = "SELECT C FROM ColfusionCanvases C WHERE C.name = :name";

			Query query = HibernateUtil.getSession().createQuery(hql);
			query.setParameter("name", name);
			
			List<ColfusionCanvases> result = _dao.findMany(query);
			
			HibernateUtil.commitTransaction();
			
			return result;
		}
		catch(Exception ex){
			HibernateUtil.rollbackTransaction();
			
			this.logger.error("Cannot find the records", ex);
			throw ex;
		}
		
		
		
		
	}
}

