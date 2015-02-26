package org.elier.exercise.restaurant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomerGroupTest {
	private static int groupCounter;

	private int size;
	private Table tableAssigned;
	private int order = groupCounter;

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

	public void setTableAssigned(Table tableAssigned) {
		this.tableAssigned = tableAssigned;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void NotEnoughPlacesTest() throws Exception {
		Table t1 = new Table(3);
		Table t2 = new Table(6);
		CustomerGroup g = new CustomerGroup(6);

		thrown.expect(Exception.class);
		thrown.expectMessage("trying to occupy more chairs than available.");

		g.setTableAssigned(t1);

	}

	@Test
	public void getTableTest() throws Exception {
		Table t2 = new Table(6);
		CustomerGroup g1 = new CustomerGroup(6);

		g1.setTableAssigned(t2);
		assertEquals(0, t2.getAvailableChairs());

		g1.leaveTable();
		assertEquals(6, t2.getAvailableChairs());

		CustomerGroup g2 = new CustomerGroup(4);

		g2.setTableAssigned(t2);
		assertEquals(2, t2.getAvailableChairs());
	}

	@Test
	public void orderTest() throws Exception {
		CustomerGroup g1 = new CustomerGroup(6);
		CustomerGroup g2 = new CustomerGroup(4);
		CustomerGroup g3 = new CustomerGroup(6);

		assertTrue(g1.getOrder() < g2.getOrder());
		assertTrue(g2.getOrder() < g3.getOrder());
		assertFalse(g3.getOrder() < g1.getOrder());
	}

}
