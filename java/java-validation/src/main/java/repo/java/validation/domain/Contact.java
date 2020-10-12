package repo.java.validation.domain;

public class Contact {
    private String value;
    private ContactType contactType;

    public Contact() {

    }

    public ContactType getContactType() {
        return contactType;
    }

    public String getValue() {
        return value;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
