/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created on 11.03.16.
 * Collector for immutable set creation.
 *
 * @author atelizhenko
 */
public final class ImmutableSetCollector {
	/**
	 * Default invisible constructor
	 */
	private ImmutableSetCollector() {

	}

	/**
	 * Returns a {@code Collector} that accumulates the input elements into a
	 * new {@code UnmodifiableSet}.
	 *
	 * @param <T> the type of the input elements
	 * @return a {@code Collector} which collects all the input elements into a
	 * {@code UnmodifiableList}, in encounter order
	 */
	public static <T> Collector<T, Set<T>, Set<T>> toImmutableSet() {
		return toImmutableSet(HashSet::new);
	}

	/**
	 * Returns a {@code Collector} that accumulates the input elements into a
	 * new {@code Set}, in encounter order.  The {@code Set} is
	 * created by the provided factory and is unmodifiable.
	 *
	 * @param <T>               the type of the input elements
	 * @param <A>               the type of the resulting {@code Collection}
	 * @param collectionFactory a {@code Supplier} which returns a new, empty
	 *                          {@code Collection} of the appropriate type
	 * @return a {@code Collector} which collects all the input elements into a
	 * {@code UnmodifiableList}, in encounter order
	 */
	public static <T, A extends Set<T>> Collector<T, A, Set<T>> toImmutableSet(Supplier<A> collectionFactory) {
		return Collector.of(collectionFactory, Set::add, (left, right) -> {
			left.addAll(right);
			return left;
		}, Collections::unmodifiableSet);
	}
}
