#pragma once
#include "option.h"
#include <vector>
#include <stdlib.h>

class Menu {
	public:
	Menu(std::vector<Option>);
	void pick(int);
	void print();

	private:
	std::vector<Option> options_;
};