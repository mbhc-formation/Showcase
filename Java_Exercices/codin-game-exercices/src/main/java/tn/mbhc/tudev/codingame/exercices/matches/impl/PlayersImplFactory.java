package tn.mbhc.tudev.codingame.exercices.matches.impl;

import java.lang.reflect.InvocationTargetException;

import tn.mbhc.tudev.codingame.exercices.matches.IPlayers;

public class PlayersImplFactory {

	public enum ImplmentationUsing {
		MAP (PlayersWithMap.class),
		SET (PlayersWithSet.class),
		;
		private Class<? extends IPlayers> instanceClass;
		
		private ImplmentationUsing(Class<? extends IPlayers> instanceClass) {
			this.instanceClass = instanceClass;
		}
	}
	
	/**
	 * Creates a new instance of the {@link IPlayers} implementation depending on the given enum type.
	 * <b>N.B :</b> the instance can be null if any error occurs. 
	 * @param using
	 * @return
	 */
	public static IPlayers create(final ImplmentationUsing using) {
		try {
			return using.instanceClass.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			return null;
		}
	}
	
}
