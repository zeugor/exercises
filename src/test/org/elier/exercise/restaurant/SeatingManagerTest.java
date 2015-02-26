package org.elier.exercise.restaurant;

import static org.junit.Assert.assertEquals;

import java.util.TreeSet;

import org.junit.Test;

public class SeatingManagerTest {

	@Test
	public void arriveGroupTest() throws Exception {
		final Table t1 = new Table(2);
		final Table t2 = new Table(2);
		final Table t3 = new Table(6);
		SeatingManager sm = new SeatingManager(new TreeSet<Table>() {
			{
				add(t1);
				add(t2);
				add(t3);
			}
		});

		CustomerGroup g1 = new CustomerGroup(4);
		sm.arrives(g1);
		assertEquals(6, g1.getTableAssigned().getSize());

		CustomerGroup g2 = new CustomerGroup(6);
		sm.arrives(g2);
		assertEquals(null, g2.getTableAssigned());

		CustomerGroup g3 = new CustomerGroup(2);
		sm.arrives(g3);
		assertEquals(2, g3.getTableAssigned().getSize());

		sm.leaves(g1);
		assertEquals(6, g2.getTableAssigned().getSize());

		CustomerGroup g4 = new CustomerGroup(2);
		sm.arrives(g4);
		assertEquals(2, g4.getTableAssigned().getSize());

		sm.leaves(g4);
		sm.leaves(g2);
		sm.leaves(g3);

		assertEquals(2, t1.getAvailableChairs());
		assertEquals(2, t2.getAvailableChairs());
		assertEquals(6, t3.getAvailableChairs());

	}
}
