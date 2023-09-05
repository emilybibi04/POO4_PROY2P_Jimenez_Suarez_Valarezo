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

public interface Readable {
    
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
    
    
    static void serializarPedidos(Pedido p){
        try (ObjectOutputStream objstrm= new ObjectOutputStream(new FileOutputStream(App.pathS+"pedido"+p.id+".bin"));){
            objstrm.writeObject(p);
        } catch(IOException e){
            
            System.out.println("Excepcion durante la serializacion");
        }
    }
    
    static double redondear(double numero){
    
        double num= Math.round((numero) * 100.0) / 100.0;
        return num;
    }
    
    public static String obtenerFechaActual() {
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fechaActual);
    }
}
