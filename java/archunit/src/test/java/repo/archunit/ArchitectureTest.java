package repo.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

class ArchitectureTest {

    private static JavaClasses JC = new ClassFileImporter().importPackages("repo.archunit");

    @Test
    void repositoriesLayerTest() {
        ArchRule rule = classes().that()
                .resideInAnyPackage("repo.archunit.repositories")
                .should()
                .onlyBeAccessed()
                .byAnyPackage("repo.archunit.services");

        rule.check(JC);

        ArchRule rule2 = classes().that()
                .resideInAnyPackage("repo.archunit.repositories")
                .should()
                .haveSimpleNameEndingWith("Repo");

        rule2.check(JC);
    }
}