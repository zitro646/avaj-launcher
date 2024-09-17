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

# PATHs #
SRC_PATH    = srcs
OBJ_PATH    = classes

# SOURCES #
SRC = srcs/main/Main.java \
      srcs/class/Persona.java 

# RULES #
all: compile run

compile: $(OBJ_PATH)/Main.class

# Compilar todos los archivos .java
$(OBJ_PATH)/%.class: $(SRC_PATH)/%.java | $(OBJ_PATH)
	$(JAVAC) $(JFLAGS) $^

# Ejecutar la aplicación principal
run:
	$(JAVA) -cp $(OBJ_PATH) main.Main

# Crear el directorio de clases
$(OBJ_PATH):
	mkdir -p $(OBJ_PATH) 2> /dev/null

# Reglas adicionales
clean:
	$(PURPLE) CLEANING CLASS FILES $(RESET)
	rm -rf $(OBJ_PATH)

fclean: clean
	$(PURPLE) CLEANING DIRECTORY $(RESET)
	rm -rf $(OBJ_PATH)

re: fclean all

.PHONY: all compile run clean fclean re

 #javac -d classes srcs/Main/Main.java .\srcs\Aircraft\Aircraft.java .\srcs\Coordinates\Coordinates.java .\srcs\Macros\Macros.java .\srcs\Helicopter\Helicopter.java .\srcs\Baloon\Baloon.java .\srcs\JetPlane\JetPlane.java .\srcs\WeatherProvider\WeatherProvider.java .\srcs\Flyable\Flyable.java .\srcs\WeatherTower\WeatherTower.java .\srcs\Tower\Tower.java .\srcs\AircraftFactory\AircraftFactory.java 
 
 
 
 #java -cp classes main.Main ejemplo.txt
