package org.elier.hp.restaurant;

public class CustomerGroup {
	private static int groupCounter;

	private final int size;
	private Table table;
	private int order = groupCounter;

	CustomerGroup(int size) {
		this.size = size;
	}

	Table getTable() {
		return table;
	}

	void leave() {
		if (table != null) {
			table.leaveChairs(size);
		}
	}
}
