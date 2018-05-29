package agc.tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import agc.AGCCalculator;
import agc.data.AccelerationByAxes;
import agc.data.FullTurnByAxes;
import agc.exceptions.AGCException;

public class CalculateDistance_EClasses {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-01
	* Clase de Equivalencia o Valor Límite Asociado: CEI2 
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error de fichero no encontrado  
	*/
	public void testCPRFG_01() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("", 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: invalid path", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-02
	* Clase de Equivalencia o Valor Límite Asociado: CEV1 CEV3 CEV5 CEV7 CEV9 CEV12 CEV14 CEV16 CEV19 CEV21 AVL1 CEI24 CEV26 CEI29 AVL3 CEI29 CEV31 AVL5 CEV33 
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Ningún error, Ficheros de salida
	*/
	public void testCPRFG_02() {
		AGCCalculator agcc = new AGCCalculator();
		
		try {
			File file = new File("/PDS-P3/tests-json/CE-y-VL/CP-RFG-02.json");
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-02-FINAL.json", 40);
			boolean ficheroOk = file.isFile();
			
			assertEquals(ficheroOk, true);//comprueba que el fichero existe
		} catch (AGCException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	/* Caso de Prueba: CP-RFG-03
	* Clase de Equivalencia o Valor Límite Asociado: CEI4
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Mensaje de error de sintaxis.  
	*/
	public void testCPRFG_03() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("", 40);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: invalid input file syntax", message);
	}

	@Test
	/* Caso de Prueba: CP-RFG-04
	* Clase de Equivalencia o Valor Límite Asociado: CEI16
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error de formato/semántico en fecha.  
	*/
	public void testCPRFG_04() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-04-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: date format does not match <YYYY-MM-DD HH:mm:ss.SSS...>", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-05
	* Clase de Equivalencia o Valor Límite Asociado: CEI18
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Error de formato/semántico en fecha.
	*/
	public void testCPRFG_05() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-05-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Time has negative values", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-06
	* Clase de Equivalencia o Valor Límite Asociado: CEI10
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Mensaje de error de formato en el fichero de entrada.  
	*/
	public void testCPRFG_06() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-06-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Time does not appear in an observation in the input json file", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-07
	* Clase de Equivalencia o Valor Límite Asociado: CEI11
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Mensaje de error de formato en el fichero de entrada.
	*/
	public void testCPRFG_07() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-07-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Time appears more than once in a singular observation", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RFG-08
	* Clase de Equivalencia o Valor Límite Asociado: CEI13 CEI25 CEI30
	* Técnica de prueba: Clase de Equivalencia 
	* Resultado Esperado: Ejecución correcta
	*/
	public void testCPRFG_08() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RF2-08-FINAL.json", 20);
		} catch (AGCException ex) {
			ex.printStackTrace();
		}
		assertEquals("Error: Separator does not match dot format", message);

	}
	
	@Test
	/* Caso de Prueba: CP-RFG-09
	* Clase de Equivalencia o Valor Límite Asociado: CEI15
	* Técnica de prueba: Clase de Equivalencia 
	* Resultado Esperado: Error en precision
	*/
	public void testCPRFG_09() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-09-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: #DECIMAL VALUES <= 2", message);
	}
	
	/* Caso de Prueba: CP-RFG-10
	* Clase de Equivalencia o Valor Límite Asociado: CEI18
	* Técnica de prueba:  Clase de Equivalencia
	* Resultado Esperado: Ejecución incorrecta
	*/
	public void testCPRFG_10() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-10-FINAL.json", 20);
		} catch (AGCException ex) {
			ex.printStackTrace();
		}
		assertEquals("Error: some ACCEL fields are empty", message);
		
	}
	
	/* Caso de Prueba: CP-RFG-11
	* Clase de Equivalencia o Valor Límite Asociado: CEI17
	* Técnica de prueba: Clase de Equivalencia
	* Resultado Esperado: Se repiten campos de ACCEL para alguno de sus ejes en el fichero de entrada
	*/
	public void testCPRFG_11() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-11-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: repeated ACCEL fields for one or more axis", message);
	}
	
	/* Caso de Prueba: CP-RFG-12
	* Clase de Equivalencia o Valor Límite Asociado: AVL2
	* Técnica de prueba:  Valor Límite
	* Resultado Esperado: El valor de la latitud en el fichero de entrada no está entre -90 y 90
	*/
	public void testCPRFG_12() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-12-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Not valid Latitude value", message);
	}
	
	/* Caso de Prueba: CP-RFG-13
	* Clase de Equivalencia o Valor Límite Asociado: AVL5
	* Técnica de prueba:  Valor Límite
	* Resultado Esperado: La duración concuerda con la ecuacion
	*/
	public void testCPRFG_13() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-13-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Not a valid interval", message);
	}
	
	/* Caso de Prueba: CP-RFG-14
	* Clase de Equivalencia o Valor Límite Asociado: AVL6
	* Técnica de prueba:  Valor Límite
	* Resultado Esperado: La duración concuerda con la ecuacion
	*/
	public void testCPRFG_14() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-14-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Not a valid interval", message);
	}
	
	/* Caso de Prueba: CP-RFG-15
	* Clase de Equivalencia o Valor Límite Asociado: AVL7
	* Técnica de prueba:  Valor Límite
	* Resultado Esperado: La duración concuerda con la ecuacion
	*/
	public void testCPRFG_15() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-15-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Not a valid interval", message);
	}
	
	/* Caso de Prueba: CP-RFG-16
	* Clase de Equivalencia o Valor Límite Asociado: AVL8
	* Técnica de prueba:  Valor Límite
	* Resultado Esperado: La duración concuerda con la ecuacion
	*/
	public void testCPRFG_16() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-16-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Not a valid interval", message);
	}
	
	
	/* Caso de Prueba: CP-RFG-17
	* Clase de Equivalencia o Valor Límite Asociado: CEI20
	* Técnica de prueba: Clase de Equivalencia
	* Resultado Esperado: Los caracteres distintos del separador no son números de 0-9 para ACCEL
	*/
	public void testCPRFG_17() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-17-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: not valid values for accel", message);
	}
	
	/* Caso de Prueba: CP-RFG-18
	* Clase de Equivalencia o Valor Límite Asociado: AVL4
	* Técnica de prueba:  Valor Límite
	* Resultado Esperado: El valor de la longitud en el fichero de entrada no está entre -180 y 180
	*/
	public void testCPRFG_18() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RFG-18-FINAL.json", 20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Not a valid LONGITUDE value", message);
	}
	
	/*H A S T A      A Q U I      G E N E R A L E S*/
	
	@Test
	/* Caso de Prueba: CP-RF3-01
	* Clase de Equivalencia o Valor Límite Asociado: CEV35 CEV37
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Los calculos sobre distancia son correctas para cada eje generando un JSON acorde con el esperado como salida
	*/
	public void testCPRF3_01() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RF3-01-FINAL.json",  20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("OK", message);
	}
	
	@Test
	/* Caso de Prueba: CP-RF3-02
	* Clase de Equivalencia o Valor Límite Asociado: CEI18
	* Técnica de prueba: Clases de Equivalencia  
	* Resultado Esperado: Fichero de salida con sintaxis JSON incorrecta para distancia respecto a cada eje
	*/
	public void testCPRF3_02() {
		AGCCalculator agcc = new AGCCalculator();
		String message = "";
		try {
			agcc.CalculateDist("/PDS-P3/tests-json/CE-y-VL/CP-RF3-02-FINAL.json",  20);
		} catch (AGCException ex) {
			message = ex.getMessage();
		}
		assertEquals("Error: Invalid output", message);
	}
	

}
