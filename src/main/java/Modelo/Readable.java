/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Modelo;

import com.pooespol.proyecto_2p_poo.App;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * La interfaz Readable proporciona métodos estáticos para realizar operaciones relacionadas con la lectura,
 * escritura y manipulación de datos.
 */

public interface Readable {
    
    /**
     * Lee un archivo de texto y devuelve su contenido como una lista de cadenas.
     *
     * @param nombreArchivo El nombre del archivo a leer.
     * @return Una lista de cadenas que representan las líneas del archivo.
     */
    
    static ArrayList<String> leerArchivo(String nombreArchivo){
        
        ArrayList<String> lineas = new ArrayList<>();
        
        //Lectura del archivo y obtencion de informacion (se agrega en el Array)
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null){
                lineas.add(linea);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (null != fr){
                    fr.close();
                }
            } catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return lineas;
    }
    
    /**
     * Escribe un pedido en un archivo de texto especificado.
     *
     * @param p    El pedido a escribir.
     * @param ruta La ruta del archivo en el que se escribirá el pedido.
     */
    
    static void escribirPedidos(Pedido p, String ruta){
        FileWriter writer=null;
        try{
            writer= new FileWriter(ruta,true);
            writer.write(p+"\n");

        }catch(IOException ex){
            ex.printStackTrace();
        } finally{
            try{
                writer.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Serializa un pedido y lo guarda en un archivo binario.
     *
     * @param p El pedido a serializar.
     */
    
    static void serializarPedidos(Pedido p){
        try (ObjectOutputStream objstrm= new ObjectOutputStream(new FileOutputStream(App.pathS+"pedido"+p.id+".bin"));){
            objstrm.writeObject(p);
        } catch(IOException e){
            
            System.out.println("Excepcion durante la serializacion");
        }
    }
    
    /**
     * Redondea un número decimal a dos decimales.
     *
     * @param numero El número decimal a redondear.
     * @return El número redondeado con dos decimales.
     */
    
    static double redondear(double numero){
    
        double num= Math.round((numero) * 100.0) / 100.0;
        return num;
    }
    
    /**
     * Obtiene la fecha actual en formato "dd/MM/yyyy".
     *
     * @return La fecha actual en formato "dd/MM/yyyy".
     */
    
    public static String obtenerFechaActual() {
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fechaActual);
    }
}
