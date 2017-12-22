package mine.describer.waving;

import java.util.List;
import java.util.Map;

import mine.describer.waving.wave_action_describe.DIRECTION;
import mine.describer.waving.wave_action_describe.VIBERATE;

/**
 * 
 * @author He Yixi
 * 
 *
 * @describe this means things acutly wave
 */
public abstract class AWave extends Object {

	/**
	 * this attribute describe the wave action 
	 */
	private List<WaveWay> waveWays;


	/**
	 * initialize the wave as the defualt action
	 * this function may return default WaveWay, it is recommend to overrider it
	 * 
	 * @return List<WaveWay>
	 */
	public List<WaveWay> getWaveWays() {
		this.waveWays.add(WaveWay.getWaveWay());
		return waveWays;
	}

	/**
	 * init WaveWay list, also  it is recommend to overrider it
	 */
	public abstract void initWaveWay();

}
