package agc.logic;

import agc.data.ExperimentChunk;
import agc.data.Experiment;
import agc.data.FullTurnByAxes;
import agc.exceptions.AGCException;

public class FullTurnCalculator implements Calculator {

	// Effort spent: 29 minutos
	@Override
	public Object Calculate(Object obj) throws AGCException {
		Experiment myExperiment= (Experiment)obj;
		
		// We do not consider the initial sample, as it is the initial position from the gyroscope
		ExperimentChunk previousChunk = myExperiment.getItem(myExperiment.getSubExperimentInitialItem());
		double xValue = 0, yValue = 0, zValue = 0;
		
		// Skip to next element to process the remaining values 
		for (int i=myExperiment.getSubExperimentInitialItem()+1; i<myExperiment.getSubExperimentFinalItem(); i++){
			ExperimentChunk currentChunk = myExperiment.getItem(i);
			xValue += Math.abs(currentChunk.getGyro_x() - previousChunk.getGyro_x());
			yValue += Math.abs(currentChunk.getGyro_y() - previousChunk.getGyro_y());
			zValue += Math.abs(currentChunk.getGyro_z() - previousChunk.getGyro_z());
			previousChunk = myExperiment.getItem(i);
		}
		FullTurnByAxes result = new FullTurnByAxes(xValue, yValue, zValue);
		return result;
	}

}
