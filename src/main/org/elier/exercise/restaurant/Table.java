package org.elier.hp.restaurant;

public class Table {
	private final int size;
	private int availableChairs;

	Table(int size) {
		this.size = size;
		availableChairs = size;
	}

	void occupyChairs(int chairs) {
		availableChairs =- chairs;
	}

	void leaveChairs(int chairs) {
		availableChairs =+ chairs;
	}
}
