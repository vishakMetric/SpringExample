package com.java.services;

import java.lang.Comparable;
import java.util.HashMap;

public class Country implements Comparable {
	
	String name;
	Long population;
	
	public Country(String name, long population) {
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}
	
	@Override 
	public int hashCode() { 
		if(this.name.length()%2==0) 
			return 31; 
		else
			return 95; 
		//return 31 * this.name.length()*this.population.intValue();
	} 
	
	@Override 
	public boolean equals(Object obj) { 
		Country other = (Country) obj; 
		if (name.equalsIgnoreCase((other.name))) return true; 
		return false;
	}

	@Override
	public int compareTo(Object o) {
		Country other = (Country) o;
	   if(this.name.equals(other.getName())) {
		   return 0;
	   } else {
		   return -1;
	   }
		
	}
	
	public static void main(String[]args) {
		
		HashMap<String, String> hMap = new HashMap<String,String>();
		hMap.put("Agra", "Agra");
		hMap.put("Bangalore", "Bangalore");
		hMap.put("Mysore", "Mysore");
		System.out.println("HashMap:::"+hMap);
		
	}
	

}
