package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static  double p = 0.0025;
    private static double tabA[] = {0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1};
    private static double tabB[] = {1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0};
    private static double tabC[] = {0,1,1,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0};
    private static double tabD[] = {1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0};
    private static double tabE[] = {1,1,1,1,1,0,0,0,1,1,1,1,1,0,0,0,1,1,1,1};
    private static double tabF[] = {1,1,1,1,1,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0};
    private static double tabG[] = {1,1,1,1,1,0,0,0,1,0,1,1,1,0,0,1,1,1,1,1};
    private static double tabH[] = {1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1};
    private static double tabT[] = {1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0};
    private static double tabL[] = {1, 0, 0 ,0 ,1, 0 , 0 ,0 ,1 ,0 ,0 ,0, 1, 0, 0, 0, 1, 1, 1, 1};
    private static double tabl[] = {1, 0, 0 ,0 ,1, 0 , 0 ,0 ,1 ,0 ,0 ,0, 1, 0, 0, 0, 1, 1, 0, 0};
    private static double tabt[] = {0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0};
    private static double tabh[] = {1, 0, 0 ,0 ,1, 0 , 0 ,0 ,1 ,1 ,1 ,0, 1, 0, 1, 0, 1, 0, 1, 0};
    private static double tabd[] = {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0};
    private static double tabc[] = {0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0,1,1,1,0};
    private static double tabf[] = {0,1,1,1,0,1,0,0,1,1,1,0,0,1,0,0,0,1,0,0};
    private static double tabi[] = {0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0};
    private static double tabu[] = {0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,1,1};
    private static double tabx[] = {0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,1,0,1};
    private static double tabn[] = {0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,1,0,1,0,1};

//testowe
private static double tabr[] = {0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,0,1,0,0};
private static double tabo[] = {0,0,0,0,0,0,0,0,1,1,1,0,1,0,1,0,1,1,1,0};
    private static double tabO[] = {1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1};
    private static double tabP[] = {1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0};










    private static double taby[] = {0, 0,0,0};
    public static void main(String[] args) {
        int k = 20;
        int liczbaliter = 4;
        int lneuronów = 2;


        List<NeuralCell> neuronList = new ArrayList<>();
        List<Double> wagiNeuronu;
        for (int i = 0; i < lneuronów; i++) {
            wagiNeuronu = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                double losowa = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
                wagiNeuronu.add(losowa);
            }
            neuronList.add(new NeuralCell(wagiNeuronu));
        }


        wpiszwejscie(neuronList, tabA);
        wypiszOutputLiter("przed", neuronList);

        for (int i = 0; i < 2000; i++) {

            taby[0] = 1;
            taby[1] = 0;
            zmienwejscie(neuronList, tabA);
            lernmore(neuronList, tabA, taby, p, k);
            zmienwejscie(neuronList, tabB);
            lernmore(neuronList, tabB, taby, p, k);
            zmienwejscie(neuronList, tabC);
            lernmore(neuronList, tabC, taby, p, k);
            zmienwejscie(neuronList, tabD);
            lernmore(neuronList, tabD, taby, p, k);
            zmienwejscie(neuronList, tabE);
            lernmore(neuronList, tabE, taby, p, k);
            zmienwejscie(neuronList, tabF);
            lernmore(neuronList, tabF, taby, p, k);
            zmienwejscie(neuronList, tabG);
            lernmore(neuronList, tabG, taby, p, k);
            zmienwejscie(neuronList, tabH);
            lernmore(neuronList, tabH, taby, p, k);
            zmienwejscie(neuronList, tabL);
            lernmore(neuronList, tabL, taby, p, k);
            zmienwejscie(neuronList, tabT);
            lernmore(neuronList, tabT, taby, p, k);


            taby[0] = 0;
            taby[1] = 1;
            zmienwejscie(neuronList, tabc);
            lernmore(neuronList, tabc, taby, p, k);
            zmienwejscie(neuronList, tabd);
            lernmore(neuronList, tabd, taby, p, k);
            zmienwejscie(neuronList, tabh);
            lernmore(neuronList, tabh, taby, p, k);
            zmienwejscie(neuronList, tabt);
            lernmore(neuronList, tabt, taby, p, k);
            zmienwejscie(neuronList, tabl);
            lernmore(neuronList, tabl, taby, p, k);
            zmienwejscie(neuronList, tabi);
            lernmore(neuronList, tabi, taby, p, k);
            zmienwejscie(neuronList, tabn);
            lernmore(neuronList, tabn, taby, p, k);
            zmienwejscie(neuronList, tabf);
            lernmore(neuronList, tabf, taby, p, k);
            zmienwejscie(neuronList, tabx);
            lernmore(neuronList, tabx, taby, p, k);
            zmienwejscie(neuronList, tabu);
            lernmore(neuronList, tabu, taby, p, k);


        }

//test
        zmienwejscie(neuronList, tabr);
        wypiszOutputLiter("mała", neuronList);
        zmienwejscie(neuronList, tabo);
        wypiszOutputLiter("mała", neuronList);



        zmienwejscie(neuronList, tabP);

        wypiszOutputLiter("duza", neuronList);
        zmienwejscie(neuronList, tabO);

        wypiszOutputLiter("duza", neuronList);


    }

    public static void wypiszOutputLiter(String litera, List<NeuralCell> x) {
        System.out.println("Literka: "+litera);
        System.out.println("Duża litera:" + x.get(0).finalizeData(x.get(0).getMembranePotential()) + "\n");
        System.out.println("Mała litera:" + x.get(1).finalizeData(x.get(1).getMembranePotential()) + "\n");
       // System.out.println("C:" + x.get(2).finalizeData(x.get(2).getMembranePotential()) + "\n");
        //System.out.println("D:" + x.get(3).finalizeData(x.get(3).getMembranePotential()) + "\n");
    }


    public static void wpiszwejscie(List<NeuralCell> x ,double[] tab ) {


        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < x.size(); i++) {
                x.get(i).newIn(j, tab[j]);
            }


        }
    }
    public static void zmienwejscie(List<NeuralCell> x ,double[] tab ){



        for (int j = 0; j <20; j++) {
            for (int i = 0; i <x.size() ; i++) {
                x.get(i).setInputData(j,tab[j]);
            }



        }



    }

    public static void lernmore(List<NeuralCell> x,double[] tab,double[] y,double p ,double roz){
        for (int j = 0; j < roz; j++) {
        for (int i = 0; i <x.size() ; i++) {

                x.get(i).edit_synapses(x.get(i).ucz(tab[j],x.get(i).getInputWeight(j),x.get(i).finalizeData(x.get(i).getMembranePotential()),y[i],p),j);
            }
        }





    }

    public static void rysuj(double[] tab ){
        System.out.print("\n");
        int k = 0 ;
        for (int i = 0; i <5 ; i++) {

            System.out.print("");
            for (int j = 0; j <4 ; j++) {
                if(tab[k]>0){
                    System.out.print("*");

                }
                else {
                    System.out.print(" ");
                }
                k++;


            }
            System.out.print("\n");

        }

        System.out.print("\n");

    }


}

