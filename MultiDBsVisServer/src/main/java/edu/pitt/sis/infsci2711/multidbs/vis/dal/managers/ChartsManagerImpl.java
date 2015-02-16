package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.dao.ChartsDAO;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.dao.ChartsDAOImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Canvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Charts;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.utils.HibernateUtil;

public class ChartsManagerImpl extends GeneralManagerImpl<ChartsDAO, Charts, Integer> implements ChartsManager{
   Logger logger = LogManager.getLogger(CanvasesManagerImpl.class.getName());
	
   public ChartsManagerImpl() {
		super(new ChartsDAOImpl(), Charts.class);
	}
   
   public Charts createNewChart(Canvases canvas, String name, String type){
	   Charts newChart = new Charts();
	   newChart.setCanvases(canvas);
	   newChart.setName(name);
	   newChart.setType(type);
	   
	   try{
		   HibernateUtil.beginTransaction();
		   
		   _dao.save(newChart);
		   
		   HibernateUtil.commitTransaction();
	   }
	   catch(HibernateException ex){
		   this.logger.error("getTableInfo failed HibernateException", ex);
		   throw ex;
	   }
	   
	   return newChart;
   }
   
  public List<Charts> findByName(String name){
	  try {
			HibernateUtil.beginTransaction();
			
			String hql = "SELECT C FROM Charts C WHERE C.name = :name";

			Query query = HibernateUtil.getSession().createQuery(hql);
			query.setParameter("name", name);
			
			List<Charts> result = _dao.findMany(query);
			
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

