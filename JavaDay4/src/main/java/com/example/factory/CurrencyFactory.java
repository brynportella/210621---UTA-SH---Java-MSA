package com.example.factory;

public class CurrencyFactory {

	public static Currency createCurrency(String country) {
		switch(country) {
			case "USA":
				return new USDollar();
			case "Germany":
				return new Euro();
			case "France":
				return new Euro();
			case "Italy":
				return new Euro();
			case "Ethiopia":
				return new Cardano();
			default:
				return new Bitcoin();
		}
	}
	
}
