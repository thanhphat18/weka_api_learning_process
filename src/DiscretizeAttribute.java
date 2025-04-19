/*
 * Discretized Dataset
Discretization is the process of converting continuous numeric attributes into nominal (categorical) ones.
Example:
Instead of Age = 47, we might have Age = 40-49.
This technique is useful for algorithms that perform better with categorical data or for improving interpretability.
 */
import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;

public class DiscretizeAttribute {
    public static void main(String[] args) throws Exception {
        // Load the dataset
        DataSource source = new DataSource("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/breast-cancer-sparse.arff");
        Instances dataset = source.getDataSet();
        //set options 
        String[] opts = new String[5];
        //choose the number of intervals
        opts[0] = "-B"; opts[1]= "4";
        //Choose the range of attrbutes on which apply the filter
        opts[2] = "-R"; opts[3] = "first-last";
        opts[4] = "-V"; 
        //apply discretization
        Discretize discretize = new Discretize();
        discretize.setOptions(opts);
        discretize.setInputFormat(dataset);
        Instances newData = Filter.useFilter(dataset, discretize);

        ArffSaver saver = new ArffSaver();
        saver.setInstances(newData);
        saver.setFile(new File("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/breast-cancer-discretized.arff"));
        saver.writeBatch();
    }
}
