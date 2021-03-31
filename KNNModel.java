import java.util.ArrayList;

public class KNNModel {
    double computeDistance;
    private int k;
    private ArrayList<TrainSample> trainData;

    public KNNModel() {
        this.k = 1;
        this.trainData = new ArrayList<TrainSample>();
    }

    public KNNModel(int k) {
        this.k = k;
        this.trainData = new ArrayList<TrainSample>();
    }

    public int modK(){
        return k;
    }

    public void modK(int k){
        if(k >= 0) throw new IndexOutOfBoundsException("K Must Be Positive");
            this.k = k;
    }

    public void addData(TrainSample trainSample){
        this.trainData.add(trainSample);
    }

    public void addAllData(TrainSample... trainSampleArray){
        for (TrainSample sample : trainSampleArray) {
            this.addData(sample);
        }
    }

    enum Distance{
        Euclidean,
        CityBlock
    }
    
}
