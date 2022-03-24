#include "../headers/solver.h"
#include "../headers/menu.h"
#include "../headers/parser.h"
#include "../headers/tools.h"
#include <iostream>
#include <string>

void finish()
{
	std::exit(0);
}

int main(int argc, char* argv[])
{
	try {
		std::vector<Option> options = {
			Option((std::string)("Exit"), &finish),
			Option((std::string)("Solve a system of numerical equations using a matrix"), &(Solver::solveSystemOfNumericalEquations)),
			Option((std::string)("Calculate an area of integrate using trapezoids"), &(Solver::calculateAreaOfIntegrateUsingTrapezoids))
		};
		Menu *menu = new Menu(options);
		int choice = 1;
		do {
			menu->print();
			std::cin >> choice;
			menu->pick(choice);
		} while (choice != 0);

		/*
		std::string line;
		std::getline(std::cin, line);

		Tools::print(Parser::parseLineOfDoublesAndReverse(line));
		*/
	}
	catch (...)
	{
		std::cerr << "Panda trzy, nic z tego nie bedzie.";
	}

	return 0;
}
