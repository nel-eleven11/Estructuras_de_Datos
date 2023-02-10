public class Listener extends User {
    @Override
    public void printMenu() {
        System.out.println("Bienvenido Listener");
        System.out.println("Seleccione su opcion");
        System.out.println("1. Escuchar canciones");
        System.out.println("2. Descargar canciones");
        System.out.println("3. Comentar canciones");
    }
}