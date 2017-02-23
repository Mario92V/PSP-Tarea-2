package psp.tarea.pkg2;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mario F. Vélez R.
 */
public class Vista
{
    //Método que permite al usuario ingresar el directorio
    //donde se buscan los archivos .java para analizar.
    //En caso de que no se especifique se usa por defecto la ruta del archivo PSPTarea2
    public String pedirDirectorio()
    {
        String ruta = "";
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la ruta del directorio: ");
        ruta = teclado.nextLine();
        if(ruta.equals("") || ruta.endsWith(" "))
        {
            File rutaDefecto = new File(".");
            ruta = rutaDefecto.getAbsolutePath();
        }
        return ruta;
    }
    
    //Método que muestra al usuario los resultados de la ejecución del programa
    public void mostrarResultados(List<Integer> totalLOC, List<Integer> numClases, List<Integer> numMetodos, List<String> darNombreClases)
    {
        int totalLineas = 0;
        int totalClases = 0;
        for (int i = 0; i<totalLOC.size(); i++)
        {
            totalLineas+=totalLOC.get(i);
        }
        System.out.println("El programa tiene: ");
        System.out.println("- " + totalLineas + " lineas de código totales.");
        for (int i = 0; i<numClases.size(); i++)
        {
            totalClases+=numClases.get(i);
        }
        System.out.println("- " + totalClases + " clases.");
        for (int i = 0; i<totalLOC.size(); i++)
        {
            System.out.println("La clase " + darNombreClases.get(i) + " tiene:");
            System.out.println("- " + totalLOC.get(i) + " lineas de código.");
            System.out.println("- " + numMetodos.get(i) + " metodos.");
        }
    }
}