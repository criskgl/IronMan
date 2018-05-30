package agc.logic;

import agc.data.AccelerationByAxes;
import agc.data.Experiment;
import agc.data.ExperimentChunk;
import agc.data.VelByAxes;
import agc.exceptions.AGCException;

public class VelCalculator implements Calculator {

	// Effort spent: 45 minutos
	@Override
	public Object Calculate(Object obj) throws AGCException {
		Experiment myExperiment= (Experiment)obj;
		// Set initial max and min values
		double speedx, speedy, speedz, varx, vary, varz;
		
		double velocidad_inicial_x = 0;
		double velocidad_final_x = 0;
		
		double velocidad_inicial_y = 0;
		double velocidad_final_y = 0;
		
		double velocidad_inicial_z = 0;
		double velocidad_final_z = 0;
		
		//Variables globales
		double[] myDoubleArrayx = new double[myExperiment.getSubExperimentFinalItem()+1];
		double[] myDoubleArrayy = new double[myExperiment.getSubExperimentFinalItem()+1];
		double[] myDoubleArrayz = new double[myExperiment.getSubExperimentFinalItem()+1];
				
		int cont = 0;
		double velacumuladax = 0;
		double velacumuladay = 0;
		double velacumuladaz = 0;
		
		// Skip to next element to process the remaining values 
		for (int i=myExperiment.getSubExperimentInitialItem(); i<=myExperiment.getSubExperimentFinalItem(); i++) {
			ExperimentChunk currentChunk = myExperiment.getItem(i);
			
			//X-AXIS
			velocidad_inicial_x = velocidad_final_x;
			velocidad_final_x = velocidad_inicial_x + currentChunk.getAccel_x()*(0.02);
			myDoubleArrayx[i] = velocidad_final_x;
			velacumuladax = velacumuladax + velocidad_final_x;
			//Y-AXIS
			velocidad_inicial_y = velocidad_final_y;
			velocidad_final_y = velocidad_inicial_y + currentChunk.getAccel_y()*(0.02);
			myDoubleArrayy[i] = velocidad_final_y;
			velacumuladay = velacumuladay + velocidad_final_y;
			//Z-AXIS
			velocidad_inicial_z = velocidad_final_z;
			velocidad_final_z = velocidad_inicial_z + currentChunk.getAccel_z()*(0.02);
			myDoubleArrayz[i] = velocidad_final_z;
			velacumuladaz = velacumuladaz + velocidad_final_z;
			
			cont = i+1;
			
		}
		
		speedx = velacumuladax/cont;
		speedy = velacumuladay/cont;
		speedz = velacumuladaz/cont;
		
		double sum_var_media_x = 0;
		double sum_var_media_y = 0;
		double sum_var_media_z = 0;
		
		for (int i=myExperiment.getSubExperimentInitialItem(); i<=myExperiment.getSubExperimentFinalItem(); i++) {
			
			sum_var_media_x = sum_var_media_x + Math.pow(myDoubleArrayx[i] - speedx, 2);
			sum_var_media_y = sum_var_media_y + Math.pow(myDoubleArrayy[i] - speedy, 2);
			sum_var_media_z = sum_var_media_z + Math.pow(myDoubleArrayz[i] - speedz, 2);
			
		}
		varx = sum_var_media_x/cont;
		vary = sum_var_media_y/cont;
		varz = sum_var_media_z/cont;
		
		VelByAxes result = new VelByAxes(speedx, varx, speedy, vary, speedz, varz);		
		return result;
	}

}
