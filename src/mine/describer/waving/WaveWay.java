package mine.describer.waving;

import java.util.List;

import mine.describer.waving.wave_action_describe.DIRECTION;
import mine.describer.waving.wave_action_describe.VIBERATE;

/**
 * 
 * @author He Yixi
 * @date 2017年11月30日
 *
 * @describe this contains the waveway
 */

class WaveWay {
	private static List<DIRECTION> direct = null;
	private static List<VIBERATE> viberate = null;

	private static WaveWay instance = new WaveWay();
	static {
		direct.add(DIRECTION.DIMENSIONAL);
		viberate.add(VIBERATE.COMBINATION);

	}
	/**
	 * clear the waveWay
	 */
	public static void emptyWaveWay(){
		direct.clear();
		viberate.clear();
	}

	/**
	 * supply a getter ogf waveway it is also to recommend to override it
	 */
	public static WaveWay getWaveWay() {
		return instance;
	}

	/**
	 * private constructor
	 */
	private WaveWay() {

	}

	/**
	 * @param direct
	 *            the direct to set
	 */
	public static void setDirect(List<DIRECTION> direct) {
		WaveWay.direct = direct;
	}

	/**
	 * @param viberate
	 *            the viberate to set
	 */
	public static void setViberate(List<VIBERATE> viberate) {
		WaveWay.viberate = viberate;
	}

	/**
	 * @return the direct
	 */
	public static List<DIRECTION> getDirect() {
		return direct;
	}

	/**
	 * @return the viberate
	 */
	public static List<VIBERATE> getViberate() {
		return viberate;
	}

}
