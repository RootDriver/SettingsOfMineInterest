package mine.evolution;

import mine.evolution.describe_elements.Evolute;
import mine.evolution.proceed_path.Qualitative;
import mine.evolution.proceed_path.Quantitative;
/**
 * this interface protend to define the method that evolution need
 * @author He Yixi
 * 
 *
 * @describe
 */
@Evolute
public interface Evolution {
	/**
	 * get Quality which describe the level of the thing
	 * @return
	 */
	Qualitative	getQualitive();
	/**
	 * get quantity which describe the maintain count of the thing
	 * @return
	 */
	Quantitative getQuantitative();
	/**
	 * is the thing break border
	 * @return
	 */
	Boolean isBreakBorder();
}
