package agc;

import agc.data.AccelerationByAxes;
import agc.data.Experiment;
import agc.data.FullTurnByAxes;
import agc.io.ExperimentDataFileManager;
import agc.exceptions.AGCException;
import agc.logic.Calculator;
import agc.logic.FullTurnCalculator;
import agc.logic.MinMaxAccelerationCalculator;

public class AGCManager implements AgcCalculatorInterface {

	@Override
	// Effort spent : 192 minutes 
	public AccelerationByAxes CalculateMinMaxAcceleration(String InputFile, int InitialInstant, int FinalInstant) throws AGCException {
		ExperimentDataFileManager myDataManager = new ExperimentDataFileManager();
		Experiment myExperiment = myDataManager.Parse(InputFile);		
		myExperiment.identifySubExperiment(InitialInstant, FinalInstant);
		
		Calculator myCalculator = new MinMaxAccelerationCalculator ();
		AccelerationByAxes result = (AccelerationByAxes) myCalculator.Calculate(myExperiment);
		return result;
	}

	@Override
	// Effort spent : 48 minutes
	public FullTurnByAxes CalculateFullTurn(String InputFile, int InitialInstant, int FinalInstant) throws AGCException {
		ExperimentDataFileManager myDataManager = new ExperimentDataFileManager();
		Experiment myExperiment = myDataManager.Parse(InputFile);		
		myExperiment.identifySubExperiment(InitialInstant, FinalInstant);
		
		Calculator myCalculator = new FullTurnCalculator ();
		FullTurnByAxes result = (FullTurnByAxes) myCalculator.Calculate(myExperiment);
		return result;		
	}
}
