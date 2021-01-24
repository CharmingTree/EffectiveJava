package Generic.Container;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;


// asSubClass를 사용해 한정적 타입 토큰을 안전하게 형변환 한다.
public class PrintAnnotation {

	static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
		Class<?> annotationType = null;
		try {
			annotationType = Class.forName(annotationTypeName);
		} catch(Exception ex) {
			throw new IllegalArgumentException(ex);
		}
		
		return element.getAnnotation(annotationType.asSubclass(Annotation.class));
	}
	
	public static void main(String[] args) {
		
		args = new String[2];
		args[0] = "java.lang.annotation.Annotation";
		args[1] = "javax.annotation.processing.SupportedAnnotationTypes";
		if (args.length != 2) {
			System.out.println("사용법 : java PrintAnnotation <class> <annotation>");
		System.exit(1);
		}
		
		String className = args[0];
		String annotationTypeName = args[1];
		Class<?> klass;
		try {
			klass = Class.forName(className);
			System.out.println(getAnnotation(klass, annotationTypeName));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
