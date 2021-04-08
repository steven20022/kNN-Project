import java.math.*;

public class CityBlock implements ComputeDistance {

    @Override
    public double computeDistance(TrainSample Sample, TrainSample tSample) {
        return Math.abs((Sample.trainSample[0]-tSample.trainSample[0])+(Sample.trainSample[1]-tSample.trainSample[1])+(Sample.trainSample[2]-tSample.trainSample[2])+(Sample.trainSample[3]-tSample.trainSample[3]));
    }

}
