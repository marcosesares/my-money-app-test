package br.edu.mcesar.core.providers;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import com.github.javafaker.Faker;

import br.edu.mcesar.core.Constants;
import br.edu.mcesar.pages.models.User;

public class UserProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		Faker faker = new Faker();
		User user = new User(faker.artist().name(), faker.regexify(Constants.EMAIL_REGEX), faker.regexify(Constants.PASSWORD_REGEX));
		return Stream.of(user).map(Arguments::of);
	}
	
}
