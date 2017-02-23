package psp.tarea.pkg2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario F. Vélez R.
 */
public class Modelo
{
    private List<String> rutaElementos = new ArrayList<>();
    
    //Método para añadir los archivos a una lista para su posterior clasificación
    public List<String> ingresarArchivos(String ruta)
    {
        File directorio = new File(ruta);
        File[] listaDeArchivos = directorio.listFiles();
        for (int i = 0; i < listaDeArchivos.length; i++)
        {
            if(listaDeArchivos[i].isDirectory())
            {
                ingresarArchivos(listaDeArchivos[i].getPath());
            }
            else if (listaDeArchivos[i].isFile())
            {
                if (listaDeArchivos[i].getName().endsWith(".java") || listaDeArchivos[i].getName().endsWith(".JAVA"))
                {
                    String path = listaDeArchivos[i].getAbsolutePath();
                    rutaElementos.add(path);
                }
            }
        }
        return rutaElementos;
    }
    
    //Método que calcula las LOC totales de cada uno de los archivos .java encontrados
    public List<Integer> calcularLOC(List<String> listaElem)
    {
        List<Integer> totalLOC = new ArrayList<>();
        String linea;
        for (int i =0; i<listaElem.size(); i++)
        {
            int contadorLOC = 0;
            try
            {
                FileReader fr = new FileReader(listaElem.get(i));
                BufferedReader br = new BufferedReader(fr);
                linea = br.readLine();
                while(linea != null)
                {
                    if((linea.contains("//")||linea.contains("/*")||linea.contains("*/")||linea.equals("")||linea.endsWith(" ")||linea.contains("*"))&&(!linea.endsWith(")")||!linea.endsWith(";")))
                    {}
                    else
                    {
                        contadorLOC+=1;
                    }
                    linea = br.readLine();
                }
            }
            catch (IOException e)
            {
                System.out.println("Error en la lectura del archivo");
            }
            totalLOC.add(contadorLOC);
        }
        return totalLOC;
    }
    
    //Método para obtener la cantidad de clases de cada archivo analizado
    public List<Integer> numeroClases(List<String> listaElem)
    {
        List<Integer> numClases = new ArrayList<>();
        String linea;
        for (int i =0; i<listaElem.size(); i++)
        {
            int contadorClases = 0;
            try
            {
                FileReader fr = new FileReader(listaElem.get(i));
                BufferedReader br = new BufferedReader(fr);
                linea = br.readLine();
                while(linea != null)
                {
                    if((linea.contains("public class")||linea.contains("private class"))&&!linea.endsWith(")"))
                    {
                        contadorClases+=1;
                    }
                    else
                    {}
                    linea = br.readLine();
                }
            }
            catch (IOException e)
            {
                System.out.println("Error en la lectura del archivo");
            }
            numClases.add(contadorClases);
        }
        return numClases;
    }
    
    //Método para obtener la cantidad de métodos de cada archivo analizado
    public List<Integer> numeroMetodos(List<String> listaElem)
    {
        List<Integer> numMetodos = new ArrayList<>();
        String linea;
        for (int i =0; i<listaElem.size(); i++)
        {
            int contadorMetodos = 0;
            try
            {
                FileReader fr = new FileReader(listaElem.get(i));
                BufferedReader br = new BufferedReader(fr);
                linea = br.readLine();
                while(linea != null)
                {
                    if((linea.contains("public")||linea.contains("private"))&&linea.endsWith(")")&&!linea.contains("if"))
                    {
                        contadorMetodos+=1;
                    }
                    else
                    {}
                    linea = br.readLine();
                }
            }
            catch (IOException e)
            {
                System.out.println("Error en la lectura del archivo");
            }
            numMetodos.add(contadorMetodos);
        }
        return numMetodos;
    }
    
    //Método que permite obtener los nombres de las clases que componen el programa
    public List<String> darNombreClases(List<String> listaElem)
    {
        List<String> nombresClases = new ArrayList<>();
        for (int i =0; i<listaElem.size(); i++)
        {
            File archivo = new File(listaElem.get(i));
            String nombre = archivo.getName();
            String[] partes = nombre.split("\\.");
            nombresClases.add(partes[0]);
        }
        return nombresClases;
    }
}