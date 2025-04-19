/*
 * the zero-value attributes are omitted
 * only the non-zero attributes are stored by explicitly stating their attribute number and value
 * ex: (1,1,0,1,0,0,0,0,0,1,3.20} -> (0,1)(3,1)(9,1)(10,3.20) (positional index, value)
 * 
 */

import java.io.File;
import weka.filters.Filter;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.instance.NonSparseToSparse;

public class Sparse {

    public static void main(String[] args) throws Exception {
        //load dataset
        DataSource source = new DataSource("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/breast-cancer.arff");
        Instances dataset = source.getDataSet();
        //create NonSparseToSparse object to save in sparse arff format
        NonSparseToSparse sparse = new NonSparseToSparse();
        sparse.setInputFormat(dataset);

        //specify dataset
        sparse.setInputFormat(dataset);
        Instances newData = Filter.useFilter(dataset, sparse);
        //save
        ArffSaver saver = new ArffSaver();
        saver.setInstances(newData);
        saver.setFile(new File("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/breast-cancer-sparse.arff"));
        saver.writeBatch();

        
    }
}
