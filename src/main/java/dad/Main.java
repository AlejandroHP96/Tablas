package dad;

import java.io.File;


public class Main {

    public static void main(String[] args) {

        // File f = new File("c:\\windows");

        // System.out.println("¿Existe? " + f.exists()); // Comprobar si existe el archivo o no
        // System.out.println("¿Nombre? " + f.getName()); // Nombre del archivo
        // System.out.println("¿Tamaño? " + f.length()); // Obtener el tamaño de bits
        // System.out.println("¿Es directorio? " + f.isDirectory()); // Para saber si es un directorio
        // System.out.println("¿Última modificación?(milisegundos) " + f.lastModified()); // Para saber cuando se modificó
        //                                                                                // por última vez
         FicherosApp.main(args);
    }
    public static void mostrar(File f) {
        System.out.println("---> " + f.getAbsolutePath());
    }
}
