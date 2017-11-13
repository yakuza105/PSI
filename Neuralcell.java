package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.exp;


class NeuralCell {

    private List<Double> dendrites;
    private List<Double> synapses = new ArrayList<>(20);


    public NeuralCell(List<Double> synapses) {
        this.synapses = synapses ;
       dendrites = new ArrayList<>(20);
    }


    public double finalizeData(double membranePotential) {
        return 1 / (1 + exp(-membranePotential));
    }


    public double ucz(double x, double waga, double yneu, double y0czek, double wspUczenia) {
        waga += x * (y0czek - yneu) * wspUczenia;
        return waga;
    }


    public int getInputSize() {
        return dendrites.size();
    }


    public void addInput(double cos) {
        dendrites.add(cos);
    }

    public void newIn(int index, double cos) {

        dendrites.add(index,cos);
    }


    public void edit_synapses(double waga, int index) {
        synapses.set(index, waga);
    }


    public void addInput(double count, double cos) {
        for (int i = 1; i <= count; i++) {

            this.addInput(cos);
            cos++;
        }

    }



    public double getInputData(int index) {
        return dendrites.get(index);
    }


    public void setInputData(int index, double value) {
        dendrites.set(index, value);
    }


    public double getInputWeight(int index) {
        return synapses.get(index);
    }


    public void setInputWeight(int index, double weight) {
        synapses.set(index, weight);
    }


    public double processCellNode(int index) {
        return (dendrites.get(index) * synapses.get(index));
    }


    public double getMembranePotential() {
        if (getInputSize() == 0)
            return -1;

        double sum = 0;
        for (int i = 0; i < getInputSize(); i++)
            sum += processCellNode(i);

        return sum;
    }


}