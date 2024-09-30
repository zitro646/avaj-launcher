# COLORS #
GREEN = "\033[0;32m"
BLUE = "\033[0;34m" 
PURPLE = "\033[0;35m"
CYAN = "\033[0;36m"
RESET = "\033[1;0m"

# VARIABLES #
OUTPUT_FILE = simulation.txt
JAVAC = javac
JAVA = java
JFLAGS = -d $(OBJ_PATH)
INPUT_FILE = ejemplo.txt

# PATHs #
SRC_PATH    = srcs
OBJ_PATH    = bin

# SOURCES #
SRC_FILE = sources.txt
SRC = 	@$(SRC_FILE)

# RULES #
all: compile

compile: 
	find * -name "*.java" > $(SRC_FILE)
	$(JAVAC) -d $(OBJ_PATH) $(SRC)
	@echo $(CYAN) PROYECT COMPILED $(RESET)

run:
	$(JAVA) -cp $(OBJ_PATH) main.Main $(INPUT_FILE)

clean:
	rm -f $(OUTPUT_FILE)
	rm -f $(SRC_FILE)
	@echo $(PURPLE) CLEANING CLASS FILES $(RESET)
	rm -rf $(OBJ_PATH)

fclean: clean
	@echo $(PURPLE) CLEANING DIRECTORY $(RESET)
	rm -rf $(OBJ_PATH)

re: fclean all

.PHONY: all compile run clean fclean re

#javac -d classes ./srcs/Main/Main.java ./srcs/Aircraft/Aircraft.java ./srcs/Coordinates/Coordinates.java ./srcs/Macros/Macros.java ./srcs/Helicopter/Helicopter.java ./srcs/Baloon/Baloon.java ./srcs/JetPlane/JetPlane.java ./srcs/WeatherProvider/WeatherProvider.java ./srcs/Flyable/Flyable.java ./srcs/WeatherTower/WeatherTower.java ./srcs/Tower/Tower.java ./srcs/AircraftFactory/AircraftFactory.java
