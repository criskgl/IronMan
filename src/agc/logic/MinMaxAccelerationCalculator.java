package agc.logic;

import agc.data.AccelerationByAxes;
import agc.data.Experiment;
import agc.data.ExperimentChunk;
import agc.exceptions.AGCException;

public class MinMaxAccelerationCalculator implements Calculator {

	// Effort spent: 38 minutos
	@Override
	public Object Calculate(Object obj) throws AGCException {
		Experiment myExperiment= (Experiment)obj;
		// Set initial max and min values
		ExperimentChunk tempChunk = myExperiment.getItem(myExperiment.getSubExperimentInitialItem());
		double maxx, maxy, maxz, minx, miny, minz;
		maxx = tempChunk.getAccel_x();
		minx = tempChunk.getAccel_x();
		maxy = tempChunk.getAccel_y();
		miny = tempChunk.getAccel_y();
		maxz = tempChunk.getAccel_z();
		minz = tempChunk.getAccel_z();

		// Skip to next element to process the remaining values 
		for (int i=myExperiment.getSubExperimentInitialItem(); i<myExperiment.getSubExperimentFinalItem()+1; i++) {
			tempChunk = myExperiment.getItem(i);
			
			if (maxx < tempChunk.getAccel_x()) {
				maxx = tempChunk.getAccel_x();
			}
			if (minx > tempChunk.getAccel_x()) {
				minx = tempChunk.getAccel_x();
			}
			if (maxy < tempChunk.getAccel_y()) {
				maxy = tempChunk.getAccel_y();
			}
			if (miny > tempChunk.getAccel_y()) {
				miny = tempChunk.getAccel_y();
			}
			if (maxz < tempChunk.getAccel_z()) {
				maxz = tempChunk.getAccel_z();
			}
			if (minz > tempChunk.getAccel_z()) {
				minz = tempChunk.getAccel_z();
			}
		}
		
		AccelerationByAxes result = new AccelerationByAxes(minx, maxx, miny, maxy, minz, maxz);		
		return result;
	}
}
