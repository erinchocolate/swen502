package model;

import java.util.Comparator;

public class SortByLastName implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		int lastNameCmp = o1.getLastName().compareTo(o2.getLastName());
		if(lastNameCmp!=0) return lastNameCmp;
		int firstNameCmp = o1.getFirstName().compareTo(o2.getFirstName());
		if(firstNameCmp!=0) return firstNameCmp;
		int ageCmp = Integer.compare(o1.getAge(),o2.getAge());
		if(ageCmp!=0) return ageCmp;
		int idCmp = Integer.compare(o1.getId(),o2.getId());
		return idCmp;
	}

}