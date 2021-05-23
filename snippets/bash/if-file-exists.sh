# Pli istenieje
if [ -a "$MRG_WAR_SPZD" ]; then
    $MRG_JBOSS_DIR/bin/jboss-cli.sh -c --command="deploy --force $MRG_WAR_SPZD"
fi

# Pli nie istenieje
if [ ! -a "$USOS_ADM_WAR_PATH" ]; then
    return
fi


# -b FILE - True if the FILE exists and is a special block file.
# -c FILE - True if the FILE exists and is a special character file.
# -d FILE - True if the FILE exists and is a directory.
# -e FILE - True if the FILE exists and is a file, regardless of type (node, directory, socket, etc.).
# -f FILE - True if the FILE exists and is a regular file (not a directory or device).
# -G FILE - True if the FILE exists and has the same group as the user running the command.
# -h FILE - True if the FILE exists and is a symbolic link.
# -g FILE - True if the FILE exists and has set-group-id (sgid) flag set.
# -k FILE - True if the FILE exists and has a sticky bit flag set.
# -L FILE - True if the FILE exists and is a symbolic link.
# -O FILE - True if the FILE exists and is owned by the user running the command.
# -p FILE - True if the FILE exists and is a pipe.
# -r FILE - True if the FILE exists and is readable.
# -S FILE - True if the FILE exists and is a socket.
# -s FILE - True if the FILE exists and has nonzero size.
# -u FILE - True if the FILE exists, and set-user-id (suid) flag is set.
# -w FILE - True if the FILE exists and is writable.
# -x FILE - True if the FILE exists and is executable.
