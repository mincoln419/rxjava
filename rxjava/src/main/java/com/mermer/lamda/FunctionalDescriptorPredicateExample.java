package com.mermer.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalDescriptorPredicateExample {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,7, 10, 30, 65, 70, 102);
		forEachPrint(numbers, n -> System.out.println(n));
		
		System.out.println("============================");
		
		List<Character> chars = Arrays.asList('a','c','g','j','n');
		List<Integer> asciNumbers = map(chars, c -> (int)c);
		forEachPrint(asciNumbers, n -> System.out.println(n));
	}

	private static <T, R> List<R> map(List<T> list, Function<T, R> F) {
		List<R> result = new ArrayList<>();
		for(T t :  list) {
			result.add(F.apply(t));
		}
		return result;
	}

	private static void forEachPrint(List<Integer> numbers, Consumer<Integer> c) {
		
		for(Integer number: numbers) {
			c.accept(number);
		}
		
	}

}

