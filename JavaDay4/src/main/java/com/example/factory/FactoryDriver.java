package com.example.factory;

public class FactoryDriver {

	public static void main(String[] args) {


		String country;
		
		country = "USA";
		Currency usa = CurrencyFactory.createCurrency(country);
		System.out.println("USA Currency: " + usa.getSymbol());
		
		country = "Italy";
		Currency italy = CurrencyFactory.createCurrency(country);
		System.out.println("Italy Currency: " + italy.getSymbol());
		
		country = "Ethiopia";
		Currency ethiopia = CurrencyFactory.createCurrency(country);
		System.out.println("Ethiopia Currency: " + ethiopia.getSymbol());
		
		country = "North Korea";
		Currency nKorea = CurrencyFactory.createCurrency(country);
		System.out.println("North Korea Currency: " + nKorea.getSymbol());
		
	}

}
