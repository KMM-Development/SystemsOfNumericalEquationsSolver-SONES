#pragma once
#include "../headers/matrix.h"
#include "../headers/parser.h"
#include <math.h>

class Solver {
	public:
	static Matrix buildAMatrix();
	static void solveSystemOfNumericalEquationsUsingMatrices();
	static void calculateAreaOfIntegrateUsingTrapezoids();
	static void solveSystemOfPolynominalEquations();
};	