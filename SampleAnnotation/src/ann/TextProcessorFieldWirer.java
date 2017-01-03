package ann;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(value=RUNTIME)
@Target(FIELD)
public @interface TextProcessorFieldWirer {
	String type() default "none";
}
