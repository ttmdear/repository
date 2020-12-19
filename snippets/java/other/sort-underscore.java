/**
 * Implementacja komparatora do sortowania wartość oddzielanych
 * underscorem
 */

list.sort(new Comparator<Data>() {
    @Override
    public int compare(Data dataA, Data dataB) {
		final String[] idA = dataA.getId().split("_");
		final String[] idB = dataB.getId().split("_");

		if ((idA.length == 1 && idB.length == 1) || !idA[0].equals(idB[0])) {
			// Bez iteracji, same kody
			return idA[0].compareTo(idB[0]);
		} else if (idA.length == 1 && idB.length > 1) {
			// Pierwszy kod, druga iteracja. Kod na g�r�.
			return 1;
		} else if (idA.length > 1 && idB.length == 1) {
			// Pierwsza iteracja, drugi kod. Kod na g�r�.
			return -1;
		}

		// Dwie iteracje, trzeba sprawdzi� kt�ra jest wi�ksza
		final int max = Math.max(idA.length, idB.length) - 1;
		int result = idA[1].compareTo(idB[1]);

		for(int i=2; i < max; i++) {
			if (i > idA.length || i > idB.length) {
			return result;
			}

			result = idA[i].compareTo(idB[i]);
		}

		return result;
    }
});
