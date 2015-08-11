SUBDIRS := $(wildcard [0-9]*)

all: run $(SUBDIRS) combine purge

run:
	@cc -c run.c
	@cc -c euler.c
	@echo -e "#include \"source.h\"\n#include \"euler.h\"\nvoid collect(){" >> exec.c

combine:
	@echo -e "}">>exec.c
	@rm run.o
	cc -c exec.c
	cc -o euler *.o -lm

$(SUBDIRS):
	cc -c ./$@/solution*.c -o problem-$@.o
	@cc -o run run.o problem-$@.o -lm
	@objcopy --localize-symbol=provide problem-$@.o
	@echo -n "reg_sol(">>exec.c
	@echo -n $@ | sed 's/^0*//'>>exec.c
	@echo -n ", &">>exec.c
	@./run>>exec.c && echo ");">>exec.c
	@echo -n "void ">>source.h
	@./run>>source.h && echo "();">>source.h
	@rm run

clean:
	rm euler

purge:
	@rm *.o exec.c source.h

.PHONY: all $(SUBDIRS)
