1. Instalación del JDK
Para ejecutar el proyecto correctamente, es necesario tener instalado el JDK de Java y asegurarse de que esté bien configurado en el PATH del sistema. En este caso, se utilizó Java 21.

2. Configuración del entorno de desarrollo (IDE)
Se recomienda utilizar IntelliJ IDEA como entorno de desarrollo. Es importante configurar el SDK de Java 21 dentro del IDE para que el proyecto funcione correctamente.

3. Modificación de los datos de prueba (correo electrónico)
Antes de ejecutar las pruebas, se debe modificar el archivo users.csv, ya que el correo utilizado puede "quemarse".
Por ejemplo, si el correo actual es eduardo12@gmail.com, se debe modificar a eduardo13@gmail.com, eduardo14@gmail.com, etc.

4. Ubicación del archivo de datos
El archivo que contiene los datos de prueba (users.csv) se encuentra en la siguiente ruta del proyecto:
src/files/users.csv.

5. Ejecución del proyecto
El proyecto ya está listo para ejecutarse. Solo hay que abrir el archivo testng.xml, hacer clic derecho sobre él y seleccionar "Run" para iniciar las pruebas.

6. Visualización del reporte de resultados
Una vez finalizadas las pruebas, se puede acceder al reporte con las validaciones y capturas de evidencia. Este reporte se encuentra en la carpeta sparkReports, bajo el archivo SparkReport.html.

7. Cómo abrir el reporte
Para visualizar el reporte, hacer clic derecho sobre el archivo SparkReport.html, seleccionar "Open in", luego "Browser" y elegir el navegador de preferencia. En este caso, se utilizó Google Chrome.

8. Sobre la base del proyecto
Cabe destacar que este proyecto fue construido utilizando una base preexistente con utilidades ya desarrolladas. Fue necesario aprender rápidamente cómo integrarlas y utilizarlas de manera efectiva para cumplir con los requerimientos.