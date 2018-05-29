package agc;

import agc.data.AccelerationByAxes;
import agc.data.DistByAxes;
import agc.data.Experiment;
import agc.data.FullTurnByAxes;
import agc.data.VelByAxes;
import agc.io.ExperimentDataFileManager;
import agc.exceptions.AGCException;
import agc.logic.Calculator;
import agc.logic.DistanceCalculator;
import agc.logic.FullTurnCalculator;
import agc.logic.MinMaxAccelerationCalculator;
import agc.logic.VelCalculator;

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
	
	@Override
	// Effort spent : 120 minutes
	public DistByAxes CalculateDist(String InputFile, int FinalInstant) throws AGCException {
		ExperimentDataFileManager myDataManager = new ExperimentDataFileManager();
		Experiment myExperiment = myDataManager.Parse(InputFile);		
		myExperiment.identifySubExperiment(0, FinalInstant);
		
		Calculator myCalculator = new DistanceCalculator ();
		DistByAxes result = (DistByAxes) myCalculator.Calculate(myExperiment);
		return result;		
	}
	
	@Override
	// Effort spent : 192 minutes 
	public VelByAxes CalculateVel(String InputFile, int FinalInstant) throws AGCException {
		ExperimentDataFileManager myDataManager = new ExperimentDataFileManager();
		Experiment myExperiment = myDataManager.Parse(InputFile);		
		myExperiment.identifySubExperiment(0, FinalInstant);
		
		Calculator myCalculator = new VelCalculator ();
		VelByAxes result = (VelByAxes) myCalculator.Calculate(myExperiment);
		return result;
	}
}
