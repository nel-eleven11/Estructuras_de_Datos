public class Producer extends User {
    @Override
    public void printMenu() {
        System.out.println("Bienvenido Producer");
        System.out.println("Seleccione su opcion");
        System.out.println("1. Subir canciones");
        System.out.println("2. Descargar canciones");
        System.out.println("3. Comentar canciones");
    }
}