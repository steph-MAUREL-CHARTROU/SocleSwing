package fr.diginamic.reflect;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.google.common.reflect.ClassPath;

public class ReflectUtils {

	public static Class<?> getClass(String className) {
		try {
			final ClassLoader loader = Thread.currentThread().getContextClassLoader();

			for (final ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClasses()) {
				if (info.getName().startsWith("fr.diginamic.")) {
					final Class<?> clazz = info.load();
					if (clazz.getSimpleName().equals(className)) {
						return clazz;
					}
				}
			}
			return null;
		} catch (IOException e) {
			throw new RuntimeException("La classe "+className+" n'existe pas.");
		}
	}
	
	public static void instantiate(String chaine) {
		
		String[] tokens = chaine.split("\\.");
        
        String className = tokens[0].substring(0, 1).toUpperCase()+tokens[0].substring(1);
        String methodWithParameter = tokens[1];
        String methodName = methodWithParameter.substring(0, methodWithParameter.indexOf("("));
        String parameter = methodWithParameter.substring(methodWithParameter.indexOf("(")+1, methodWithParameter.indexOf(")"));
        Long id = Long.parseLong(parameter);
		
		Class<?> classe = getClass(className);
		Object obj = null;
		try {
			Constructor<?> construct = classe.getConstructor(null);
			obj = construct.newInstance(null);
			
			Method method = classe.getMethod(methodName, Long.class);
			method.invoke(obj, id);
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException("Le constructeur sans paramètre est obligatoire dans la classe "+classe.getName());
		}		
	}
}
