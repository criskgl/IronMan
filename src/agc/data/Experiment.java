package agc.data;

import java.util.ArrayList;

import agc.exceptions.AGCException;

import java.util.Date;

public class Experiment {
	private ArrayList<ExperimentChunk> experimentItems;
	private int subExperimentInitialItem;
	private int subExperimentFinalItem;
	
	public Experiment () {
		experimentItems = new ArrayList<ExperimentChunk>();
	}
	
	public void AddExperimentChunk (ExperimentChunk item){
		this.experimentItems.add(item);
	}
	
	public ExperimentChunk getItem (int index)
	{
		return this.experimentItems.get(index);
	}
	
	public int getSubExperimentInitialItem() {
		return subExperimentInitialItem;
	}

	public int getSubExperimentFinalItem() {
		return subExperimentFinalItem;
	}
	
	// Effort spent: 32 minutos
	public void identifySubExperiment (int InitialInstant, int FinalInstant) throws AGCException {
		long experimentLengthMillis = calculateExperimentLenght();
		if (InitialInstant < 0) {
			throw new AGCException("Error: initial instant less than zero.");
		} else if (FinalInstant < 0) {
			throw new AGCException("Error: final instant less than zero.");
		} else if (InitialInstant + FinalInstant > experimentLengthMillis) {
			throw new AGCException("Error: time frame to process exceeds experiment length.");
		}
		else {
			this.subExperimentInitialItem = calculatePositionIndex(InitialInstant);
			this.subExperimentFinalItem = calculatePositionIndex(FinalInstant);
		}
	}
	
	// Effort spent: 18 minutos
	private long calculateExperimentLenght() throws AGCException {
		long length;
		if (this.experimentItems.size() > 0) {
			Date end = this.experimentItems.get(this.experimentItems.size()-1).getTime();
			Date begin = this.experimentItems.get(0).getTime();
			length = end.getTime() - begin.getTime();
		} else {
			throw new AGCException("Error: experiment is empty.");
		}
		return length;
	}
	
	// Effort spent: 25 minutos
	private int calculatePositionIndex(int Instant) {
		int index;
		if (Instant % 20 != 0) {
			index = (int) (Math.floor(Instant / 20) + 1);
		} else {
			index = Instant / 20;
		}
		return index;
	}
	
	// Effort spent: 33 minutos
	// This method does all the error processing for a number based on the corresponding label
	public boolean isSemanticallyRight() throws AGCException {
		Date ini;
		Date next;
		
		if (this.experimentItems.size() == 0) {
			return false;
		} else if (this.experimentItems.size() == 1) {
			return true;
		} else {
			ini = this.experimentItems.get(0).getTime();
			for (int i=1; i < this.experimentItems.size(); i++) {
				next = this.experimentItems.get(i).getTime();
				
				// If not 20 milliseconds of difference, error (50Hz) 
				if (next.getTime() - ini.getTime() != 20) {
					throw new AGCException("Error: time values in experiment are not consecutive with a 50Hz rate.");
				}
				
				ini = this.experimentItems.get(i).getTime();
			}
		}
		return true;
	}
	
}


