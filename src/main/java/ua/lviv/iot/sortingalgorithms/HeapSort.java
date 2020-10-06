package ua.lviv.iot.sortingalgorithms;

import ua.lviv.iot.model.Ship;
import ua.lviv.iot.utilities.ShipNumberOfPassengersComparator;

public class HeapSort {
	public static int exchanges = 0;
	public static int compares = 0;

	public static void sortByNumberOfPassengersDescending(Ship[] ships) {
		int length = ships.length;
		for (int position = length / 2; position >= 1; position--) {
			sink(ships, position, length);
		}
		while (length > 1) {
			swap(ships, 1, length--);
			sink(ships, 1, length);
		}
	}

	private static void sink(Ship[] ships, int position, int length) {
		while (2 * position <= length) {
			int descendantPosition = 2 * position;
			if (descendantPosition < length && !less(ships[descendantPosition - 1], ships[descendantPosition])) {
				descendantPosition++;
			}
			if (less(ships[position - 1], ships[descendantPosition - 1])) {
				break;
			} else {
				swap(ships, position, descendantPosition);
			}
			position = descendantPosition;
		}
	}

	private static void swap(Ship[] ships, int firstShipPosition, int secondShipPosition) {
		Ship tempShip = ships[firstShipPosition - 1];
		ships[firstShipPosition - 1] = ships[secondShipPosition - 1];
		ships[secondShipPosition - 1] = tempShip;
		exchanges++;
	}

	private static boolean less(Ship firstShip, Ship secondShip) {
		compares++;
		ShipNumberOfPassengersComparator numberOfPassengersComparator = new ShipNumberOfPassengersComparator();
		if (numberOfPassengersComparator.compare(firstShip, secondShip) < 0) {
			return true;
		} else {
			return false;
		}
	}

	public static int getCompares() {
		return compares;
	}

	public static int getExchanges() {
		return exchanges;
	}

	public static void resetTestData() {
		compares = 0;
		exchanges = 0;
	}
}
