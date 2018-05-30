package agc.logic;

import agc.data.ExperimentChunk;
import agc.data.DistByAxes;
import agc.data.Experiment;
import agc.exceptions.AGCException;

public class DistanceCalculator implements Calculator {

	// Effort spent: 35 minutos
	@Override
	public Object Calculate(Object obj) throws AGCException {
		Experiment myExperiment= (Experiment)obj;
		//Global Variables
		double distancia_x = 0, distancia_y = 0, distancia_z = 0;
		
				double velocidad_inicial_x = 0;
				double velocidad_final_x = 0;
				
				double velocidad_inicial_y = 0;
				double velocidad_final_y = 0;
				
				double velocidad_inicial_z = 0;
				double velocidad_final_z = 0;
	
		// Skip to next element to process the remaining values 
		for (int i=myExperiment.getSubExperimentInitialItem(); i<=myExperiment.getSubExperimentFinalItem(); i++){
			
			ExperimentChunk currentChunk = myExperiment.getItem(i);
			velocidad_inicial_x = velocidad_final_x;
			distancia_x = distancia_x + velocidad_inicial_x*(0.02)+0.5*currentChunk.getAccel_x()*Math.pow((0.02), 2);
			velocidad_final_x = velocidad_inicial_x + currentChunk.getAccel_x()*(0.02);
			//Y-AXIS
			velocidad_inicial_y = velocidad_final_y;
			distancia_y = distancia_y + velocidad_inicial_y*(0.02)+0.5*currentChunk.getAccel_y()*Math.pow((0.02), 2);
			velocidad_final_y = velocidad_inicial_y + currentChunk.getAccel_y()*(0.02);
			//Z-AXIS
			velocidad_inicial_z = velocidad_final_z;
			distancia_z = distancia_z + velocidad_inicial_z*(0.02)+0.5*currentChunk.getAccel_z()*Math.pow((0.02), 2);
			velocidad_final_z = velocidad_inicial_z + currentChunk.getAccel_z()*(0.02);
		}
		DistByAxes result = new DistByAxes(distancia_x, distancia_y, distancia_z);
		return result;
	}

}
