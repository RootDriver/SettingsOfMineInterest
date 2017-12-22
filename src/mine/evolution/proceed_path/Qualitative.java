package mine.evolution.proceed_path;

import java.math.BigDecimal;

import mine.evolution.describe_elements.Evolute;
import mine.evolution.describe_elements.EvolutionType;

/**
 * This class describe the Qualitative of evolution
 * 
 * @author He Yixi
 * 
 *
 * @describe
 */
@Evolute(EvolutionType.QUALITATIVE)
public interface Qualitative {
	/**
	 * getNatural is to get the natural persistence ,for instance , like the
	 * coefficient a in the Normal Growth Formula
	 * 
	 * @return
	 */
	public abstract Object getNatural();

	/**
	 * getGrowth is to get the growth persistence ,for instance , like the
	 * coefficient b in the Normal Growth Formula
	 * 
	 * @return
	 */
	public abstract Object getGrowth();
}
