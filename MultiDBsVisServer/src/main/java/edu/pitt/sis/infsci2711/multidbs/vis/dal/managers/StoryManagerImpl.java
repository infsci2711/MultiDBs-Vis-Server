package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.*;
import org.hibernate.Hibernate;
import org.hibernate.Query;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.dao.StoryDAO;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.dao.StoryDAOImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Canvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Story;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.utils.HibernateUtil;


public class StoryManagerImpl extends GeneralManagerImpl<StoryDAO, Story, Integer> 
		implements StoryManager {
	Logger logger = LogManager.getLogger(CanvasesManagerImpl.class.getName());

	
	public StoryManagerImpl() {
		super(new StoryDAOImpl(), Story.class);
	}
	

	public Story createNewStory(String did, String dname, String tname, Canvases canvases){
		Story newStory = new Story(new Date());
		newStory.setDid(did);
		newStory.setDname(dname);
		newStory.setTname(tname);
		newStory.setCanvases(canvases);
		
		try{
            HibernateUtil.beginTransaction();
			
			_dao.save(newStory);
			
			HibernateUtil.commitTransaction();
		}
		catch (Exception ex) {
			HibernateUtil.rollbackTransaction();
			
			this.logger.error("getTableInfo failed HibernateException", ex);
			throw ex;
		}
	    
		return newStory;
	}
	
	public List<Story> showAllByCanvasId(Canvases canvases){
		try {
			HibernateUtil.beginTransaction();
			
			String hql = "SELECT S FROM Story S WHERE S.canvases = :canvases";
			
			Query query = HibernateUtil.getSession().createQuery(hql);
			query.setParameter("canvases", canvases);
			
			List<Story> result = _dao.findMany(query);
			
			HibernateUtil.commitTransaction();
			
			return result;
		} catch (Exception ex) {
			 HibernateUtil.rollbackTransaction();
		     this.logger.error("Cannot find the records", ex);
			 throw ex;
		}
	}

	
//	public List<Story> findStoryById(int sid){
//		try {
//            HibernateUtil.beginTransaction();
//			
//			//int userId = user.getUserId();
//			String hql = "SELECT S FROM Story S WHERE S.sid = :sid";
//
//			Query query = HibernateUtil.getSession().createQuery(hql);
//			query.setParameter("sid", sid);
//			
//			List<Story> result = _dao.findMany(query);
			
//			for (Story story : result) { // lazy
//				Hibernate.initialize(story.getUser());
//			}
//			
//			HibernateUtil.commitTransaction();
//			
//			return result;
//			
//		}catch(Exception ex){
//            HibernateUtil.rollbackTransaction();
//			
//			this.logger.error("Cannot find the records", ex);
//			throw ex;
//	    }
//
//	}
}
