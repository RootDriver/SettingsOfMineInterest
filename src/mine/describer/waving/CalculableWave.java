package mine.describer.waving;

import java.util.List;
import java.util.Map;

import mine.describer.basic.Energy;
import mine.describer.basic.Metrial;

/**
 * 
 * @author He Yixi
 * 
 *
 * @describe CalculableWave is means that you can calculate the data that you
 *           want
 */
public class CalculableWave extends AWave {
	
	
	/**
	 * this attribute describe the latitude that the wave have
	 */
	private Map<WaveWay, Double> WaveLatitude;
	private Metrial metrial;
	private Energy energy;
	private List<WaveWay> waveWaysCal;
	{
		this.initWaveWay();
	}

	@Override
	public List<WaveWay> getWaveWays() {

		return this.waveWaysCal;
	}

	/**
	 * set waveWaysCal  as defualt waveWay
	 */
	public void resetToDefaultWaveWay() {
		this.waveWaysCal = super.getWaveWays();
	}

	/**
	 * set the topical type of waveWaysCal
	 */
	@Override
	public void initWaveWay() {
		
	}
}
