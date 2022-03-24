project (SystemsOfNumericalEquationsSolver)
add_executable (SystemsOfNumericalEquationsSolver sources/main ${SOURCES} 
	"headers/matrix.h"	"sources/matrix.cpp" 
	"headers/solver.h"	"sources/solver.cpp"
	"headers/menu.h"	"sources/menu.cpp"
	"headers/option.h"	"sources/option.cpp"
	"headers/parser.h"	"sources/parser.cpp" "headers/tools.h" "sources/tools.cpp")