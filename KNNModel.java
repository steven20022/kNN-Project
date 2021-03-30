import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class KNNModel {
    double computeDistance;
    private int k;
    private Collection trainData = new ArrayList();

    public KNNModel() {
        k = 1;
    }

    public KNNModel(int k) {
        this.k = k;
    }


    public enum Distance(ComputeDistance) {

    }
}
