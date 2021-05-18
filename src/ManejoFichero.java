
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class ManejoFichero extends AbstractaManejoFichero{

    protected RandomAccessFile fichero = null;

    public ManejoFichero(File fichero, String modo) throws FileNotFoundException{
        this.fichero = new RandomAccessFile(fichero,modo);
    }


    @Override
    protected int numRegistros() throws IOException {
        return (int) (fichero.length()/Registro.TAMANO_REGISTRO);
    }

    @Override
    protected Registro leerRegistro(int nRegistro) throws IOException {
        fichero.seek(0);
        fichero.seek((nRegistro-1)*Registro.TAMANO_REGISTRO);
        String nombre = "";
        for (int i=0;i<Registro.TAMANO_STRING;i++){
            nombre += fichero.readChar();
        }
        Registro registro = new Registro(nombre,fichero.readInt(),fichero.readDouble(),fichero.readChar(),fichero.readBoolean());
        return registro;
    }

    @Override
    protected void escribirRegistro(Registro reg, int nRegistro) throws IOException {
        //Los Strings tienen que tener un minimo de 20 caracteres
        StringBuffer buf = new StringBuffer(reg.getNombre());
        buf.setLength(Registro.TAMANO_STRING); // Le asignamos el tamaño que tienen que tener los strings
        fichero.seek(nRegistro*Registro.TAMANO_REGISTRO); //Que busque en todx el registro

        //Escribimos en el registro
        fichero.writeChars(buf.toString());
        fichero.writeInt(reg.getEdad());
        fichero.writeDouble(reg.getPeso());
        fichero.writeChar(reg.getGenero());
        fichero.writeBoolean(reg.getCasado());
    }

    @Override
    protected void cierraFich() throws IOException {
        fichero.close();
    }
}
