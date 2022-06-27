package lab7;
public class ModelTest {

    public static void main(String[] args) {
	MarkovModel model = new MarkovModel(5, "SampleTextFiles/FoxInSocks.txt");
	model.printModel();
    }
}
