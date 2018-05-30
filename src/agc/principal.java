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
		
		VelByAxes result = new VelByAxes();
		result = experimento.CalculateVel("CP-RF1-01-FINAL.json", 20);
		
		
		System.out.println("velmedia: "+"\n"+result.getX_Axis().getspeedValue()+ "\n"+result.getY_Axis().getspeedValue()+ "\n"+result.getZ_Axis().getspeedValue());
		System.out.println("varianza: "+"\n"+result.getX_Axis().getDesvValue()+ "\n"+result.getY_Axis().getDesvValue()+ "\n"+result.getZ_Axis().getDesvValue());
		
		try (FileWriter file = new FileWriter("result.json")) {
			file.write(result.toString());
			System.out.println("Successfully Copied JSON Object to File...");
		}

	}

}



//C:\\Users\\guill\\Documents\\GitHub\\IronMan\\