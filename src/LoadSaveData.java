import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;

public class LoadSaveData {
    public static void main(String[] args) throws Exception {
        DataSource source = new DataSource("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/breast-cancer.arff");
        Instances dataset = source.getDataSet();

        System.out.println(dataset.toSummaryString());

        // Save the dataset
        ArffSaver saver = new ArffSaver();
        saver.setInstances(dataset);
        saver.setFile(new File("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/new_source.arff"));
        saver.writeBatch();

    }
    
}
