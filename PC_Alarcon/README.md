Proyecto: PC_Alarcon (Ejemplo entregable)
Autor: Gero Alarcon

Requisitos: Java 21, Maven

Cómo ejecutar:
1. mvn clean package
2. java -jar target/PC_Alarcon-0.0.1-SNAPSHOT.jar
3. Swagger UI: http://localhost:8080/swagger-ui.html  (springdoc)
4. Endpoints principales:
   - GET /api/dictionary -> lista palabras
   - POST /api/dictionary?word=palabra -> agrega palabra al diccionario
   - DELETE /api/dictionary -> borra diccionario
   - GET /api/texts -> lista textos
   - POST /api/texts -> agrega texto (JSON: {id,title,body})
   - GET /api/texts/{id} -> obtener texto
   - DELETE /api/texts -> borrar textos
   - GET /api/analysis/count -> conteo total por palabra
   - GET /api/analysis/stats -> estadísticas (occurrencias totales y nro documentos)
   - GET /autor -> muestra el nombre del autor

Persistencia: archivos JSON creados en carpeta 'data' al ejecutar la aplicación:
 - data/dictionary.json
 - data/texts.json

Notas: Cambia el nombre del paquete y del autor si lo necesitas para entrega.