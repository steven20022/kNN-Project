public class KNNModel {
    double computeDistance;
    private int k;
    private TrainSample[] trainData = {};
    ComputeDistance distance;

    public KNNModel() {
        this.k = 1;
    }

    public KNNModel(int k) {
        this.k = k;
    }

    public int modK(){
        return k;
    }

    public void modK(int k){
        if(k >= 0) throw new IndexOutOfBoundsException("K Must Be Positive");
            this.k = k;
    }

    public void addData(TrainSample trainSample){
        TrainSample[] temp = new TrainSample[this.trainData.length+1];
        int i = 0;
        for (TrainSample sample : trainData) {
            temp[i]=sample;
            i++;
        }
        temp[i]=trainSample;
        this.trainData=temp;
    }

    public void addAllData(TrainSample[] trainSampleArray){
        for (TrainSample sample : trainSampleArray) {
            this.addData(sample);
        }
    }

    enum Distance{
        Euclidean,
        CityBlock
    }

    public void chooseDistacnce(Distance d){
        switch (d) {
            case Euclidean:
                    this.distance = new Euclidean();
                break;
            
            case CityBlock:
                    this.distance = new CityBlock();
                break;
        
            default:
                break;
        }
    }
    
    public int perdict(TrainSample sample, TrainSample[] data) throws Exception{
        for (int i = 0; i < data.length; i++) {
            data[i].distance = distance.computeDistance(sample, data[i]);
        }
        data = OrderList(data);
        TrainSample[] Kdata = new TrainSample[this.k];
        for (int i = 0; i < k-1; i++) {
            Kdata[i] = data[i];
        }
        int a = 0; int b = 0; int c = 0;
        for (TrainSample kSample : Kdata) {
            switch (kSample.label) {
                case 1:
                    a++;
                    break;
                
                case 2:
                    b++;
                    break;

                case 3:
                    c++;
                    break;
                
                default:
                    break;
            }
        }
        if (a > b && a > c) {
            return 1;
        } else if (b > a && b > c) {
            return 2;
        } else if (c > b && c > a) {
            return 3;
        }else {
            throw new Exception();
        }
    }

    public TrainSample[] OrderList(TrainSample[] array){
        int count = array.length;
        TrainSample temp;
        for (int i = 0; i < count; i++) 
        {
            for (int j = i + 1; j < count; j++) { 
                if (array[i].distance > array[j].distance) 
                {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
