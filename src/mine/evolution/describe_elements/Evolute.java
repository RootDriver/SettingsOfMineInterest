package mine.evolution.describe_elements;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
/**
 * This annotation declared evolute type
 * @author He Yixi
 * 
 *
 * @describe
 */
public @interface Evolute {
	EvolutionType value() default EvolutionType.BOTH;
}
