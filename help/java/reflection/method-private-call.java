// Pobranie instancji metody
Method indexOfMethod = LongArrayUtil.class.getDeclaredMethod("indexOf", long[].class, long.class, int.class, int.class);

// Ustawienie dostępu do metody
indexOfMethod.setAccessible(true);

// Wywołanie metody
int value = (int) indexOfMethod.invoke(LongArrayUtil.class, someLongArray, 2L, 0, someLongArray.length);
