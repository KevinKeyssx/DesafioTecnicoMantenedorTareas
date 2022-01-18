package com.coopeuch.mantenedor.tareas.common;

/**
 * @author Kevin Candia
 * 17-01-2022
 */
public class Constants {

	public static final String END_COOPEUCH = "/coopeuch";

	public static final String VERSION = END_COOPEUCH + "/v1";

	public static final String END_TAREA = VERSION + "/tarea";

	public static final String SEARCH = "/search";

	public static final String SEARCH_BY_ID = "/searchid";

	public static final String SEARCH_ALL = "/searchall";

	public static final String INSERT = "/insert";

	public static final String UPDATE = "/update";

	public static final String DELETE = "/delete";

	private Constants() {
		throw new IllegalAccessError();
	}

}
