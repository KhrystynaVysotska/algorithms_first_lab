package ua.lviv.iot.utilities;

import java.util.Comparator;
import ua.lviv.iot.model.Ship;

public class ShipTonnageComparator implements Comparator<Ship> {

	@Override
	public int compare(Ship firstShip, Ship secondShip) {
		if (firstShip.getTonnageInTons() > secondShip.getTonnageInTons())
			return 1;
		else if (firstShip.getTonnageInTons() < secondShip.getTonnageInTons())
			return -1;
		else
			return 0;
	}

}
