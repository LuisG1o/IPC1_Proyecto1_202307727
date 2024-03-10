package controlador;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class DoctorDAO{
    
    public static  ArrayList<Doctor> doctores = new ArrayList<>();
     
    public static int buscarD(String doctor){
        int n = -1;
        for (int i = 0; i < doctores.size(); i++ ){
            if(doctores.get(i).getDoctor().equals(doctor)){
                n = i;
                break;
            }
        }
        return n;
    }
        public Doctor obtenerD(String doctor){
        if(buscarD(doctor) != -1){
            return doctores.get(buscarD(doctor));
        }else{
            return null;
        }
    }
    public boolean insertarD(Doctor doctor){
        if(buscarD(doctor.getDoctor())== -1){
            doctores.add(doctor);
            return true;
        }else{
            return false;
        }
    }
    public boolean actualizarD(Doctor doctor){
        if(buscarD(doctor.getDoctor())!=1){
            Doctor doctoraux = obtenerD(doctor.getDoctor());           
            doctoraux.setNombre(doctor.getNombre());
            doctoraux.setApellido(doctor.getApellido());
            doctoraux.setEspecialidad(doctor.getEspecialidad());
            doctoraux.setPass(doctor.getPass());
            doctoraux.setTelefono(doctor.getTelefono());
            doctoraux.setEdad(doctor.getEdad());
            return true;
        }else{
            return false;
        }
    }
    public static boolean eliminarD(String doctor){
        if(buscarD(doctor)!=1){
            doctores.remove(buscarD(doctor));
            return true;
        }else{
            return false;
        }
    } 
    public static Object[][] convertir(){
    int filas  =  doctores.size();
    Object [][] listaDoctores = new Object[filas][7];
    for(int i = 0; i < filas; i++){
        Doctor doctor = doctores.get(i);
        listaDoctores[i][0] = doctor.getCodigo();      
        listaDoctores[i][1] = doctor.getNombre();
        listaDoctores[i][2] = doctor.getApellido();
        listaDoctores[i][3] = doctor.getGenero();
        listaDoctores[i][4] = doctor.getEdad();
        listaDoctores[i][5] = doctor.getEspecialidad();
        listaDoctores[i][6] = doctor.getTelefono();
        
    }  
     return listaDoctores;
    }   

    public List<Doctor> getDoctores() {
    return doctores;
}
  public static HashSet<String> ObtenerEspecialidad(){
      HashSet<String> especialidades = new HashSet<>();     
      for(Doctor doctor: doctores){
          especialidades.add(doctor.getEspecialidad());
      }return especialidades;
  }
  public static ArrayList<Doctor> filtrarPorEspecialidad(String Especialidad){
      ArrayList<Doctor> doctoresFiltrados = new ArrayList<>();
      for(Doctor doctor: doctores){
          if(doctor.getEspecialidad().equalsIgnoreCase(Especialidad)){
              doctoresFiltrados.add(doctor);
          }
      }
        return doctoresFiltrados;
  } 
}
