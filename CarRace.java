package com;

public class CarRace {

	public static void main(String[] args) {
		long length = 1500;	// track length in meters
		long N = 30; // number of laps
		long totalDist = N * length; // total distance to be covered in meters
		long distU = 0; // distance covered by U
		long distV = 0; // distance covered by V
		long timeU = 0; // time taken by U in seconds
		long timeV = 0; // time taken by V in seconds
		long time = 0; // current timer in seconds
		long speedU = (time/60)+1; // speed U = m  (m = minute in progress after the race starts, start with m=1)
		long speedV = 3 * ((distV / length) + 1); // speed V = 3n (n = lap in progress, start with n=1.)
		char ahead = '-';
		long positionU = 0;
		long positionV = 0;
		boolean overtake = false;
		long overtakeCount = 0;
		while(distU < totalDist && distV < totalDist){
			speedU = (time/60)+1;
			speedV = 3 * ((distV / length) + 1);
			distU += speedU;
			distV += speedV;
			positionU = distU % length;
			positionV = distV % length;
			if(ahead == '-'){
				if(positionU > positionV)
					ahead = 'U';
				else
					ahead = 'V';
			}else if( ahead == 'U' && positionV > positionU){
				ahead = 'V';
				overtake = true;
			}else if( ahead == 'V' && positionU > positionV){
				ahead = 'U';
				overtake = true;
			}
			
			if(overtake){
				timeU += 2;
				timeV += 2;
				overtake = false;
				overtakeCount++;
			}
			
			timeU++;
			timeV++;
			time++;
		}
		System.out.println("distU : " + distU);
		System.out.println("distV : " + distV);
		System.out.println("overtakeCount : " + overtakeCount);
		System.out.println("timeU : " + timeU);
		System.out.println("timeV : " + timeV);
	}

}
