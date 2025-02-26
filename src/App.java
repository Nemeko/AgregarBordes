

public class App {
    public static void main(String[] args) throws Exception {
        
        AgregarBordes mostrar = new AgregarBordes();
        String mensaje = """
        Hola mundo!
        Este es un mensaje de prueba
        Testing
        Leopoldo!
                """;
        mostrar.colorBorde("red");
        mostrar.contenido(mensaje, "blue");
    }
}
