package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Story;

public interface StoryManager extends GeneralManager<Story, Integer> {
   public Story createNewStory(int sid);
}
