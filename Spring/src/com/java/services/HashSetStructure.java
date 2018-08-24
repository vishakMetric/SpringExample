package com.java.services;

import java.util.HashSet;

public class HashSetStructure {
	
	public static void main(String[] args) {
		
		Country india=new Country("India",1000);
        Country japan=new Country("Japan",10000);
        Country france=new Country("France",2000);
        Country russia=new Country("Russia",20000);
        
        HashSet<Country> countrySet=new HashSet<Country>(); 
        countrySet.add(india);
        countrySet.add(japan);
        countrySet.add(france);
        countrySet.add(russia);
        
        System.out.println(countrySet);
		
	}

}
