// Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.util;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;

/**
 * Author: msk
 */
@SuppressWarnings("MethodOverridesStaticMethodOfSuperclass")
public class ArrayUtil {

  private ArrayUtil() { }

  @NotNull
  public static <T> T[] newArray(@NotNull Class<T> type, int length) {
    //noinspection unchecked
    return (T[])Array.newInstance(type, length);
  }

  @NotNull
  public static <T> Class<T> getComponentType(@NotNull T[] collection) {
    //noinspection unchecked
    return (Class<T>)collection.getClass().getComponentType();
  }
}
