package agc;

import java.io.FileWriter;
import java.io.IOException;

import agc.data.AccelerationByAxes;
import agc.data.DistByAxes;
import agc.data.FullTurnByAxes;
import agc.data.VelByAxes;
import agc.exceptions.AGCException;

public class principal {

	public static void main(String[] args) throws AGCException, IOException {
		// TODO Auto-generated method stub
		
		AGCManager experimento = new AGCManager();
		experimento.CalculateDist("CP-RFG-01-FINAL.json", 20);
		
		AGCManager experimento2 = new AGCManager();
		experimento2.CalculateVel("CP-RF4-01-FINAL.json", 20);
		

	}

}


