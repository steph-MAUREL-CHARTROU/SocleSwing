package fr.diginamic.reflect;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.google.common.reflect.ClassPath;

/** Fournit des méthodes utiles pour instantier une classe et appeler dynamiquement une méthode
 * @author RichardBONNAMY
 *
 */
public class ReflectUtils {

	/** Recherche une classe dans le projet (scan) à partir de son nom.
	 * @param className nom de la classe
	 * @return Class
	 */
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
	
	/** Invoque une méthode pour une classe donnée avec un paramètre Long. La chaine d'invocation doit être du type:
	 * maClass.maMethode(Long.class) 
	 * @param chaineInvocation
	 */
	public static void invoke(String chaineInvocation) {
		
		if (chaineInvocation.contains(".")) {
			String[] tokens = chaineInvocation.split("\\.");
	        
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
			} catch (ReflectiveOperationException e) {
				throw new RuntimeException("Le constructeur sans paramètre est obligatoire dans la classe "+classe.getName());
			}	
			try {
	
				Method method = classe.getMethod(methodName, Long.class);
				method.invoke(obj, id);
			} catch (ReflectiveOperationException e) {
				throw new RuntimeException("La méthode "+methodName+"(Long.class) n'existe pas dans la classe "+classe.getName());
			}	
		}
	}
}
