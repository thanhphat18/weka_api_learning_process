import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ArffSaver;

import java.io.File;

public class ARFF2CSV {

    public static void main(String[] args) throws Exception {
        //load ARFF file
        ArffLoader loader = new ArffLoader();
        loader.setSource(new File("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/breast-cancer.arff"));
        Instances data = loader.getDataSet();

        //save CSV file
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);
        saver.setFile(new File("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/breast-cancer.csv"));
        saver.writeBatch();
        System.out.println("ARFF file converted to CSV format successfully.");

    }
}