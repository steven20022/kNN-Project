package KNNProject.src;

public class TrainSample {
    double[] trainSample;
    int label;
    double distance=-1;
    int plabel=-1;

    public TrainSample(double[] trainSample, int label) {
        this.trainSample = trainSample;
        this.label = label;
    }

    public String toString() {
        return this.trainSample.toString() + "," + this.label;
    }
}


