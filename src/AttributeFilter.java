import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class AttributeFilter {
    public static void main(String[] args) throws Exception {
        //load dataset
        DataSource source = new DataSource("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/cleaned_data_inARFF.arff");
        Instances dataset = source.getDataSet();

        //use a simple filter to remove a certain attribute
        //set up options to remove 2nd attribute
        String[] opts = new String[]{"-R", "2"};
        //create a remove obj 
        Remove remove = new Remove();
        //set filter options
        remove.setOptions(opts);
        //set the input format
        remove.setInputFormat(dataset);
        Instances newData = Filter.useFilter(dataset, remove);

        ArffSaver save = new ArffSaver();
        save.setInstances(newData);
        save.setFile(new File("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/cleaned_data_atrrfilter.arff"));
        save.writeBatch();


    }
}
