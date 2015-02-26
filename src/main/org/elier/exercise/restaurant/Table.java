package org.elier.exercise.restaurant;

public class Table implements Comparable<Table> {
	private final int size;
	private int availableChairs;

	public int getSize() {
		return size;
	}

	public int getAvailableChairs() {
		return availableChairs;
	}

	public void setAvailableChairs(int availableChairs) {
		this.availableChairs = availableChairs;
	}

	Table(int size) {
		this.size = size;
		setAvailableChairs(size);
	}

	void occupyChairs(int chairs) throws Exception {
		if (chairs <= availableChairs) {
			availableChairs -= chairs;
		} else {
			throw new Exception("trying to occupy more chairs than available.");
		}
	}

	void leaveChairs(int chairs) throws Exception {
		if (availableChairs + chairs <= size) {
			availableChairs += chairs;
		} else {
			throw new Exception("leaving more chairs than possible");
		}
	}

	@Override
	public int compareTo(Table o) {
		int flag = (new Integer(getSize())).compareTo(o.getSize());
		if (flag == 0 && !this.equals(o)) {
			return -1;
		}
		return flag;
	}
}