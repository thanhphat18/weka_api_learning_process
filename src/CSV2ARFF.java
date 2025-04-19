import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import java.io.File;

public class CSV2ARFF {
    public static void main(String[] args) throws Exception {
        //load CSV file
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/cleaned_data.csv"));
        Instances data = loader.getDataSet();

        //save ARFF file
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);
        saver.setFile(new File("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/cleaned_data_inARFF.arff"));
        saver.writeBatch();
        System.out.println("CSV file converted to ARFF format successfully.");
    }
    
}
