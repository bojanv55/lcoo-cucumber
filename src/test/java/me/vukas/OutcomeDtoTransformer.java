package me.vukas;

import java.util.Locale;
import java.util.Map;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

public class OutcomeDtoTransformer implements TypeRegistryConfigurer {
	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		typeRegistry.defineDataTableType(new DataTableType(OutcomeDto.class,
				(Map<String, String> row) -> {
					OutcomeDto outcomeDto = new OutcomeDto();
					outcomeDto.outcome = row.get("outcome");
					outcomeDto.value = Double.parseDouble(row.get("value"));
					return outcomeDto;
				}));
	}
}
