package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.List;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Story;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;

public interface StoryManager extends GeneralManager<Story, Integer> {

   public Story createNewStory(Users user, String connInfo);
   public List<Story> findStoryByUser(Users users); //add, may need to delete

}
