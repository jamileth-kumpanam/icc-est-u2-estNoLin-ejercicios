package main;

import utils.StudentValidator;

public class App {
    public static void main(String[] args) throws Exception {
        // NO MODIFICAR ESTE CÓDIGO
        var estudiante = StudentValidator.validarDatos();
        System.out.println("👤 Estudiante: Jamileth Estefanía Kumpanam Segarra " + estudiante.nombre());
        System.out.println("✉️  Correo: jkumpanam@est.ups.edu.ec " + estudiante.correo());
        // NO MODIFICAR HASTA AQUÍ
    }

}
