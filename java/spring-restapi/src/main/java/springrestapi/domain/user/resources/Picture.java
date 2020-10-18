package springrestapi.domain.user.resources;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import springrestapi.domain.user.BaseEntity;

@Entity
@Table(name = "RES_PICTURE")
public class Picture extends BaseEntity {

    private final static long serialVersionUID = -8449187953684778033L;

    private String name;
    private String type;

    @Lob
    private byte[] content;

    public Picture() {
    }

    public Picture(String name, String type, byte[] content) {
        super();

        this.name = name;
        this.type = type;
        this.content = content;
    }

    public byte[] getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
