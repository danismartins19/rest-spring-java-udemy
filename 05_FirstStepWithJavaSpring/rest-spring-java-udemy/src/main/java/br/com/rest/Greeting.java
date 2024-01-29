package br.com.rest;

public class Greeting {

	private final long Id;
	private final String name;
	public Greeting(long id, String name) {
		Id = id;
		this.name = name;
	}
	public long getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	
	
	
}
