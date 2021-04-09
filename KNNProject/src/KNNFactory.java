package KNNProject.src;

public class KNNFactory {
    public static KNNModel createKnnModel(KNNModel.Distance d, int k) {
        KNNModel newModel = new KNNModel(k);
        newModel.chooseDistacnce(d);
        return newModel;
    }
}
