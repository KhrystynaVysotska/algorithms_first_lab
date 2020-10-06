package ua.lviv.iot.utilities;

import java.util.Comparator;
import ua.lviv.iot.model.Ship;

public class ShipNumberOfPassengersComparator implements Comparator<Ship> {

	@Override
	public int compare(Ship firstShip, Ship secondShip) {
		if (firstShip.getNumberOfPassengers() > secondShip.getNumberOfPassengers())
			return 1;
		else if (firstShip.getNumberOfPassengers() < secondShip.getNumberOfPassengers())
			return -1;
		else
			return 0;
	}

}