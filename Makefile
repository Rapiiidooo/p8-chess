PROG = chess

all: $(PROG)

$(PROG):
	javac Main.java
	rm -r *.class
	javac Main.java
	java Main
	rm -r *.class
clean:
	rm -r *.class