# COLORS #
GREEN = @echo "\033[0;32m"
BLUE = @echo "\033[0;34m" 
PURPLE = @echo "\033[0;35m"
CYAN = @echo "\033[0;36m"
RESET = @echo "\033[1;0m"

# VARIABLES #
NAME = ejemplo
JAVAC = javac
JAVA = java
JFLAGS = -d $(OBJ_PATH)
INPUT_FILE = ejemplo.txt
OUTPUT_FILE = simulation.txt
SOURCE_FILE = sources.txt

# PATHs #
SRC_PATH    = srcs
OBJ_PATH    = classes


# SOURCES #
SRC = 	@$(SOURCE_FILE)
#@sources.txt
# RULES #
all: compile

compile:
	find * -name "*.java" > sources.txt
	$(JAVAC) -d $(OBJ_PATH) $(SRC)
	$(CYAN) PROYECT COMPILED $(RESET)

run:
	$(JAVA) -cp $(OBJ_PATH) main.Main $(INPUT_FILE)

clean:
	$(PURPLE) CLEANING CLASS FILES $(RESET)
	rm -f $(SOURCE_FILE)
	rm -f $(OUTPUT_FILE)

fclean: clean
	$(PURPLE) CLEANING DIRECTORY $(RESET)
	rm -rf $(OBJ_PATH)

re: fclean all

.PHONY: all compile run clean fclean re