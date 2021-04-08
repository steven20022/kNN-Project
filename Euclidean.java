import java.math.*;

public class Euclidean implements ComputeDistance {

    @Override
    public double computeDistance(TrainSample Sample, TrainSample tSample) {
        return Math.sqrt(Math.pow(Sample.trainSample[0]-tSample.trainSample[0],2)+Math.pow(Sample.trainSample[1]-tSample.trainSample[1], 2)+Math.pow(Sample.trainSample[2]-tSample.trainSample[2],2)+Math.pow(Sample.trainSample[3]-tSample.trainSample[3],2));
    }

}
