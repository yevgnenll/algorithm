a.out: main.o
	g++ -o a.out main.o

main.o: main.cpp
	g++ -c -o main.o main.cpp -std=c++1z

clean:
	rm -rf *.o *.out *.dSYM
