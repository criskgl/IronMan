package agc.io;

import javax.json.JsonArray;
import javax.json.JsonObject;

import agc.data.Experiment;
import agc.data.ExperimentChunk;
import agc.exceptions.AGCException;

public class ExperimentDataFileManager {
	
	// Effort spent: 35 minutos
	public Experiment Parse (String InputFile) throws AGCException {
		
		AGCJsonHandler jsonHandler = new AGCJsonHandler();
		JsonArray jsonArray = jsonHandler.readJson(InputFile);
		Experiment myExperiment = ValiateJSON (jsonArray);
		
		return myExperiment;
	}

	// Effort spent: 43 minutos
	private Experiment ValiateJSON(JsonArray jsonArray) throws AGCException {
		// Check every element per chunk in JSON input file
		Experiment myExperiment = new Experiment();
		ExperimentChunkValidator myChunkValidator = new ExperimentChunkValidator();
		for (JsonObject element : jsonArray.getValuesAs(JsonObject.class)) {
			ExperimentChunk item = myChunkValidator.Validate(element);
			myExperiment.AddExperimentChunk(item);
		}
		if (myExperiment.isSemanticallyRight())
		{ 
			return myExperiment;
		}
		else
		{
			return null;
		}
	}
}
