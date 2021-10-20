// Java
MessageDigest digest = MessageDigest.getInstance("SHA-256");
byte[] encodedhash = digest.digest(
  originalString.getBytes(StandardCharsets.UTF_8));

private static String bytesToHex(byte[] hash) {
    StringBuilder hexString = new StringBuilder(2 * hash.length);
    for (int i = 0; i < hash.length; i++) {
        String hex = Integer.toHexString(0xff & hash[i]);
        if(hex.length() == 1) {
            hexString.append('0');
        }
        hexString.append(hex);
    }
    return hexString.toString();
}

// Guava
String sha256hex = Hashing.sha256()
  .hashString(originalString, StandardCharsets.UTF_8)
  .toString();


// Apache Commons
String sha256hex = DigestUtils.sha256Hex(originalString);

// Bouncy Castle
MessageDigest digest = MessageDigest.getInstance("SHA-256");
byte[] hash = digest.digest(
  originalString.getBytes(StandardCharsets.UTF_8));
String sha256hex = new String(Hex.encode(hash));

// SHA3-256
final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
final byte[] hashbytes = digest.digest(
  originalString.getBytes(StandardCharsets.UTF_8));
String sha3Hex = bytesToHex(hashbytes);

// Apache Commons Codecs
String sha3Hex = new DigestUtils("SHA3-256").digestAsHex(originalString);
