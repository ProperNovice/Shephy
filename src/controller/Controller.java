package controller;

import instances.Instances;

public class Controller {

	public Controller() {

		createInstances();

	}

	private void createInstances() {

		Instances.createController(this);
		System.out.println("k");

	}

}
