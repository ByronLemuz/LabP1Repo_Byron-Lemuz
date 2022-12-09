import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Make a 4 option menu
        System.out.println("1. Ajedréz Nórdico");
        System.out.println("2. Venta de Carros");
        System.out.println("3. Salir");


        // storing cars using ArrayList
        ArrayList<Carro> carros = new ArrayList<Carro>();

        // Make a scanner to get the user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        // Make a switch statement to get the user choice
        switch (choice) {
            case 1:
                System.out.println("Ajedréz Nórdico");

                // Get a random number from 1 to 10
                int randomNumber = (int) (Math.random() * 10) + 1;
                System.out.println("Random number: " + randomNumber);

                // If number is even, player 1 starts
                int player = 0;
                if (randomNumber % 2 == 0) {
                    System.out.println("Empieza el jugador 1");
                    player = 1;
                } else {
                    System.out.println("Empieza el jugador 2");
                    player = 2;
                }

                // Make a 9x9 array with empty spaces
                String[][] board = new String[][] {
                        {" ", " ", " ", "*", "*", "*", " ", " ", " "},
                        {" ", " ", " ", " ", "*", " ", " ", " ", " "},
                        {" ", " ", " ", " ", "+", " ", " ", " ", " "},
                        {"*", " ", " ", " ", "+", " ", " ", " ", "*"},
                        {"*", "*", "+", "+", "R", "+", "+", "*", "*"},
                        {"*", " ", " ", " ", "+", " ", " ", " ", "*"},
                        {" ", " ", " ", " ", "+", " ", " ", " ", " "},
                        {" ", " ", " ", " ", "*", " ", " ", " ", " "},
                        {" ", " ", " ", "*", "*", "*", " ", " ", " "}
                };

                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }

                // Start the game
                while (true) {
                    // Get the user input
                    System.out.print("Enter a row (0 - 8) for player " + player + ": ");
                    int row = input.nextInt();
                    System.out.print("Enter a column (0 - 8) for player " + player + ": ");
                    int column = input.nextInt();

                    // Check if the user input is valid
                    if (row < 0 || row > 8 || column < 0 || column > 8) {
                        System.out.println("Invalid input");
                        continue;
                    }

                    // Check if the user input is already taken
                    if (board[row][column] != " ") {
                        System.out.println("Invalid input");
                        continue;
                    }

                    // Check if the player is 1 or 2
                    if (player == 1) {
                        board[row][column] = "X";
                        player = 2;
                    } else {
                        board[row][column] = "O";
                        player = 1;
                    }

                    // Print the array
                    for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board[i].length; j++) {
                            System.out.print(board[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
            case 2:
               boolean status = true;
               // consuming \n char
               input.nextLine();
               while(status){

                   int userChoice = Menu();

                   switch (userChoice){
                       case 1:
                           System.out.println("Ingrese el VIN: ");
                           String VIN = input.nextLine();
                           System.out.println("Ingrese la marca: ");
                           String marca = input.nextLine();
                           System.out.println("Ingrese el modelo: ");
                           String modelo = input.nextLine();
                           System.out.println("Ingrese el color: ");
                           String color = input.nextLine();
                           System.out.println("Ingrese el año: ");
                           int año = input.nextInt();
                           input.nextLine();

                           carros.add(new Carro(VIN,marca,modelo,color,año));
                           System.out.println("Se ha ingresado el carro exitosamente");
                           break;
                       case 2:
                           System.out.println("Lista de carros: ");
                           ListaCarros(carros);
                           System.out.println("Ingrese índice del carro que quiere modificar: ");
                           int indice = input.nextInt();
                           // catching \n
                           input.nextLine();

                           Carro auto = carros.get(indice);


                           // taking new car attributes in order to modify its original instance
                           System.out.println("Ingrese el VIN: ");
                           String newVIN = input.nextLine();
                           System.out.println("Ingrese la marca: ");
                           String newmarca = input.nextLine();
                           System.out.println("Ingrese el modelo: ");
                           String newmodelo = input.nextLine();
                           System.out.println("Ingrese el color: ");
                           String newcolor = input.nextLine();
                           System.out.println("Ingrese el año: ");
                           int newaño = input.nextInt();
                           // catching \n again
                           input.nextLine();

                           auto.vin = newVIN;
                           auto.marca = newmarca;
                           auto.modelo = newmodelo;
                           auto.color = newcolor;
                           auto.año = newaño;

                           System.out.println("Auto modificado exitosamente");



                           break;
                       case 3:
                           ListaCarros(carros);
                           break;
                       case 4:
                           System.out.println("Lista de carros");
                           ListaCarros(carros);

                           System.out.println("Ingresa el índice del auto que deseas eliminar: ");
                           int removeIndex = input.nextInt();

                           carros.remove(removeIndex);
                           System.out.println("Carro removido exitosamente");

                           break;

                   }

                   // asking user if he wants to leave
                   System.out.println("Desea ingresar otra opción [S/N]: ");
                   String userAnswer = input.nextLine().toUpperCase();

                   if(userAnswer.equals("N")){
                       status = false;
                   }


               }
        }
    }

    public static int Menu(){
        Scanner lector = new Scanner(System.in);
        System.out.println("---- Menú Hermanos Rodríguez ----");
        System.out.println("1. Ingresar un carro");
        System.out.println("2. Modificar un carro");
        System.out.println("3. Leer la lista de carros");
        System.out.println("4. Eliminar un carro");
        System.out.println("Ingrese una opción: ");
        int opc = lector.nextInt();
        // consuming \n char
        lector.nextLine();
        return opc;
    }

    public static void ListaCarros(ArrayList<Carro> carros){
        for(int i = 0; i< carros.size(); i++){
            System.out.printf("Índice : %d\n",i);
            System.out.println(carros.get(i));
        }
        if (carros.size() == 0){
            System.out.println("La lista está vacía");
        }
    }
}