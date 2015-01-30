package edu.pitt.sis.infsci2711.multidbs.visapi;

import edu.pitt.sis.infsci2711.multidbs.utils.JerseyJettyServer;

public class VisualizationServer {
	public static void main(final String[] args) throws Exception {
		JerseyJettyServer server = new JerseyJettyServer(7777, "edu.pitt.sis.infsci2711.tutorial.rest");
		server.start();
	}
}
