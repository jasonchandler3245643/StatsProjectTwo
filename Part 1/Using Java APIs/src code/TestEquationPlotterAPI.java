import java.io.IOException;

public class TestEquationPlotterAPI  {

	public static void main(String[] args) throws IOException {

		EquationPlotterAPI ep = new EquationPlotterAPI(-200, 200, 401);
		EquationPlotterAPI.plotInitialData();

		double[] s = ep.saltWithApache(ep.getOutputs(), 0, 1000, 2);
		EquationPlotterAPI.plotNewCol(s, "Salted");
	
		double[] smoothedWindow3 = ep.smoothWithApache(s, 10);
		EquationPlotterAPI.plotNewCol(smoothedWindow3, "Smoothed Once Window 10");
		
		ep.makeLineChart();
		
		//double[] smoothedWindow7 = ep.smoothWithApache(s, 7);
		//EquationPlotterAPI.plotNewCol(smoothedWindow7, "Smoothed Once Window 7");
		
		//double[] smoothedWindow12 = ep.smoothWithApache(s, 12);
		//EquationPlotterAPI.plotNewCol(smoothedWindow12, "Smoothed Once Window 12");
		
		//double[] smoothedWindow16 = ep.smoothWithApache(s, 16);
		//EquationPlotterAPI.plotNewCol(smoothedWindow16, "Smoothed Twice Window 16");
	}

}
