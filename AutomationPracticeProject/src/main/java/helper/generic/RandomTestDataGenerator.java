package helper.generic;

import java.util.Locale;

import com.github.javafaker.Faker;

public class RandomTestDataGenerator {

	

		// If we want to generate Indian names or local Indian Data
		public static Locale local = new Locale("en-IND");
		public static Faker fake = new Faker(local);
		public static String firstName = fake.name().firstName();
		public static String fullName = fake.name().fullName();
		public static String phoneNumber = fake.phoneNumber().phoneNumber().replace("+91", "").replace("-", "");
		public static String companyName = fake.company().name();
		public static String email = fake.internet().emailAddress();
		public static String password = fake.internet().password();
		

	
}