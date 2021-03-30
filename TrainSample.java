import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainSample {
    Scanner scanner = new Scanner(System.in);
    private double[] trainSample;
    private int label;
    private double trainData;
    TrainSample trainSample = new TrainSample(trainData, label);
    private int k;
    System.out.println(trainSample);

    public TrainSample(int k) {
        this.k = k;
    }

    public TrainSample() {
        double trainData;
        this.k = 1;
    }


    public double[] getTrainSample() {
        return trainSample;
    }

    public void setTrainSample(double[] trainSample) {
        this.trainSample = trainSample;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }


    private ArrayList<trainData> sampleReader(String filename) {
        ArrayList<trainData> samples = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner inputFile = new Scanner(file);
            inputFile.nextLine();
            while (inputFile.hasNext()) {
                String str = inputFile.nextLine();
                String[] values = str.split(",");
                trainData sample = new trainData(Double.parseDouble(values[0]), Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), Integer.parseInt(values[4]));
                samples.add(sample);
            }
            inputFile.close();
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getStackTrace());
        }
        return samples;
    }


    public String toString() {
        return Arrays.toString(getFeatures) + “, ”+label;
    }

    public ArrayList<trainData> getSamples() {
        return samples;
    }

    class trainData {
        private double redData;
        private double violetData;
        private double greenData;
        private double beigeData;
        private int limeData;

        public trainData() {
            redData = 0.0;
            violetData = 0.0;
            greenData = 0.0;
            beigeData = 0.0;
            limeData = 0;
        }

        public trainData(double redData, double violetData, double greenData, double beigeData, int limeData) {
            this.redData = redData;
            this.violetData = violetData;
            this.greenData = greenData;
            this.beigeData = beigeData;
            this.limeData = limeData;
        }

        public double getRedData() {
            return redData;
        }

        public void setRedData(double redData) {
            this.redData = redData;
        }

        public double getVioletData() {
            return violetData;
        }

        public void setVioletData(double violetData) {
            this.violetData = violetData;
        }

        public double getGreenData() {
            return greenData;
        }

        public void setGreenData(double greenData) {
            this.greenData = greenData;
        }

        public double getBeigeData() {
            return beigeData;
        }

        public void setBeigeData(double beigeData) {
            this.beigeData = beigeData;
        }

        public double getLimeData() {
            return redData;
        }

        public void setLimeData(int limeData) {
            this.limeData = limeData;
        }
    }

    class collectionOfData {
        int input = scanner.nextInt();
        private ArrayList<trainData> samples;

        public collectionOfData() {
            System.out.println("Please select data set, enter one for iris and two for iris_test.: ");
            if (input == 1) {
                samples = sampleReader("C:\\Users\\TrMaC\\IdeaProjects\\KNNproject\\src\\iris.csv");
            } else
                samples = sampleReader("C:\\Users\\TrMaC\\IdeaProjects\\KNNproject\\src\\iris_test.csv");

        }
    }

}


