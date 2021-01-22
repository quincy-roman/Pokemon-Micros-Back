package com.pokemaster.model;

public class ClientMessage<T> {

	T object;
	
	public ClientMessage( T object)
	{
		
		this.object = object;
	}
			
	
	public T getObjects()
	{
		return object;
	}
	
}
