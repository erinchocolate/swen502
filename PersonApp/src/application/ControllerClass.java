package application;

import model.Person;
import model.PersonGenerator;

public interface ControllerClass {
	public abstract void preloadData(Person person, PersonGenerator pg);
}
