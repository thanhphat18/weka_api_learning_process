import java.io.File;

import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;

public class AttrSelection {
    public static void main(String[] args) throws Exception {
        //Load dataset
        DataSource source = new DataSource("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/breast-cancer.arff");
        Instances dataset = source.getDataSet();
        //create AttributeSelection object
        AttributeSelection filter = new AttributeSelection();
        //create evaluator and search algorithms objs
        CfsSubsetEval eval = new CfsSubsetEval();
        GreedyStepwise search = new GreedyStepwise();
        //set the algorithms to search backward
        search.setSearchBackwards(true);
        //set filter to use eval and search algo
        filter.setEvaluator(eval);
        filter.setSearch(search);
        //specify the dataset
        filter.setInputFormat(dataset);
        //apply the filter
        Instances newData = Filter.useFilter(dataset, filter);
        //save
        ArffSaver saver = new ArffSaver();
        saver.setInstances(newData);
        saver.setFile(new File("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/breast-cancer-selected.arff"));
        saver.writeBatch();


    }

}
