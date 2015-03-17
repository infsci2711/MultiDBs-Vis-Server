package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.*;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.dao.StoryDAO;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.dao.StoryDAOImpl;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Story;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.utils.HibernateUtil;


public class StoryManagerImpl extends GeneralManagerImpl<StoryDAO, Story, Integer> 
		implements StoryManager {
	Logger logger = LogManager.getLogger(CanvasesManagerImpl.class.getName());

	
	public StoryManagerImpl() {
		super(new StoryDAOImpl(), Story.class);
	}
	
<<<<<<< HEAD

=======
>>>>>>> origin/master
	public Story createNewStory(Users user, String connInfo){
		Story newStory = new Story(user, new Date(), new Date(), connInfo);
		
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

	

	
}
