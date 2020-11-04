/**
 * Przykład Boostrapa do uruchomienia aplikacji z wiersza poleceń.
 */


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

@Component
@Slf4j
@Profile("!test")
public class Bootstrap implements CommandLineRunner {
    private static final String OPTION_MODES = "modes";
    private final LauncherService launcherService;

    public Bootstrap(LauncherService launcherService) {
        this.launcherService = launcherService;
    }

    private List<LaunchModeEnum> convertModeToLaunchMode(String[] modes) {
        Vector<LaunchModeEnum> launchModes = new Vector<>();

        if (modes == null) {
            return launchModes;
        }

        for (String mode : modes) {
            launchModes.add(LaunchModeEnum.valueOf(mode.toUpperCase()));
        }

        return launchModes;
    }

    @Override
    public void run(String... args) throws Exception {
        Options options = new Options();

        String modesOptionValues = Arrays.stream(LaunchModeEnum.values())
            .map(launchModeEnum -> launchModeEnum.toString().toLowerCase())
            .collect(Collectors.joining(","));

        Option modeOption = new Option("m", OPTION_MODES, true, "run modes with options: " + modesOptionValues);
        modeOption.setValueSeparator(',');
        modeOption.setArgs(LaunchModeEnum.values().length);

        options.addOption(modeOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption(OPTION_MODES)) {
                validateModeOption(cmd.getOptionValues(OPTION_MODES));
            }

            launcherService.run(convertModeToLaunchMode(cmd.getOptionValues(OPTION_MODES)));
        } catch (ParseException e) {
            log.error(e.getMessage());

            formatter.printHelp("ted-importer", options);

            System.exit(1);
        }
    }

    private void validateModeOption(String[] modes) throws ParseException {
        for (String mode : modes) {
            if (!EnumUtils.isValidEnum(LaunchModeEnum.class, mode.toUpperCase())) {
                throw new ParseException("Inccorect mode " + mode);
            }
        }
    }
}
