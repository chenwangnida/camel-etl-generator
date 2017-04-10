import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Generator {

	// size of the inputs
	final static int number = 5;
	// bound of name length
	final static int startInclusive_name = 3;
	final static int endExclusive_name = 10;
	// bound of city length
	final static int startInclusive_city = 3;
	final static int endExclusive_city = 10;

	public static void main(String[] args) {
		// initial tool
		GeneratorUtil generatorUtil = new GeneratorUtil();
		HashSet<String> randomlyFirstNameSet = generatorUtil.getRandomlyString(number, startInclusive_name,
				endExclusive_name);
		HashSet<String> randomlyLastNameSet = generatorUtil.getRandomlyString(number, startInclusive_name,
				endExclusive_name);
		HashSet<String> randomlyCitySet = generatorUtil.getRandomlyString(number, startInclusive_city,
				endExclusive_city);
		// transfer set to list
		List<String> randomlyFirstNameList = new ArrayList<String>(randomlyFirstNameSet);
		List<String> randomlyLastNameList = new ArrayList<String>(randomlyLastNameSet);
		List<String> randomlyCityList = new ArrayList<String>(randomlyCitySet);

		//initial instances of PersonDocument
		for (int i = 0; i < number; i++) {
			PersonDocument personDocument = new PersonDocument();
			personDocument.setUser(randomlyFirstNameList.get(i));
			personDocument.setFirstName(randomlyFirstNameList.get(i));
			personDocument.setLastName(randomlyLastNameList.get(i));
			personDocument.setCity(randomlyCityList.get(i));
			generateInput(number, personDocument);
		}
	}


	private static void generateInput(int number, PersonDocument personDocument) {

		try {

			File file = new File("inputs/row" + number + ".xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(PersonDocument.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(personDocument, file);
			jaxbMarshaller.marshal(personDocument, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
