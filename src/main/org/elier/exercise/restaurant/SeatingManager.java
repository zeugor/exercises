package org.elier.hp.restaurant;

import java.util.LinkedList;
import java.util.List;

public class SeatingManager {
	private List<Table> tables;
	private List<CustomerGroup> groupList = new LinkedList<CustomerGroup>();

	private void heuristicAssigment() {
		// goup list with no table assigned ordered by arriving time
		TreeList<CustomerGroup> waitingGroups 
			= new TreeList<CustomerGroup>(
				new Comparator(CustomerGroup() {
					@Override
					int compare(CustomerGroup g1, CustomerGroup g2) {
						return 0;
					}
					@Override
					public equals(Object obj) {
						// implement equals
					}
				};
				)) {
			{
				for (CustomerGroup group : groupList) {
					if (group.getTable() == null) {
						add(group);
					}
				}
			}
		};
		for (CustomerGroup group : waitingGroups) {

		}
		// loop groups 
			// loop 
	}

	public SeatingManager(List<Table> tables) {
		this.tables = tables;
	}

	public void arrives(CustomerGroup group) {
		groupList.add(group);
		heuristicAssigment(); / *** /
	}

	public void leaves(CustomerGroup group) throws RuntimeException {
		if (groupList.remove(group)) {
			group.leave();
			heuristicAssigment(); / *** /
			return;
		}
	}

	public Table locate(CustomerGroup group) {
		return groupList.getTable();
	}
}
