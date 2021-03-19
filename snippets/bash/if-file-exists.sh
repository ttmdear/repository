# Pli istenieje
if [ -a "$MRG_WAR_SPZD" ]; then
    $MRG_JBOSS_DIR/bin/jboss-cli.sh -c --command="deploy --force $MRG_WAR_SPZD"
fi

# Pli nie istenieje
if [ ! -a "$USOS_ADM_WAR_PATH" ]; then
    return
fi
