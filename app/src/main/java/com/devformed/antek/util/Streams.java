package com.devformed.antek.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * @author Anton Gorokh
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Streams {

	public static <T, K, V>
	Collector<T, ?, ImmutableMap<K, V>> immutableMapCollector(Function<? super T, ? extends K> keyMapper,
	                                                          Function<? super T, ? extends V> valueMapper) {
		return Collectors.collectingAndThen(toMap(keyMapper, valueMapper), ImmutableMap::copyOf);
	}

	public static <T>
	Collector<T, ?, ImmutableList<T>> immutableListCollector() {
		return Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf);
	}
}
