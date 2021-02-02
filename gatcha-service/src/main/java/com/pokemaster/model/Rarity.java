package com.pokemaster.model;

// The different rarities Pokemon can have in relation to the gatcha system.
public enum Rarity {
	
	COMMON,
	UNCOMMON,
	RARE,
	EPIC,
	LEGENDARY,
	MYTHIC;

	
	public static Rarity getRarityfromAvg(float average)
	{
		if(average <=54)
		{
			return Rarity.COMMON;
		}
		else if(average <=70)
		{
			return Rarity.UNCOMMON;
		}
		else if(average <=82)
		{
			return Rarity.RARE;
		}
		else if(average <= 95)
		{
			return Rarity.EPIC;
		}
		else if(average <= 99)
		{
			return Rarity.LEGENDARY;
		}
		else {
			return Rarity.MYTHIC;
		}
	}
	
}
