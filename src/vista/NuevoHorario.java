/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import java.util.*;
/**
 *
 * @author Yorch
 */
public class NuevoHorario {
    private int codigoHorario;
    private String horarioCita;

    public NuevoHorario(int codigoHorario, String horarioCita) {
        this.codigoHorario = codigoHorario;
        this.horarioCita = horarioCita;
    }

    public int getCodigoHorario() {
        return codigoHorario;
    }

    public void setCodigoHorario(int codigoHorario) {
        this.codigoHorario = codigoHorario;
    }

    public String getHorarioCita() {
        return horarioCita;
    }

    public void setHorarioCita(String horarioCita) {
        this.horarioCita = horarioCita;
    }
    public static int codigo = 001;
    public static ArrayList<NuevoHorario> Horarios = new ArrayList<>();
    
    public static void registrarHorario(int codigoHorario, String horarioCita){
    NuevoHorario horario = new NuevoHorario(codigo,horarioCita);
    Horarios.add(horario);
    
    }
      public static Object[][] convertirDatosHorario(){
       int filasHorario = Horarios.size();
       Object [][] arregloHorario = new Object[filasHorario][2];
       
       for (int i = 0; i < filasHorario; i++){
           NuevoHorario nuevoHorario = Horarios.get(i);
           arregloHorario[i][0] = nuevoHorario.getCodigoHorario();
           arregloHorario[i][1] = nuevoHorario.getHorarioCita();
       }
        return arregloHorario;
   }
    public static HashSet<String> obtenerHorario(){
    HashSet<String> horarios = new HashSet<>();
    
    for(NuevoHorario horario : Horarios){
        horarios.add(horario.getHorarioCita());
    }
    return horarios;
    }
}