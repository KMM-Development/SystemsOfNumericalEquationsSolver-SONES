#include "../headers/option.h"

Option::Option(std::string description, std::function<void()> functionCalled)
	: description_(description)
	, functionCalled_(functionCalled) 
{ }

void Option::callFunction()
{
	functionCalled_();
}