package KNNProject.src;

import java.util.Scanner;

public class KNNFactory {
    public static KNNModel createKnnModel(KNNModel.Distance d, int k) {
        KNNModel newModel = new KNNModel(k);
        newModel.chooseDistacnce(d);
        return newModel;
    }

    public static void main(String[] args) {
        KNNModel Model = createKnnModel(KNNModel.Distance.Euclidean, 5);
        try {
            Model.addAllFromFile(new Scanner(System.in).next());
            System.out.println(Model.predict(Model.trainData[20], Model.trainData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
