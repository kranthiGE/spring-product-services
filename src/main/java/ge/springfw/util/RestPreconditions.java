package ge.springfw.util;

import ge.springfw.exception.MyResourceNotFoundException;

public class RestPreconditions {

	private RestPreconditions() {
		throw new AssertionError();
	}
	
	public static void checkFound(final boolean expression, String message) {
		if(!expression) {
			throw new MyResourceNotFoundException(message);
		}
	}
	
	public static <T> T checkFound(final T resource, String message) {
		if(resource == null) {
			throw new MyResourceNotFoundException(message);
		}
		return resource;
	}
}
