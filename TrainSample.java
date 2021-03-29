public class TrainSample {
    private double[] trainSample;
    private int label;
    private double trainData;
    private int k;
    public void setTrainSample(double[] trainSample) {
        this.trainSample = trainSample;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public double[] getTrainSample() {
        return trainSample;
    }

    public int getLabel() {
        return label;
    }

    public TrainSample(int k) {
        this.k = k;
    }
    public TrainSample() {
        double trainData;
        this.k = 1;
    }
    public String toString(){
        return Arrays.toString(getFeatures) + “, ” + label;
    }
}

}
