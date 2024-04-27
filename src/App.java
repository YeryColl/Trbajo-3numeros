// Nombre: Yery William Collado Rivera     Carnet: 2024-1627U

//importamos el Scanner
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3;
        do {
            //Usamos un try-catch para poder manejar las posibles exepciones 
            try {
                //le pedimos al usuario que ingrese los numeros
                System.out.println("Ingrese el primer número:");
                num1 = scanner.nextInt();
                System.out.println("Ingrese el segundo número:");
                //llamamos al médoto obtenerNumero para verificar que el numero no sea el mismo que el de arriba
                num2 = obtenerNumero(num1,scanner);
                System.out.println("Ingrese el tercer número:");
                //Volvemos a llamar al método pero ahora le ingresamos el segundo numero tambien
                num3 = obtenerNumero(num2,num1,scanner);
                //Si todo sale bien el bucle se detiene
                continuar = false;  
                //Guardamos en una variable el resultado de los métodos llamados 
                int sumaDosMenores = sumaDosMenores(num1, num2, num3);
                int diferenciaDosMayores = diferenciaDosMayores(num1, num2, num3);
                int mayor = encontrarMayor(num1, num2, num3);
                //mostramos al usuario el resultado final
                System.out.println("La suma de los dos números más pequeños es: " + sumaDosMenores);
                System.out.println("La diferencia entre los dos números más grandes es: " + diferenciaDosMayores);
                System.out.println("El número mayor es: " + mayor);
                //Usamos un catch por si el usuario ingresa un numero no entero o letras.
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error. Asegúrate de ingresar solo números enteros.");
                //Limpiamos el buffer
                scanner.nextLine();
            } 
        } while (continuar);
            
    }
        
    // Método para encontrar la suma de los dos números más pequeños
    public static int sumaDosMenores(int num1, int num2, int num3) {
        //Buscamos el numero menor usando Match.min que busca el numero mas bajo 
        int menor = Math.min(Math.min(num1, num2), num3);
        //Buscamos el 2 numero mas bajo, sumando todos los numeros y restandolos por el menor y el mayor asi quedando solo el segundo numero
        int medio = (num1+num3+num2)- Math.min(Math.min(num1, num2), num3) -  Math.max(Math.max(num1, num2), num3);
        //Retornamos la suma del numero menor y el siguente numero menor
        return menor + medio;
        
    }
        
    // Método para encontrar la diferencia entre los dos números más grandes
    public static int diferenciaDosMayores(int num1, int num2, int num3) {
        //Buscamos el numero mayor usando Match.max que busca el numero mas alto
        int mayor = Math.max(Math.max(num1, num2), num3);
        //Buscamos el 2 numero mas alto, sumando todos los numeros y restandolos por el menor y el mayor asi quedando solo el segundo numero
        int medio =(num1+num3+num2)- Math.max(Math.max(num1, num2), num3) - Math.min(Math.min(num1, num2), num3);
        //Retornamos la resta del numero mayor y el segundo numero mas grande
        return mayor - medio;
    } 
    // Método para encontrar el número mayor
    public static int encontrarMayor(int num1, int num2, int num3) {
        //Usamos una variable donde asumimos que el numero mayor es el primero
        int mayor = num1;
        //Si el segundo numero es mayor que la variable declarada antes este pasara a ser el mayor sino simplemente se ignora
        if (num2 > mayor) {
            mayor = num2;
        }
        //Si el tercer numero es mayor que la variable antes dicha este pasara ha ser el mayor sino simplemente se ignora
        if (num3 > mayor) {
            mayor = num3;
        }
        //Retornamos el numero mayor
        return mayor;
    }
    // Método para que no se repitan los numero, donde se le pasa el numero que habia ingresado antes y el Scanner.
    public static int obtenerNumero(int num1, Scanner scanner){
        //Declaramos una variable que guardara el numero que el usuario ingrese
        int num = scanner.nextInt();
        //Si el usuario ingresa un numero que es igual al que ingreso previamente entra al while hasta que ya no sean iguales
        while (num == num1) {
            System.out.println("No pueden ser los mismos numeros");
            //Se vuelve a leer el numero
            num = scanner.nextInt();
            
        }
        //Se retorna el numero
        return num;
    }
    // Método para que no se repitan los numeros
    // En este metodo no solo se le pasa el primer numero y un Scanner sino que tambien el segundo numero
    public static int obtenerNumero(int num1,int num2, Scanner scanner){
        //Declaramos una variable que guardara el numero que el usuario ingrese
        int num = scanner.nextInt();
        //Si el numero ingresado es igual a uno de los dos ingresados anteriormente entra al while hasta que ya no sean iguales
        while (num == num1 || num == num2) {
            System.out.println("No pueden ser los mismos numeros");
            //Se vuelve a leer el numero
            num = scanner.nextInt();
            
        }
        //Se retorna el numero
        return num;
    }
}
