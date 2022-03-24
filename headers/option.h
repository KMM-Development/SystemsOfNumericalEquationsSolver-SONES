#pragma once
#include <iostream>
#include <functional>

class Option {
	public:
		std::string description_;
		void callFunction();
		Option(std::string, std::function<void()>);

	private:
	std::function<void()> functionCalled_;
};