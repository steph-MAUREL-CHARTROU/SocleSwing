package fr.diginamic.composants.reflect;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.google.common.reflect.ClassPath;

import fr.diginamic.composants.error.ErrorManager;

/**
 * Fournit des méthodes utiles pour instantier une classe et appeler
 * dynamiquement une méthode
 * 
 * @author RichardBONNAMY
 *
 */
public class ReflectUtils {

	/**
	 * Recherche une classe dans le projet à partir du package fr.diginamic (scan)
	 * et à partir de son nom.
	 * 
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
			String msg = "La classe " + className + " n'existe pas.";
			ErrorManager.manage(msg, e);
			return null;
		}
	}

	/**
	 * Invoque une méthode pour une classe donnée avec un paramètre Long. La chaine
	 * d'invocation doit être du type: maClass.maMethode(Long.class)
	 * 
	 * @param chaineInvocation
	 */
	public static void invoke(String chaineInvocation) {

		if (chaineInvocation.contains(".")) {
			String[] tokens = chaineInvocation.split("\\.");

			String className = tokens[0].substring(0, 1).toUpperCase() + tokens[0].substring(1);
			String methodWithParameter = tokens[1];
			String methodName = methodWithParameter.substring(0, methodWithParameter.indexOf("("));
			String parameter = methodWithParameter.substring(methodWithParameter.indexOf("(") + 1,
					methodWithParameter.indexOf(")"));
			Long id = Long.parseLong(parameter);

			Class<?> classe = getClass(className);
			Object obj = null;
			try {
				if (classe != null) {
					Constructor<?> construct = classe.getConstructor(null);
					if (construct != null) {
						obj = construct.newInstance(null);
					} else {
						ErrorManager.manage("Le constructeur sans paramètre n'existe pas dans la classe " + className);
					}
				} else {
					ErrorManager.manage("La classe " + className + " n'existe pas.");
				}
			} catch (ReflectiveOperationException e) {
				String msg = "Le constructeur sans paramètre est obligatoire dans la classe " + classe.getName();
				ErrorManager.manage(msg, e);
			}
			try {
				Method method = classe.getMethod(methodName, Long.class);
				method.invoke(obj, id);
			} catch (ReflectiveOperationException e) {
				String msg = "La méthode " + methodName + "(Long.class) n'existe pas dans la classe "
						+ classe.getName();
				ErrorManager.manage(msg, e);
			}
		}
	}
}
