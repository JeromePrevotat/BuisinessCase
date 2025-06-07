package com.electricitybuisiness.api.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.electricitybusiness.api.model.Borne;
import com.electricitybusiness.api.model.EtatBorne;
import com.electricitybusiness.api.model.Lieu;

@SpringBootTest(classes = com.electricitybusiness.api.ElectricityBusinessApplication.class,  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class LieuTest {
    @Autowired
    private TestRestTemplate restTemplate;
    List<Borne> bornes = new ArrayList<>();

    @BeforeAll
    public void setUp() {
        bornes.clear();
        bornes.add(new Borne(
            Long.valueOf(1), "Gare Clermont", BigDecimal.valueOf(45.777503), BigDecimal.valueOf(3.100850),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(2), "Delille", BigDecimal.valueOf(45.780752), BigDecimal.valueOf(3.091250),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(3), "Jaude", BigDecimal.valueOf(45.776543), BigDecimal.valueOf(3.082084),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(4), "Gaillard", BigDecimal.valueOf(45.780061), BigDecimal.valueOf(3.081912),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(5), "Victoire", BigDecimal.valueOf(45.778167), BigDecimal.valueOf(3.085810),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(6), "Cezeaux", BigDecimal.valueOf(45.762452), BigDecimal.valueOf(3.110723),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(7), "HB", BigDecimal.valueOf(45.758675), BigDecimal.valueOf(3.126843),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(8), "Leclerc", BigDecimal.valueOf(45.762020), BigDecimal.valueOf(3.128239),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(9), "Mybeers", BigDecimal.valueOf(45.761137), BigDecimal.valueOf(3.136681),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(10), "LaPardieu", BigDecimal.valueOf(45.766656), BigDecimal.valueOf(3.133186),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(11), "Michelin", BigDecimal.valueOf(45.783370), BigDecimal.valueOf(3.092637),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(12), "CHU Gabriel Montpied", BigDecimal.valueOf(45.758793), BigDecimal.valueOf(3.091188),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(13), "42", BigDecimal.valueOf(48.896400), BigDecimal.valueOf(2.318633),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(14), "Place de Clichy", BigDecimal.valueOf(48.883559), BigDecimal.valueOf(2.327390),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(15), "Gare Bercy", BigDecimal.valueOf(48.883559), BigDecimal.valueOf(2.327390),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(16), "Lyon", BigDecimal.valueOf(45.762251), BigDecimal.valueOf(4.835266),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(17), "Vichy", BigDecimal.valueOf(46.128379), BigDecimal.valueOf(3.423370),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(18), "Moulins sur Allier", BigDecimal.valueOf(46.560727), BigDecimal.valueOf(3.330676),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(19), "Nevers", BigDecimal.valueOf(46.983551), BigDecimal.valueOf(3.156365),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
        bornes.add(new Borne(
            Long.valueOf(20), "Riom", BigDecimal.valueOf(45.890568), BigDecimal.valueOf(3.106724),
            BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
            LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
    }

    // private static List<Borne> getAllFreeBorneFromLieu(Lieu lieu)
    @Test
    public void testGetAllFreeBorneFromLieu() {
        // Arrange & Act
        ResponseEntity<String> response = restTemplate.getForEntity("/api/lieux", String.class);
        // Assert
        assertAll("Lieu API Response Validation",
            () -> assertNotNull(response, "Response should not be null"),
            () -> assertEquals(HttpStatus.OK, response.getStatusCode(), "Status should be 200 OK"),
            () -> assertNotNull(response.getBody(), "Response body should not be null"),
            () -> assertEquals(response.getBody(),
                
            )
        );
    }

}
