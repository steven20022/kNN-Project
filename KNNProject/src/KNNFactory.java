package KNNProject.src;

public class KNNFactory {
    public static KNNModel createKnnModel(KNNModel.Distance d, int k) {
        KNNModel newModel = new KNNModel(k);
        newModel.chooseDistacnce(d);
        return newModel;
    }

    public static void main(String[] args) {
        KNNModel Model = createKnnModel(KNNModel.Distance.Euclidean, 5);
        try {
            Model.addAllFromFile("C:\\\\Users\\jacob\\Desktop\\Programming\\kNN-Project\\KNNProject\\src\\iris.csv");
            System.out.println(Model.predict(Model.trainData[0], Model.trainData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
