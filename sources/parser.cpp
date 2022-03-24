#include "../headers/parser.h"

/*
vector.size
vector.push_back
vector.pop_back
*/

std::vector<double> Parser::parseLineOfDoublesAndReverse(std::string input)
{
	std::vector<double> output;

    try {
        for (std::string s : Tools::split(input, " ")) 
        {
            output.emplace_back(std::stod(s));
        }
    }
    catch (...) {
        std::cerr << "The given line of doubles could not be parsed.";
        throw;
    }

    return output;
}