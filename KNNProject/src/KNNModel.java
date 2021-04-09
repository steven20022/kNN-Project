package KNNProject.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KNNModel {
    double computeDistance;
    private int k;
    public TrainSample[] trainData = {};
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

    /*
    public void addAllDBData(){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase Samples = mongoClient.getDatabase("samples");

        Samples.find()
        .forEach(doc -> {
            double[] tSample = {doc.sample_dimensions_d0,doc.sample_dimensions_d1, doc.sample_dimensions_d2, doc.sample_dimensions_d3};
            addData(new TrainSample(tSample, doc.sample_label));});

    }*/

    public void addAllFromFile(String dir) throws FileNotFoundException{
        File file = new File(dir);
        Scanner s;
        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        while(s.hasNextLine()){
            String line = s.nextLine();
            String[] arr = line.split(",");
            double[] tSamplearr = new double[arr.length-1];
            for (int i = 0; i < tSamplearr.length; i++) {
                tSamplearr[i] = Double.parseDouble(arr[i]);
            }
            addData(new TrainSample(tSamplearr, Integer.parseInt(arr[arr.length-1])));
            System.out.println(new TrainSample(tSamplearr, Integer.parseInt(arr[arr.length-1])).toString());
        }
        s.close();
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
    
    public int predict(TrainSample sample, TrainSample[] data) throws Exception{
        for (int i = 0; i < data.length; i++) {
            data[i].distance = distance.computeDistance(sample, data[i]);
        }
        data = OrderList(data);
        TrainSample[] Kdata = new TrainSample[this.k];
        for (int i = 0; i < this.k; i++) {
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

    public int[] predict(TrainSample[] sample, TrainSample[] data) throws Exception{
        int[] predictArr = new int[sample.length];
        int i = 0;
        for (TrainSample sTrainSample : sample) {
            predictArr[i] = predict(sTrainSample, data);
            i++;
        }
        return predictArr;
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
