package br.edu.mcesar.core.providers;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import com.github.javafaker.Faker;

import br.edu.mcesar.core.Constants;
import br.edu.mcesar.pages.models.Credits;
import br.edu.mcesar.pages.models.Debits;
import br.edu.mcesar.pages.models.Debits.Status;
import br.edu.mcesar.pages.models.PaymentCycle;

public class PaymentCycleProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		Faker faker = new Faker();
		Credits credits = new Credits(faker.artist().name(), faker.regexify(Constants.MONTH_REGEX));
		Debits debits = new Debits(faker.artist().name(), faker.regexify(Constants.MONTH_REGEX), Status.AGENDADO);

		PaymentCycle paymentCycle = new PaymentCycle(faker.artist().name(),
				Integer.parseInt(faker.regexify(Constants.MONTH_REGEX)),
				Integer.parseInt(faker.regexify(Constants.YEAR_REGEX)), Arrays.asList(credits), Arrays.asList(debits));
		return Stream.of(paymentCycle).map(Arguments::of);
	}

}
