#ifndef HEALTHPOTION_H_
#define HEALTHPOTION_H_

#include <Potion.h>

#include <iostream>
#include <string>		


using namespace std;

class HealthPotion : public Potion{

	public:
		HealthPotion(string, double, int);
		~HealthPotion();
		void use(Character*);

};
#endif

