package com.example.exceptions;

public class Bicycle {
	
	public int speed = 0;
	public int gear = 1;
	
	public static String bikeShop = "RevaBikes";
	public static final int MAX_SPEED = 25;
	public static final int MAX_GEAR = 3;
	
	public void speedUp(int inc) {
		if(speed + inc > MAX_SPEED) {
			speed = MAX_SPEED;
			gear = MAX_GEAR;
			System.out.println("Cannot exceed maximum speed of " + MAX_SPEED);
			return;
		} else {
			speed += inc;
			gear = gear < MAX_GEAR ? gear+1 : MAX_GEAR;
		}
	}
	
	public void slowDown(int dec) throws NegativeSpeedException {
		if(speed - dec < 0) {
			throw new NegativeSpeedException();
		} else {
			speed -= dec;
			gear = gear > 1 ? gear -1 : 1;
		}
	}
	
}
