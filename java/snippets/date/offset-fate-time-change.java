/**
 * Odkodowanie daty i czasu i przesunięcie strefy czasowej.
 */

LocalDateTime localDateTime = LocalDateTime
    .parse(dateForSubmission, DateTimeFormatter.ofPattern("yyyyMMdd HH:mm"));

return OffsetDateTime.of(localDateTime, ZoneOffset.of(inZoneOffset))
    .withOffsetSameInstant(ZoneOffset.of(outZoneOffset));

LocalDate localDate = LocalDate
    .parse(dateDispatch, DateTimeFormatter.ofPattern("yyyyMMdd"));

return OffsetDateTime
    .of(LocalDateTime.of(localDate, LocalTime.of(0, 0)), ZoneOffset.of(inZoneOffset))
    .withOffsetSameInstant(ZoneOffset.of(outZoneOffset));
