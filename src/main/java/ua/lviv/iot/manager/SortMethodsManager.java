package ua.lviv.iot.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.iot.model.Ship;
import ua.lviv.iot.sortingalgorithms.HeapSort;
import ua.lviv.iot.sortingalgorithms.InsertionSort;

public class SortMethodsManager {
	public static void main(String[] args) throws Exception {
		List<Ship> ships = new ArrayList<>();
		String fileName = args[0];
		BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
		String row = csvReader.readLine();
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			ships.add(new Ship(Double.parseDouble(data[0]), data[1], Integer.parseInt(data[2])));
		}
		csvReader.close();
		Ship[] shipStore = new Ship[ships.size()];
		shipStore = ships.toArray(shipStore);

		long startOfInsertionSort = System.currentTimeMillis();
		Ship[] dataSortedWithInserionSort = InsertionSort.sortByTonnageAccending(shipStore);
		long endOfInsertionSort = System.currentTimeMillis();
		printAlgorithmData(dataSortedWithInserionSort, "Insertion Sort", endOfInsertionSort - startOfInsertionSort,
				InsertionSort.getExchanges(), InsertionSort.getCompares());

		long startOfHeapSort = System.currentTimeMillis();
		Ship[] dataSortedWithHeapSort = HeapSort.sortByNumberOfPassengersDescending(shipStore);
		long endOfHeapSort = System.currentTimeMillis();
		printAlgorithmData(dataSortedWithHeapSort, "HeapSort", endOfHeapSort - startOfHeapSort, HeapSort.getExchanges(),
				HeapSort.getCompares());
	}

	protected static void printAlgorithmData(Ship[] shipStore, String nameOfAlgorithm, long timeInMillis,
			int numberOfExchanhes, int numberOfCompares) {
		System.out.println(nameOfAlgorithm + ": " + " time: " + timeInMillis + " ms," + " compares: " + numberOfCompares
				+ ", exchanges: " + numberOfExchanhes + "\n");
		for (int i = 0; i < shipStore.length; i++) {
			System.out.println(shipStore[i]);
		}
	}
}
