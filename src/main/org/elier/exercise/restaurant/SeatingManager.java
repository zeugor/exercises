package org.elier.exercise.restaurant;

import java.util.TreeSet;

public class SeatingManager {
	private TreeSet<Table> tables;
	private TreeSet<CustomerGroup> groupList = new TreeSet<CustomerGroup>() {
		void heuristicAssigment() {
			for (CustomerGroup group : this) {
				if (group.getTableAssigned() == null) {
					for (Table t : tables) {
						if (group.getSize() <= t.getAvailableChairs()) {
							try {
								group.setTableAssigned(t);
								break;
							} catch (Exception e) {
								throw new NullPointerException();
							}
						}
					}
				}
			}
		}

		@Override
		public boolean add(CustomerGroup group) {
			boolean res = super.add(group);
			heuristicAssigment();
			return res;
		}

		@Override
		public boolean remove(Object obj) {
			boolean res = super.remove(obj);
			try {
				((CustomerGroup) obj).leaveTable();
			} catch (Exception e) {
				e.printStackTrace();
			}
			heuristicAssigment();
			return res;
		}
	};

	public SeatingManager(TreeSet<Table> tables) {
		this.tables = tables;
	}

	public void arrives(CustomerGroup group) throws Exception {
		groupList.add(group);
	}

	public void leaves(CustomerGroup group) throws Exception {
		groupList.remove(group);
	}

	public Table locate(CustomerGroup group) {
		return group.getTableAssigned();
	}

}
