Algoritmo de búsqueda binaria, para buscar eficientemente un valor en un arreglo ordenado.

Estructura del proyecto
- 'BusquedaBinaria.java' contiene el método que realiza la búsqueda binaria.  

La búsqueda binaria es un algoritmo de búsqueda muy eficiente que solo funciona sobre arreglos ordenados.
Utiliza la técnica de dividir, en cada paso reduce a la mitad el rango de búsqueda.  
- Se calcula la posición media 'mid' entre los índices 'low' y 'high'.  
- Se compara el elemento de 'arr[mid]' con el valor buscado:  
  - Si son iguales, se ha encontrado el valor.  
  - Si el valor buscado es menor, la búsqueda continúa en la mitad izquierda.  
  - Si es mayor, continúa en la mitad derecha.   
- Esto se repite mientras 'low <= high'. Si 'low' pasa de 'high', significa que el valor no está en el arreglo. 