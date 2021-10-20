/**
 * Przykład funkcji konwerującej wartości oddzielone myślnikiem na te ze
 * znakiem podkreślenia.
 */
public CommandName argToCommandName(String arg) {
    if (arg == null || arg.isEmpty()) return null;

    String[] splitted = arg.split("-");

    if (splitted.length == 1) {
        CommandName.valueOf(splitted[0].toUpperCase());
    }

    String upperUnderScore = Stream.of(splitted).map(s -> {
        return s.toUpperCase();
    }).collect(Collectors.joining("_"));

    return CommandName.valueOf(upperUnderScore);
}
