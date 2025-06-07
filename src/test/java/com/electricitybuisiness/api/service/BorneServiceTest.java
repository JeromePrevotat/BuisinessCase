// package com.electricitybuisiness.api.service;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.Test;

// import com.electricitybuisiness.api.borneutils.BorneUtils;
// import com.electricitybusiness.api.model.Borne;
// import com.electricitybusiness.api.model.EtatBorne;

// import com.electricitybusiness.api.service.BorneService;

// public class BorneServiceTest {
//     private final int EARTH_RADIUS = 6371; // Earth radius in kilometers
//     private final BigDecimal MAX_LONGITUDE = BigDecimal.valueOf(180);
//     private final BigDecimal MIN_LONGITUDE = BigDecimal.valueOf(-180);
//     private final BigDecimal MAX_LATITUDE = BigDecimal.valueOf(90);
//     private final BigDecimal MIN_LATITUDE = BigDecimal.valueOf(-90);
//     private final List<Borne> bornes = new ArrayList<>();
    // public List<Borne> get_nearby_borne(BigDecimal longitude, BigDecimal latitude, int rayon, List<Borne> bornes) {
    // φ = Latitude (NS)
    // λ = Longitude (EW)
    // a = sin²(Δφ/2) + cos(φa)*cos(φb)*sin²(Δλ/2)
    // c = 2*arctan(√a/√(1−a))
    // d = R*c (R = 6371 km = Earth radius)

    // GPS COORD
    // Gare Clermont : Longitude: 45.777N, Latitude: 3.1E
    // Delille 45.780752, 3.091250                                          0.8511km from Jaude
    // Jaude 45.776543, 3.082084
    // Gaillard 45.780061, 3.081912                                         0.4km from Jaude
    // Victoire 45.778167, 3.085810                 2.605km from Cezeaux    0.3407km from Jaude
    // Gare 45.777503, 3.100850                     1.84km from Cezeaux
    // Cezeaux 45.762452, 3.110723
    // HB 45.758675, 3.126843                       1.319km from Cezeaux
    // Leclerc 45.762020, 3.128239                  1.36km from Cezeaux
    // Mybeers 45.761137, 3.136681                  2.019km from Cezeaux
    // LaPardieu 45.766656, 3.133186                1.804km from Cezeaux
    // Michelin 45.783370, 3.092637
    // CHU Gabriel Montpied 45.758793, 3.091188     1.569km from Cezeaux
    // 42 48.896400, 2.318633
    // Place de Clichy 48.883559, 2.327390
    // Gare Bercy 48.883559, 2.327390
    // Lyon 45.762251, 4.835266
    // Vichy 46.128379, 3.423370
    // Moulins sur Allier 46.560727, 3.330676
    // Nevers 46.983551, 3.156365
    // Riom 45.890568, 3.106724
//     @BeforeAll
//     public void init() {
//         this.bornes.clear();
//         this.bornes.add(new Borne(
//             Long.valueOf(1), "Gare Clermont", BigDecimal.valueOf(45.777503), BigDecimal.valueOf(3.100850),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(2), "Delille", BigDecimal.valueOf(45.780752), BigDecimal.valueOf(3.091250),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(3), "Jaude", BigDecimal.valueOf(45.776543), BigDecimal.valueOf(3.082084),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(4), "Gaillard", BigDecimal.valueOf(45.780061), BigDecimal.valueOf(3.081912),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(5), "Victoire", BigDecimal.valueOf(45.778167), BigDecimal.valueOf(3.085810),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(6), "Cezeaux", BigDecimal.valueOf(45.762452), BigDecimal.valueOf(3.110723),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(7), "HB", BigDecimal.valueOf(45.758675), BigDecimal.valueOf(3.126843),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(8), "Leclerc", BigDecimal.valueOf(45.762020), BigDecimal.valueOf(3.128239),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(9), "Mybeers", BigDecimal.valueOf(45.761137), BigDecimal.valueOf(3.136681),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(10), "LaPardieu", BigDecimal.valueOf(45.766656), BigDecimal.valueOf(3.133186),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(11), "Michelin", BigDecimal.valueOf(45.783370), BigDecimal.valueOf(3.092637),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(12), "CHU Gabriel Montpied", BigDecimal.valueOf(45.758793), BigDecimal.valueOf(3.091188),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(13), "42", BigDecimal.valueOf(48.896400), BigDecimal.valueOf(2.318633),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(14), "Place de Clichy", BigDecimal.valueOf(48.883559), BigDecimal.valueOf(2.327390),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(15), "Gare Bercy", BigDecimal.valueOf(48.883559), BigDecimal.valueOf(2.327390),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(16), "Lyon", BigDecimal.valueOf(45.762251), BigDecimal.valueOf(4.835266),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(17), "Vichy", BigDecimal.valueOf(46.128379), BigDecimal.valueOf(3.423370),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(18), "Moulins sur Allier", BigDecimal.valueOf(46.560727), BigDecimal.valueOf(3.330676),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(19), "Nevers", BigDecimal.valueOf(46.983551), BigDecimal.valueOf(3.156365),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//         this.bornes.add(new Borne(
//             Long.valueOf(20), "Riom", BigDecimal.valueOf(45.890568), BigDecimal.valueOf(3.106724),
//             BigDecimal.valueOf(22.5), "Instruction", true, EtatBorne.ACTIVE, false,
//             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null));
//     }

//     @Test
//     public void bornes_null_should_throw_null_pointer_exception() {
//         BorneService bornesService = new BorneService(null);
//         assertThrowsExactly(NullPointerException.class,
//             () -> bornesService.get_nearby_borne(BigDecimal.ZERO, BigDecimal.ZERO, 1000, null));
//     }

//     @Test
//     public void bornes_empty_should_return_empty_list() {
//         BorneService bornesService = new BorneService(null);
//         assertEquals(List.of(), 
//             bornesService.get_nearby_borne(BigDecimal.ZERO, BigDecimal.ZERO, 1000, List.of()));
//     }

//     @Test
//     public void longitude_should_be_lower_than_180() {
//         BorneService bornesService = new BorneService(null);
//         assertThrowsExactly(IllegalArgumentException.class,
//             () -> bornesService.get_nearby_borne(MAX_LONGITUDE.add(BigDecimal.ONE), BigDecimal.ZERO, 1000, List.of(new Borne())));
//     }

//     @Test
//     public void longitude_should_be_greater_than_minus_180() {
//         BorneService bornesService = new BorneService(null);
//         assertThrowsExactly(IllegalArgumentException.class,
//             () -> bornesService.get_nearby_borne(MIN_LONGITUDE.subtract(BigDecimal.ONE), BigDecimal.ZERO, 1000, List.of(new Borne())));
//     }

//     @Test
//     public void latitude_should_be_between_lower_than_90() {
//         BorneService bornesService = new BorneService(null);
//         assertThrowsExactly(IllegalArgumentException.class,
//             () -> bornesService.get_nearby_borne(BigDecimal.ZERO, MAX_LATITUDE.add(BigDecimal.ONE), 1000, List.of(new Borne())));
//     }
    
//     @Test
//     public void latitude_should_be_between_greater_than_minus_90() {
//         BorneService bornesService = new BorneService(null);
//         assertThrowsExactly(IllegalArgumentException.class,
//             () -> bornesService.get_nearby_borne(BigDecimal.ZERO, MIN_LATITUDE.subtract(BigDecimal.ONE), 1000, List.of(new Borne())));
//     }

//     @Test
//     public void rayon_should_be_positive() {
//         BorneService bornesService = new BorneService(null);
//         assertThrowsExactly(IllegalArgumentException.class,
//             () -> bornesService.get_nearby_borne(BigDecimal.ZERO, BigDecimal.ZERO, 0, List.of(new Borne())));
//     }

//     @Test
//     public void rayon_be_lower_than_earth_radius() {
//         BorneService bornesService = new BorneService(null);
//         assertThrowsExactly(IllegalArgumentException.class,
//             () -> bornesService.get_nearby_borne(BigDecimal.ZERO, BigDecimal.ZERO, EARTH_RADIUS + 1, List.of(new Borne())));
//     }

//     @Test
//     public void borne_exact_position_should_return_itself() {
//         BorneService bornesService = new BorneService(null);
//         List<Borne> result = bornesService.get_nearby_borne(
//             BigDecimal.valueOf(45.762452), BigDecimal.valueOf(3.110723), 0, this.bornes);
//         assertEquals(1, result.size());
//         assertEquals("Cezeaux", result.get(0).getNomBorne());
//     }

//     @Test
//     public void search_from_cezeaux_with_2km_radius_should_return_6_bornes(){
//         BorneService bornesService = new BorneService(null);
//         List<Borne> result = bornesService.get_nearby_borne(
//             BigDecimal.valueOf(45.762452), BigDecimal.valueOf(3.110723), 2000, this.bornes);
//         assertEquals(6, result.size());
//         assertEquals(List.of(Long.valueOf(6), Long.valueOf(1), Long.valueOf(7), Long.valueOf(8), Long.valueOf(10), Long.valueOf(12)),  
//                     result.stream()
//                         .map(Borne::getNumBorne)
//                         .toList());
//     }

//     @Test
//     public void search_from_jaude_with_1km_radius_should_return_4_bornes(){
//         BorneService bornesService = new BorneService(null);
//         List<Borne> result = bornesService.get_nearby_borne(
//             BigDecimal.valueOf(45.776543), BigDecimal.valueOf(3.082084), 1000, this.bornes);
//         assertEquals(4, result.size());
//         assertEquals(List.of(Long.valueOf(2), Long.valueOf(3), Long.valueOf(4), Long.valueOf(5)),  
//                     result.stream()
//                         .map(Borne::getNumBorne)
//                         .toList());
//     }

//     @Test
//     public void search_from_vichy_with_100km_radius_should_return_4_bornes(){
//         BorneService bornesService = new BorneService(null);
//         List<Borne> result = bornesService.get_nearby_borne(
//             BigDecimal.valueOf(46.128379), BigDecimal.valueOf(3.423370), 100000, this.bornes);
//         assertEquals(4, result.size());
//         assertEquals(List.of(Long.valueOf(2), Long.valueOf(3), Long.valueOf(4), Long.valueOf(5)),  
//                     result.stream()
//                         .map(Borne::getNumBorne)
//                         .toList());
//     }
// }
    // import static org.junit.jupiter.api.Assertions.assertEquals;

    // import java.math.BigDecimal;
    // import java.time.LocalDateTime;
    // import java.util.ArrayList;
    // import java.util.Arrays;
    // import java.util.List;

    // import org.junit.jupiter.api.Test;

    // import com.electricitybusiness.api.model.Borne;
    // import com.electricitybusiness.api.model.EtatBorne;

    // public class BorneUtilsTest {

    //     static int id = 1;
    //     static Borne createBorne(String nom, double latitude, double longitude, double puissance) {
    //         id++;
    //         return new Borne(
    //             Long.valueOf(id), nom, BigDecimal.valueOf(latitude), BigDecimal.valueOf(longitude),
    //             BigDecimal.valueOf(puissance), "Instruction", true, EtatBorne.ACTIVE, false,
    //             LocalDateTime.now(), LocalDateTime.now(), null, null, null, null);
    //     }

    //     List<Borne> bornes = List.of(
    //         createBorne("Gare Clermont", 45.777503, 3.100850, 22.5),
    //         createBorne("Gare 1", 45.779, 3.10900, 22.5),
    //         createBorne("Gare 2", 45.772, 3.100200, 22.5),
    //         createBorne("Gare 3", 44.777503, 3.100850, 22.5),
    //         createBorne("Gare 4", 46.777503, 3.100850, 22.5),
    //         createBorne("Gare 5", 45.779, 3.22, 22.5)
    //     );


    //     @Test
    //     void testGet_nearby_borne_length_List() {
    //         double latitude = 45.774900;
    //         double longitude = 3.100090;
    //         double rayon = 1000;

    //         List<Borne> bornesProches = BorneUtils.get_nearby_borne(bornes, longitude, latitude, rayon);

    //         assertEquals(3, bornesProches.size());

    //     }


    //     @Test
    //     void testGet_nearby_borne_test_result() {
    //         double latitude = 45.777500;
    //         double longitude = 3.100090;
    //         double rayon = 100;

    //         List<Borne> bornesProches = BorneUtils.get_nearby_borne(bornes, longitude, latitude, rayon);

    //         assertEquals(1, bornesProches.size());
    //         assertEquals("Gare Clermont", bornesProches.get(0).getNomBorne());
    //     }