package lesson3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.stream.Collectors;

public class Lesson3 {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Companies companies = mapper.readValue(new File(Path.of("src/lesson3/organizations.json").toAbsolutePath().toString()), Companies.class);
            companies.getCompanies().forEach(company -> System.out.println(company.getName() + " - " + company.getFounded()));
            List<Securities> securitiesList = companies.getCompanies().stream()
                    .flatMap(company -> company.getSecurities().stream())
                    .filter(securities -> LocalDate.now().isAfter(LocalDate.parse(securities.getDate(),
                            new DateTimeFormatterBuilder().appendPattern("dd.MM.yyyy").toFormatter())))
                    .collect(Collectors.toList());
            securitiesList.forEach(System.out::println);
            System.out.println("Count of expired currencies : " + securitiesList.size());
            if (args.length > 0) {
                getCompaniesFoundedAfter(companies, args[0]);
                getCurrencyByName(companies, args[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getCompaniesFoundedAfter(Companies companies, String stringDate) {
        if (stringDate != null && companies != null) {
            try {
                DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                        .appendPattern("[dd.MM.yyyy]")
                        .appendPattern("[dd/MM/yyyy]")
                        .appendPattern("[dd/MM/yy]")
                        .toFormatter();
                LocalDate date = LocalDate.parse(stringDate, formatter);
                companies.getCompanies().stream()
                        .filter(company -> date.isBefore(LocalDate.parse(company.getFounded(), formatter)))
                        .forEach(company -> System.out.println("Company " + company.getName() + " was founded in " + company.getFounded()));
            } catch (Exception e) {
                System.out.println("Unable parse input parameter to date " + stringDate + " cause " + e.getMessage());
            }
        }
    }

    public static void getCurrencyByName(Companies companies, String currencyName) {
        companies.getCompanies().stream()
                .flatMap(company -> company.getSecurities().stream())
                .filter(securities -> securities.getCurrency().contains(currencyName))
                .forEach(securities -> System.out.println("Name \"" + securities.getName() + "\" code " + securities.getCode()));
    }
}
