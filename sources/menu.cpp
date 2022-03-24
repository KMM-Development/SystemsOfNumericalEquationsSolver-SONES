#include "../headers/menu.h"

Menu::Menu(std::vector<Option> options)
	:options_(options)
{ }

void Menu::pick(int num)
{
	if (num >= options_.size()) {
		std::cout << std::endl << "This number is outside of the available scope of choices.";
		return;
	}
	options_[num].callFunction();
}

void Menu::print()
{
	for (int i = 1; i < options_.size(); i++)
	{
		std::cout << i << ") " << options_[i].description_ << std::endl;
	}
	std::cout << "0) " << options_[0].description_ << std::endl << std::endl;
}