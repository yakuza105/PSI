package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class NeuralCell
{
    /**
     * NeuralCell Ciało
     */
    private List<Double> Dendrites;
    private List<Double> Synapses;

    /**
     * Kontruktor klasy.
     */
    public NeuralCell()
    {
        Dendrites = new ArrayList<>(100);
        Synapses = new ArrayList<>(100);
    }

    /**

     	Dane po obróbce finalnych kalkulacji.
     */

        public double finalizeData(double membranePotential )
        {
            if(membranePotential>=1)
                return 1;
            else
                return 0;
        }


        public double ucz(double x ,double waga , double yneu , double y0czek , double stała){
                waga = waga + stała*(y0czek - yneu) * x;
            return waga;




        }


    /**
     *
     * @return Ilość istniejących dendrytów i synaps.
     */
    public int getInputSize()
    {
        return Dendrites.size();
    }

    /**
     * Dodaje nowe pole wejściowe.
     */
    public void addInput(double cos)
    {
       // Random r = new Random();
       // double randomValue = -1 + (-1 - 0.5) * r.nextDouble();
        double los = ThreadLocalRandom.current().nextDouble(-1.0, 0.5);
       // double los = r.nextDouble();

        Dendrites.add(cos);
        Synapses.add(los);
    }


    public  void edit_synapses (double waga , int index) {
        Synapses.set(index, waga);




    }
    /**

     * @param //count
     */
    public void addInput(double count , int cos)
    {
        for(int i = 1; i <= count; i++){

            this.addInput( cos);
            cos++;
        }

    }

    /**
     * Sprawdza wartość przechowywaną przez określony dendryt.
     * @param index
     * @return Wartość przechowywaną przez dany dendryt.
     */
    public double getInputData(int index)
    {
        return Dendrites.get(index);
    }

    /**
     * Ustawia wartość przechowywaną przez dendryt o określonym indeksie.
     * @param index
     * @param value
     */
    public void setInputData(int index, double value)
    {
        Dendrites.set(index, value);
    }

    /**
     * Sprawdza wagę przechowywaną przez określoną synapsę.
     * @param index
     * @return Wagę przechowywaną przez daną synapsę.
     */
    public double getInputWeight(int index)
    {
        return Synapses.get(index);
    }

    /**
     * Ustawia wartość przechowywaną przez synapsę o określonym indeksie.
     * @param index
     * @param //value
     */
    public void setInputWeight(int index, double weight)
    {
        Synapses.set(index, weight);
    }

    /**
     * Przetwarza przechowywane dane w pojedynczym węźle neuronowym,którym jest dendryt
     * i przypisana do niego synapsa.
     * @param index
     * @return Wynik przetwarzania danych pojedynczego węzła.
     */
    public double processCellNode(int index)
    {
        return (Dendrites.get(index)*Synapses.get(index));
    }

    /**
     * Oblicza potencjał membranowy pojedynczego neuronu.
     * @return Potencjał membranowy lub -1 w przypadku, gdy dane wejściowe nie istnieją.
     */
    public double getMembranePotential()
    {
        if(getInputSize() == 0)
            return -1;

        double sum = 0;
        for (int i = 0; i < getInputSize(); i++)
            sum+=processCellNode(i);

        return sum;
    }

    /**
     * Oblicza wyjście pojedynczego neuronu.
     * @return Obliczone dane wyjściowe neuronu lub -1 w przypadku, gdy dane wejściowe nie istnieją.
     */
   /* public double getOutput()
    {
        if(getInputSize() == 0)
            return -1;

        return finalizeData(getMembranePotential());
    }
    */
}