package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Story;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;

public interface StoryManager extends GeneralManager<Story, Integer> {

   public Story createNewStory(Users user, String connInfo);

}
