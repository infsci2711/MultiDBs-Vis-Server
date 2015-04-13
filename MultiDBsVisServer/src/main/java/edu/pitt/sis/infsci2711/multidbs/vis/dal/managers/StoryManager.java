package edu.pitt.sis.infsci2711.multidbs.vis.dal.managers;

import java.util.List;

import jnr.ffi.Struct.int16_t;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Canvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Story;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;

public interface StoryManager extends GeneralManager<Story, Integer> {

   public Story createNewStory(String did, String dname, String tname, Canvases canvases);
   public List<Story> showAllByCanvasId(Canvases canvses); //add, may need to delete
   //public List<Story> findStoryById(int sid);

}
