package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class NeuralCell
{

    private List<Double> Dendrites;
    private List<Double> Synapses;


    public NeuralCell()
    {
        Dendrites = new ArrayList<>(100);
        Synapses = new ArrayList<>(100);
    }


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


    public int getInputSize()
    {
        return Dendrites.size();
    }


    public void addInput(double cos)
    {

        double los = ThreadLocalRandom.current().nextDouble(-1.0, 0.5);


        Dendrites.add(cos);
        Synapses.add(los);
    }


    public  void edit_synapses (double waga , int index) {
        Synapses.set(index, waga);




    }


    public void addInput(double count , int cos)
    {
        for(int i = 1; i <= count; i++){

            this.addInput( cos);
            cos++;
        }

    }


    public double getInputData(int index)
    {
        return Dendrites.get(index);
    }


    public void setInputData(int index, double value)
    {
        Dendrites.set(index, value);
    }


    public double getInputWeight(int index)
    {
        return Synapses.get(index);
    }


    public void setInputWeight(int index, double weight)
    {
        Synapses.set(index, weight);
    }


    public double processCellNode(int index)
    {
        return (Dendrites.get(index)*Synapses.get(index));
    }


    public double getMembranePotential()
    {
        if(getInputSize() == 0)
            return -1;

        double sum = 0;
        for (int i = 0; i < getInputSize(); i++)
            sum+=processCellNode(i);

        return sum;
    }


}