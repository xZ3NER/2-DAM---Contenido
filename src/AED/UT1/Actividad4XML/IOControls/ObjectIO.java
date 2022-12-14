package AED.UT1.Actividad4XML.IOControls;

import AED.UT1.Actividad4XML.Objects.CentroEducativo;

import java.io.*;
import java.util.ArrayList;

//Clase para escribir/leer objetos de un fichero.
//(El objeto a escribir tiene que implementar la interfaz 'Serializable'))
public class ObjectIO {

    private File file;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public ObjectIO(String path) {
        this.file = new File(path);
    }

    //Lee los objetos contenidos en un fichero y los muestra por consola (modificable)
    public void readObject() {
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(this.file));

            try {
                while (true) {
                    //Castea al nombre del objeto correspondiente
                    System.out.println(/*(Object)*/objectInputStream.readObject().toString());
                }
            }catch (EOFException e) {}

            objectInputStream.close();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Lee los objetos de un fichero y los almacena en una lista, al final devuelve la lista.
    //(Modificar clase de la lista según el objeto)
    public ArrayList<CentroEducativo> readObjectToList() {
        //Cambiar según el tipo de objeto
        ArrayList<CentroEducativo> objectList = new ArrayList<>();

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(this.file));

            try {
                while (true) {
                    objectList.add((CentroEducativo) objectInputStream.readObject());
                }
            }catch (EOFException e) {}

            objectInputStream.close();
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return objectList;
    }

    //Escribe en un fichero, la lista de objetos que le pasemos como parámetros.
    //<T> = Generics/Génerico, es decir, aceptara listas de cualquier clase.
    public <T> void writeObject(ArrayList<T> objectList) {
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.file));

            for (int i = 0;i<objectList.size();i++) {
                objectOutputStream.writeObject(objectList.get(i));
            }

            objectOutputStream.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }
}
