package com.pc.ezamowienia.mo.noticegen.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import com.google.common.base.Strings;
import com.pc.ezamowienia.mo.noticegen.config.GeneratorConfig;
import com.pc.ezamowienia.mo.noticegen.config.GeneratorConfig.TypeConfig;
import com.pc.ezamowienia.mo.noticegen.model.NoticeData.TypeEnum;
import com.pc.ezamowienia.mo.noticegen.service.VersionService;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class VersionServiceImpl implements VersionService {
    private static final String VERSION_REGEX = "^(\\d*?)\\.(\\d*?)\\.(\\d*)$";
    private static final Pattern PATTERN = Pattern.compile(VERSION_REGEX);

    private final GeneratorConfig generatorConfig;

    private Map<TypeEnum, Map<Integer, Version>> typeMajorVersion = new HashMap<>();
    private Map<TypeEnum, Version> typeHighestVersion = new HashMap<>();

    public VersionServiceImpl(GeneratorConfig generatorConfig) {
        this.generatorConfig = generatorConfig;
    }

    private void initVersionsVariables() {
        for (Entry<TypeEnum, TypeConfig> entry : generatorConfig.getTypes().entrySet()) {
            Map<Integer, Version> majorVersion = new HashMap<>();

            typeMajorVersion.put(entry.getKey(), majorVersion);

            for (String versionString : entry.getValue().getVersions()) {
                if (!validateVersionFormat(versionString)) {
                    throw new RuntimeException(
                        String.format("Version [%s] for [%s] type is incorrect.", versionString, entry.getKey()));
                }

                Version version = new Version(versionString);

                Version savedVersion = majorVersion.get(version.getMajor());

                if (savedVersion == null || version.compareTo(savedVersion) > 0) {
                    majorVersion.put(version.getMajor(), version);
                }

                Version savedHighestVersion = typeHighestVersion.get(entry.getKey());

                if (savedHighestVersion == null || version.compareTo(savedHighestVersion) > 0) {
                    typeHighestVersion.put(entry.getKey(), version);
                }
            }
        }
    }

    @Override
    public String matchVersion(TypeEnum type, String version) {
        Objects.requireNonNull(type, "Type is can not be null.");

        if (Strings.isNullOrEmpty(version)) {
            throw new IllegalArgumentException("Version is required.");
        }

        Map<Integer, Version> majorVersion = typeMajorVersion.get(type);

        if (majorVersion == null) {
            throw new RuntimeException(String.format("There is no versions for [%s] type.", type));
        }

        int versionMajor = new Version(version).getMajor();

        if (majorVersion.get(versionMajor) == null) {
            throw new RuntimeException(String.format("There is no version for major version [%s].", versionMajor));
        }

        return majorVersion.get(versionMajor).formatToString();
    }

    @Override
    public String matchVersion(TypeEnum type) {
        Objects.requireNonNull(type, "Type is can not be null.");

        Version highestVersion = typeHighestVersion.get(type);

        if (highestVersion == null) {
            throw new RuntimeException(String.format("There is no versions for [%s] type.", type));
        }

        return highestVersion.formatToString();
    }

    @PostConstruct
    public void postContruct() {
        initVersionsVariables();
    }

    @Override
    public boolean validateVersionFormat(String version) {
        return PATTERN.matcher(version).matches();
    }

    @Data
    private static class Version implements Comparable<Version> {
        private final int major;
        private final int minor;
        private final int patch;

        private Version(String version) {
            String[] splitted = version.split("\\.");

            switch (splitted.length) {
                case 1:
                    major = Integer.parseInt(splitted[0]);
                    minor = 0;
                    patch = 0;
                    break;
                case 2:
                    major = Integer.parseInt(splitted[0]);
                    minor = Integer.parseInt(splitted[1]);
                    patch = 0;
                    break;
                default:
                    major = Integer.parseInt(splitted[0]);
                    minor = Integer.parseInt(splitted[1]);
                    patch = Integer.parseInt(splitted[2]);
                    break;
            }
        }

        @Override
        public int compareTo(Version version) {
            final int majorCompare = Integer.compare(getMajor(), version.getMajor());

            if (majorCompare == 0) {
                final int minorCompare = Integer.compare(getMinor(), version.getMinor());

                if (minorCompare == 0) {
                    return Integer.compare(getPatch(), version.getPatch());
                } else {
                    return minorCompare;
                }
            } else {
                return majorCompare;
            }
        }

        public String formatToString() {
            return major + "." + minor + "." + patch;
        }
    }
}
