package mine.evolution.proceed_path;

import mine.evolution.describe_elements.Evolute;
import mine.evolution.describe_elements.EvolutionType;

/**
 * This class describe the Quantitative tend of evolution
 * 
 * @author He Yixi
 * 
 *
 * @describe
 */
@Evolute(EvolutionType.QUANTITATIVE)
public interface Quantitative {
	/**
	 * getPrimary is to get the primary persistence ,for instance , like the
	 * coefficient c in the Normal Growth Formula
	 * 
	 * @return
	 */
	public abstract Object getPrimary();

	/**
	 * getInital is to get the inital persistence ,for instance , like the
	 * result when coefficient x set zero in the Normal Growth Formula
	 * 
	 * @return
	 */
	public abstract Object getInital();
}
