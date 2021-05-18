import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class ProcesoFichero {

    public static void main(String[] args){
        final int ENTRADAREGISTROS=6;
        File fichero = new File("Registros.dat");
        ManejoFichero manejoFichero;
        try {
            manejoFichero = new ManejoFichero(fichero,"rw");
            System.out.println("Añade 5 registros: ");
            for (int i=1;i<3;i++){
                manejoFichero.escribirRegistro(getRegistro(),i);
            }
            System.out.println("Consulta del registro número 4");
            System.out.println(manejoFichero.leerRegistro(1).customToString());

            System.out.println("Muestra todos los registros del fichero: ");
            for (int i = 1;i<manejoFichero.numRegistros()+1;i++){
                System.out.println(manejoFichero.leerRegistro(i).customToString());
            }
            manejoFichero.cierraFich();
        } catch(FileNotFoundException e){
            System.exit(0);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Registro getRegistro(){
        String nombre = "";
        int edad = 0;
        double peso = 0.0;
        char genero = ' ';
        char casado = ' ';
        Boolean estaCasado = false;
        Registro registro = null;
        Scanner introducirDatos = new Scanner(System.in);

        System.out.println("Nombre: ");
        nombre = introducirDatos.nextLine();

        System.out.println("Edad: ");
        edad = Integer.parseInt(introducirDatos.nextLine());

        System.out.println("Peso: ");
        peso = Double.parseDouble(introducirDatos.nextLine());

        do {
            System.out.println("Genero: ");
            genero = introducirDatos.nextLine().toLowerCase().charAt(0);
        } while (genero != 'M' && genero != 'F');

        do {
            System.out.println("Casado(S/N): ");
            casado = introducirDatos.nextLine().toLowerCase().charAt(0);
        } while (casado != 's' && casado!= 'n');

        if (casado == 's') {
            estaCasado = true;
        }
        return new Registro(nombre,edad,peso,genero,estaCasado);

    }

}
