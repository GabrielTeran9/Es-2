import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class App {

public static void main(String[] args) throws Exception {
List<Integer> numeriEstratti = estraiNumeriCasuali();
List<Integer> scheda = generaScheda();
        
System.out.println("Scheda Tombola:");
stampaScheda(scheda);
System.out.println("\nInizio estrazioni...\n");        
int numeriEstrattiCount = 0;
while (!scheda.isEmpty()) {
int numeroEstratto = numeriEstratti.get(numeriEstrattiCount);
System.out.println("Numero estratto: " + numeroEstratto);
if (scheda.contains(numeroEstratto)) {
scheda.remove(Integer.valueOf(numeroEstratto));
System.out.println("Trovato sulla scheda!");
}
stampaScheda(scheda);
    numeriEstrattiCount++;
    if (scheda.isEmpty()) {
    System.out.println("\nTombola! Hai trovato tutti i numeri!");
    }
    try {
        Thread.sleep(1000);
        } 
        catch (InterruptedException e) {
        e.printStackTrace();
        }
        }
    }
    public static List<Integer> estraiNumeriCasuali() {
    List<Integer> numeri = new ArrayList<>();
    for (int i = 1; i <= 90; i++) {
        numeri.add(i);
        }
        Collections.shuffle(numeri);
        return numeri;
    }
    public static List<Integer> generaScheda() {
        List<Integer> numeriScheda = new ArrayList<>();
        Random random = new Random();
        while (numeriScheda.size() < 15) {
            int numero = random.nextInt(90) + 1;
            if (!numeriScheda.contains(numero)) {
                numeriScheda.add(numero);
            }
        }
        return numeriScheda;
    }
    public static void stampaScheda(List<Integer> scheda) {
        System.out.print("Scheda: ");
        for (int i = 0; i < 15; i++) {
            if (scheda.size() > i) {
                System.out.print(scheda.get(i) + " ");
            } else {
                System.out.print("   ");
            }
        }
        System.out.println();
    }
}
