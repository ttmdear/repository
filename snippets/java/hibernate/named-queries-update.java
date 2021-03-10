package pl.domain.bn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.DETACH;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = ProviderGroup.NQ_DETACH_PROVIDERS,
                query = "UPDATE USERS ip " +
                        "SET ip.importance = null, ip.providerGroup = null " +
                        "WHERE ip.providerGroup is not null and ip.providerGroup.id = :id"),
        @NamedQuery(name = ProviderGroup.NQ_ATTACH_PROVIDER,
                query = "UPDATE USERS ip " +
                        "SET ip.importance = :importance, ip.providerGroup.id = :id " +
                        "WHERE ip.id = :idpId"),
})
@NoArgsConstructor
public class ProviderGroup {

    public static final String NQ_DETACH_PROVIDERS = "ProviderGroup.NQ_DETACH_PROVIDERS";
    public static final String NQ_ATTACH_PROVIDER = "ProviderGroup.NQ_ATTACH_PROVIDER";

    @Id
    @Column(name = "PRGR_ID")
    @GeneratedValue(generator = "bnr_id_gen")
    @GenericGenerator(name = "bnr_id_gen", strategy = "pl.domain.IdGenerator")
    private Long id;

    @Column(name = "PRGR_NAME")
    private String name;

    @Column(name = "PRGR_IMPORTANCE")
    private Integer importance;

    @Lob
    @Column(name = "PRGR_LOGO")
    private byte[] logo;

    @Column(name = "PRGR_GROUP_IDENTIFIER")
    private Integer groupIdentifier;

    @Transient
    private Long providerCount;

    @OneToMany(fetch = FetchType.LAZY, cascade = DETACH, mappedBy = "providerGroup")
    private List<Users> identityProviders = new ArrayList<>();

    @Transient
    private List<Users> identityProvidersInGroup;

    public ProviderGroup(Long id, String name, Integer importance, byte[] logo, Long providerCount, Integer groupIdentifier) {
        this.id = id;
        this.name = name;
        this.importance = importance;
        this.logo = logo;
        this.providerCount = providerCount;
        this.groupIdentifier = groupIdentifier;
    }
}
