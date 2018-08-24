package me.vukas;

import java.util.Locale;
import java.util.Map;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

public class ImportedOutcomeTransformer implements TypeRegistryConfigurer {
	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		typeRegistry.defineDataTableType(new DataTableType(ImportedOutcome.class,
				(Map<String, String> row) -> {
					ImportedOutcome importedOutcome = new ImportedOutcome();
					importedOutcome.outcome = row.get("outcome");
					importedOutcome.probability = Double.parseDouble(row.get("probability"));
					return importedOutcome;
				}));
	}
}
