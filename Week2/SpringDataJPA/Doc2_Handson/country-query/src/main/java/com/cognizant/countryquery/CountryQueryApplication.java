package com.cognizant.countryquery;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.countryquery.model.Country;
import com.cognizant.countryquery.model.Stock;
import com.cognizant.countryquery.repository.CountryRepository;
import com.cognizant.countryquery.repository.StockRepository;

@SpringBootApplication
public class CountryQueryApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryQueryApplication.class);

    private static CountryRepository countryRepository;
    private static StockRepository stockRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CountryQueryApplication.class, args);
        countryRepository = context.getBean(CountryRepository.class);
        stockRepository = context.getBean(StockRepository.class);
        testQueryMethods();
        testStockQueryMethods();
    }

    private static void testQueryMethods() {
        LOGGER.info("Start");
        List<Country> containingOu = countryRepository.findByNameContaining("ou");
        LOGGER.debug("findByNameContaining(ou)={}", containingOu);
        List<Country> containingOuSorted = countryRepository.findByNameContainingOrderByNameAsc("ou");
        LOGGER.debug("findByNameContainingOrderByNameAsc(ou)={}", containingOuSorted);
        List<Country> startingWithZ = countryRepository.findByNameStartingWith("Z");
        LOGGER.debug("findByNameStartingWith(Z)={}", startingWithZ);
        LOGGER.info("End");
    }

    private static void testStockQueryMethods() {
        LOGGER.info("Start stock tests");

        List<Stock> fbSeptember = stockRepository.findByStCodeAndStDateBetween(
                "FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
        LOGGER.debug("FB September 2019={}", fbSeptember);

        List<Stock> googleAbove1250 = stockRepository.findByStCodeAndStCloseGreaterThan(
                "GOOGL", new BigDecimal("1250"));
        LOGGER.debug("GOOGL close > 1250={}", googleAbove1250);

        List<Stock> top3Volume = stockRepository.findTop3ByOrderByStVolumeDesc();
        LOGGER.debug("Top 3 highest volume={}", top3Volume);

        List<Stock> netflixLowest3 = stockRepository.findTop3ByStCodeOrderByStCloseAsc("NFLX");
        LOGGER.debug("NFLX lowest 3 close={}", netflixLowest3);

        LOGGER.info("End stock tests");
    }
}