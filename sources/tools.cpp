#include "../headers/tools.h"

void Tools::print(std::vector<double> vec)
{
	for (double d : vec)
		std::cout << d << std::endl;
}


std::vector<std::string> Tools::split(std::string input, std::string delimiter)
{
	std::vector<std::string> output;

    int position = 0;
    std::string subinput;
    while ((position = input.find(delimiter)) != std::string::npos)
    {
        subinput = input.substr(0, position);
        output.emplace_back(subinput);
        input.erase(0, position + delimiter.length());
    }
    output.emplace_back(input);

    return output;
}