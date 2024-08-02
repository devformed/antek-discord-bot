package com.devformed.antek.util;

import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;

/**
 * @author Anton Gorokh
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Commons {

	public static @Nullable Boolean not(@Nullable Boolean value) {
		return BooleanUtils.negate(value);
	}
}
