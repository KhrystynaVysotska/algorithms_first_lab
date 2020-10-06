package ua.lviv.iot.sortingalgorithms;

import ua.lviv.iot.model.Ship;
import ua.lviv.iot.utilities.ShipTonnageComparator;

public class InsertionSort {
	private static int exchanges = 0;
	private static int compares = 0;

	public static void sortByTonnageAccending(Ship[] ships) {
		int length = ships.length;
		for (int i = 0; i < length; i++) {
			for (int j = i; j > 0; j--) {
				if (less(ships[j], ships[j - 1])) {
					swap(ships, j, j - 1);
				}
			}
		}
	}

	private static boolean less(Ship firstShip, Ship secondShip) {
		compares++;
		ShipTonnageComparator tonnageComparator = new ShipTonnageComparator();
		if (tonnageComparator.compare(firstShip, secondShip) < 0) {
			return true;
		} else {
			return false;
		}
	}

	private static void swap(Ship[] ships, int firstShipPosition, int secondShipPosition) {
		Ship tempShip = ships[firstShipPosition];
		ships[firstShipPosition] = ships[secondShipPosition];
		ships[secondShipPosition] = tempShip;
		exchanges++;
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
