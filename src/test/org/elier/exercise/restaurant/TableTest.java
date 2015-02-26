package org.elier.exercise.restaurant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

public class TableTest {

	@Test
	public void occupyAndLeaveChairs() {
		try {
			Table t1 = new Table(6);
			assertEquals(6, t1.getSize());
			assertEquals(6, t1.getAvailableChairs());
			assertNotSame(8, t1.getSize());

			t1.occupyChairs(6);
			assertEquals(6, t1.getSize());
			assertEquals(0, t1.getAvailableChairs());

			t1.leaveChairs(2);
			assertEquals(6, t1.getSize());
			assertEquals(2, t1.getAvailableChairs());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
