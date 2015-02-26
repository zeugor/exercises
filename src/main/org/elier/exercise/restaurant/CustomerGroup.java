package org.elier.exercise.restaurant;

public class CustomerGroup implements Comparable<CustomerGroup> {
	private static int groupCounter;

	private final int size;
	private Table tableAssigned;
	private int order = groupCounter;

	{
		groupCounter++;
	}

	CustomerGroup(int size) {
		this.size = size;
	}

	void leaveTable() throws Exception {
		if (tableAssigned != null) {
			tableAssigned.leaveChairs(size);
		}
	}

	public int getSize() {
		return size;
	}

	public Table getTableAssigned() {
		return tableAssigned;
	}

	public int getOrder() {
		return order;
	}

	public void setTableAssigned(Table tableAssigned) throws Exception {
		tableAssigned.occupyChairs(size);
		this.tableAssigned = tableAssigned;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public int compareTo(CustomerGroup o) {
		int flag = (new Integer(this.getOrder())).compareTo(o.getOrder());
		if (flag == 0 && !this.equals(o)) {
			return -1;
		}
		return flag;
	}
}
