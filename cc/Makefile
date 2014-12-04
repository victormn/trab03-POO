CFLAGS= -I include/

all: classes
	@g++ ./src/trab2.cpp $(CFLAGS) -o trab2 ./obj/Character.o ./obj/Knight.o ./obj/Wizard.o ./obj/Thief.o ./obj/Inventory.o ./obj/Item.o ./obj/Armor.o ./obj/Weapon.o ./obj/Potion.o ./obj/HealthPotion.o ./obj/ManaPotion.o ./obj/Team.o

classes:
	@g++ -c ./src/Item.cpp $(CFLAGS) -o ./obj/Item.o
	@g++ -c ./src/Character.cpp $(CFLAGS) -o ./obj/Character.o 
	@g++ -c ./src/Knight.cpp $(CFLAGS) -o ./obj/Knight.o
	@g++ -c ./src/Wizard.cpp $(CFLAGS) -o ./obj/Wizard.o
	@g++ -c ./src/Thief.cpp $(CFLAGS) -o ./obj/Thief.o
	@g++ -c ./src/Inventory.cpp $(CFLAGS) -o ./obj/Inventory.o
	@g++ -c ./src/Armor.cpp $(CFLAGS) -o ./obj/Armor.o
	@g++ -c ./src/Weapon.cpp $(CFLAGS) -o ./obj/Weapon.o
	@g++ -c ./src/Potion.cpp $(CFLAGS) -o ./obj/Potion.o
	@g++ -c ./src/HealthPotion.cpp $(CFLAGS) -o ./obj/HealthPotion.o	
	@g++ -c ./src/ManaPotion.cpp $(CFLAGS) -o ./obj/ManaPotion.o
	@g++ -c ./src/Team.cpp $(CFLAGS) -o ./obj/Team.o

clean:
	@rm -f ./obj/*.o trab2
	@find -name "*~" | xargs rm -rf

memorycheck:
	@valgrind ./trab2

run:
	@./trab2


# sera usado somente para testar os metodos das classes atraves de mainTest.cpp
test: classes
	@g++ ./src/mainTest.cpp $(CFLAGS) -o mainTest ./obj/Character.o ./obj/Knight.o ./obj/Wizard.o ./obj/Thief.o ./obj/Inventory.o ./obj/Item.o ./obj/Armor.o ./obj/Weapon.o ./obj/Potion.o ./obj/HealthPotion.o ./obj/ManaPotion.o ./obj/Team.o

cleanT:
	@rm -f ./obj/*.o mainTest

runT:
	@./mainTest
