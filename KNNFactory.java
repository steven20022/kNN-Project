public class KNNFactory {
    public static KNNModel createKnnModel(KNNModel.Distance d, int k) {
        return new KNNModel(k);
    }
}
