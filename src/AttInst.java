import weka.core.AttributeStats;
import weka.core.Instances;
import weka.core.Instance;
import weka.core.converters.ConverterUtils.DataSource;
import weka.experiment.Stats;

public class AttInst {
    public static void main(String[] args) throws Exception {
        //load dataset
        DataSource source = new DataSource("/Users/thanhphatchau/Documents/Projects/DataMiningProject/weka_api/dataset/cleaned_data_atrrfilter.arff");
        //get instances objt
        Instances data = source.getDataSet();
        //set class index..as the last attribute
        if(data.classIndex() == -1) {
            data.setClassIndex(data.numAttributes() - 1);
        }
        //get number of attributes (notice class is not counter 
        int numAttr = data.numAttributes()-1;
        for (int i = 0; i < numAttr; i++){
            //check if attribute is nominal
            if(data.attribute(i).isNominal()){
                System.out.println("The"+i+"th attribute is Nominal");
                //get number of values
                int n = data.attribute(i).numValues();
                System.out.println("The"+i+"th attribute has "+n+" values");
            }
            //get an AttributeStats object
            AttributeStats as = data.attributeStats(i);
            int dC = as.distinctCount;
            System.out.println("The"+i+"th attribute has "+dC+" distinct values");

            //get a Stats object from the attributeStats object
            if (data.attribute(i).isNumeric()){
                System.out.println("The"+i+"th attribute is Numeric");
                Stats s = as.numericStats;
                System.out.println("The"+i+"th attribute has min value: "+s.min+" and max value: "+s.max+"and mean value: "+s.mean+" and std deviation: "+s.stdDev);
            }
        }

        //get number of instances
        int numInst = data.numInstances();
        //loop through all instances
        for (int j = 0;j < numInst; j++){
            //get the jth instances
            Instances instance = (Instances) data.instance(j);
            //check if instance is missing
            if(((Instance) instance).isMissing(0)){
                System.out.println("The"+0+"th Attribute is missing");
            }
            //check if the class is missing from the j'th instnace
            if(((Instance) instance).classIsMissing()){
                System.out.println("The class is missing from the"+j+"th instance");
            }
            //if you want to access the value of class in your data
            //notice classes of type nominal and string are given ID's
            double cV = ((Instance) instance).classValue();
            System.out.println(instance.classAttribute().value((int)cV));
        }
        
    }
}
