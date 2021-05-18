public class Registro {

    static final int TAMANO_REGISTRO = 53;
    static final int TAMANO_STRING = 20;
    static int numeroRegistro = 0;

    String nombre;
    int edad;
    double peso;
    char genero;
    Boolean casado;

    public Registro(String nombre, int edad, double peso, char genero, Boolean casado){
        super();
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.genero = genero;
        this.casado = casado;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

     public int getEdad(){
        return edad;
     }
     public void setEdad(int edad){
        this.edad = edad;
     }

     public double getPeso(){
        return peso;
     }
     public void setPeso(double peso){
        this.peso = peso;
     }

     public char getGenero(){
        return genero;
     }
     public void setGenero(char genero){
        this.genero = genero;
     }

     public Boolean getCasado(){
        return casado;
     }
     public void setCasado(Boolean casado){
        this.casado=casado;
     }

    public int getTamanoRegistro() {
        return TAMANO_REGISTRO;
    }

    public static int getNumeroRegistro() {
        return numeroRegistro;
    }

    public static void setNumeroRegistro(int numeroRegistro){
        Registro.numeroRegistro = numeroRegistro;
    }

    @Override
    public String toString(){
        return  "Registro [nombre = " + nombre + ", edad = " + edad + ", peso = " + peso + ", genero = " + genero + ", casado = " + casado + "]";
    }

    public String customToString(){
        return nombre +""+edad+""+peso+""+genero+""+casado;
    }

}
