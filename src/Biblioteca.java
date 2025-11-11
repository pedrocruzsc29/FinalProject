
import servicios.ServicioPrincipal;
import ui.MenuPrincipal;
import estructuras.Validaciones.validaciones;

public class Biblioteca {
    public static void main(String[] args) {

        ServicioPrincipal bibliotecaService = new ServicioPrincipal();
        
        mostrarBienvenida();
        // Esperar a que el usuario presione Enter
        validaciones.pause();

       
        MenuPrincipal menuPrincipal = new MenuPrincipal(bibliotecaService);
        
        // Iniciar la aplicación
        menuPrincipal.mostrar();
        
        mostrarDespedida();
    }
    private static void mostrarBienvenida() {
        validaciones.limpiarPantalla();
        System.out.println("\n====================================");
        System.out.println("  SISTEMA DE GESTIÓN DE BIBLIOTECA  ");
        System.out.println("====================================");
        System.out.println("Cargando recursos...\n");
        System.out.println("\033[0m");
        
        efectoMatrixCarga();
    }

    private static void efectoMatrixCarga() {
        try {
            System.out.println("\n\033[0;32m  [INICIALIZANDO SISTEMAS...]");
            Thread.sleep(300);
            
            System.out.print("  [");
            for (int i = 0; i < 30; i++) {
                System.out.print("|");
                Thread.sleep(50);
            }
            System.out.println("] 100%");
            
            System.out.println("  [100%] Base de datos conectada");
            Thread.sleep(200);
            System.out.println("  [100%] Módulos cargados");
            Thread.
            sleep(200);
            System.out.println("  [100%] Sistema listo\033[0m\n");
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    private static void mostrarDespedida() {
        System.out.println("\n\033[1;32m");
        System.out.println("  ╔══════════════════════════════════════════════════════╗");
        System.out.println("  ║                                                      ║");
        System.out.println("  ║           \033[5m>>> SESIÓN CERRADA <<<\033[0m\033[1;32m                     ║");
        System.out.println("  ║                                                      ║");
        System.out.println("  ╚══════════════════════════════════════════════════════╝");
        System.out.println("\033[0m\n");
    }
    
}