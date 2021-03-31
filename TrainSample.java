
public class TrainSample {
    private double[] trainSample;
    private int label;

    public TrainSample(double[] trainSample, int label) {
        this.trainSample = trainSample;
        this.label = label;
    }

    public String toString() {
        return this.trainSample + "," + this.label;
    }
}


