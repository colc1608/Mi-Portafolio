package pe.com.colc.test07;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        System.out.println("hola mundo");

        pruebaSupplier();
        pruebaConsumerAndBiConsumer();
        pruebaPredicateAndBiPredicate();
        pruebaFuncionAndBiFuncion();
        pruebaUnaryOperatorAndBinaryOperator();

    }

    static void pruebaSupplier(){

        System.out.println("----------------- SUPLIER -------------------------");
        // No necesitamos pasar un argumento
        // Devolverá algo y puede ser de cualquier tipo

        Stream<Integer> stream = Stream.generate( () -> new Random().nextInt(50, 60) )
                .limit(5);

        stream.forEach(System.out::println);

    }

    static void pruebaConsumerAndBiConsumer(){

        System.out.println("\n\n----------------- CONSUMER -------------------------");
        // Recibe una variable genérica
        // hace algo con ella y luego NO devuelve nada.

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.forEach(num -> esPar(num));

        numbers.forEach(System.out::println);


        System.out.println("----------------- BI CONSUMER con expresion lambda -------------------------");
        BiConsumer<Integer, Integer> biConsumer = (n1, n2) -> System.out.println("lambda BI consumer = " + (n1+n2) );
        biConsumer.accept(2,3);

        System.out.println("----------------- BI CONSUMER referencia a metodo -------------------------");
        BiConsumer<String, Integer> biCon = Main::imprimir;
        biCon.accept("juan", 11);

    }

    static void esPar(Integer valor){
        if(0 == (valor % 2) ){
            System.out.println(valor + " es par");
        }
    }


    static void pruebaPredicateAndBiPredicate(){

        System.out.println("\n\n----------------- PREDICATE -------------------------");
        // Tiene un método llamado test
        // Recibe un argumento y devuelve un booleano

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        Stream<Integer> stream = numbers.stream()
                .filter(num -> num % 2 == 0);

        stream.forEach(System.out::println);



        System.out.println("----------------- BI PREDICATE -------------------------");
        BiPredicate<String,Integer> wordSizeIsValid = (word, size) -> {
            return word.length() == size;
        };

        boolean test1 = wordSizeIsValid.test("cesar", 5);
        boolean test2 = wordSizeIsValid.test("juan", 3);

        System.out.println(test1);
        System.out.println(test2);


    }


    static void pruebaFuncionAndBiFuncion(){

        System.out.println("\n\n----------------- FUNCION -------------------------");
        // FUNCION
        // Recibe algo y devuelve algo

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        Stream<Double> stream = numbers.stream()
                .map(num -> sumarUno(num))
                        .map(val -> restarUno(val));

        stream.forEach(System.out::println);


        System.out.println("----------------- BI FUNCION -------------------------");

        BiFunction<String, String, Integer> biFunction = (str1, str2) ->
            str1.length() + str2.length();

        Integer result1 = biFunction.apply("hola", "mundo");
        Integer result2 = biFunction.apply("test", "22");

        System.out.println(result1);
        System.out.println(result2);

    }

    static Double sumarUno(Integer num){
        return num.doubleValue() + 1;
    }
    static Double restarUno(Double num){
        return num.doubleValue() - 1;
    }

    static void pruebaUnaryOperatorAndBinaryOperator(){


        System.out.println("\n\n-------------- UnaryOperator ---------------");
        UnaryOperator<Integer> unaryOperatorSuma = x -> x + 1;
        UnaryOperator<String> unaryOperatorCadena = str -> str.concat(".com");

        Integer res1 = unaryOperatorSuma.apply(1);
        String res2 = unaryOperatorCadena.apply("peru");

        System.out.println(res1);
        System.out.println(res2);

        System.out.println("-------------- BinaryOperator ---------------");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.stream()
                //.reduce( (n1, n2) -> (n1 + n2) )
                .reduce( (n1, n2) -> (suma(n1, n2)) )
                .ifPresent(System.out::println);

    }
    // =================================================================

    static void imprimir(String name, Integer age){
        System.out.println(name + " - " + age);
    }

    static Integer suma(Integer num1, Integer num2){
        System.out.println("metodo suma / num1 = " + num1);
        System.out.println("metodo suma / num2 = " + num2);
        return num1 + num2;

    }

}
