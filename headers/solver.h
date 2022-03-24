#pragma once
#include "../headers/matrix.h"
#include <math.h>

class Solver {
	public:
	static Matrix buildAMatrix();
	static void solveSystemOfNumericalEquations();
	static void calculateAreaOfIntegrateUsingTrapezoids();
};	