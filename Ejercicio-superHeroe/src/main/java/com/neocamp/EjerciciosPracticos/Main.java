package com.neocamp.EjerciciosPracticos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<SuperHeroe> liga = new ArrayList<>();

        liga.add(new SuperHeroe("Superman", "musculoso", true, 70));
        liga.add(new SuperHeroe("Batman", "alto", true, 80));
        liga.add(new SuperHeroe("WonderWoman", "Guapa", true, 95));
        liga.add(new SuperHeroe("Flash", "Rojizo", false, 50));
        liga.add(new SuperHeroe("Aquaman", "mojado", false, 55));

        //Lista solo los superheroes que lleven capa
        System.out.println("=== SuperHeroes ===");
        liga.stream()
                .filter(j -> j.isLlevaCapa())
                .forEach(System.out::println);

        //Obtener los nombres de todos los superheroes en mayusculas, odernados
        System.out.println("=== Nombres ordenados");
        liga.stream()
                .map(j -> j.getNombre())
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        //Encontrar el superheroe con mayor nivel de poder
        liga.stream()
                .max(Comparator.comparingInt(SuperHeroe::getPoder))
                .ifPresent(j -> System.out.println("Top: " + j));

        //Calcular el poder promedio de toda la liga
        double promedio = liga.stream()
                .mapToInt(SuperHeroe::getPoder)
                .average()
                .orElse(0.0);

        System.out.println("Promedio: " + promedio);

        //Agrupar los superheroes en dos listas, los que tienen capa y los que no
        Map<Boolean, List<SuperHeroe>> agrupados =
                liga.stream()
                        .collect(Collectors.partitioningBy(SuperHeroe::isLlevaCapa));

        System.out.println("Con capa: " + agrupados.get(true));
        System.out.println("Sin capa: " + agrupados.get(false));
    }
}
