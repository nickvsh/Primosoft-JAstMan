/*
 * Copyright (c) 2015.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created on 11.12.15.
 * Collector for immutable list creation.
 *
 * @author atelizhenko
 */
public final class ImmutableListCollector {
	/**
	 * Invisible default constructor
	 */
	private ImmutableListCollector() {

	}

	/**
	 * Returns a {@code Collector} that accumulates the input elements into a
	 * new {@code UnmodifiableList}.
	 *
	 * @param <T> the type of the input elements
	 * @return a {@code Collector} which collects all the input elements into a
	 * {@code UnmodifiableList}, in encounter order
	 */
	public static <T> Collector<T, List<T>, List<T>> toImmutableList() {
		return toImmutableList(ArrayList::new);
	}

	/**
	 * Returns a {@code Collector} that accumulates the input elements into a
	 * new {@code List}, in encounter order.  The {@code List} is
	 * created by the provided factory and is unmodifiable.
	 *
	 * @param <T>               the type of the input elements
	 * @param <A>               the type of the resulting {@code Collection}
	 * @param collectionFactory a {@code Supplier} which returns a new, empty
	 *                          {@code Collection} of the appropriate type
	 * @return a {@code Collector} which collects all the input elements into a
	 * {@code UnmodifiableList}, in encounter order
	 */
	public static <T, A extends List<T>> Collector<T, A, List<T>> toImmutableList(Supplier<A> collectionFactory) {
		return Collector.of(collectionFactory, List::add, (left, right) -> {
			left.addAll(right);
			return left;
		}, Collections::unmodifiableList);
	}
}
