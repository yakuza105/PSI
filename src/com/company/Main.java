package com.company;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        int k = 4;

        NeuralCell neuron = new NeuralCell();
        double tabx1[] = new double[k];
        double tabx2[] = new double[k];
        double taby[] = new double[k];
        double  w1, w2;

        tabx1[0] =0 ;
        tabx2[0]=0;
        tabx1[1] =1 ;
        tabx2[1]=0;
        tabx1[2] =0 ;
        tabx2[2]=1;
        tabx1[3] =1;
        tabx2[3]=1;

        for(int i =0 ; i<4 ; i++){
            taby[i]= tabx1[i]+tabx2[i];
            if(taby[i] >= 2){
                taby[i] = 1;
            }
            else
                taby[i] = taby[i];


        }




        neuron.addInput(tabx1[0]);
        neuron.addInput(tabx2[0]);

        for (int i = 0; i < k; i++) {
            neuron.setInputData(0, tabx1[i]);
            neuron.setInputData(1, tabx2[i]);



             System.out.println("synapsa 1:" + neuron.getInputWeight(0)+ "\n");

             System.out.println("synapsa 2:" + neuron.getInputWeight(1)+ "\n");

            System.out.println("powinno byc :" + taby[i] + "\n");
            int licznik = 0;
            while (neuron.getMembranePotential() - taby[i]> 0.00001 || neuron.getMembranePotential() -taby[i] <= -   0.0001) {
                licznik++;


                w1 = neuron.ucz(tabx1[i], neuron.getInputWeight(0), neuron.getMembranePotential(), taby[i], 0.1);
                w2 = neuron.ucz(tabx2[i], neuron.getInputWeight(1), neuron.getMembranePotential(), taby[i], 0.1);

                neuron.edit_synapses(w1, 0);
                neuron.edit_synapses(w2, 1);
                neuron.getMembranePotential();



            }
            if (licznik < 4 && licznik != 0)
                i = k + 1;
            System.out.println("licznik :" + licznik + "\n");



            System.out.println("ptencjał :" + neuron.getMembranePotential() + "\n");
        }
        System.out.println("synapsa 1:" + neuron.getInputWeight(0) + "\n");

        System.out.println("synapsa 2:" + neuron.getInputWeight(1) + "\n");

        double xa = 0;
         double xb = 1;
        neuron.setInputData(0, xa);
        neuron.setInputData(1, xb);
        System.out.println("powinno byc :" + 0 +"\n");
        System.out.println("ptencjał :" + neuron.finalizeData(neuron.getMembranePotential()) + "\n");

    }
}

