# DesafioTecnicoMantenedorTareas
Crear una aplicación web fron-back para coopeuch

#Para poder utilizar la aplicación debemos primero compilar tareas-api
#Paso 0
#Se debe instarlar posgreSQL con la siguiente conexion:
#HOST:localhost
#PORT:5432
#USER:postgres
#PASS:1234 puede ser cambiada luego en el archivo application.yml
#DATABASE: postgres

#Paso 1
#Agregar a las variables de entorno OpenJDK17
https://jdk.java.net/17/
#Abrir el buscador de variables de entorno agregar JAVA_HOME y dar la url de OpenJDK17 donde se descargó
#Agregar %JAVA_HOME%\bin a las variables de entorno llamada PATH

#Paso 2
#Descargar y Agregar apache-maven a las variables de entorno
https://maven.apache.org/download.cgi
#Abrir el buscador de variables de entorno agregar MAVEN_HOME y dar la url de maven donde se descargó
#Agregar %MAVEN_HOME%\bin a las variables de entorno llamada PATH

#Paso 3
#Una vez teniendo las variables de entorno, se de abrir el proyecto tareas-api y ejecutarlo con el comando
mvn spring-boot:run

#Paso 4 opcional
#Se pueden correr las pruebas unitarias
mvn clean package

#Paso 5 opcional
#Si se quiere probar el api desde un cliente REST, existe un archivo json llamado thunder-collection_CoopeuchTareas.json
#Esta echo desde la extension de VSCODE llamada Thunder Client, simpletemente se busca Thunder Client e instalar e importar el archivo
#URL: /DesafioTecnicoMantenedorTareas/

#Paso 6 opcional
#Existe un script llamado tarea_coopeuch.sql, en cual se puede crear la tabla con el script que existe ahí
#Además de proporcionar datos de pruebas
#URL: /DesafioTecnicoMantenedorTareas/tareas-api/src/main/resources/
#NOTA : no es realmente necesario ya que al ejecutar la aplicación se crea la tabla automaticamente al ejecutarse, pero si se puede insetar lo datos

#Compilar aplicación UI
#Paso 1
#Abrir la aplicación luego ejecutar el comando:
npm install

#Paso 2
#Ejecutar el comando:
ng serve