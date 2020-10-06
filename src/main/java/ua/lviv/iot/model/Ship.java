package ua.lviv.iot.model;

public class Ship {
	private double tonnageInTons;
	private String nameOfShip;
	private int numberOfPassengers;

	public Ship(double tonnageInTons, String nameOfShip, int numberOfPassengers) {
		this.tonnageInTons = tonnageInTons;
		this.nameOfShip = nameOfShip;
		this.numberOfPassengers = numberOfPassengers;
	}

	public double getTonnageInTons() {
		return tonnageInTons;
	}

	public void setTonnageInTons(double tonnageInTons) {
		this.tonnageInTons = tonnageInTons;
	}

	public String getNameOfShip() {
		return nameOfShip;
	}

	public void setNameOfShip(String nameOfShip) {
		this.nameOfShip = nameOfShip;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	@Override
	public String toString() {
		return "Ship [tonnageInTons: " + tonnageInTons + ", nameOfShip: " + nameOfShip + ", numberOfPassengers: "
				+ numberOfPassengers + "]";
	}
}
