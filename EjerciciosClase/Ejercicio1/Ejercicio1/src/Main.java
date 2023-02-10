import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        User user;
        UserInstanceCreator creador = new UserInstanceCreator();

        Scanner miScanner = new Scanner(System.in);

        System.out.println("Bienvenido a la plataforma de musica");
        System.out.println("Ingrese su nombre de usuario");
        String username = miScanner.nextLine();
        System.out.println("Ingrese su contraseña");
        String password = miScanner.nextLine();

        if(username.equals("listener") && password.equals("listener")) {
            //user = creador.createUser("listener");
        } else if(username.equals("producer") && password.equals("producer")) {
            //user = creador.createUser("producer");
        } else {
            System.out.println("Usuario o contraseña incorrectos");
            return;
        }




    }
}