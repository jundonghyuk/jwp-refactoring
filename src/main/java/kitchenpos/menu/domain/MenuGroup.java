package kitchenpos.menu.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class MenuGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private MenuGroupName name;

    protected MenuGroup() {
    }
    
    public MenuGroup(String name) {
        this(null, name);
    }

    public MenuGroup(Long id, String name) {
        this.id = id;
        this.name = new MenuGroupName(name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuGroup menuGroup = (MenuGroup) o;
        return Objects.equals(getId(), menuGroup.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
