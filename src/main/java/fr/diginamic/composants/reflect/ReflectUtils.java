package fr.diginamic.composants.reflect;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.google.common.reflect.ClassPath;

import fr.diginamic.composants.AbstractApplication;
import fr.diginamic.composants.error.ErrorManager;

/**
 * Fournit des m�thodes utiles pour instantier une classe et appeler
 * dynamiquement une m�thode
 * 
 * @author RichardBONNAMY
 *
 */
public class ReflectUtils {

	/**
	 * Recherche une classe dans le projet � partir du package fr.diginamic (scan)
	 * et � partir de son nom.
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
	 * Invoque une m�thode pour une classe donn�e avec un param�tre Long. La chaine
	 * d'invocation doit �tre du type: maClass.maMethode(Long.class)
	 * 
	 * @param chaineInvocation
	 */
	public static void invoke(String chaineInvocation) {

		if (chaineInvocation.contains(".") && chaineInvocation.contains("(") && chaineInvocation.contains(")")) {
			String[] tokens = chaineInvocation.split("\\.");

			String className = tokens[0].substring(0, 1).toUpperCase() + tokens[0].substring(1);
			String methodWithParameter = tokens[1];
			String methodName = methodWithParameter.substring(0, methodWithParameter.indexOf("("));
			String parameter = methodWithParameter.substring(methodWithParameter.indexOf("(") + 1,
					methodWithParameter.indexOf(")"));
			
			Class<?> classe = getClass(className);
			if (classe==null) {
				ErrorManager.manage("La classe " + className + " n'existe pas.");
			}
			if (parameter.isEmpty()) {
				callMethod(classe, methodName, null);
			}
			else {
				Long id = Long.parseLong(parameter);	
				callMethod(classe, methodName, id);
			}
		}
		else if (chaineInvocation.contains("(") && chaineInvocation.contains(")")){
			
			String methodName = chaineInvocation.substring(0, chaineInvocation.indexOf("("));
			String parameter = chaineInvocation.substring(chaineInvocation.indexOf("(") + 1,
					chaineInvocation.indexOf(")"));
			
			Class<?> classe = AbstractApplication.currentMenuService.getClass();
			if (parameter.isEmpty()) {
				callMethod(classe, methodName, null);
			}
			else {
				Long id = Long.parseLong(parameter);
				callMethod(classe, methodName, id);
			}
		}
	}

	/** Appel de la m�thode methodName de la classe classe avec l'identifiant id
	 * @param classe classe
	 * @param methodName nom de la m�thode
	 * @param id identifiant
	 */
	private static void callMethod(Class<?> classe, String methodName, Long id) {
		Object obj = null;
		try {
			if (classe != null) {
				Constructor<?> construct = classe.getConstructor();
				construct.setAccessible(true);
				if (construct != null) {
					obj = construct.newInstance();
				} else {
					ErrorManager.manage("Le constructeur sans param�tre n'existe pas dans la classe " + classe.getName());
				}
			} 
		} catch (ReflectiveOperationException e) {
			String msg = "Le constructeur sans param�tre est obligatoire dans la classe " + classe.getName();
			ErrorManager.manage(msg, e);
		}
		try {
			Method method = null;
			if (id!=null) {
				method = classe.getDeclaredMethod(methodName, Long.class);
				method.setAccessible(true);
				method.invoke(obj, id);
			}
			else {
				method = classe.getDeclaredMethod(methodName);
				method.setAccessible(true);
				method.invoke(obj);
			}
			
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
			ErrorManager.manage(e.getMessage(), e);
		}
	}
}