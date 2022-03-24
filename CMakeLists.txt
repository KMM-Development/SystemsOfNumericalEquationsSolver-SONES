project (SystemsOfNumericalEquationsSolver)
add_executable (SystemsOfNumericalEquationsSolver sources/main ${SOURCES} 
	"headers/matrix.h" "sources/matrix.cpp" 
	"headers/solver.h" "sources/solver.cpp"
)