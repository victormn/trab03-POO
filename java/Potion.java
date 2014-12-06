interface Potion{

	public int getRestorePts();
// mudar ou nao para manapts

	// Indica uso dos itens 'Potion'(implementado em ManaPotion e HealthPotion)
	public void use(Character character);

}
