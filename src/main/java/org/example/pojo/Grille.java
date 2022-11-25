package org.example.pojo;

import java.lang.reflect.Array;

public class Grille {

    public String[][] maGrille;

    public String[][] saGrille;

    public Integer dimension;

    public Integer attaquereussie = 0;




    public Grille(int dimension) {
        this.dimension = dimension;
        maGrille = new String[dimension][dimension];
        saGrille = new String[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                maGrille[i][j] = " x ";
                saGrille[i][j] = " x ";
            }
        }
    }

    public void showGrid() {
        System.out.print("\n \n");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print("| " + maGrille[i][j]+ " ");
            }
            System.out.print("| \n");
        }
    }

    public void attack(int abscisse, int ordonne){
        if (maGrille[abscisse][ordonne] != " x "){
            maGrille[abscisse][ordonne] = ": :";
            attaquereussie += 1;
        } else {
            System.out.println("raté");
        }
    }

    public boolean check(int abscisse, int ordonne) {
        boolean result = false;
        if (maGrille[abscisse][ordonne] == " x ") {
            result = true;
        }
        return result;
    }

    public Integer getAttaquereussie() {
        return attaquereussie;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public void addBateau(Bateau bateau, int x, int y, int postionnement){
        if (postionnement == 0) { //vertical
            for (int i = x; i < bateau.getTaille() + x; i++) {
                maGrille[i][y] = bateau.getSurnom() + " ";
            }
        } else if (postionnement == 1) { //horizontal
            for (int i = y; i < bateau.getTaille() + y; i++) {
                maGrille[x][i] = bateau.getSurnom() + " ";
            }
        }
    }

    public boolean checkPositionnement(Bateau bateau, int x, int y, int postionnement){
        boolean result = false;
        if (postionnement == 0 && bateau.getTaille() + x < dimension){
            result = true;
            for (int i = x; i < bateau.getTaille() + x; i++) {
                if (maGrille[i][y] != " x "){
                    result = false;
                    break;
                }
            }
        } else if (postionnement == 1 && bateau.getTaille() + y < dimension) {
            result = true;
            for (int i = y; i < bateau.getTaille() + y; i++) {
                if (maGrille[x][i] != " x "){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }


}

