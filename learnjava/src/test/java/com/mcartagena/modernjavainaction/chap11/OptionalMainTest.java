package com.mcartagena.modernjavainaction.chap11;

import com.mcartagena.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class OptionalMainTest {

    OptionalMain optionalMain;
    Person person;

    @Before
    public void setupBefore(){
        optionalMain = new OptionalMain();
        person = Person.builder().name("Marcelo")
                .age(50).build();
    }


    @Test(expected=NullPointerException.class)
    public void shouldGetAnInsuranceName() {

        fail(optionalMain.getCarInsuranceName(person));
    }

    @Test
    public void shouldGetAnInsuranceNameWithoutNull() {

        assertEquals(optionalMain.getCarInsuranceNameReducingNull(person), "Unknown");
    }

    @Test
    public void shouldGetAnInsuranceNameWithoutNullSecondIntent() {

        assertEquals(optionalMain.getCarInsuranceNameReducingNullSecondIntent(person), "Unknown");
    }

    @Test
    public void shouldGetCarInsuranceName() {
        Person person = Person.builder().name("Marcelo")
                .age(50).carOptional(Optional.empty()).build();
        Optional<Person> personOptional = Optional.of(person);

        assertEquals(optionalMain.getCarInsuranceName(personOptional), "Unknown");
    }

    @Test
    public void shouldGetCarAsOptional() {

        assertEquals(person.getCarAsOptional(), Optional.empty());
    }

    @Test
    public void shouldGetInsuranceAsOptional() {
        Person person = Person.builder().name("Marcelo")
                .age(50)
                .car(Car.builder()
                        .brand(Brand.MAZDACX5)
                        .color(Color.BLUE)
                        .build())
                .build();

        assertEquals(person.getCar().getInsuranceAsOptional(), Optional.empty());

    }

    @Test
    public void shouldGetCarInsuranceNames(){
        Person person = Person.builder().name("Marcelo")
                .age(50)
                .carOptional(Optional.of(Car.builder()
                        .brand(Brand.MAZDACX5)
                        .color(Color.BLUE)
                        .insuranceOptional(Optional.of(Insurance.builder()
                                .name("Liberty")
                                .build()))
                        .build()))
                .build();

        Person person1 = Person.builder().name("Cielo")
                .age(51)
                .carOptional(Optional.of(Car.builder()
                        .brand(Brand.MAZDA3)
                        .color(Color.RED)
                        .insuranceOptional(Optional.empty())
                        .build()))
                .build();

        Person person2 = Person.builder().name("Soledad")
                .age(41)
                .carOptional(Optional.empty())
                .build();

        List<Person> persons = Arrays.asList(person,person1,person2);

        assertEquals(optionalMain.getCarInsuranceNames(persons), Set.of("Liberty"));

    }

    @Test
    public void shouldFindCheapestInsurance(){
        Person person = Person.builder().name("Soledad")
                .age(41)
                .carOptional(Optional.empty())
                .build();

        Car car = Car.builder()
                .brand(Brand.MAZDA3)
                .color(Color.RED)
                .insuranceOptional(Optional.empty())
                .build();

        assertEquals(optionalMain.nullSafeFindCheapestInsurance(Optional.of(person),Optional.of(car)),Optional.of(new Insurance()));
        assertEquals(optionalMain.nullSafeFindCheapestInsurance(Optional.of(person),Optional.empty()),Optional.empty());

    }

    @Test
    public void shouldFindCheapestInsuranceCombiningTwoOptionalsWithoutUnwrappingThem(){
        Person person = Person.builder().name("Soledad")
                .age(41)
                .carOptional(Optional.empty())
                .build();

        Car car = Car.builder()
                .brand(Brand.MAZDA3)
                .color(Color.RED)
                .insuranceOptional(Optional.empty())
                .build();

        assertEquals(optionalMain.nullSafeFindCheapestInsuranceQuiz(Optional.of(person),Optional.of(car)),Optional.of(new Insurance()));
        assertEquals(optionalMain.nullSafeFindCheapestInsuranceQuiz(Optional.of(person),Optional.empty()),Optional.empty());

    }

    @Test
    public void shouldGetCarInsuranceNameFilteringByAge(){
        Person person = Person.builder().name("Marcelo")
                .age(50)
                .carOptional(Optional.of(Car.builder()
                        .brand(Brand.MAZDACX5)
                        .color(Color.BLUE)
                        .insuranceOptional(Optional.of(Insurance.builder()
                                .name("Liberty")
                                .build()))
                        .build()))
                .build();

        assertEquals(optionalMain.getCarInsuranceName(Optional.of(person),18), "Liberty");
        assertEquals(optionalMain.getCarInsuranceName(Optional.of(person),51), "Unknown");

    }

}