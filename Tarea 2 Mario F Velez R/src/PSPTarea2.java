package psp.tarea.pkg2;

import java.util.List;

/**
 *
 * @author Mario F. Vélez R.
 */
public class PSPTarea2
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String ruta;
        Vista controladorVista = new Vista();
        Modelo controladorModelo = new Modelo();
        ruta = controladorVista.pedirDirectorio();
        List<String> listaElem = controladorModelo.ingresarArchivos(ruta);
        List <Integer> totalLOC = controladorModelo.calcularLOC(listaElem);
        List <Integer> numClases = controladorModelo.numeroClases(listaElem);
        List <Integer> numMetodos = controladorModelo.numeroMetodos(listaElem);
        List <String> nombreClases = controladorModelo.darNombreClases(listaElem);
        controladorVista.mostrarResultados(totalLOC, numClases, numMetodos, nombreClases);
    }
}