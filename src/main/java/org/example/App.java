package org.example;

import org.example.pojo.Bateau;
import org.example.pojo.Grille;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static int J1 = 0;
    private static int J2 = 1;
    private static int J;
    private static int X = 0;
    private static int Y = 0;

    public static void main( String[] args )
    {
        J = J1;
        Grille maGrille = new Grille(10);
        Grille saGrille = new Grille(10);
        Bateau cr = new Bateau("Croiseur", 4, "cr");
        Bateau pa = new Bateau("Porte-avion", 5, "pa");
        Bateau ct = new Bateau("Contre-torpilleur", 3, "ct");
        Bateau to = new Bateau("Torpilleur", 2, "to");
        Bateau sm = new Bateau("Sous-marin", 1, "sm");
        List<Bateau> bateaux = new ArrayList<Bateau>();
        bateaux.add(cr);
        bateaux.add(pa);
        bateaux.add(ct);
        bateaux.add(to);
        bateaux.add(sm);
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            boolean continuer = false;
            while (!continuer) {
                int rabscisse = random.nextInt(maGrille.getDimension());
                int rordonne = random.nextInt(maGrille.getDimension());
                int rpositionnement = (int) Math.round(Math.random());
                if (maGrille.checkPositionnement(bateaux.get(i), rabscisse, rordonne, rpositionnement)){
                    maGrille.addBateau(bateaux.get(i), rabscisse, rordonne, rpositionnement);
                    break;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            boolean continuer = false;
            while (!continuer) {
                int rabscisse = random.nextInt(saGrille.getDimension());
                int rordonne = random.nextInt(saGrille.getDimension());
                int rpositionnement = (int) Math.round(Math.random());
                if (saGrille.checkPositionnement(bateaux.get(i), rabscisse, rordonne, rpositionnement)){
                    saGrille.addBateau(bateaux.get(i), rabscisse, rordonne, rpositionnement);
                    break;
                }
            }
        }
        System.out.println("grille joueur 1");
        maGrille.showGrid();
        System.out.println("grille joueur 2");
        saGrille.showGrid();
        boolean vrai = true;
        int nombre1 = 0;
        int nombre2 = 0;
        while (vrai){
            while (X < maGrille.getDimension() || X > 0 || Y < maGrille.getDimension() || Y >0 ){
                if (J == J1){
                    System.out.println("Tour de Joueur 1 :");
                } else {
                    System.out.println("Tour de Joueur 2 :");
                }
                System.out.println("entrez l'abscisse : ");
                Scanner coord = new Scanner(System.in);
                X = coord.nextInt();
                System.out.println("entrez l'ordonnée : ");
                Y = coord.nextInt();
                if (X > maGrille.getDimension() || X < 0 || Y > maGrille.getDimension() || Y <0 ){
                    System.out.println("les coordonnées doivent être comprises entre 0 et 9!");
                } else {
                    if (J == J1) {
                        for (int i = 0; i < bateaux.size() ; i++) {
                            if (saGrille.maGrille[Y][X] == bateaux.get(i).getSurnom()){
                                System.out.println("vous avez touché un " + bateaux.get(i).getName());
                            }
                        }
                        saGrille.attack(Y, X);
                        nombre2++;
                        saGrille.showGrid();
                        J = J2;
                    } else if (J == J2) {
                        for (int i = 0; i < bateaux.size() ; i++) {
                            if (maGrille.maGrille[Y][X] == bateaux.get(i).getSurnom()){
                                System.out.println("vous avez touché un " + bateaux.get(i).getName());
                            }
                        }
                        maGrille.attack(Y, X);
                        nombre1++;
                        maGrille.showGrid();
                        J = J1;
                    }
                }
            } if (nombre1 == 15){
                System.out.println("Joueur 2 a gagné!");
            } else if (nombre2 == 15){
                System.out.println("Joueur 1 a gagné!");
            }
        }
    }
}

